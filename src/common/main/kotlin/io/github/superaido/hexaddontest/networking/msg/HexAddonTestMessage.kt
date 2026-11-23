package io.github.superaido.hexaddontest.networking.msg

import io.github.superaido.hexaddontest.HexAddonTest
import io.github.superaido.hexaddontest.networking.HexAddonTestNetworking
import io.github.superaido.hexaddontest.networking.handler.applyOnClient
import io.github.superaido.hexaddontest.networking.handler.applyOnServer
import io.wispforest.owo.network.ClientAccess
import io.wispforest.owo.network.OwoNetChannel
import io.wispforest.owo.network.ServerAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer

sealed interface HexAddonTestMessage

sealed interface HexAddonTestMessageC2S : HexAddonTestMessage {
    fun <T> T.sendToServer() where T : Record {
        HexAddonTestNetworking.CHANNEL.clientHandle().send(this)
    }
}

sealed interface HexAddonTestMessageS2C : HexAddonTestMessage {
}

fun <T> T.sendToPlayer(player: ServerPlayer) where T : Record {
    HexAddonTestNetworking.CHANNEL.serverHandle(player).send( this)
}

fun <T> T.sendToPlayers(players: Iterable<ServerPlayer>) where T : Record {
    players.forEach { sendToPlayer(it) }
}

sealed interface HexAddonTestMessageCompanion<T> where T : HexAddonTestMessage, T : Record {
    val type: Class<T>

    fun apply(msg: T, access: ServerAccess): Unit {
        HexAddonTest.LOGGER.debug("Server received packet from {}: {}", access.player().name.string, this)
        when (msg) {
            is HexAddonTestMessageC2S -> msg.applyOnServer(access)
            else -> HexAddonTest.LOGGER.warn("Message not handled on server: {}", msg::class)
        }
    }

    fun apply(msg: T, access: ClientAccess): Unit {
        HexAddonTest.LOGGER.debug("Client received packet: {}", this)
        when (msg) {
            is HexAddonTestMessageS2C -> msg.applyOnClient(access)
            else -> HexAddonTest.LOGGER.warn("Message not handled on client: {}", msg::class)
        }
    }

    fun register(channel: OwoNetChannel) {
        channel.registerServerbound(type) { msg, access -> apply(msg, access) }
    }
}

package io.github.superaido.hexaddontest.networking

import io.github.superaido.hexaddontest.HexAddonTest
import io.github.superaido.hexaddontest.networking.msg.HexAddonTestMessageCompanion
import io.wispforest.owo.network.OwoNetChannel

object HexAddonTestNetworking {
    val CHANNEL: OwoNetChannel = OwoNetChannel.create(HexAddonTest.id("networking_channel"))

    fun init() {
        for (subclass in HexAddonTestMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}

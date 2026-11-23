package io.github.superaido.hexaddontest.client

import io.github.superaido.hexaddontest.client.HexAddonTestClient
import net.fabricmc.api.ClientModInitializer

object FabricHexAddonTestClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexAddonTestClient.init()
    }
}
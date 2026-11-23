package io.github.superaido.hexaddontest

import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexAddonTestServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        HexAddonTest.initServer()
    }
}

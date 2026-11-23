package io.github.superaido.hexaddontest

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object NeoForgeHexAddonTestServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        HexAddonTest.initServer()
    }
}


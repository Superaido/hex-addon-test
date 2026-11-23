package io.github.superaido.hexaddontest

import net.fabricmc.api.ModInitializer

object FabricHexAddonTest : ModInitializer {
    override fun onInitialize() {
        HexAddonTest.init()
    }
}

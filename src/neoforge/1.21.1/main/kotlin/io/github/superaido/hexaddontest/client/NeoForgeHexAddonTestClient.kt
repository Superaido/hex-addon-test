package io.github.superaido.hexaddontest.client

import io.github.superaido.hexaddontest.client.HexAddonTestClient
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.gui.IConfigScreenFactory
import thedarkcolour.kotlinforforge.neoforge.forge.LOADING_CONTEXT

object NeoForgeHexAddonTestClient {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLClientSetupEvent) {
        HexAddonTestClient.init()
    }
}
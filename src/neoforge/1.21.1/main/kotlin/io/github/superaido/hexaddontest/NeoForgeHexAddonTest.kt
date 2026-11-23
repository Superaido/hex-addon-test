package io.github.superaido.hexaddontest

import io.github.superaido.hexaddontest.client.NeoForgeHexAddonTestClient
import io.github.superaido.hexaddontest.datagen.NeoForgeHexAddonTestDatagen
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.ModList
import net.neoforged.fml.common.Mod

@Mod(HexAddonTest.MODID)
class NeoForgeHexAddonTest(modBus: IEventBus, container: ModContainer) {
    init {
        modBus.apply {
            addListener(NeoForgeHexAddonTestClient::init)
            addListener(NeoForgeHexAddonTestDatagen::init)
            addListener(NeoForgeHexAddonTestServer::init)
        }
        HexAddonTest.init()
    }

    companion object {
        internal val container: ModContainer
            get() = ModList.get().getModContainerById(HexAddonTest.MODID).get()
    }
}

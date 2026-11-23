package io.github.superaido.hexaddontest.datagen

import at.petrak.hexcasting.forge.datagen.TagsProviderEFHSetter
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.data.event.GatherDataEvent

object NeoForgeHexAddonTestDatagen {
    fun init(event: GatherDataEvent) {
        event.apply {
            addVanillaProvider(includeServer()) { HexAddonTestActionTags(it, lookupProvider) }
        }
    }
}

private fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, DataProvider.Factory { factory(it) })

private fun <T : DataProvider> GatherDataEvent.addVanillaProvider(run: Boolean, factory: (PackOutput) -> T) =
    addProvider(run) { packOutput ->
        factory(packOutput).also {
            (it as TagsProviderEFHSetter).setEFH(existingFileHelper)
        }
    }

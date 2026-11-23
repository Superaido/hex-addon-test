@file:JvmName("HexAddonTestAbstractionsActual")

package io.github.superaido.hexaddontest

import io.github.superaido.hexaddontest.registry.HexAddonTestRegistrar
import net.msrandom.multiplatform.annotations.Actual
import net.neoforged.neoforge.registries.RegisterEvent

actual fun <T : Any> initRegistry(registrar: HexAddonTestRegistrar<T>) {
        NeoForgeHexAddonTest.container.eventBus!!.addListener { event: RegisterEvent ->
            event.register(registrar.registryKey) { helper ->
                registrar.init(helper::register)
            }
        }
}
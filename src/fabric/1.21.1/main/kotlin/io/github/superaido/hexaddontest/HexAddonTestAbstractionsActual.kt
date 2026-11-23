@file:JvmName("HexAddonTestAbstractionsActual")

package io.github.superaido.hexaddontest

import io.github.superaido.hexaddontest.registry.HexAddonTestRegistrar
import net.minecraft.core.Registry
import net.msrandom.multiplatform.annotations.Actual

actual fun <T : Any> initRegistry(registrar: HexAddonTestRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}

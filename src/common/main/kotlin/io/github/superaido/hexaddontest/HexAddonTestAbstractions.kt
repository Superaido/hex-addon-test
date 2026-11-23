@file:JvmName("HexAddonTestAbstractions")

package io.github.superaido.hexaddontest

import io.github.superaido.hexaddontest.registry.HexAddonTestRegistrar

fun initRegistries(vararg registries: HexAddonTestRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

expect fun <T : Any> initRegistry(registrar: HexAddonTestRegistrar<T>)

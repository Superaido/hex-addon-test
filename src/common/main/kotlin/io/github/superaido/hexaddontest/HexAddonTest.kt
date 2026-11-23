package io.github.superaido.hexaddontest

import io.github.superaido.hexaddontest.config.HexAddonTestConfigs
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.superaido.hexaddontest.networking.HexAddonTestNetworking
import io.github.superaido.hexaddontest.registry.HexAddonTestActions

object HexAddonTest {
    const val MODID = "hexaddontest"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)



    @JvmStatic
    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MODID, path)

    fun init() {
        initRegistries(
            HexAddonTestActions,
        )
        HexAddonTestNetworking.init()
        HexAddonTestConfigs.init()
    }

    fun initServer() {
    }
}

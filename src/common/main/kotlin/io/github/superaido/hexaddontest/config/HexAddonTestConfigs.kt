package io.github.superaido.hexaddontest.config

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import me.fzzyhmstrs.fzzy_config.api.RegisterType

object HexAddonTestConfigs {
    //instance of your config loaded from file and automatically registered to the SyncedConfigRegistry and ClientConfigRegistry using the getId() method
    val COMMON_CONFIG = ConfigApi.registerAndLoadConfig(::HexAddonTestCommonConfig)

    //adding the registerType, you can register a config as client-only. No syncing will occur. Useful for client-only mods.
    val CLIENT_CONFIG = ConfigApi.registerAndLoadConfig(::HexAddonTestClientConfig, RegisterType.CLIENT)

    fun init() {}
}
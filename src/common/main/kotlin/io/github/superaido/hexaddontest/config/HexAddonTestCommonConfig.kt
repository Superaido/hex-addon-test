package io.github.superaido.hexaddontest.config

import io.github.superaido.hexaddontest.HexAddonTest
import me.fzzyhmstrs.fzzy_config.config.Config

// guide: https://moddedmc.wiki/en/project/fzzy-config/latest/docs/config-design/New-Configs#2-config-creation
class HexAddonTestCommonConfig : Config(HexAddonTest.id("common_config")) {

    var testValue = 1.5

}
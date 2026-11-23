package io.github.superaido.hexaddontest.networking.handler

import io.github.superaido.hexaddontest.networking.msg.*
import io.wispforest.owo.network.ServerAccess

fun HexAddonTestMessageC2S.applyOnServer(access: ServerAccess) = access.player().server.execute {
    // NOTE: this is commented out because otherwise it fails to compile if there's nothing inside of the when expression
    /*
    when (this) {
        is MsgExampleNameC2S -> {
           handleMessage(...)
        }
        // add server-side message handlers here
    }
    */
}

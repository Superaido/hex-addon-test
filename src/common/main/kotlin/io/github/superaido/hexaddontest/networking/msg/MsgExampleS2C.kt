package io.github.superaido.hexaddontest.networking.msg

@JvmRecord
data class MsgExampleS2C(val payload: Int) : HexAddonTestMessageS2C {
   companion object : HexAddonTestMessageCompanion<MsgExampleS2C> {
       override val type = MsgExampleS2C::class.java
   }
}

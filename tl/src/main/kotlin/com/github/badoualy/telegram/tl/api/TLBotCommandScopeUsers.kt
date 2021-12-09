package com.github.badoualy.telegram.tl.api

/**
 * botCommandScopeUsers#3c4f04d8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotCommandScopeUsers : TLAbsBotCommandScope() {
    private val _constructor: String = "botCommandScopeUsers#3c4f04d8"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotCommandScopeUsers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3c4f04d8
    }
}

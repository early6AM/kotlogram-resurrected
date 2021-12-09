package com.github.badoualy.telegram.tl.api

/**
 * botCommandScopeChats#6fe1a881
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotCommandScopeChats : TLAbsBotCommandScope() {
    private val _constructor: String = "botCommandScopeChats#6fe1a881"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotCommandScopeChats) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6fe1a881
    }
}

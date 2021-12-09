package com.github.badoualy.telegram.tl.api

/**
 * botCommandScopeChatAdmins#b9aa606a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotCommandScopeChatAdmins : TLAbsBotCommandScope() {
    private val _constructor: String = "botCommandScopeChatAdmins#b9aa606a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotCommandScopeChatAdmins) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb9aa606a.toInt()
    }
}

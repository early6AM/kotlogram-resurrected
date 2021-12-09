package com.github.badoualy.telegram.tl.api.help

/**
 * help.userInfoEmpty#f3ae2eed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserInfoEmpty : TLAbsUserInfo() {
    private val _constructor: String = "help.userInfoEmpty#f3ae2eed"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserInfoEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf3ae2eed.toInt()
    }
}

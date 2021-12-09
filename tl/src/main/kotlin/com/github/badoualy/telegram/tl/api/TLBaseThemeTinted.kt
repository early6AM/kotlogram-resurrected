package com.github.badoualy.telegram.tl.api

/**
 * baseThemeTinted#6d5f77ee
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBaseThemeTinted : TLAbsBaseTheme() {
    private val _constructor: String = "baseThemeTinted#6d5f77ee"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBaseThemeTinted) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6d5f77ee
    }
}

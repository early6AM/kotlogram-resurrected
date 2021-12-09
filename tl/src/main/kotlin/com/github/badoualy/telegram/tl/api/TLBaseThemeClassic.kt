package com.github.badoualy.telegram.tl.api

/**
 * baseThemeClassic#c3a12462
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBaseThemeClassic : TLAbsBaseTheme() {
    private val _constructor: String = "baseThemeClassic#c3a12462"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBaseThemeClassic) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc3a12462.toInt()
    }
}

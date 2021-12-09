package com.github.badoualy.telegram.tl.api

/**
 * baseThemeDay#fbd81688
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBaseThemeDay : TLAbsBaseTheme() {
    private val _constructor: String = "baseThemeDay#fbd81688"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBaseThemeDay) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfbd81688.toInt()
    }
}

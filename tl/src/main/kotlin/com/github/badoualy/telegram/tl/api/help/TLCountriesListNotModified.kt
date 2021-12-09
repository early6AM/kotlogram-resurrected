package com.github.badoualy.telegram.tl.api.help

/**
 * help.countriesListNotModified#93cc1f32
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCountriesListNotModified : TLAbsCountriesList() {
    private val _constructor: String = "help.countriesListNotModified#93cc1f32"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCountriesListNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x93cc1f32.toInt()
    }
}

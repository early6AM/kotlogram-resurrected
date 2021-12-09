package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypePersonalDetails#9d2a81e3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypePersonalDetails : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypePersonalDetails#9d2a81e3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypePersonalDetails) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9d2a81e3.toInt()
    }
}

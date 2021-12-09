package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeDriverLicense#6e425c4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeDriverLicense : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeDriverLicense#6e425c4"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeDriverLicense) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6e425c4
    }
}

package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeRentalAgreement#8b883488
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeRentalAgreement : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeRentalAgreement#8b883488"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeRentalAgreement) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8b883488.toInt()
    }
}

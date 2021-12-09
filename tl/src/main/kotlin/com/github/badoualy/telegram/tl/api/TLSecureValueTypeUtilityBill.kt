package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeUtilityBill#fc36954e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeUtilityBill : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeUtilityBill#fc36954e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeUtilityBill) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfc36954e.toInt()
    }
}

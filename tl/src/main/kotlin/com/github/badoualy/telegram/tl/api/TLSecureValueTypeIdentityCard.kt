package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeIdentityCard#a0d0744b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeIdentityCard : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeIdentityCard#a0d0744b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeIdentityCard) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa0d0744b.toInt()
    }
}

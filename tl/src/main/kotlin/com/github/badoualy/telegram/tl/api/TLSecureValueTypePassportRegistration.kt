package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypePassportRegistration#99e3806a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypePassportRegistration : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypePassportRegistration#99e3806a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypePassportRegistration) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x99e3806a.toInt()
    }
}

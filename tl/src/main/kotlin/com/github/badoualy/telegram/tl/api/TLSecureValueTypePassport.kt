package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypePassport#3dac6a00
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypePassport : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypePassport#3dac6a00"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypePassport) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3dac6a00
    }
}

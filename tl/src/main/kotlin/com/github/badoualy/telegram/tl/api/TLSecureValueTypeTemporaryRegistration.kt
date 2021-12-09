package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeTemporaryRegistration#ea02ec33
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeTemporaryRegistration : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeTemporaryRegistration#ea02ec33"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeTemporaryRegistration) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea02ec33.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypePhone#b320aadb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypePhone : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypePhone#b320aadb"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypePhone) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb320aadb.toInt()
    }
}

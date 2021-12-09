package com.github.badoualy.telegram.tl.api

/**
 * secureValueTypeBankStatement#89137c0d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueTypeBankStatement : TLAbsSecureValueType() {
    private val _constructor: String = "secureValueTypeBankStatement#89137c0d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueTypeBankStatement) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x89137c0d.toInt()
    }
}

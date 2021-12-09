package com.github.badoualy.telegram.tl.api

/**
 * jsonNull#3f6d7b68
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLJsonNull : TLAbsJSONValue() {
    private val _constructor: String = "jsonNull#3f6d7b68"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLJsonNull) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3f6d7b68
    }
}

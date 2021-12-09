package com.github.badoualy.telegram.tl.api

/**
 * inputCheckPasswordEmpty#9880f658
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputCheckPasswordEmpty : TLAbsInputCheckPasswordSRP() {
    private val _constructor: String = "inputCheckPasswordEmpty#9880f658"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputCheckPasswordEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9880f658.toInt()
    }
}

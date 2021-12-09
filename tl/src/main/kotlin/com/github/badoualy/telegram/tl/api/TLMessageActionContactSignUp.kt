package com.github.badoualy.telegram.tl.api

/**
 * messageActionContactSignUp#f3f25f76
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionContactSignUp : TLAbsMessageAction() {
    private val _constructor: String = "messageActionContactSignUp#f3f25f76"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionContactSignUp) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf3f25f76.toInt()
    }
}

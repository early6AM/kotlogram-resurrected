package com.github.badoualy.telegram.tl.api

/**
 * inputMessagePinned#86872538
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagePinned : TLAbsInputMessage() {
    private val _constructor: String = "inputMessagePinned#86872538"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagePinned) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86872538.toInt()
    }
}

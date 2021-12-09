package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * keyboardButtonRequestPoll#bbc7515d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonRequestPoll() : TLAbsKeyboardButton() {
    var quiz: Boolean? = null

    override var text: String = ""

    private val _constructor: String = "keyboardButtonRequestPoll#bbc7515d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(quiz: Boolean?, text: String) : this() {
        this.quiz = quiz
        this.text = text
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(quiz, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(quiz, 1) { writeBoolean(it) }
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        quiz = readIfMask(1) { readBoolean() }
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(quiz, 1) { SIZE_BOOLEAN }
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonRequestPoll) return false
        if (other === this) return true

        return _flags == other._flags
                && quiz == other.quiz
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbbc7515d.toInt()
    }
}

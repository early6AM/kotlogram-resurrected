package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaDice#3f7ee58b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaDice() : TLAbsMessageMedia() {
    var value: Int = 0

    var emoticon: String = ""

    private val _constructor: String = "messageMediaDice#3f7ee58b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(value: Int, emoticon: String) : this() {
        this.value = value
        this.emoticon = emoticon
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(value)
        writeString(emoticon)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        value = readInt()
        emoticon = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(emoticon)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaDice) return false
        if (other === this) return true

        return value == other.value
                && emoticon == other.emoticon
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3f7ee58b
    }
}

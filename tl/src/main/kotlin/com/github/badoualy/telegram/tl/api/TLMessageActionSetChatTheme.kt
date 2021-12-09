package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionSetChatTheme#aa786345
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionSetChatTheme() : TLAbsMessageAction() {
    var emoticon: String = ""

    private val _constructor: String = "messageActionSetChatTheme#aa786345"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(emoticon: String) : this() {
        this.emoticon = emoticon
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(emoticon)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        emoticon = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(emoticon)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionSetChatTheme) return false
        if (other === this) return true

        return emoticon == other.emoticon
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaa786345.toInt()
    }
}

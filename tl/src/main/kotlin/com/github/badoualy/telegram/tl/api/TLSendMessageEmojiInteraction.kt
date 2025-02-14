package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * sendMessageEmojiInteraction#25972bcb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageEmojiInteraction() : TLAbsSendMessageAction() {
    var emoticon: String = ""

    var msgId: Int = 0

    var interaction: TLDataJSON = TLDataJSON()

    private val _constructor: String = "sendMessageEmojiInteraction#25972bcb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            emoticon: String,
            msgId: Int,
            interaction: TLDataJSON
    ) : this() {
        this.emoticon = emoticon
        this.msgId = msgId
        this.interaction = interaction
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(emoticon)
        writeInt(msgId)
        writeTLObject(interaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        emoticon = readString()
        msgId = readInt()
        interaction = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(emoticon)
        size += SIZE_INT32
        size += interaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageEmojiInteraction) return false
        if (other === this) return true

        return emoticon == other.emoticon
                && msgId == other.msgId
                && interaction == other.interaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x25972bcb.toInt()
    }
}

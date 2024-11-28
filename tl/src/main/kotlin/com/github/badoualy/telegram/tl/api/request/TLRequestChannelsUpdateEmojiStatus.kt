package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEmojiStatus
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLEmojiStatusEmpty
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsUpdateEmojiStatus() : TLMethod<TLAbsUpdates>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var emojiStatus: TLAbsEmojiStatus = TLEmojiStatusEmpty()

    private val _constructor: String = "channels.updateEmojiStatus#f0d3e6a8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channel: TLAbsInputChannel, emojiStatus: TLAbsEmojiStatus) : this() {
        this.channel = channel
        this.emojiStatus = emojiStatus
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(emojiStatus)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        emojiStatus = readTLObject<TLAbsEmojiStatus>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += emojiStatus.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsUpdateEmojiStatus) return false
        if (other === this) return true

        return channel == other.channel
                && emojiStatus == other.emojiStatus
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf0d3e6a8.toInt()
    }
}

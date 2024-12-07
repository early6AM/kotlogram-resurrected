package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsCreateForumTopic() : TLMethod<TLAbsUpdates>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var title: String = ""

    var iconColor: Int? = null

    var iconEmojiId: Long? = null

    var randomId: Long = 0L

    var sendAs: TLAbsInputPeer? = null

    private val _constructor: String = "channels.createForumTopic#f40c0224"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            title: String,
            iconColor: Int?,
            iconEmojiId: Long?,
            randomId: Long,
            sendAs: TLAbsInputPeer?
    ) : this() {
        this.channel = channel
        this.title = title
        this.iconColor = iconColor
        this.iconEmojiId = iconEmojiId
        this.randomId = randomId
        this.sendAs = sendAs
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(iconColor, 1)
        updateFlags(iconEmojiId, 8)
        updateFlags(sendAs, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeString(title)
        doIfMask(1, iconColor, 1) { writeInt(it) }
        doIfMask(1, iconEmojiId, 8) { writeLong(it) }
        writeLong(randomId)
        doIfMask(1, sendAs, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channel = readTLObject<TLAbsInputChannel>()
        title = readString()
        iconColor = readIfMask(1, 1) { readInt() }
        iconEmojiId = readIfMask(1, 8) { readLong() }
        randomId = readLong()
        sendAs = readIfMask(1, 4) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(1, iconColor, 1) { SIZE_INT32 }
        size += getIntIfMask(1, iconEmojiId, 8) { SIZE_INT64 }
        size += SIZE_INT64
        size += getIntIfMask(1, sendAs, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsCreateForumTopic) return false
        if (other === this) return true

        return _flags == other._flags
                && channel == other.channel
                && title == other.title
                && iconColor == other.iconColor
                && iconEmojiId == other.iconEmojiId
                && randomId == other.randomId
                && sendAs == other.sendAs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf40c0224.toInt()
    }
}

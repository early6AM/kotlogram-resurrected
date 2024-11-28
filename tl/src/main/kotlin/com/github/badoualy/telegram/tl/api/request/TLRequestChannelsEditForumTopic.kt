package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
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
class TLRequestChannelsEditForumTopic() : TLMethod<TLAbsUpdates>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var topicId: Int = 0

    var title: String? = null

    var iconEmojiId: Long? = null

    var closed: Boolean? = null

    var hidden: Boolean? = null

    private val _constructor: String = "channels.editForumTopic#f4dfa185"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            topicId: Int,
            title: String?,
            iconEmojiId: Long?,
            closed: Boolean?,
            hidden: Boolean?
    ) : this() {
        this.channel = channel
        this.topicId = topicId
        this.title = title
        this.iconEmojiId = iconEmojiId
        this.closed = closed
        this.hidden = hidden
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 1)
        updateFlags(iconEmojiId, 2)
        updateFlags(closed, 4)
        updateFlags(hidden, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeInt(topicId)
        doIfMask(title, 1) { writeString(it) }
        doIfMask(iconEmojiId, 2) { writeLong(it) }
        doIfMask(closed, 4) { writeBoolean(it) }
        doIfMask(hidden, 8) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channel = readTLObject<TLAbsInputChannel>()
        topicId = readInt()
        title = readIfMask(1) { readString() }
        iconEmojiId = readIfMask(2) { readLong() }
        closed = readIfMask(4) { readBoolean() }
        hidden = readIfMask(8) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(iconEmojiId, 2) { SIZE_INT64 }
        size += getIntIfMask(closed, 4) { SIZE_BOOLEAN }
        size += getIntIfMask(hidden, 8) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsEditForumTopic) return false
        if (other === this) return true

        return _flags == other._flags
                && channel == other.channel
                && topicId == other.topicId
                && title == other.title
                && iconEmojiId == other.iconEmojiId
                && closed == other.closed
                && hidden == other.hidden
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf4dfa185.toInt()
    }
}

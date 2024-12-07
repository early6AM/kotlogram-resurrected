package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics
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
class TLRequestChannelsGetForumTopics() : TLMethod<TLForumTopics>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var q: String? = null

    var offsetDate: Int = 0

    var offsetId: Int = 0

    var offsetTopic: Int = 0

    var limit: Int = 0

    private val _constructor: String = "channels.getForumTopics#de560d1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            q: String?,
            offsetDate: Int,
            offsetId: Int,
            offsetTopic: Int,
            limit: Int
    ) : this() {
        this.channel = channel
        this.q = q
        this.offsetDate = offsetDate
        this.offsetId = offsetId
        this.offsetTopic = offsetTopic
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLForumTopics = tlDeserializer.readTLObject(TLForumTopics::class, TLForumTopics.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(q, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        doIfMask(1, q, 1) { writeString(it) }
        writeInt(offsetDate)
        writeInt(offsetId)
        writeInt(offsetTopic)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channel = readTLObject<TLAbsInputChannel>()
        q = readIfMask(1, 1) { readString() }
        offsetDate = readInt()
        offsetId = readInt()
        offsetTopic = readInt()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += getIntIfMask(1, q, 1) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsGetForumTopics) return false
        if (other === this) return true

        return _flags == other._flags
                && channel == other.channel
                && q == other.q
                && offsetDate == other.offsetDate
                && offsetId == other.offsetId
                && offsetTopic == other.offsetTopic
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xde560d1.toInt()
    }
}

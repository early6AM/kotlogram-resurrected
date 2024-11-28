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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updateChannelPinnedTopic#192efbe3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelPinnedTopic() : TLAbsUpdate() {
    @Transient
    var pinned: Boolean = false

    var channelId: Long = 0L

    var topicId: Int = 0

    private val _constructor: String = "updateChannelPinnedTopic#192efbe3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            channelId: Long,
            topicId: Int
    ) : this() {
        this.pinned = pinned
        this.channelId = channelId
        this.topicId = topicId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(channelId)
        writeInt(topicId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(1)
        channelId = readLong()
        topicId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelPinnedTopic) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && channelId == other.channelId
                && topicId == other.topicId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x192efbe3.toInt()
    }
}

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

/**
 * updateReadChannelDiscussionInbox#d6b19546
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadChannelDiscussionInbox() : TLAbsUpdate() {
    var channelId: Long = 0L

    var topMsgId: Int = 0

    var readMaxId: Int = 0

    var broadcastId: Long? = null

    var broadcastPost: Int? = null

    private val _constructor: String = "updateReadChannelDiscussionInbox#d6b19546"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            topMsgId: Int,
            readMaxId: Int,
            broadcastId: Long?,
            broadcastPost: Int?
    ) : this() {
        this.channelId = channelId
        this.topMsgId = topMsgId
        this.readMaxId = readMaxId
        this.broadcastId = broadcastId
        this.broadcastPost = broadcastPost
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(broadcastId, 1)
        updateFlags(broadcastPost, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(channelId)
        writeInt(topMsgId)
        writeInt(readMaxId)
        doIfMask(1, broadcastId, 1) { writeLong(it) }
        doIfMask(1, broadcastPost, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channelId = readLong()
        topMsgId = readInt()
        readMaxId = readInt()
        broadcastId = readIfMask(1, 1) { readLong() }
        broadcastPost = readIfMask(1, 1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, broadcastId, 1) { SIZE_INT64 }
        size += getIntIfMask(1, broadcastPost, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadChannelDiscussionInbox) return false
        if (other === this) return true

        return _flags == other._flags
                && channelId == other.channelId
                && topMsgId == other.topMsgId
                && readMaxId == other.readMaxId
                && broadcastId == other.broadcastId
                && broadcastPost == other.broadcastPost
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd6b19546.toInt()
    }
}

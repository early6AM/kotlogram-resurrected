package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageReplies#83d60fc2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageReplies() : TLObject() {
    @Transient
    var comments: Boolean = false

    var replies: Int = 0

    var repliesPts: Int = 0

    var recentRepliers: TLObjectVector<TLAbsPeer>? = TLObjectVector()

    var channelId: Long? = null

    var maxId: Int? = null

    var readMaxId: Int? = null

    private val _constructor: String = "messageReplies#83d60fc2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            comments: Boolean,
            replies: Int,
            repliesPts: Int,
            recentRepliers: TLObjectVector<TLAbsPeer>?,
            channelId: Long?,
            maxId: Int?,
            readMaxId: Int?
    ) : this() {
        this.comments = comments
        this.replies = replies
        this.repliesPts = repliesPts
        this.recentRepliers = recentRepliers
        this.channelId = channelId
        this.maxId = maxId
        this.readMaxId = readMaxId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(comments, 1)
        updateFlags(recentRepliers, 2)
        updateFlags(channelId, 1)
        updateFlags(maxId, 4)
        updateFlags(readMaxId, 8)

        // Following parameters might be forced to true by another field that updated the flags
        comments = isMask(1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(replies)
        writeInt(repliesPts)
        doIfMask(recentRepliers, 2) { writeTLVector(it) }
        doIfMask(channelId, 1) { writeLong(it) }
        doIfMask(maxId, 4) { writeInt(it) }
        doIfMask(readMaxId, 8) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        comments = isMask(1)
        replies = readInt()
        repliesPts = readInt()
        recentRepliers = readIfMask(2) { readTLVector<TLAbsPeer>() }
        channelId = readIfMask(1) { readLong() }
        maxId = readIfMask(4) { readInt() }
        readMaxId = readIfMask(8) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(recentRepliers, 2) { it.computeSerializedSize() }
        size += getIntIfMask(channelId, 1) { SIZE_INT64 }
        size += getIntIfMask(maxId, 4) { SIZE_INT32 }
        size += getIntIfMask(readMaxId, 8) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageReplies) return false
        if (other === this) return true

        return _flags == other._flags
                && comments == other.comments
                && replies == other.replies
                && repliesPts == other.repliesPts
                && recentRepliers == other.recentRepliers
                && channelId == other.channelId
                && maxId == other.maxId
                && readMaxId == other.readMaxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x83d60fc2.toInt()
    }
}

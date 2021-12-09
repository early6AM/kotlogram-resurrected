package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateReadChannelDiscussionOutbox#695c9e7c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadChannelDiscussionOutbox() : TLAbsUpdate() {
    var channelId: Long = 0L

    var topMsgId: Int = 0

    var readMaxId: Int = 0

    private val _constructor: String = "updateReadChannelDiscussionOutbox#695c9e7c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            topMsgId: Int,
            readMaxId: Int
    ) : this() {
        this.channelId = channelId
        this.topMsgId = topMsgId
        this.readMaxId = readMaxId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeInt(topMsgId)
        writeInt(readMaxId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        topMsgId = readInt()
        readMaxId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadChannelDiscussionOutbox) return false
        if (other === this) return true

        return channelId == other.channelId
                && topMsgId == other.topMsgId
                && readMaxId == other.readMaxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x695c9e7c
    }
}

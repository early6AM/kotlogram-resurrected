package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateReadChannelInbox#922e6e10
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadChannelInbox() : TLAbsUpdate() {
    var folderId: Int? = null

    var channelId: Long = 0L

    var maxId: Int = 0

    var stillUnreadCount: Int = 0

    var pts: Int = 0

    private val _constructor: String = "updateReadChannelInbox#922e6e10"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            folderId: Int?,
            channelId: Long,
            maxId: Int,
            stillUnreadCount: Int,
            pts: Int
    ) : this() {
        this.folderId = folderId
        this.channelId = channelId
        this.maxId = maxId
        this.stillUnreadCount = stillUnreadCount
        this.pts = pts
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(folderId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(folderId, 1) { writeInt(it) }
        writeLong(channelId)
        writeInt(maxId)
        writeInt(stillUnreadCount)
        writeInt(pts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        folderId = readIfMask(1) { readInt() }
        channelId = readLong()
        maxId = readInt()
        stillUnreadCount = readInt()
        pts = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(folderId, 1) { SIZE_INT32 }
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadChannelInbox) return false
        if (other === this) return true

        return _flags == other._flags
                && folderId == other.folderId
                && channelId == other.channelId
                && maxId == other.maxId
                && stillUnreadCount == other.stillUnreadCount
                && pts == other.pts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x922e6e10.toInt()
    }
}

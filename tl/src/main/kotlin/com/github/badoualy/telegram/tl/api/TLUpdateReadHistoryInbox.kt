package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateReadHistoryInbox#9c974fdf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadHistoryInbox() : TLAbsUpdate() {
    var folderId: Int? = null

    var peer: TLAbsPeer = TLPeerChat()

    var maxId: Int = 0

    var stillUnreadCount: Int = 0

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateReadHistoryInbox#9c974fdf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            folderId: Int?,
            peer: TLAbsPeer,
            maxId: Int,
            stillUnreadCount: Int,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.folderId = folderId
        this.peer = peer
        this.maxId = maxId
        this.stillUnreadCount = stillUnreadCount
        this.pts = pts
        this.ptsCount = ptsCount
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
        writeTLObject(peer)
        writeInt(maxId)
        writeInt(stillUnreadCount)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        folderId = readIfMask(1) { readInt() }
        peer = readTLObject<TLAbsPeer>()
        maxId = readInt()
        stillUnreadCount = readInt()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(folderId, 1) { SIZE_INT32 }
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadHistoryInbox) return false
        if (other === this) return true

        return _flags == other._flags
                && folderId == other.folderId
                && peer == other.peer
                && maxId == other.maxId
                && stillUnreadCount == other.stillUnreadCount
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9c974fdf.toInt()
    }
}

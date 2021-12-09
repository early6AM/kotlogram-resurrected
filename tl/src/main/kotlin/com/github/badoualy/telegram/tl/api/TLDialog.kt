package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * dialog#2c171f72
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialog() : TLAbsDialog() {
    @Transient
    override var pinned: Boolean = false

    @Transient
    var unreadMark: Boolean = false

    override var peer: TLAbsPeer = TLPeerChat()

    override var topMessage: Int = 0

    var readInboxMaxId: Int = 0

    var readOutboxMaxId: Int = 0

    var unreadCount: Int = 0

    var unreadMentionsCount: Int = 0

    var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var pts: Int? = null

    var draft: TLAbsDraftMessage? = null

    var folderId: Int? = null

    private val _constructor: String = "dialog#2c171f72"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            unreadMark: Boolean,
            peer: TLAbsPeer,
            topMessage: Int,
            readInboxMaxId: Int,
            readOutboxMaxId: Int,
            unreadCount: Int,
            unreadMentionsCount: Int,
            notifySettings: TLPeerNotifySettings,
            pts: Int?,
            draft: TLAbsDraftMessage?,
            folderId: Int?
    ) : this() {
        this.pinned = pinned
        this.unreadMark = unreadMark
        this.peer = peer
        this.topMessage = topMessage
        this.readInboxMaxId = readInboxMaxId
        this.readOutboxMaxId = readOutboxMaxId
        this.unreadCount = unreadCount
        this.unreadMentionsCount = unreadMentionsCount
        this.notifySettings = notifySettings
        this.pts = pts
        this.draft = draft
        this.folderId = folderId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 4)
        updateFlags(unreadMark, 8)
        updateFlags(pts, 1)
        updateFlags(draft, 2)
        updateFlags(folderId, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(topMessage)
        writeInt(readInboxMaxId)
        writeInt(readOutboxMaxId)
        writeInt(unreadCount)
        writeInt(unreadMentionsCount)
        writeTLObject(notifySettings)
        doIfMask(pts, 1) { writeInt(it) }
        doIfMask(draft, 2) { writeTLObject(it) }
        doIfMask(folderId, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(4)
        unreadMark = isMask(8)
        peer = readTLObject<TLAbsPeer>()
        topMessage = readInt()
        readInboxMaxId = readInt()
        readOutboxMaxId = readInt()
        unreadCount = readInt()
        unreadMentionsCount = readInt()
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        pts = readIfMask(1) { readInt() }
        draft = readIfMask(2) { readTLObject<TLAbsDraftMessage>() }
        folderId = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(pts, 1) { SIZE_INT32 }
        size += getIntIfMask(draft, 2) { it.computeSerializedSize() }
        size += getIntIfMask(folderId, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialog) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && unreadMark == other.unreadMark
                && peer == other.peer
                && topMessage == other.topMessage
                && readInboxMaxId == other.readInboxMaxId
                && readOutboxMaxId == other.readOutboxMaxId
                && unreadCount == other.unreadCount
                && unreadMentionsCount == other.unreadMentionsCount
                && notifySettings == other.notifySettings
                && pts == other.pts
                && draft == other.draft
                && folderId == other.folderId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2c171f72
    }
}

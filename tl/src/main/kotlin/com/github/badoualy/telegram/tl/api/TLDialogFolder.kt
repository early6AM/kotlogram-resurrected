package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * dialogFolder#71bd134c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialogFolder() : TLAbsDialog() {
    @Transient
    override var pinned: Boolean = false

    var folder: TLFolder = TLFolder()

    override var peer: TLAbsPeer = TLPeerChat()

    override var topMessage: Int = 0

    var unreadMutedPeersCount: Int = 0

    var unreadUnmutedPeersCount: Int = 0

    var unreadMutedMessagesCount: Int = 0

    var unreadUnmutedMessagesCount: Int = 0

    private val _constructor: String = "dialogFolder#71bd134c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            folder: TLFolder,
            peer: TLAbsPeer,
            topMessage: Int,
            unreadMutedPeersCount: Int,
            unreadUnmutedPeersCount: Int,
            unreadMutedMessagesCount: Int,
            unreadUnmutedMessagesCount: Int
    ) : this() {
        this.pinned = pinned
        this.folder = folder
        this.peer = peer
        this.topMessage = topMessage
        this.unreadMutedPeersCount = unreadMutedPeersCount
        this.unreadUnmutedPeersCount = unreadUnmutedPeersCount
        this.unreadMutedMessagesCount = unreadMutedMessagesCount
        this.unreadUnmutedMessagesCount = unreadUnmutedMessagesCount
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(folder)
        writeTLObject(peer)
        writeInt(topMessage)
        writeInt(unreadMutedPeersCount)
        writeInt(unreadUnmutedPeersCount)
        writeInt(unreadMutedMessagesCount)
        writeInt(unreadUnmutedMessagesCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(4)
        folder = readTLObject<TLFolder>(TLFolder::class, TLFolder.CONSTRUCTOR_ID)
        peer = readTLObject<TLAbsPeer>()
        topMessage = readInt()
        unreadMutedPeersCount = readInt()
        unreadUnmutedPeersCount = readInt()
        unreadMutedMessagesCount = readInt()
        unreadUnmutedMessagesCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += folder.computeSerializedSize()
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialogFolder) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && folder == other.folder
                && peer == other.peer
                && topMessage == other.topMessage
                && unreadMutedPeersCount == other.unreadMutedPeersCount
                && unreadUnmutedPeersCount == other.unreadUnmutedPeersCount
                && unreadMutedMessagesCount == other.unreadMutedMessagesCount
                && unreadUnmutedMessagesCount == other.unreadUnmutedMessagesCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x71bd134c
    }
}

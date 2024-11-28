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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updateDialogPinned#6e6fe51c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDialogPinned() : TLAbsUpdate() {
    @Transient
    var pinned: Boolean = false

    var folderId: Int? = null

    var peer: TLAbsDialogPeer = TLDialogPeerFolder()

    private val _constructor: String = "updateDialogPinned#6e6fe51c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            folderId: Int?,
            peer: TLAbsDialogPeer
    ) : this() {
        this.pinned = pinned
        this.folderId = folderId
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 1)
        updateFlags(folderId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(folderId, 2) { writeInt(it) }
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(1)
        folderId = readIfMask(2) { readInt() }
        peer = readTLObject<TLAbsDialogPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(folderId, 2) { SIZE_INT32 }
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateDialogPinned) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && folderId == other.folderId
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6e6fe51c.toInt()
    }
}

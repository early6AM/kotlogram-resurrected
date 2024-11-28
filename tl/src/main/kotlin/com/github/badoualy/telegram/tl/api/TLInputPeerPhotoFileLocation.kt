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
 * inputPeerPhotoFileLocation#37257e99
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPeerPhotoFileLocation() : TLAbsInputFileLocation() {
    @Transient
    var big: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var photoId: Long = 0L

    private val _constructor: String = "inputPeerPhotoFileLocation#37257e99"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            big: Boolean,
            peer: TLAbsInputPeer,
            photoId: Long
    ) : this() {
        this.big = big
        this.peer = peer
        this.photoId = photoId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(big, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeLong(photoId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        big = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        photoId = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPeerPhotoFileLocation) return false
        if (other === this) return true

        return _flags == other._flags
                && big == other.big
                && peer == other.peer
                && photoId == other.photoId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x37257e99.toInt()
    }
}

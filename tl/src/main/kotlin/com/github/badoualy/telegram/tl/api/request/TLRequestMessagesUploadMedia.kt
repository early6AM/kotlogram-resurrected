package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsMessageMedia
import com.github.badoualy.telegram.tl.api.TLInputMediaEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesUploadMedia() : TLMethod<TLAbsMessageMedia>() {
    var businessConnectionId: String? = null

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var media: TLAbsInputMedia = TLInputMediaEmpty()

    private val _constructor: String = "messages.uploadMedia#14967978"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            businessConnectionId: String?,
            peer: TLAbsInputPeer,
            media: TLAbsInputMedia
    ) : this() {
        this.businessConnectionId = businessConnectionId
        this.peer = peer
        this.media = media
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(businessConnectionId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(businessConnectionId, 1) { writeString(it) }
        writeTLObject(peer)
        writeTLObject(media)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        businessConnectionId = readIfMask(1) { readString() }
        peer = readTLObject<TLAbsInputPeer>()
        media = readTLObject<TLAbsInputMedia>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(businessConnectionId, 1) { computeTLStringSerializedSize(it) }
        size += peer.computeSerializedSize()
        size += media.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesUploadMedia) return false
        if (other === this) return true

        return _flags == other._flags
                && businessConnectionId == other.businessConnectionId
                && peer == other.peer
                && media == other.media
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x14967978.toInt()
    }
}

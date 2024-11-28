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

/**
 * updateMessageExtendedMedia#5a73a98c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMessageExtendedMedia() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var msgId: Int = 0

    var extendedMedia: TLAbsMessageExtendedMedia = TLMessageExtendedMedia()

    private val _constructor: String = "updateMessageExtendedMedia#5a73a98c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            msgId: Int,
            extendedMedia: TLAbsMessageExtendedMedia
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.extendedMedia = extendedMedia
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(msgId)
        writeTLObject(extendedMedia)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        msgId = readInt()
        extendedMedia = readTLObject<TLAbsMessageExtendedMedia>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += extendedMedia.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMessageExtendedMedia) return false
        if (other === this) return true

        return peer == other.peer
                && msgId == other.msgId
                && extendedMedia == other.extendedMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5a73a98c.toInt()
    }
}

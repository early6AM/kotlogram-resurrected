package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLIntVector
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
class TLRequestStoriesTogglePinned() : TLMethod<TLIntVector>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: TLIntVector = TLIntVector()

    var pinned: Boolean = false

    private val _constructor: String = "stories.togglePinned#9a75a1ef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            pinned: Boolean
    ) : this() {
        this.peer = peer
        this.id = id
        this.pinned = pinned
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLIntVector = tlDeserializer.readTLIntVector()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLVector(id)
        writeBoolean(pinned)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        id = readTLIntVector()
        pinned = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += id.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesTogglePinned) return false
        if (other === this) return true

        return peer == other.peer
                && id == other.id
                && pinned == other.pinned
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a75a1ef.toInt()
    }
}

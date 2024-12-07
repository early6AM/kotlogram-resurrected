package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
class TLRequestMessagesGetSearchCounters() : TLMethod<TLObjectVector<TLSearchCounter>>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var savedPeerId: TLAbsInputPeer? = null

    var topMsgId: Int? = null

    var filters: TLObjectVector<TLAbsMessagesFilter> = TLObjectVector()

    private val _constructor: String = "messages.getSearchCounters#1bbcf300"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            topMsgId: Int?,
            filters: TLObjectVector<TLAbsMessagesFilter>
    ) : this() {
        this.peer = peer
        this.savedPeerId = savedPeerId
        this.topMsgId = topMsgId
        this.filters = filters
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLSearchCounter> = tlDeserializer.readTLVector<TLSearchCounter>()

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(savedPeerId, 4)
        updateFlags(topMsgId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(1, savedPeerId, 4) { writeTLObject(it) }
        doIfMask(1, topMsgId, 1) { writeInt(it) }
        writeTLVector(filters)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        savedPeerId = readIfMask(1, 4) { readTLObject<TLAbsInputPeer>() }
        topMsgId = readIfMask(1, 1) { readInt() }
        filters = readTLVector<TLAbsMessagesFilter>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(1, savedPeerId, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, topMsgId, 1) { SIZE_INT32 }
        size += filters.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetSearchCounters) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && savedPeerId == other.savedPeerId
                && topMsgId == other.topMsgId
                && filters == other.filters
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1bbcf300.toInt()
    }
}

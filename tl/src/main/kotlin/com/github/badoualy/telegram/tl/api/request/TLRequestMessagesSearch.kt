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
import com.github.badoualy.telegram.tl.api.TLAbsReaction
import com.github.badoualy.telegram.tl.api.TLInputMessagesFilterEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSearch() : TLMethod<TLAbsMessages>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var q: String = ""

    var fromId: TLAbsInputPeer? = null

    var savedPeerId: TLAbsInputPeer? = null

    var savedReaction: TLObjectVector<TLAbsReaction>? = TLObjectVector()

    var topMsgId: Int? = null

    var filter: TLAbsMessagesFilter = TLInputMessagesFilterEmpty()

    var minDate: Int = 0

    var maxDate: Int = 0

    var offsetId: Int = 0

    var addOffset: Int = 0

    var limit: Int = 0

    var maxId: Int = 0

    var minId: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "messages.search#29ee847a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputPeer?,
            savedPeerId: TLAbsInputPeer?,
            savedReaction: TLObjectVector<TLAbsReaction>?,
            topMsgId: Int?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ) : this() {
        this.peer = peer
        this.q = q
        this.fromId = fromId
        this.savedPeerId = savedPeerId
        this.savedReaction = savedReaction
        this.topMsgId = topMsgId
        this.filter = filter
        this.minDate = minDate
        this.maxDate = maxDate
        this.offsetId = offsetId
        this.addOffset = addOffset
        this.limit = limit
        this.maxId = maxId
        this.minId = minId
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromId, 1)
        updateFlags(savedPeerId, 4)
        updateFlags(savedReaction, 8)
        updateFlags(topMsgId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeString(q)
        doIfMask(fromId, 1) { writeTLObject(it) }
        doIfMask(savedPeerId, 4) { writeTLObject(it) }
        doIfMask(savedReaction, 8) { writeTLVector(it) }
        doIfMask(topMsgId, 2) { writeInt(it) }
        writeTLObject(filter)
        writeInt(minDate)
        writeInt(maxDate)
        writeInt(offsetId)
        writeInt(addOffset)
        writeInt(limit)
        writeInt(maxId)
        writeInt(minId)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        q = readString()
        fromId = readIfMask(1) { readTLObject<TLAbsInputPeer>() }
        savedPeerId = readIfMask(4) { readTLObject<TLAbsInputPeer>() }
        savedReaction = readIfMask(8) { readTLVector<TLAbsReaction>() }
        topMsgId = readIfMask(2) { readInt() }
        filter = readTLObject<TLAbsMessagesFilter>()
        minDate = readInt()
        maxDate = readInt()
        offsetId = readInt()
        addOffset = readInt()
        limit = readInt()
        maxId = readInt()
        minId = readInt()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += computeTLStringSerializedSize(q)
        size += getIntIfMask(fromId, 1) { it.computeSerializedSize() }
        size += getIntIfMask(savedPeerId, 4) { it.computeSerializedSize() }
        size += getIntIfMask(savedReaction, 8) { it.computeSerializedSize() }
        size += getIntIfMask(topMsgId, 2) { SIZE_INT32 }
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSearch) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && q == other.q
                && fromId == other.fromId
                && savedPeerId == other.savedPeerId
                && savedReaction == other.savedReaction
                && topMsgId == other.topMsgId
                && filter == other.filter
                && minDate == other.minDate
                && maxDate == other.maxDate
                && offsetId == other.offsetId
                && addOffset == other.addOffset
                && limit == other.limit
                && maxId == other.maxId
                && minId == other.minId
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x29ee847a.toInt()
    }
}

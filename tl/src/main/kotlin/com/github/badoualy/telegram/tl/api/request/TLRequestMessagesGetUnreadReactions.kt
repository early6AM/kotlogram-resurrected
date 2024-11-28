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
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
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
class TLRequestMessagesGetUnreadReactions() : TLMethod<TLAbsMessages>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var topMsgId: Int? = null

    var offsetId: Int = 0

    var addOffset: Int = 0

    var limit: Int = 0

    var maxId: Int = 0

    var minId: Int = 0

    private val _constructor: String = "messages.getUnreadReactions#3223495b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ) : this() {
        this.peer = peer
        this.topMsgId = topMsgId
        this.offsetId = offsetId
        this.addOffset = addOffset
        this.limit = limit
        this.maxId = maxId
        this.minId = minId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(topMsgId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(topMsgId, 1) { writeInt(it) }
        writeInt(offsetId)
        writeInt(addOffset)
        writeInt(limit)
        writeInt(maxId)
        writeInt(minId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        topMsgId = readIfMask(1) { readInt() }
        offsetId = readInt()
        addOffset = readInt()
        limit = readInt()
        maxId = readInt()
        minId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(topMsgId, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetUnreadReactions) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && topMsgId == other.topMsgId
                && offsetId == other.offsetId
                && addOffset == other.addOffset
                && limit == other.limit
                && maxId == other.maxId
                && minId == other.minId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3223495b.toInt()
    }
}

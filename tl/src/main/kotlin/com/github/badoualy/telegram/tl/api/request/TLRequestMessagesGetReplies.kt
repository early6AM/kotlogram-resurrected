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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetReplies() : TLMethod<TLAbsMessages>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var offsetId: Int = 0

    var offsetDate: Int = 0

    var addOffset: Int = 0

    var limit: Int = 0

    var maxId: Int = 0

    var minId: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "messages.getReplies#22ddd30c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            msgId: Int,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.offsetId = offsetId
        this.offsetDate = offsetDate
        this.addOffset = addOffset
        this.limit = limit
        this.maxId = maxId
        this.minId = minId
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(msgId)
        writeInt(offsetId)
        writeInt(offsetDate)
        writeInt(addOffset)
        writeInt(limit)
        writeInt(maxId)
        writeInt(minId)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        offsetId = readInt()
        offsetDate = readInt()
        addOffset = readInt()
        limit = readInt()
        maxId = readInt()
        minId = readInt()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
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
        if (other !is TLRequestMessagesGetReplies) return false
        if (other === this) return true

        return peer == other.peer
                && msgId == other.msgId
                && offsetId == other.offsetId
                && offsetDate == other.offsetDate
                && addOffset == other.addOffset
                && limit == other.limit
                && maxId == other.maxId
                && minId == other.minId
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x22ddd30c.toInt()
    }
}

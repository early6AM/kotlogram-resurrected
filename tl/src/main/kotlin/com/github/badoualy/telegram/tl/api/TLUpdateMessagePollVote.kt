package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytesVector
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
 * updateMessagePollVote#24f40e77
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMessagePollVote() : TLAbsUpdate() {
    var pollId: Long = 0L

    var peer: TLAbsPeer = TLPeerChat()

    var options: TLBytesVector = TLBytesVector()

    var qts: Int = 0

    private val _constructor: String = "updateMessagePollVote#24f40e77"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pollId: Long,
            peer: TLAbsPeer,
            options: TLBytesVector,
            qts: Int
    ) : this() {
        this.pollId = pollId
        this.peer = peer
        this.options = options
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(pollId)
        writeTLObject(peer)
        writeTLVector(options)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pollId = readLong()
        peer = readTLObject<TLAbsPeer>()
        options = readTLBytesVector()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += peer.computeSerializedSize()
        size += options.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMessagePollVote) return false
        if (other === this) return true

        return pollId == other.pollId
                && peer == other.peer
                && options == other.options
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x24f40e77.toInt()
    }
}

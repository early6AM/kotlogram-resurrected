package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateMessagePollVote#106395c9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMessagePollVote() : TLAbsUpdate() {
    var pollId: Long = 0L

    var userId: Long = 0L

    var options: TLBytesVector = TLBytesVector()

    var qts: Int = 0

    private val _constructor: String = "updateMessagePollVote#106395c9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pollId: Long,
            userId: Long,
            options: TLBytesVector,
            qts: Int
    ) : this() {
        this.pollId = pollId
        this.userId = userId
        this.options = options
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(pollId)
        writeLong(userId)
        writeTLVector(options)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pollId = readLong()
        userId = readLong()
        options = readTLBytesVector()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += options.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMessagePollVote) return false
        if (other === this) return true

        return pollId == other.pollId
                && userId == other.userId
                && options == other.options
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x106395c9
    }
}

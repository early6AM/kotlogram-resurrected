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

/**
 * updateMessagePoll#aca1657b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMessagePoll() : TLAbsUpdate() {
    var pollId: Long = 0L

    var poll: TLPoll? = null

    var results: TLPollResults = TLPollResults()

    private val _constructor: String = "updateMessagePoll#aca1657b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pollId: Long,
            poll: TLPoll?,
            results: TLPollResults
    ) : this() {
        this.pollId = pollId
        this.poll = poll
        this.results = results
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(poll, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(pollId)
        doIfMask(poll, 1) { writeTLObject(it) }
        writeTLObject(results)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pollId = readLong()
        poll = readIfMask(1) { readTLObject<TLPoll>(TLPoll::class, TLPoll.CONSTRUCTOR_ID) }
        results = readTLObject<TLPollResults>(TLPollResults::class, TLPollResults.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(poll, 1) { it.computeSerializedSize() }
        size += results.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMessagePoll) return false
        if (other === this) return true

        return _flags == other._flags
                && pollId == other.pollId
                && poll == other.poll
                && results == other.results
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaca1657b.toInt()
    }
}

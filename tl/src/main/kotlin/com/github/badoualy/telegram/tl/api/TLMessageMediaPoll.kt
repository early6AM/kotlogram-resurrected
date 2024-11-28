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
 * messageMediaPoll#4bd6e798
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaPoll() : TLAbsMessageMedia() {
    var poll: TLPoll = TLPoll()

    var results: TLPollResults = TLPollResults()

    private val _constructor: String = "messageMediaPoll#4bd6e798"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(poll: TLPoll, results: TLPollResults) : this() {
        this.poll = poll
        this.results = results
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(poll)
        writeTLObject(results)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        poll = readTLObject<TLPoll>(TLPoll::class, TLPoll.CONSTRUCTOR_ID)
        results = readTLObject<TLPollResults>(TLPollResults::class, TLPollResults.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += poll.computeSerializedSize()
        size += results.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaPoll) return false
        if (other === this) return true

        return poll == other.poll
                && results == other.results
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4bd6e798.toInt()
    }
}

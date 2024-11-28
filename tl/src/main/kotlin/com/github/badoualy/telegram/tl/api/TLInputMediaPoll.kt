package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytesVector
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
 * inputMediaPoll#f94e5f1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaPoll() : TLAbsInputMedia() {
    var poll: TLPoll = TLPoll()

    var correctAnswers: TLBytesVector? = null

    var solution: String? = null

    var solutionEntities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "inputMediaPoll#f94e5f1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            poll: TLPoll,
            correctAnswers: TLBytesVector?,
            solution: String?,
            solutionEntities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.poll = poll
        this.correctAnswers = correctAnswers
        this.solution = solution
        this.solutionEntities = solutionEntities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(correctAnswers, 1)
        updateFlags(solution, 2)
        updateFlags(solutionEntities, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(poll)
        doIfMask(correctAnswers, 1) { writeTLVector(it) }
        doIfMask(solution, 2) { writeString(it) }
        doIfMask(solutionEntities, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        poll = readTLObject<TLPoll>(TLPoll::class, TLPoll.CONSTRUCTOR_ID)
        correctAnswers = readIfMask(1) { readTLBytesVector() }
        solution = readIfMask(2) { readString() }
        solutionEntities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += poll.computeSerializedSize()
        size += getIntIfMask(correctAnswers, 1) { it.computeSerializedSize() }
        size += getIntIfMask(solution, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(solutionEntities, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaPoll) return false
        if (other === this) return true

        return _flags == other._flags
                && poll == other.poll
                && correctAnswers == other.correctAnswers
                && solution == other.solution
                && solutionEntities == other.solutionEntities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf94e5f1.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * pollResults#7adf2420
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPollResults() : TLObject() {
    @Transient
    var min: Boolean = false

    var results: TLObjectVector<TLPollAnswerVoters>? = TLObjectVector()

    var totalVoters: Int? = null

    var recentVoters: TLObjectVector<TLAbsPeer>? = TLObjectVector()

    var solution: String? = null

    var solutionEntities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "pollResults#7adf2420"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            min: Boolean,
            results: TLObjectVector<TLPollAnswerVoters>?,
            totalVoters: Int?,
            recentVoters: TLObjectVector<TLAbsPeer>?,
            solution: String?,
            solutionEntities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.min = min
        this.results = results
        this.totalVoters = totalVoters
        this.recentVoters = recentVoters
        this.solution = solution
        this.solutionEntities = solutionEntities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(min, 1)
        updateFlags(results, 2)
        updateFlags(totalVoters, 4)
        updateFlags(recentVoters, 8)
        updateFlags(solution, 16)
        updateFlags(solutionEntities, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(results, 2) { writeTLVector(it) }
        doIfMask(totalVoters, 4) { writeInt(it) }
        doIfMask(recentVoters, 8) { writeTLVector(it) }
        doIfMask(solution, 16) { writeString(it) }
        doIfMask(solutionEntities, 16) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        min = isMask(1)
        results = readIfMask(2) { readTLVector<TLPollAnswerVoters>() }
        totalVoters = readIfMask(4) { readInt() }
        recentVoters = readIfMask(8) { readTLVector<TLAbsPeer>() }
        solution = readIfMask(16) { readString() }
        solutionEntities = readIfMask(16) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(results, 2) { it.computeSerializedSize() }
        size += getIntIfMask(totalVoters, 4) { SIZE_INT32 }
        size += getIntIfMask(recentVoters, 8) { it.computeSerializedSize() }
        size += getIntIfMask(solution, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(solutionEntities, 16) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPollResults) return false
        if (other === this) return true

        return _flags == other._flags
                && min == other.min
                && results == other.results
                && totalVoters == other.totalVoters
                && recentVoters == other.recentVoters
                && solution == other.solution
                && solutionEntities == other.solutionEntities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7adf2420.toInt()
    }
}

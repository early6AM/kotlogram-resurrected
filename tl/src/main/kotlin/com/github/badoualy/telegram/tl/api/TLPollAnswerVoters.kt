package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
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
 * pollAnswerVoters#3b6ddad2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPollAnswerVoters() : TLObject() {
    @Transient
    var chosen: Boolean = false

    @Transient
    var correct: Boolean = false

    var option: TLBytes = TLBytes.EMPTY

    var voters: Int = 0

    private val _constructor: String = "pollAnswerVoters#3b6ddad2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chosen: Boolean,
            correct: Boolean,
            option: TLBytes,
            voters: Int
    ) : this() {
        this.chosen = chosen
        this.correct = correct
        this.option = option
        this.voters = voters
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(chosen, 1)
        updateFlags(correct, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLBytes(option)
        writeInt(voters)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chosen = isMask(1)
        correct = isMask(2)
        option = readTLBytes()
        voters = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(option)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPollAnswerVoters) return false
        if (other === this) return true

        return _flags == other._flags
                && chosen == other.chosen
                && correct == other.correct
                && option == other.option
                && voters == other.voters
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3b6ddad2.toInt()
    }
}

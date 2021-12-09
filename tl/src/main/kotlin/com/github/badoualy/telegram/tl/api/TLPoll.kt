package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * poll#86e18161
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPoll() : TLObject() {
    var id: Long = 0L

    @Transient
    var closed: Boolean = false

    @Transient
    var publicVoters: Boolean = false

    @Transient
    var multipleChoice: Boolean = false

    @Transient
    var quiz: Boolean = false

    var question: String = ""

    var answers: TLObjectVector<TLPollAnswer> = TLObjectVector()

    var closePeriod: Int? = null

    var closeDate: Int? = null

    private val _constructor: String = "poll#86e18161"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            closed: Boolean,
            publicVoters: Boolean,
            multipleChoice: Boolean,
            quiz: Boolean,
            question: String,
            answers: TLObjectVector<TLPollAnswer>,
            closePeriod: Int?,
            closeDate: Int?
    ) : this() {
        this.id = id
        this.closed = closed
        this.publicVoters = publicVoters
        this.multipleChoice = multipleChoice
        this.quiz = quiz
        this.question = question
        this.answers = answers
        this.closePeriod = closePeriod
        this.closeDate = closeDate
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(closed, 1)
        updateFlags(publicVoters, 2)
        updateFlags(multipleChoice, 4)
        updateFlags(quiz, 8)
        updateFlags(closePeriod, 16)
        updateFlags(closeDate, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeLong(id)
        writeInt(_flags)
        writeString(question)
        writeTLVector(answers)
        doIfMask(closePeriod, 16) { writeInt(it) }
        doIfMask(closeDate, 32) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        _flags = readInt()
        closed = isMask(1)
        publicVoters = isMask(2)
        multipleChoice = isMask(4)
        quiz = isMask(8)
        question = readString()
        answers = readTLVector<TLPollAnswer>()
        closePeriod = readIfMask(16) { readInt() }
        closeDate = readIfMask(32) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(question)
        size += answers.computeSerializedSize()
        size += getIntIfMask(closePeriod, 16) { SIZE_INT32 }
        size += getIntIfMask(closeDate, 32) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPoll) return false
        if (other === this) return true

        return id == other.id
                && _flags == other._flags
                && closed == other.closed
                && publicVoters == other.publicVoters
                && multipleChoice == other.multipleChoice
                && quiz == other.quiz
                && question == other.question
                && answers == other.answers
                && closePeriod == other.closePeriod
                && closeDate == other.closeDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86e18161.toInt()
    }
}

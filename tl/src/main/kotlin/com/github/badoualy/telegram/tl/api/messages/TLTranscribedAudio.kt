package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messages.transcribedAudio#cfb9d957
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTranscribedAudio() : TLObject() {
    @Transient
    var pending: Boolean = false

    var transcriptionId: Long = 0L

    var text: String = ""

    var trialRemainsNum: Int? = null

    var trialRemainsUntilDate: Int? = null

    private val _constructor: String = "messages.transcribedAudio#cfb9d957"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pending: Boolean,
            transcriptionId: Long,
            text: String,
            trialRemainsNum: Int?,
            trialRemainsUntilDate: Int?
    ) : this() {
        this.pending = pending
        this.transcriptionId = transcriptionId
        this.text = text
        this.trialRemainsNum = trialRemainsNum
        this.trialRemainsUntilDate = trialRemainsUntilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pending, 1)
        updateFlags(trialRemainsNum, 2)
        updateFlags(trialRemainsUntilDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(transcriptionId)
        writeString(text)
        doIfMask(trialRemainsNum, 2) { writeInt(it) }
        doIfMask(trialRemainsUntilDate, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pending = isMask(1)
        transcriptionId = readLong()
        text = readString()
        trialRemainsNum = readIfMask(2) { readInt() }
        trialRemainsUntilDate = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(text)
        size += getIntIfMask(trialRemainsNum, 2) { SIZE_INT32 }
        size += getIntIfMask(trialRemainsUntilDate, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTranscribedAudio) return false
        if (other === this) return true

        return _flags == other._flags
                && pending == other.pending
                && transcriptionId == other.transcriptionId
                && text == other.text
                && trialRemainsNum == other.trialRemainsNum
                && trialRemainsUntilDate == other.trialRemainsUntilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcfb9d957.toInt()
    }
}

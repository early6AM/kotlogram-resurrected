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
 * groupCallParticipantVideo#67753ac8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupCallParticipantVideo() : TLObject() {
    @Transient
    var paused: Boolean = false

    var endpoint: String = ""

    var sourceGroups: TLObjectVector<TLGroupCallParticipantVideoSourceGroup> = TLObjectVector()

    var audioSource: Int? = null

    private val _constructor: String = "groupCallParticipantVideo#67753ac8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            paused: Boolean,
            endpoint: String,
            sourceGroups: TLObjectVector<TLGroupCallParticipantVideoSourceGroup>,
            audioSource: Int?
    ) : this() {
        this.paused = paused
        this.endpoint = endpoint
        this.sourceGroups = sourceGroups
        this.audioSource = audioSource
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(paused, 1)
        updateFlags(audioSource, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(endpoint)
        writeTLVector(sourceGroups)
        doIfMask(1, audioSource, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        paused = isMask(1, 1)
        endpoint = readString()
        sourceGroups = readTLVector<TLGroupCallParticipantVideoSourceGroup>()
        audioSource = readIfMask(1, 2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(endpoint)
        size += sourceGroups.computeSerializedSize()
        size += getIntIfMask(1, audioSource, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupCallParticipantVideo) return false
        if (other === this) return true

        return _flags == other._flags
                && paused == other.paused
                && endpoint == other.endpoint
                && sourceGroups == other.sourceGroups
                && audioSource == other.audioSource
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x67753ac8.toInt()
    }
}

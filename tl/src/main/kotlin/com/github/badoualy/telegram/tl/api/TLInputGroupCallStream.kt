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
 * inputGroupCallStream#598a92a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputGroupCallStream() : TLAbsInputFileLocation() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var timeMs: Long = 0L

    var scale: Int = 0

    var videoChannel: Int? = null

    var videoQuality: Int? = null

    private val _constructor: String = "inputGroupCallStream#598a92a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            call: TLInputGroupCall,
            timeMs: Long,
            scale: Int,
            videoChannel: Int?,
            videoQuality: Int?
    ) : this() {
        this.call = call
        this.timeMs = timeMs
        this.scale = scale
        this.videoChannel = videoChannel
        this.videoQuality = videoQuality
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(videoChannel, 1)
        updateFlags(videoQuality, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(call)
        writeLong(timeMs)
        writeInt(scale)
        doIfMask(videoChannel, 1) { writeInt(it) }
        doIfMask(videoQuality, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        timeMs = readLong()
        scale = readInt()
        videoChannel = readIfMask(1) { readInt() }
        videoQuality = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += call.computeSerializedSize()
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(videoChannel, 1) { SIZE_INT32 }
        size += getIntIfMask(videoQuality, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputGroupCallStream) return false
        if (other === this) return true

        return _flags == other._flags
                && call == other.call
                && timeMs == other.timeMs
                && scale == other.scale
                && videoChannel == other.videoChannel
                && videoQuality == other.videoQuality
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x598a92a.toInt()
    }
}

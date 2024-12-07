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
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * videoSize#de33b094
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLVideoSize() : TLAbsVideoSize() {
    var type: String = ""

    var w: Int = 0

    var h: Int = 0

    var size: Int = 0

    var videoStartTs: Double? = null

    private val _constructor: String = "videoSize#de33b094"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: String,
            w: Int,
            h: Int,
            size: Int,
            videoStartTs: Double?
    ) : this() {
        this.type = type
        this.w = w
        this.h = h
        this.size = size
        this.videoStartTs = videoStartTs
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(videoStartTs, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(type)
        writeInt(w)
        writeInt(h)
        writeInt(size)
        doIfMask(1, videoStartTs, 1) { writeDouble(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        type = readString()
        w = readInt()
        h = readInt()
        size = readInt()
        videoStartTs = readIfMask(1, 1) { readDouble() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(type)
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, videoStartTs, 1) { SIZE_DOUBLE }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLVideoSize) return false
        if (other === this) return true

        return _flags == other._flags
                && type == other.type
                && w == other.w
                && h == other.h
                && size == other.size
                && videoStartTs == other.videoStartTs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xde33b094.toInt()
    }
}

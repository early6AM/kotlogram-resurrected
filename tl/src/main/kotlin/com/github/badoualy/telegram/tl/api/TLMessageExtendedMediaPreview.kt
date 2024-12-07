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
 * messageExtendedMediaPreview#ad628cc8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageExtendedMediaPreview() : TLAbsMessageExtendedMedia() {
    var w: Int? = null

    var h: Int? = null

    var thumb: TLAbsPhotoSize? = null

    var videoDuration: Int? = null

    private val _constructor: String = "messageExtendedMediaPreview#ad628cc8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            w: Int?,
            h: Int?,
            thumb: TLAbsPhotoSize?,
            videoDuration: Int?
    ) : this() {
        this.w = w
        this.h = h
        this.thumb = thumb
        this.videoDuration = videoDuration
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(w, 1)
        updateFlags(h, 1)
        updateFlags(thumb, 2)
        updateFlags(videoDuration, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, w, 1) { writeInt(it) }
        doIfMask(1, h, 1) { writeInt(it) }
        doIfMask(1, thumb, 2) { writeTLObject(it) }
        doIfMask(1, videoDuration, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        w = readIfMask(1, 1) { readInt() }
        h = readIfMask(1, 1) { readInt() }
        thumb = readIfMask(1, 2) { readTLObject<TLAbsPhotoSize>() }
        videoDuration = readIfMask(1, 4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, w, 1) { SIZE_INT32 }
        size += getIntIfMask(1, h, 1) { SIZE_INT32 }
        size += getIntIfMask(1, thumb, 2) { it.computeSerializedSize() }
        size += getIntIfMask(1, videoDuration, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageExtendedMediaPreview) return false
        if (other === this) return true

        return _flags == other._flags
                && w == other.w
                && h == other.h
                && thumb == other.thumb
                && videoDuration == other.videoDuration
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xad628cc8.toInt()
    }
}

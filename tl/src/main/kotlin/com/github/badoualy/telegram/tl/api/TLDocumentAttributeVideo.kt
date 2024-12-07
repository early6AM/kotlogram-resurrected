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
import kotlin.jvm.Transient

/**
 * documentAttributeVideo#17399fad
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeVideo() : TLAbsDocumentAttribute() {
    @Transient
    var roundMessage: Boolean = false

    @Transient
    var supportsStreaming: Boolean = false

    @Transient
    var nosound: Boolean = false

    var duration: Double = 0.0

    var w: Int = 0

    var h: Int = 0

    var preloadPrefixSize: Int? = null

    var videoStartTs: Double? = null

    private val _constructor: String = "documentAttributeVideo#17399fad"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            roundMessage: Boolean,
            supportsStreaming: Boolean,
            nosound: Boolean,
            duration: Double,
            w: Int,
            h: Int,
            preloadPrefixSize: Int?,
            videoStartTs: Double?
    ) : this() {
        this.roundMessage = roundMessage
        this.supportsStreaming = supportsStreaming
        this.nosound = nosound
        this.duration = duration
        this.w = w
        this.h = h
        this.preloadPrefixSize = preloadPrefixSize
        this.videoStartTs = videoStartTs
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(roundMessage, 1)
        updateFlags(supportsStreaming, 2)
        updateFlags(nosound, 8)
        updateFlags(preloadPrefixSize, 4)
        updateFlags(videoStartTs, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeDouble(duration)
        writeInt(w)
        writeInt(h)
        doIfMask(preloadPrefixSize, 4) { writeInt(it) }
        doIfMask(videoStartTs, 16) { writeDouble(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        roundMessage = isMask(1)
        supportsStreaming = isMask(2)
        nosound = isMask(8)
        duration = readDouble()
        w = readInt()
        h = readInt()
        preloadPrefixSize = readIfMask(4) { readInt() }
        videoStartTs = readIfMask(16) { readDouble() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_DOUBLE
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(preloadPrefixSize, 4) { SIZE_INT32 }
        size += getIntIfMask(videoStartTs, 16) { SIZE_DOUBLE }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeVideo) return false
        if (other === this) return true

        return _flags == other._flags
                && roundMessage == other.roundMessage
                && supportsStreaming == other.supportsStreaming
                && nosound == other.nosound
                && duration == other.duration
                && w == other.w
                && h == other.h
                && preloadPrefixSize == other.preloadPrefixSize
                && videoStartTs == other.videoStartTs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x17399fad.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

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
 * autoSaveSettings#c84834ce
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAutoSaveSettings() : TLObject() {
    @Transient
    var photos: Boolean = false

    @Transient
    var videos: Boolean = false

    var videoMaxSize: Long? = null

    private val _constructor: String = "autoSaveSettings#c84834ce"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            photos: Boolean,
            videos: Boolean,
            videoMaxSize: Long?
    ) : this() {
        this.photos = photos
        this.videos = videos
        this.videoMaxSize = videoMaxSize
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photos, 1)
        updateFlags(videos, 2)
        updateFlags(videoMaxSize, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(videoMaxSize, 4) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        photos = isMask(1)
        videos = isMask(2)
        videoMaxSize = readIfMask(4) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(videoMaxSize, 4) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAutoSaveSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && photos == other.photos
                && videos == other.videos
                && videoMaxSize == other.videoMaxSize
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc84834ce.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * chatPhoto#1c6e1c11
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatPhoto() : TLAbsChatPhoto() {
    @Transient
    var hasVideo: Boolean = false

    var photoId: Long = 0L

    var strippedThumb: TLBytes? = null

    var dcId: Int = 0

    private val _constructor: String = "chatPhoto#1c6e1c11"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasVideo: Boolean,
            photoId: Long,
            strippedThumb: TLBytes?,
            dcId: Int
    ) : this() {
        this.hasVideo = hasVideo
        this.photoId = photoId
        this.strippedThumb = strippedThumb
        this.dcId = dcId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasVideo, 1)
        updateFlags(strippedThumb, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(photoId)
        doIfMask(strippedThumb, 2) { writeTLBytes(it) }
        writeInt(dcId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasVideo = isMask(1)
        photoId = readLong()
        strippedThumb = readIfMask(2) { readTLBytes() }
        dcId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(strippedThumb, 2) { computeTLBytesSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && hasVideo == other.hasVideo
                && photoId == other.photoId
                && strippedThumb == other.strippedThumb
                && dcId == other.dcId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1c6e1c11.toInt()
    }
}

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
 * userProfilePhoto#82d1f706
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserProfilePhoto() : TLAbsUserProfilePhoto() {
    @Transient
    var hasVideo: Boolean = false

    @Transient
    var personal: Boolean = false

    var photoId: Long = 0L

    var strippedThumb: TLBytes? = null

    var dcId: Int = 0

    private val _constructor: String = "userProfilePhoto#82d1f706"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasVideo: Boolean,
            personal: Boolean,
            photoId: Long,
            strippedThumb: TLBytes?,
            dcId: Int
    ) : this() {
        this.hasVideo = hasVideo
        this.personal = personal
        this.photoId = photoId
        this.strippedThumb = strippedThumb
        this.dcId = dcId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(hasVideo, 1)
        updateFlags(personal, 4)
        updateFlags(strippedThumb, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(photoId)
        doIfMask(1, strippedThumb, 2) { writeTLBytes(it) }
        writeInt(dcId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasVideo = isMask(1, 1)
        personal = isMask(1, 4)
        photoId = readLong()
        strippedThumb = readIfMask(1, 2) { readTLBytes() }
        dcId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, strippedThumb, 2) { computeTLBytesSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserProfilePhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && hasVideo == other.hasVideo
                && personal == other.personal
                && photoId == other.photoId
                && strippedThumb == other.strippedThumb
                && dcId == other.dcId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x82d1f706.toInt()
    }
}

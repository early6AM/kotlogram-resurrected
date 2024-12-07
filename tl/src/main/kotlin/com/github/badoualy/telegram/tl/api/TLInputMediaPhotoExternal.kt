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
import kotlin.jvm.Transient

/**
 * inputMediaPhotoExternal#e5bbfe1a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaPhotoExternal() : TLAbsInputMedia() {
    @Transient
    var spoiler: Boolean = false

    var url: String = ""

    var ttlSeconds: Int? = null

    private val _constructor: String = "inputMediaPhotoExternal#e5bbfe1a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            spoiler: Boolean,
            url: String,
            ttlSeconds: Int?
    ) : this() {
        this.spoiler = spoiler
        this.url = url
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(spoiler, 2)
        updateFlags(ttlSeconds, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
        doIfMask(1, ttlSeconds, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        spoiler = isMask(1, 2)
        url = readString()
        ttlSeconds = readIfMask(1, 1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += getIntIfMask(1, ttlSeconds, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaPhotoExternal) return false
        if (other === this) return true

        return _flags == other._flags
                && spoiler == other.spoiler
                && url == other.url
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe5bbfe1a.toInt()
    }
}

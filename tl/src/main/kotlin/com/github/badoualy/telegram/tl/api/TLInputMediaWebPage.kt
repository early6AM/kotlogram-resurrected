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
 * inputMediaWebPage#c21b8849
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaWebPage() : TLAbsInputMedia() {
    @Transient
    var forceLargeMedia: Boolean = false

    @Transient
    var forceSmallMedia: Boolean = false

    @Transient
    var optional: Boolean = false

    var url: String = ""

    private val _constructor: String = "inputMediaWebPage#c21b8849"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forceLargeMedia: Boolean,
            forceSmallMedia: Boolean,
            optional: Boolean,
            url: String
    ) : this() {
        this.forceLargeMedia = forceLargeMedia
        this.forceSmallMedia = forceSmallMedia
        this.optional = optional
        this.url = url
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(forceLargeMedia, 1)
        updateFlags(forceSmallMedia, 2)
        updateFlags(optional, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forceLargeMedia = isMask(1)
        forceSmallMedia = isMask(2)
        optional = isMask(4)
        url = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaWebPage) return false
        if (other === this) return true

        return _flags == other._flags
                && forceLargeMedia == other.forceLargeMedia
                && forceSmallMedia == other.forceSmallMedia
                && optional == other.optional
                && url == other.url
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc21b8849.toInt()
    }
}

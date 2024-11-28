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
import kotlin.String
import kotlin.jvm.Throws

/**
 * sponsoredWebPage#3db8ec63
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSponsoredWebPage() : TLObject() {
    var url: String = ""

    var siteName: String = ""

    var photo: TLAbsPhoto? = null

    private val _constructor: String = "sponsoredWebPage#3db8ec63"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            siteName: String,
            photo: TLAbsPhoto?
    ) : this() {
        this.url = url
        this.siteName = siteName
        this.photo = photo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
        writeString(siteName)
        doIfMask(photo, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        url = readString()
        siteName = readString()
        photo = readIfMask(1) { readTLObject<TLAbsPhoto>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(siteName)
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSponsoredWebPage) return false
        if (other === this) return true

        return _flags == other._flags
                && url == other.url
                && siteName == other.siteName
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3db8ec63.toInt()
    }
}

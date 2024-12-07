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
 * webViewResultUrl#4d22ff98
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebViewResultUrl() : TLObject() {
    @Transient
    var fullsize: Boolean = false

    var queryId: Long? = null

    var url: String = ""

    private val _constructor: String = "webViewResultUrl#4d22ff98"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fullsize: Boolean,
            queryId: Long?,
            url: String
    ) : this() {
        this.fullsize = fullsize
        this.queryId = queryId
        this.url = url
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fullsize, 2)
        updateFlags(queryId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(queryId, 1) { writeLong(it) }
        writeString(url)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fullsize = isMask(2)
        queryId = readIfMask(1) { readLong() }
        url = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(queryId, 1) { SIZE_INT64 }
        size += computeTLStringSerializedSize(url)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebViewResultUrl) return false
        if (other === this) return true

        return _flags == other._flags
                && fullsize == other.fullsize
                && queryId == other.queryId
                && url == other.url
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4d22ff98.toInt()
    }
}

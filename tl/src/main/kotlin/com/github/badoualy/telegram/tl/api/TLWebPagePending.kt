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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * webPagePending#b0d13e47
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebPagePending() : TLAbsWebPage() {
    var id: Long = 0L

    var url: String? = null

    var date: Int = 0

    private val _constructor: String = "webPagePending#b0d13e47"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            url: String?,
            date: Int
    ) : this() {
        this.id = id
        this.url = url
        this.date = date
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(url, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        doIfMask(1, url, 1) { writeString(it) }
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readLong()
        url = readIfMask(1, 1) { readString() }
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, url, 1) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebPagePending) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && url == other.url
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb0d13e47.toInt()
    }
}

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
 * factCheck#b89bfccf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFactCheck() : TLObject() {
    @Transient
    var needCheck: Boolean = false

    var country: String? = null

    var text: TLTextWithEntities? = null

    var hash: Long = 0L

    private val _constructor: String = "factCheck#b89bfccf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            needCheck: Boolean,
            country: String?,
            text: TLTextWithEntities?,
            hash: Long
    ) : this() {
        this.needCheck = needCheck
        this.country = country
        this.text = text
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(needCheck, 1)
        updateFlags(country, 2)
        updateFlags(text, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(country, 2) { writeString(it) }
        doIfMask(text, 2) { writeTLObject(it) }
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        needCheck = isMask(1)
        country = readIfMask(2) { readString() }
        text = readIfMask(2) { readTLObject<TLTextWithEntities>(TLTextWithEntities::class, TLTextWithEntities.CONSTRUCTOR_ID) }
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(country, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(text, 2) { it.computeSerializedSize() }
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFactCheck) return false
        if (other === this) return true

        return _flags == other._flags
                && needCheck == other.needCheck
                && country == other.country
                && text == other.text
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb89bfccf.toInt()
    }
}

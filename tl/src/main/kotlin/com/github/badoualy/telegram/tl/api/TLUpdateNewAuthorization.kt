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
import kotlin.jvm.Transient

/**
 * updateNewAuthorization#8951abef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateNewAuthorization() : TLAbsUpdate() {
    @Transient
    var unconfirmed: Boolean = false

    var hash: Long = 0L

    var date: Int? = null

    var device: String? = null

    var location: String? = null

    private val _constructor: String = "updateNewAuthorization#8951abef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            unconfirmed: Boolean,
            hash: Long,
            date: Int?,
            device: String?,
            location: String?
    ) : this() {
        this.unconfirmed = unconfirmed
        this.hash = hash
        this.date = date
        this.device = device
        this.location = location
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(unconfirmed, 1)
        updateFlags(date, 1)
        updateFlags(device, 1)
        updateFlags(location, 1)

        // Following parameters might be forced to true by another field that updated the flags
        unconfirmed = isMask(1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(hash)
        doIfMask(date, 1) { writeInt(it) }
        doIfMask(device, 1) { writeString(it) }
        doIfMask(location, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        unconfirmed = isMask(1)
        hash = readLong()
        date = readIfMask(1) { readInt() }
        device = readIfMask(1) { readString() }
        location = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(date, 1) { SIZE_INT32 }
        size += getIntIfMask(device, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(location, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateNewAuthorization) return false
        if (other === this) return true

        return _flags == other._flags
                && unconfirmed == other.unconfirmed
                && hash == other.hash
                && date == other.date
                && device == other.device
                && location == other.location
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8951abef.toInt()
    }
}

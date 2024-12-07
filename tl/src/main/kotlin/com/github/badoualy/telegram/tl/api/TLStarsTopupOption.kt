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
 * starsTopupOption#bd915c0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStarsTopupOption() : TLObject() {
    @Transient
    var extended: Boolean = false

    var stars: Long = 0L

    var storeProduct: String? = null

    var currency: String = ""

    var amount: Long = 0L

    private val _constructor: String = "starsTopupOption#bd915c0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            extended: Boolean,
            stars: Long,
            storeProduct: String?,
            currency: String,
            amount: Long
    ) : this() {
        this.extended = extended
        this.stars = stars
        this.storeProduct = storeProduct
        this.currency = currency
        this.amount = amount
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(extended, 2)
        updateFlags(storeProduct, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(stars)
        doIfMask(1, storeProduct, 1) { writeString(it) }
        writeString(currency)
        writeLong(amount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        extended = isMask(1, 2)
        stars = readLong()
        storeProduct = readIfMask(1, 1) { readString() }
        currency = readString()
        amount = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, storeProduct, 1) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStarsTopupOption) return false
        if (other === this) return true

        return _flags == other._flags
                && extended == other.extended
                && stars == other.stars
                && storeProduct == other.storeProduct
                && currency == other.currency
                && amount == other.amount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbd915c0.toInt()
    }
}

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
 * broadcastRevenueTransactionRefund#42d30d2e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastRevenueTransactionRefund() : TLAbsBroadcastRevenueTransaction() {
    override var amount: Long = 0L

    var date: Int = 0

    var provider: String = ""

    private val _constructor: String = "broadcastRevenueTransactionRefund#42d30d2e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            amount: Long,
            date: Int,
            provider: String
    ) : this() {
        this.amount = amount
        this.date = date
        this.provider = provider
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(amount)
        writeInt(date)
        writeString(provider)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        amount = readLong()
        date = readInt()
        provider = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(provider)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastRevenueTransactionRefund) return false
        if (other === this) return true

        return amount == other.amount
                && date == other.date
                && provider == other.provider
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x42d30d2e.toInt()
    }
}

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
 * broadcastRevenueTransactionProceeds#557e2cc4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastRevenueTransactionProceeds() : TLAbsBroadcastRevenueTransaction() {
    override var amount: Long = 0L

    var fromDate: Int = 0

    var toDate: Int = 0

    private val _constructor: String = "broadcastRevenueTransactionProceeds#557e2cc4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            amount: Long,
            fromDate: Int,
            toDate: Int
    ) : this() {
        this.amount = amount
        this.fromDate = fromDate
        this.toDate = toDate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(amount)
        writeInt(fromDate)
        writeInt(toDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        amount = readLong()
        fromDate = readInt()
        toDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastRevenueTransactionProceeds) return false
        if (other === this) return true

        return amount == other.amount
                && fromDate == other.fromDate
                && toDate == other.toDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x557e2cc4.toInt()
    }
}

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
 * broadcastRevenueTransactionWithdrawal#5a590978
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastRevenueTransactionWithdrawal() : TLAbsBroadcastRevenueTransaction() {
    @Transient
    var pending: Boolean = false

    @Transient
    var failed: Boolean = false

    override var amount: Long = 0L

    var date: Int = 0

    var provider: String = ""

    var transactionDate: Int? = null

    var transactionUrl: String? = null

    private val _constructor: String = "broadcastRevenueTransactionWithdrawal#5a590978"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pending: Boolean,
            failed: Boolean,
            amount: Long,
            date: Int,
            provider: String,
            transactionDate: Int?,
            transactionUrl: String?
    ) : this() {
        this.pending = pending
        this.failed = failed
        this.amount = amount
        this.date = date
        this.provider = provider
        this.transactionDate = transactionDate
        this.transactionUrl = transactionUrl
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pending, 1)
        updateFlags(failed, 4)
        updateFlags(transactionDate, 2)
        updateFlags(transactionUrl, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(amount)
        writeInt(date)
        writeString(provider)
        doIfMask(transactionDate, 2) { writeInt(it) }
        doIfMask(transactionUrl, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pending = isMask(1)
        failed = isMask(4)
        amount = readLong()
        date = readInt()
        provider = readString()
        transactionDate = readIfMask(2) { readInt() }
        transactionUrl = readIfMask(2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(provider)
        size += getIntIfMask(transactionDate, 2) { SIZE_INT32 }
        size += getIntIfMask(transactionUrl, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastRevenueTransactionWithdrawal) return false
        if (other === this) return true

        return _flags == other._flags
                && pending == other.pending
                && failed == other.failed
                && amount == other.amount
                && date == other.date
                && provider == other.provider
                && transactionDate == other.transactionDate
                && transactionUrl == other.transactionUrl
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5a590978.toInt()
    }
}

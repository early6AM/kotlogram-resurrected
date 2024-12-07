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
 * starsRevenueStatus#79342946
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStarsRevenueStatus() : TLObject() {
    @Transient
    var withdrawalEnabled: Boolean = false

    var currentBalance: Long = 0L

    var availableBalance: Long = 0L

    var overallRevenue: Long = 0L

    var nextWithdrawalAt: Int? = null

    private val _constructor: String = "starsRevenueStatus#79342946"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            withdrawalEnabled: Boolean,
            currentBalance: Long,
            availableBalance: Long,
            overallRevenue: Long,
            nextWithdrawalAt: Int?
    ) : this() {
        this.withdrawalEnabled = withdrawalEnabled
        this.currentBalance = currentBalance
        this.availableBalance = availableBalance
        this.overallRevenue = overallRevenue
        this.nextWithdrawalAt = nextWithdrawalAt
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(withdrawalEnabled, 1)
        updateFlags(nextWithdrawalAt, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(currentBalance)
        writeLong(availableBalance)
        writeLong(overallRevenue)
        doIfMask(nextWithdrawalAt, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        withdrawalEnabled = isMask(1)
        currentBalance = readLong()
        availableBalance = readLong()
        overallRevenue = readLong()
        nextWithdrawalAt = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT64
        size += getIntIfMask(nextWithdrawalAt, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStarsRevenueStatus) return false
        if (other === this) return true

        return _flags == other._flags
                && withdrawalEnabled == other.withdrawalEnabled
                && currentBalance == other.currentBalance
                && availableBalance == other.availableBalance
                && overallRevenue == other.overallRevenue
                && nextWithdrawalAt == other.nextWithdrawalAt
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x79342946.toInt()
    }
}

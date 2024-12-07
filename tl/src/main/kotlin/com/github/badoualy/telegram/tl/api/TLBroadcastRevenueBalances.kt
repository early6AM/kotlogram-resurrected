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

/**
 * broadcastRevenueBalances#8438f1c6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastRevenueBalances() : TLObject() {
    var currentBalance: Long = 0L

    var availableBalance: Long = 0L

    var overallRevenue: Long = 0L

    private val _constructor: String = "broadcastRevenueBalances#8438f1c6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            currentBalance: Long,
            availableBalance: Long,
            overallRevenue: Long
    ) : this() {
        this.currentBalance = currentBalance
        this.availableBalance = availableBalance
        this.overallRevenue = overallRevenue
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(currentBalance)
        writeLong(availableBalance)
        writeLong(overallRevenue)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        currentBalance = readLong()
        availableBalance = readLong()
        overallRevenue = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastRevenueBalances) return false
        if (other === this) return true

        return currentBalance == other.currentBalance
                && availableBalance == other.availableBalance
                && overallRevenue == other.overallRevenue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8438f1c6.toInt()
    }
}

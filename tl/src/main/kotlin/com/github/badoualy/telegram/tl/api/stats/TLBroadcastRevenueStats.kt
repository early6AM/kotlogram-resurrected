package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLBroadcastRevenueBalances
import com.github.badoualy.telegram.tl.api.TLStatsGraphAsync
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * stats.broadcastRevenueStats#5407e297
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastRevenueStats() : TLObject() {
    var topHoursGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var revenueGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var balances: TLBroadcastRevenueBalances = TLBroadcastRevenueBalances()

    var usdRate: Double = 0.0

    private val _constructor: String = "stats.broadcastRevenueStats#5407e297"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            topHoursGraph: TLAbsStatsGraph,
            revenueGraph: TLAbsStatsGraph,
            balances: TLBroadcastRevenueBalances,
            usdRate: Double
    ) : this() {
        this.topHoursGraph = topHoursGraph
        this.revenueGraph = revenueGraph
        this.balances = balances
        this.usdRate = usdRate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(topHoursGraph)
        writeTLObject(revenueGraph)
        writeTLObject(balances)
        writeDouble(usdRate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        topHoursGraph = readTLObject<TLAbsStatsGraph>()
        revenueGraph = readTLObject<TLAbsStatsGraph>()
        balances = readTLObject<TLBroadcastRevenueBalances>(TLBroadcastRevenueBalances::class, TLBroadcastRevenueBalances.CONSTRUCTOR_ID)
        usdRate = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += topHoursGraph.computeSerializedSize()
        size += revenueGraph.computeSerializedSize()
        size += balances.computeSerializedSize()
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastRevenueStats) return false
        if (other === this) return true

        return topHoursGraph == other.topHoursGraph
                && revenueGraph == other.revenueGraph
                && balances == other.balances
                && usdRate == other.usdRate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5407e297.toInt()
    }
}

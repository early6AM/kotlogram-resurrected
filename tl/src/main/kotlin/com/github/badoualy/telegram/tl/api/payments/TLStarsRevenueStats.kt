package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLStarsRevenueStatus
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
 * payments.starsRevenueStats#c92bb73b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStarsRevenueStats() : TLObject() {
    var revenueGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var status: TLStarsRevenueStatus = TLStarsRevenueStatus()

    var usdRate: Double = 0.0

    private val _constructor: String = "payments.starsRevenueStats#c92bb73b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            revenueGraph: TLAbsStatsGraph,
            status: TLStarsRevenueStatus,
            usdRate: Double
    ) : this() {
        this.revenueGraph = revenueGraph
        this.status = status
        this.usdRate = usdRate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(revenueGraph)
        writeTLObject(status)
        writeDouble(usdRate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        revenueGraph = readTLObject<TLAbsStatsGraph>()
        status = readTLObject<TLStarsRevenueStatus>(TLStarsRevenueStatus::class, TLStarsRevenueStatus.CONSTRUCTOR_ID)
        usdRate = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += revenueGraph.computeSerializedSize()
        size += status.computeSerializedSize()
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStarsRevenueStats) return false
        if (other === this) return true

        return revenueGraph == other.revenueGraph
                && status == other.status
                && usdRate == other.usdRate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc92bb73b.toInt()
    }
}

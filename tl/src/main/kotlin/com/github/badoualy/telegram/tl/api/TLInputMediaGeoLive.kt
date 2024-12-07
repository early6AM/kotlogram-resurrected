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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * inputMediaGeoLive#971fa843
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaGeoLive() : TLAbsInputMedia() {
    @Transient
    var stopped: Boolean = false

    var geoPoint: TLAbsInputGeoPoint = TLInputGeoPointEmpty()

    var heading: Int? = null

    var period: Int? = null

    var proximityNotificationRadius: Int? = null

    private val _constructor: String = "inputMediaGeoLive#971fa843"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            stopped: Boolean,
            geoPoint: TLAbsInputGeoPoint,
            heading: Int?,
            period: Int?,
            proximityNotificationRadius: Int?
    ) : this() {
        this.stopped = stopped
        this.geoPoint = geoPoint
        this.heading = heading
        this.period = period
        this.proximityNotificationRadius = proximityNotificationRadius
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(stopped, 1)
        updateFlags(heading, 4)
        updateFlags(period, 2)
        updateFlags(proximityNotificationRadius, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(geoPoint)
        doIfMask(1, heading, 4) { writeInt(it) }
        doIfMask(1, period, 2) { writeInt(it) }
        doIfMask(1, proximityNotificationRadius, 8) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        stopped = isMask(1, 1)
        geoPoint = readTLObject<TLAbsInputGeoPoint>()
        heading = readIfMask(1, 4) { readInt() }
        period = readIfMask(1, 2) { readInt() }
        proximityNotificationRadius = readIfMask(1, 8) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += geoPoint.computeSerializedSize()
        size += getIntIfMask(1, heading, 4) { SIZE_INT32 }
        size += getIntIfMask(1, period, 2) { SIZE_INT32 }
        size += getIntIfMask(1, proximityNotificationRadius, 8) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaGeoLive) return false
        if (other === this) return true

        return _flags == other._flags
                && stopped == other.stopped
                && geoPoint == other.geoPoint
                && heading == other.heading
                && period == other.period
                && proximityNotificationRadius == other.proximityNotificationRadius
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x971fa843.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaGeoLive#b940c666
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaGeoLive() : TLAbsMessageMedia() {
    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    var heading: Int? = null

    var period: Int = 0

    var proximityNotificationRadius: Int? = null

    private val _constructor: String = "messageMediaGeoLive#b940c666"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geo: TLAbsGeoPoint,
            heading: Int?,
            period: Int,
            proximityNotificationRadius: Int?
    ) : this() {
        this.geo = geo
        this.heading = heading
        this.period = period
        this.proximityNotificationRadius = proximityNotificationRadius
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(heading, 1)
        updateFlags(proximityNotificationRadius, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(geo)
        doIfMask(heading, 1) { writeInt(it) }
        writeInt(period)
        doIfMask(proximityNotificationRadius, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        geo = readTLObject<TLAbsGeoPoint>()
        heading = readIfMask(1) { readInt() }
        period = readInt()
        proximityNotificationRadius = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += geo.computeSerializedSize()
        size += getIntIfMask(heading, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(proximityNotificationRadius, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaGeoLive) return false
        if (other === this) return true

        return _flags == other._flags
                && geo == other.geo
                && heading == other.heading
                && period == other.period
                && proximityNotificationRadius == other.proximityNotificationRadius
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb940c666.toInt()
    }
}

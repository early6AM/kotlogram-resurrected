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

/**
 * inputBotInlineMessageMediaGeo#96929a85
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineMessageMediaGeo() : TLAbsInputBotInlineMessage() {
    var geoPoint: TLAbsInputGeoPoint = TLInputGeoPointEmpty()

    var heading: Int? = null

    var period: Int? = null

    var proximityNotificationRadius: Int? = null

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "inputBotInlineMessageMediaGeo#96929a85"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geoPoint: TLAbsInputGeoPoint,
            heading: Int?,
            period: Int?,
            proximityNotificationRadius: Int?,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.geoPoint = geoPoint
        this.heading = heading
        this.period = period
        this.proximityNotificationRadius = proximityNotificationRadius
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(heading, 1)
        updateFlags(period, 2)
        updateFlags(proximityNotificationRadius, 8)
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(geoPoint)
        doIfMask(heading, 1) { writeInt(it) }
        doIfMask(period, 2) { writeInt(it) }
        doIfMask(proximityNotificationRadius, 8) { writeInt(it) }
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        geoPoint = readTLObject<TLAbsInputGeoPoint>()
        heading = readIfMask(1) { readInt() }
        period = readIfMask(2) { readInt() }
        proximityNotificationRadius = readIfMask(8) { readInt() }
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += geoPoint.computeSerializedSize()
        size += getIntIfMask(heading, 1) { SIZE_INT32 }
        size += getIntIfMask(period, 2) { SIZE_INT32 }
        size += getIntIfMask(proximityNotificationRadius, 8) { SIZE_INT32 }
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineMessageMediaGeo) return false
        if (other === this) return true

        return _flags == other._flags
                && geoPoint == other.geoPoint
                && heading == other.heading
                && period == other.period
                && proximityNotificationRadius == other.proximityNotificationRadius
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x96929a85.toInt()
    }
}

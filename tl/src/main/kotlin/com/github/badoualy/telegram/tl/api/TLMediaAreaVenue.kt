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
 * mediaAreaVenue#be82db9c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMediaAreaVenue() : TLAbsMediaArea() {
    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    var title: String = ""

    var address: String = ""

    var provider: String = ""

    var venueId: String = ""

    var venueType: String = ""

    private val _constructor: String = "mediaAreaVenue#be82db9c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            coordinates: TLMediaAreaCoordinates,
            geo: TLAbsGeoPoint,
            title: String,
            address: String,
            provider: String,
            venueId: String,
            venueType: String
    ) : this() {
        this.coordinates = coordinates
        this.geo = geo
        this.title = title
        this.address = address
        this.provider = provider
        this.venueId = venueId
        this.venueType = venueType
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(coordinates)
        writeTLObject(geo)
        writeString(title)
        writeString(address)
        writeString(provider)
        writeString(venueId)
        writeString(venueType)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        geo = readTLObject<TLAbsGeoPoint>()
        title = readString()
        address = readString()
        provider = readString()
        venueId = readString()
        venueType = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += coordinates.computeSerializedSize()
        size += geo.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(address)
        size += computeTLStringSerializedSize(provider)
        size += computeTLStringSerializedSize(venueId)
        size += computeTLStringSerializedSize(venueType)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMediaAreaVenue) return false
        if (other === this) return true

        return coordinates == other.coordinates
                && geo == other.geo
                && title == other.title
                && address == other.address
                && provider == other.provider
                && venueId == other.venueId
                && venueType == other.venueType
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbe82db9c.toInt()
    }
}

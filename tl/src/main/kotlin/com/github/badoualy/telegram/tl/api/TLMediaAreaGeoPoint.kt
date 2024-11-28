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
 * mediaAreaGeoPoint#df8b3b22
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMediaAreaGeoPoint() : TLAbsMediaArea() {
    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    private val _constructor: String = "mediaAreaGeoPoint#df8b3b22"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(coordinates: TLMediaAreaCoordinates, geo: TLAbsGeoPoint) : this() {
        this.coordinates = coordinates
        this.geo = geo
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(coordinates)
        writeTLObject(geo)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        geo = readTLObject<TLAbsGeoPoint>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += coordinates.computeSerializedSize()
        size += geo.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMediaAreaGeoPoint) return false
        if (other === this) return true

        return coordinates == other.coordinates
                && geo == other.geo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdf8b3b22.toInt()
    }
}

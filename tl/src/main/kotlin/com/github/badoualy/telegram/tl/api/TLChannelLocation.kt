package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelLocation#209b82db
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelLocation() : TLAbsChannelLocation() {
    var geoPoint: TLAbsGeoPoint = TLGeoPointEmpty()

    var address: String = ""

    private val _constructor: String = "channelLocation#209b82db"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(geoPoint: TLAbsGeoPoint, address: String) : this() {
        this.geoPoint = geoPoint
        this.address = address
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(geoPoint)
        writeString(address)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        geoPoint = readTLObject<TLAbsGeoPoint>()
        address = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += geoPoint.computeSerializedSize()
        size += computeTLStringSerializedSize(address)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelLocation) return false
        if (other === this) return true

        return geoPoint == other.geoPoint
                && address == other.address
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x209b82db
    }
}

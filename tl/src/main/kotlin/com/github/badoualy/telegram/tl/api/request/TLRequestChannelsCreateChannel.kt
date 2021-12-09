package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsCreateChannel() : TLMethod<TLAbsUpdates>() {
    @Transient
    var broadcast: Boolean = false

    @Transient
    var megagroup: Boolean = false

    @Transient
    var forImport: Boolean = false

    var title: String = ""

    var about: String = ""

    var geoPoint: TLAbsInputGeoPoint? = null

    var address: String? = null

    private val _constructor: String = "channels.createChannel#3d5fb10f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?
    ) : this() {
        this.broadcast = broadcast
        this.megagroup = megagroup
        this.forImport = forImport
        this.title = title
        this.about = about
        this.geoPoint = geoPoint
        this.address = address
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(broadcast, 1)
        updateFlags(megagroup, 2)
        updateFlags(forImport, 8)
        updateFlags(geoPoint, 4)
        updateFlags(address, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(about)
        doIfMask(geoPoint, 4) { writeTLObject(it) }
        doIfMask(address, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        broadcast = isMask(1)
        megagroup = isMask(2)
        forImport = isMask(8)
        title = readString()
        about = readString()
        geoPoint = readIfMask(4) { readTLObject<TLAbsInputGeoPoint>() }
        address = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(about)
        size += getIntIfMask(geoPoint, 4) { it.computeSerializedSize() }
        size += getIntIfMask(address, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsCreateChannel) return false
        if (other === this) return true

        return _flags == other._flags
                && broadcast == other.broadcast
                && megagroup == other.megagroup
                && forImport == other.forImport
                && title == other.title
                && about == other.about
                && geoPoint == other.geoPoint
                && address == other.address
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3d5fb10f
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
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

    @Transient
    var forum: Boolean = false

    var title: String = ""

    var about: String = ""

    var geoPoint: TLAbsInputGeoPoint? = null

    var address: String? = null

    var ttlPeriod: Int? = null

    private val _constructor: String = "channels.createChannel#91006707"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            forum: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?,
            ttlPeriod: Int?
    ) : this() {
        this.broadcast = broadcast
        this.megagroup = megagroup
        this.forImport = forImport
        this.forum = forum
        this.title = title
        this.about = about
        this.geoPoint = geoPoint
        this.address = address
        this.ttlPeriod = ttlPeriod
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(broadcast, 1)
        updateFlags(megagroup, 2)
        updateFlags(forImport, 8)
        updateFlags(forum, 32)
        updateFlags(geoPoint, 4)
        updateFlags(address, 4)
        updateFlags(ttlPeriod, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(about)
        doIfMask(1, geoPoint, 4) { writeTLObject(it) }
        doIfMask(1, address, 4) { writeString(it) }
        doIfMask(1, ttlPeriod, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        broadcast = isMask(1, 1)
        megagroup = isMask(1, 2)
        forImport = isMask(1, 8)
        forum = isMask(1, 32)
        title = readString()
        about = readString()
        geoPoint = readIfMask(1, 4) { readTLObject<TLAbsInputGeoPoint>() }
        address = readIfMask(1, 4) { readString() }
        ttlPeriod = readIfMask(1, 16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(about)
        size += getIntIfMask(1, geoPoint, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, address, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, ttlPeriod, 16) { SIZE_INT32 }
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
                && forum == other.forum
                && title == other.title
                && about == other.about
                && geoPoint == other.geoPoint
                && address == other.address
                && ttlPeriod == other.ttlPeriod
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x91006707.toInt()
    }
}

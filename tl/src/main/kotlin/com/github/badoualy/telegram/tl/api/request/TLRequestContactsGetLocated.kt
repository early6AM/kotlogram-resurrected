package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputGeoPointEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsGetLocated() : TLMethod<TLAbsUpdates>() {
    @Transient
    var background: Boolean = false

    var geoPoint: TLAbsInputGeoPoint = TLInputGeoPointEmpty()

    var selfExpires: Int? = null

    private val _constructor: String = "contacts.getLocated#d348bc44"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            background: Boolean,
            geoPoint: TLAbsInputGeoPoint,
            selfExpires: Int?
    ) : this() {
        this.background = background
        this.geoPoint = geoPoint
        this.selfExpires = selfExpires
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(background, 2)
        updateFlags(selfExpires, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(geoPoint)
        doIfMask(selfExpires, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        background = isMask(2)
        geoPoint = readTLObject<TLAbsInputGeoPoint>()
        selfExpires = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += geoPoint.computeSerializedSize()
        size += getIntIfMask(selfExpires, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsGetLocated) return false
        if (other === this) return true

        return _flags == other._flags
                && background == other.background
                && geoPoint == other.geoPoint
                && selfExpires == other.selfExpires
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd348bc44.toInt()
    }
}

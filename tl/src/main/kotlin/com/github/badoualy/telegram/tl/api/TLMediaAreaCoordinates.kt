package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * mediaAreaCoordinates#cfc9e002
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMediaAreaCoordinates() : TLObject() {
    var x: Double = 0.0

    var y: Double = 0.0

    var w: Double = 0.0

    var h: Double = 0.0

    var rotation: Double = 0.0

    var radius: Double? = null

    private val _constructor: String = "mediaAreaCoordinates#cfc9e002"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            x: Double,
            y: Double,
            w: Double,
            h: Double,
            rotation: Double,
            radius: Double?
    ) : this() {
        this.x = x
        this.y = y
        this.w = w
        this.h = h
        this.rotation = rotation
        this.radius = radius
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(radius, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeDouble(x)
        writeDouble(y)
        writeDouble(w)
        writeDouble(h)
        writeDouble(rotation)
        doIfMask(1, radius, 1) { writeDouble(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        x = readDouble()
        y = readDouble()
        w = readDouble()
        h = readDouble()
        rotation = readDouble()
        radius = readIfMask(1, 1) { readDouble() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += getIntIfMask(1, radius, 1) { SIZE_DOUBLE }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMediaAreaCoordinates) return false
        if (other === this) return true

        return _flags == other._flags
                && x == other.x
                && y == other.y
                && w == other.w
                && h == other.h
                && rotation == other.rotation
                && radius == other.radius
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcfc9e002.toInt()
    }
}

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
 * statsAbsValueAndPrev#cb43acde
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStatsAbsValueAndPrev() : TLObject() {
    var current: Double = 0.0

    var previous: Double = 0.0

    private val _constructor: String = "statsAbsValueAndPrev#cb43acde"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(current: Double, previous: Double) : this() {
        this.current = current
        this.previous = previous
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeDouble(current)
        writeDouble(previous)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        current = readDouble()
        previous = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStatsAbsValueAndPrev) return false
        if (other === this) return true

        return current == other.current
                && previous == other.previous
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcb43acde.toInt()
    }
}

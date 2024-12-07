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
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * storiesStealthMode#712e27fd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoriesStealthMode() : TLObject() {
    var activeUntilDate: Int? = null

    var cooldownUntilDate: Int? = null

    private val _constructor: String = "storiesStealthMode#712e27fd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(activeUntilDate: Int?, cooldownUntilDate: Int?) : this() {
        this.activeUntilDate = activeUntilDate
        this.cooldownUntilDate = cooldownUntilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(activeUntilDate, 1)
        updateFlags(cooldownUntilDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, activeUntilDate, 1) { writeInt(it) }
        doIfMask(1, cooldownUntilDate, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        activeUntilDate = readIfMask(1, 1) { readInt() }
        cooldownUntilDate = readIfMask(1, 2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, activeUntilDate, 1) { SIZE_INT32 }
        size += getIntIfMask(1, cooldownUntilDate, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoriesStealthMode) return false
        if (other === this) return true

        return _flags == other._flags
                && activeUntilDate == other.activeUntilDate
                && cooldownUntilDate == other.cooldownUntilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x712e27fd.toInt()
    }
}

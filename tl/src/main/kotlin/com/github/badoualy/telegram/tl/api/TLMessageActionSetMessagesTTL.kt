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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageActionSetMessagesTTL#3c134d7b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionSetMessagesTTL() : TLAbsMessageAction() {
    var period: Int = 0

    var autoSettingFrom: Long? = null

    private val _constructor: String = "messageActionSetMessagesTTL#3c134d7b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(period: Int, autoSettingFrom: Long?) : this() {
        this.period = period
        this.autoSettingFrom = autoSettingFrom
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(autoSettingFrom, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(period)
        doIfMask(autoSettingFrom, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        period = readInt()
        autoSettingFrom = readIfMask(1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(autoSettingFrom, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionSetMessagesTTL) return false
        if (other === this) return true

        return _flags == other._flags
                && period == other.period
                && autoSettingFrom == other.autoSettingFrom
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3c134d7b.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * businessWorkHours#8c92b098
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBusinessWorkHours() : TLObject() {
    @Transient
    var openNow: Boolean = false

    var timezoneId: String = ""

    var weeklyOpen: TLObjectVector<TLBusinessWeeklyOpen> = TLObjectVector()

    private val _constructor: String = "businessWorkHours#8c92b098"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            openNow: Boolean,
            timezoneId: String,
            weeklyOpen: TLObjectVector<TLBusinessWeeklyOpen>
    ) : this() {
        this.openNow = openNow
        this.timezoneId = timezoneId
        this.weeklyOpen = weeklyOpen
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(openNow, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(timezoneId)
        writeTLVector(weeklyOpen)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        openNow = isMask(1)
        timezoneId = readString()
        weeklyOpen = readTLVector<TLBusinessWeeklyOpen>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(timezoneId)
        size += weeklyOpen.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBusinessWorkHours) return false
        if (other === this) return true

        return _flags == other._flags
                && openNow == other.openNow
                && timezoneId == other.timezoneId
                && weeklyOpen == other.weeklyOpen
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c92b098.toInt()
    }
}

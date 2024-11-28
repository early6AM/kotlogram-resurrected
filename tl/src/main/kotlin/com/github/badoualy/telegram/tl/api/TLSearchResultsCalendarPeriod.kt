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
 * searchResultsCalendarPeriod#c9b0539f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSearchResultsCalendarPeriod() : TLObject() {
    var date: Int = 0

    var minMsgId: Int = 0

    var maxMsgId: Int = 0

    var count: Int = 0

    private val _constructor: String = "searchResultsCalendarPeriod#c9b0539f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            date: Int,
            minMsgId: Int,
            maxMsgId: Int,
            count: Int
    ) : this() {
        this.date = date
        this.minMsgId = minMsgId
        this.maxMsgId = maxMsgId
        this.count = count
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(date)
        writeInt(minMsgId)
        writeInt(maxMsgId)
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        date = readInt()
        minMsgId = readInt()
        maxMsgId = readInt()
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSearchResultsCalendarPeriod) return false
        if (other === this) return true

        return date == other.date
                && minMsgId == other.minMsgId
                && maxMsgId == other.maxMsgId
                && count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9b0539f.toInt()
    }
}

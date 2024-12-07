package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateReadMessagesContents#f8227181
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadMessagesContents() : TLAbsUpdate() {
    var messages: TLIntVector = TLIntVector()

    var pts: Int = 0

    var ptsCount: Int = 0

    var date: Int? = null

    private val _constructor: String = "updateReadMessagesContents#f8227181"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            messages: TLIntVector,
            pts: Int,
            ptsCount: Int,
            date: Int?
    ) : this() {
        this.messages = messages
        this.pts = pts
        this.ptsCount = ptsCount
        this.date = date
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(date, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(messages)
        writeInt(pts)
        writeInt(ptsCount)
        doIfMask(1, date, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        messages = readTLIntVector()
        pts = readInt()
        ptsCount = readInt()
        date = readIfMask(1, 1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += messages.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, date, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadMessagesContents) return false
        if (other === this) return true

        return _flags == other._flags
                && messages == other.messages
                && pts == other.pts
                && ptsCount == other.ptsCount
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf8227181.toInt()
    }
}

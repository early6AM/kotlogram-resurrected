package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
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
 * messages.affectedFoundMessages#ef8d3e6c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAffectedFoundMessages() : TLObject() {
    var pts: Int = 0

    var ptsCount: Int = 0

    var offset: Int = 0

    var messages: TLIntVector = TLIntVector()

    private val _constructor: String = "messages.affectedFoundMessages#ef8d3e6c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pts: Int,
            ptsCount: Int,
            offset: Int,
            messages: TLIntVector
    ) : this() {
        this.pts = pts
        this.ptsCount = ptsCount
        this.offset = offset
        this.messages = messages
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(pts)
        writeInt(ptsCount)
        writeInt(offset)
        writeTLVector(messages)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pts = readInt()
        ptsCount = readInt()
        offset = readInt()
        messages = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += messages.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAffectedFoundMessages) return false
        if (other === this) return true

        return pts == other.pts
                && ptsCount == other.ptsCount
                && offset == other.offset
                && messages == other.messages
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xef8d3e6c.toInt()
    }
}

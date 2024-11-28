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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * peerColor#b54b5acf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerColor() : TLObject() {
    var color: Int? = null

    var backgroundEmojiId: Long? = null

    private val _constructor: String = "peerColor#b54b5acf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(color: Int?, backgroundEmojiId: Long?) : this() {
        this.color = color
        this.backgroundEmojiId = backgroundEmojiId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(color, 1)
        updateFlags(backgroundEmojiId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(color, 1) { writeInt(it) }
        doIfMask(backgroundEmojiId, 2) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        color = readIfMask(1) { readInt() }
        backgroundEmojiId = readIfMask(2) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(color, 1) { SIZE_INT32 }
        size += getIntIfMask(backgroundEmojiId, 2) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerColor) return false
        if (other === this) return true

        return _flags == other._flags
                && color == other.color
                && backgroundEmojiId == other.backgroundEmojiId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb54b5acf.toInt()
    }
}

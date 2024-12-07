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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messageEntityBlockquote#f1ccaaac
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageEntityBlockquote() : TLAbsMessageEntity() {
    @Transient
    var collapsed: Boolean = false

    override var offset: Int = 0

    override var length: Int = 0

    private val _constructor: String = "messageEntityBlockquote#f1ccaaac"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            collapsed: Boolean,
            offset: Int,
            length: Int
    ) : this() {
        this.collapsed = collapsed
        this.offset = offset
        this.length = length
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(collapsed, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(offset)
        writeInt(length)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        collapsed = isMask(1)
        offset = readInt()
        length = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageEntityBlockquote) return false
        if (other === this) return true

        return _flags == other._flags
                && collapsed == other.collapsed
                && offset == other.offset
                && length == other.length
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf1ccaaac.toInt()
    }
}

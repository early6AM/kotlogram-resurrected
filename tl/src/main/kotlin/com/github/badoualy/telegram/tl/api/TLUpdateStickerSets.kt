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
 * updateStickerSets#31c24808
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateStickerSets() : TLAbsUpdate() {
    @Transient
    var masks: Boolean = false

    @Transient
    var emojis: Boolean = false

    private val _constructor: String = "updateStickerSets#31c24808"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(masks: Boolean, emojis: Boolean) : this() {
        this.masks = masks
        this.emojis = emojis
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(masks, 1)
        updateFlags(emojis, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        masks = isMask(1)
        emojis = isMask(2)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateStickerSets) return false
        if (other === this) return true

        return _flags == other._flags
                && masks == other.masks
                && emojis == other.emojis
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x31c24808.toInt()
    }
}

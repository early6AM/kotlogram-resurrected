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
import kotlin.jvm.Transient

/**
 * updateMoveStickerSetToTop#86fccf85
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMoveStickerSetToTop() : TLAbsUpdate() {
    @Transient
    var masks: Boolean = false

    @Transient
    var emojis: Boolean = false

    var stickerset: Long = 0L

    private val _constructor: String = "updateMoveStickerSetToTop#86fccf85"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            masks: Boolean,
            emojis: Boolean,
            stickerset: Long
    ) : this() {
        this.masks = masks
        this.emojis = emojis
        this.stickerset = stickerset
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
        writeLong(stickerset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        masks = isMask(1)
        emojis = isMask(2)
        stickerset = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMoveStickerSetToTop) return false
        if (other === this) return true

        return _flags == other._flags
                && masks == other.masks
                && emojis == other.emojis
                && stickerset == other.stickerset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86fccf85.toInt()
    }
}

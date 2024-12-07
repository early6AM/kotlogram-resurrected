package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * webPageAttributeStickerSet#50cc03d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebPageAttributeStickerSet() : TLAbsWebPageAttribute() {
    @Transient
    var emojis: Boolean = false

    @Transient
    var textColor: Boolean = false

    var stickers: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "webPageAttributeStickerSet#50cc03d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            emojis: Boolean,
            textColor: Boolean,
            stickers: TLObjectVector<TLAbsDocument>
    ) : this() {
        this.emojis = emojis
        this.textColor = textColor
        this.stickers = stickers
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(emojis, 1)
        updateFlags(textColor, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(stickers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        emojis = isMask(1)
        textColor = isMask(2)
        stickers = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += stickers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebPageAttributeStickerSet) return false
        if (other === this) return true

        return _flags == other._flags
                && emojis == other.emojis
                && textColor == other.textColor
                && stickers == other.stickers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x50cc03d3.toInt()
    }
}

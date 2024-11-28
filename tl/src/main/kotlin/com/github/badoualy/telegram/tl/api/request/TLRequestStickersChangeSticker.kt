package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLInputDocumentEmpty
import com.github.badoualy.telegram.tl.api.TLMaskCoords
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersChangeSticker() : TLMethod<TLAbsStickerSet>() {
    var sticker: TLAbsInputDocument = TLInputDocumentEmpty()

    var emoji: String? = null

    var maskCoords: TLMaskCoords? = null

    var keywords: String? = null

    private val _constructor: String = "stickers.changeSticker#f5537ebc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            sticker: TLAbsInputDocument,
            emoji: String?,
            maskCoords: TLMaskCoords?,
            keywords: String?
    ) : this() {
        this.sticker = sticker
        this.emoji = emoji
        this.maskCoords = maskCoords
        this.keywords = keywords
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(emoji, 1)
        updateFlags(maskCoords, 2)
        updateFlags(keywords, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(sticker)
        doIfMask(emoji, 1) { writeString(it) }
        doIfMask(maskCoords, 2) { writeTLObject(it) }
        doIfMask(keywords, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        sticker = readTLObject<TLAbsInputDocument>()
        emoji = readIfMask(1) { readString() }
        maskCoords = readIfMask(2) { readTLObject<TLMaskCoords>(TLMaskCoords::class, TLMaskCoords.CONSTRUCTOR_ID) }
        keywords = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += sticker.computeSerializedSize()
        size += getIntIfMask(emoji, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(maskCoords, 2) { it.computeSerializedSize() }
        size += getIntIfMask(keywords, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersChangeSticker) return false
        if (other === this) return true

        return _flags == other._flags
                && sticker == other.sticker
                && emoji == other.emoji
                && maskCoords == other.maskCoords
                && keywords == other.keywords
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf5537ebc.toInt()
    }
}

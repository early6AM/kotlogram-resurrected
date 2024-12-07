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
import com.github.badoualy.telegram.tl.api.TLInputStickerSetItem
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
class TLRequestStickersReplaceSticker() : TLMethod<TLAbsStickerSet>() {
    var sticker: TLAbsInputDocument = TLInputDocumentEmpty()

    var newSticker: TLInputStickerSetItem = TLInputStickerSetItem()

    private val _constructor: String = "stickers.replaceSticker#4696459a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(sticker: TLAbsInputDocument, newSticker: TLInputStickerSetItem) : this() {
        this.sticker = sticker
        this.newSticker = newSticker
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(sticker)
        writeTLObject(newSticker)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        sticker = readTLObject<TLAbsInputDocument>()
        newSticker = readTLObject<TLInputStickerSetItem>(TLInputStickerSetItem::class, TLInputStickerSetItem.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += sticker.computeSerializedSize()
        size += newSticker.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersReplaceSticker) return false
        if (other === this) return true

        return sticker == other.sticker
                && newSticker == other.newSticker
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4696459a.toInt()
    }
}

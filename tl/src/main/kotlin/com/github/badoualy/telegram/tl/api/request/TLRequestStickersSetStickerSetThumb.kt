package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.api.TLInputDocumentEmpty
import com.github.badoualy.telegram.tl.api.TLInputStickerSetEmpty
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersSetStickerSetThumb() : TLMethod<TLStickerSet>() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var thumb: TLAbsInputDocument = TLInputDocumentEmpty()

    private val _constructor: String = "stickers.setStickerSetThumb#9a364e30"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stickerset: TLAbsInputStickerSet, thumb: TLAbsInputDocument) : this() {
        this.stickerset = stickerset
        this.thumb = thumb
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStickerSet = tlDeserializer.readTLObject(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
        writeTLObject(thumb)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
        thumb = readTLObject<TLAbsInputDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        size += thumb.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersSetStickerSetThumb) return false
        if (other === this) return true

        return stickerset == other.stickerset
                && thumb == other.thumb
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a364e30.toInt()
    }
}

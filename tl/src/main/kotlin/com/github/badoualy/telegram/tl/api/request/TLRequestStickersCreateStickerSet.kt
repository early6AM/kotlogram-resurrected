package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputStickerSetItem
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersCreateStickerSet() : TLMethod<TLAbsStickerSet>() {
    @Transient
    var masks: Boolean = false

    @Transient
    var emojis: Boolean = false

    @Transient
    var textColor: Boolean = false

    var userId: TLAbsInputUser = TLInputUserEmpty()

    var title: String = ""

    var shortName: String = ""

    var thumb: TLAbsInputDocument? = null

    var stickers: TLObjectVector<TLInputStickerSetItem> = TLObjectVector()

    var software: String? = null

    private val _constructor: String = "stickers.createStickerSet#9021ab67"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            masks: Boolean,
            emojis: Boolean,
            textColor: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            thumb: TLAbsInputDocument?,
            stickers: TLObjectVector<TLInputStickerSetItem>,
            software: String?
    ) : this() {
        this.masks = masks
        this.emojis = emojis
        this.textColor = textColor
        this.userId = userId
        this.title = title
        this.shortName = shortName
        this.thumb = thumb
        this.stickers = stickers
        this.software = software
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(masks, 1)
        updateFlags(emojis, 32)
        updateFlags(textColor, 64)
        updateFlags(thumb, 4)
        updateFlags(software, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(userId)
        writeString(title)
        writeString(shortName)
        doIfMask(thumb, 4) { writeTLObject(it) }
        writeTLVector(stickers)
        doIfMask(software, 8) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        masks = isMask(1)
        emojis = isMask(32)
        textColor = isMask(64)
        userId = readTLObject<TLAbsInputUser>()
        title = readString()
        shortName = readString()
        thumb = readIfMask(4) { readTLObject<TLAbsInputDocument>() }
        stickers = readTLVector<TLInputStickerSetItem>()
        software = readIfMask(8) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += userId.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(shortName)
        size += getIntIfMask(thumb, 4) { it.computeSerializedSize() }
        size += stickers.computeSerializedSize()
        size += getIntIfMask(software, 8) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersCreateStickerSet) return false
        if (other === this) return true

        return _flags == other._flags
                && masks == other.masks
                && emojis == other.emojis
                && textColor == other.textColor
                && userId == other.userId
                && title == other.title
                && shortName == other.shortName
                && thumb == other.thumb
                && stickers == other.stickers
                && software == other.software
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9021ab67.toInt()
    }
}

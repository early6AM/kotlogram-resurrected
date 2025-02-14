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
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputStickerSetItem#32da9e9c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetItem() : TLObject() {
    var document: TLAbsInputDocument = TLInputDocumentEmpty()

    var emoji: String = ""

    var maskCoords: TLMaskCoords? = null

    var keywords: String? = null

    private val _constructor: String = "inputStickerSetItem#32da9e9c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            document: TLAbsInputDocument,
            emoji: String,
            maskCoords: TLMaskCoords?,
            keywords: String?
    ) : this() {
        this.document = document
        this.emoji = emoji
        this.maskCoords = maskCoords
        this.keywords = keywords
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(maskCoords, 1)
        updateFlags(keywords, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(document)
        writeString(emoji)
        doIfMask(maskCoords, 1) { writeTLObject(it) }
        doIfMask(keywords, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        document = readTLObject<TLAbsInputDocument>()
        emoji = readString()
        maskCoords = readIfMask(1) { readTLObject<TLMaskCoords>(TLMaskCoords::class, TLMaskCoords.CONSTRUCTOR_ID) }
        keywords = readIfMask(2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += document.computeSerializedSize()
        size += computeTLStringSerializedSize(emoji)
        size += getIntIfMask(maskCoords, 1) { it.computeSerializedSize() }
        size += getIntIfMask(keywords, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetItem) return false
        if (other === this) return true

        return _flags == other._flags
                && document == other.document
                && emoji == other.emoji
                && maskCoords == other.maskCoords
                && keywords == other.keywords
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x32da9e9c.toInt()
    }
}

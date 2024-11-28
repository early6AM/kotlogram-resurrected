package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.api.TLInputStickerSetEmpty
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
class TLRequestStickersRenameStickerSet() : TLMethod<TLAbsStickerSet>() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var title: String = ""

    private val _constructor: String = "stickers.renameStickerSet#124b1c00"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stickerset: TLAbsInputStickerSet, title: String) : this() {
        this.stickerset = stickerset
        this.title = title
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
        writeString(title)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
        title = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersRenameStickerSet) return false
        if (other === this) return true

        return stickerset == other.stickerset
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x124b1c00.toInt()
    }
}

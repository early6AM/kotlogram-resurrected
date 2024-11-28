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

/**
 * inputStickerSetThumb#9d84f3db
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetThumb() : TLAbsInputFileLocation() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var thumbVersion: Int = 0

    private val _constructor: String = "inputStickerSetThumb#9d84f3db"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stickerset: TLAbsInputStickerSet, thumbVersion: Int) : this() {
        this.stickerset = stickerset
        this.thumbVersion = thumbVersion
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
        writeInt(thumbVersion)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
        thumbVersion = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetThumb) return false
        if (other === this) return true

        return stickerset == other.stickerset
                && thumbVersion == other.thumbVersion
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9d84f3db.toInt()
    }
}

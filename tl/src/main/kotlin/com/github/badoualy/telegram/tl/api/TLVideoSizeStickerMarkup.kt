package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * videoSizeStickerMarkup#da082fe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLVideoSizeStickerMarkup() : TLAbsVideoSize() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var stickerId: Long = 0L

    var backgroundColors: TLIntVector = TLIntVector()

    private val _constructor: String = "videoSizeStickerMarkup#da082fe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            stickerset: TLAbsInputStickerSet,
            stickerId: Long,
            backgroundColors: TLIntVector
    ) : this() {
        this.stickerset = stickerset
        this.stickerId = stickerId
        this.backgroundColors = backgroundColors
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
        writeLong(stickerId)
        writeTLVector(backgroundColors)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
        stickerId = readLong()
        backgroundColors = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        size += SIZE_INT64
        size += backgroundColors.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLVideoSizeStickerMarkup) return false
        if (other === this) return true

        return stickerset == other.stickerset
                && stickerId == other.stickerId
                && backgroundColors == other.backgroundColors
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xda082fe.toInt()
    }
}

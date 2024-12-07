package com.github.badoualy.telegram.tl.api.bots

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLBotPreviewMedia
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * bots.previewInfo#ca71d64
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPreviewInfo() : TLObject() {
    var media: TLObjectVector<TLBotPreviewMedia> = TLObjectVector()

    var langCodes: TLStringVector = TLStringVector()

    private val _constructor: String = "bots.previewInfo#ca71d64"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(media: TLObjectVector<TLBotPreviewMedia>, langCodes: TLStringVector) : this() {
        this.media = media
        this.langCodes = langCodes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(media)
        writeTLVector(langCodes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        media = readTLVector<TLBotPreviewMedia>()
        langCodes = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += media.computeSerializedSize()
        size += langCodes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPreviewInfo) return false
        if (other === this) return true

        return media == other.media
                && langCodes == other.langCodes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xca71d64.toInt()
    }
}

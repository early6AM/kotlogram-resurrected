package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.api.TLStickerPack
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * messages.favedStickers#2cb51097
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFavedStickers() : TLAbsFavedStickers() {
    var hash: Long = 0L

    var packs: TLObjectVector<TLStickerPack> = TLObjectVector()

    var stickers: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "messages.favedStickers#2cb51097"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hash: Long,
            packs: TLObjectVector<TLStickerPack>,
            stickers: TLObjectVector<TLAbsDocument>
    ) : this() {
        this.hash = hash
        this.packs = packs
        this.stickers = stickers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(packs)
        writeTLVector(stickers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        packs = readTLVector<TLStickerPack>()
        stickers = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += packs.computeSerializedSize()
        size += stickers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFavedStickers) return false
        if (other === this) return true

        return hash == other.hash
                && packs == other.packs
                && stickers == other.stickers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2cb51097.toInt()
    }
}

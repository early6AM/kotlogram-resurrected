package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * stickerSetFullCovered#40d13c0e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickerSetFullCovered() : TLAbsStickerSetCovered() {
    override var set: TLStickerSet = TLStickerSet()

    var packs: TLObjectVector<TLStickerPack> = TLObjectVector()

    var keywords: TLObjectVector<TLStickerKeyword> = TLObjectVector()

    var documents: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "stickerSetFullCovered#40d13c0e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            set: TLStickerSet,
            packs: TLObjectVector<TLStickerPack>,
            keywords: TLObjectVector<TLStickerKeyword>,
            documents: TLObjectVector<TLAbsDocument>
    ) : this() {
        this.set = set
        this.packs = packs
        this.keywords = keywords
        this.documents = documents
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(set)
        writeTLVector(packs)
        writeTLVector(keywords)
        writeTLVector(documents)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        set = readTLObject<TLStickerSet>(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)
        packs = readTLVector<TLStickerPack>()
        keywords = readTLVector<TLStickerKeyword>()
        documents = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += set.computeSerializedSize()
        size += packs.computeSerializedSize()
        size += keywords.computeSerializedSize()
        size += documents.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickerSetFullCovered) return false
        if (other === this) return true

        return set == other.set
                && packs == other.packs
                && keywords == other.keywords
                && documents == other.documents
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40d13c0e.toInt()
    }
}

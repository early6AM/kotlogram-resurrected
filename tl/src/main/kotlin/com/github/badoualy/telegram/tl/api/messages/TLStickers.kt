package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
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
 * messages.stickers#30a6ec7e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickers() : TLAbsStickers() {
    var hash: Long = 0L

    var stickers: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "messages.stickers#30a6ec7e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Long, stickers: TLObjectVector<TLAbsDocument>) : this() {
        this.hash = hash
        this.stickers = stickers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(stickers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        stickers = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += stickers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickers) return false
        if (other === this) return true

        return hash == other.hash
                && stickers == other.stickers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x30a6ec7e.toInt()
    }
}

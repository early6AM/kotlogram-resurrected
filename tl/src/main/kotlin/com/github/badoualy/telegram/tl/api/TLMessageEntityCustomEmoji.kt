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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageEntityCustomEmoji#c8cf05f8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageEntityCustomEmoji() : TLAbsMessageEntity() {
    override var offset: Int = 0

    override var length: Int = 0

    var documentId: Long = 0L

    private val _constructor: String = "messageEntityCustomEmoji#c8cf05f8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            offset: Int,
            length: Int,
            documentId: Long
    ) : this() {
        this.offset = offset
        this.length = length
        this.documentId = documentId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(offset)
        writeInt(length)
        writeLong(documentId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        offset = readInt()
        length = readInt()
        documentId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageEntityCustomEmoji) return false
        if (other === this) return true

        return offset == other.offset
                && length == other.length
                && documentId == other.documentId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc8cf05f8.toInt()
    }
}

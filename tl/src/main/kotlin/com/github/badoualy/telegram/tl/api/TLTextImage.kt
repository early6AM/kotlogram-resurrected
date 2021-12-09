package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * textImage#81ccf4f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTextImage() : TLAbsRichText() {
    var documentId: Long = 0L

    var w: Int = 0

    var h: Int = 0

    private val _constructor: String = "textImage#81ccf4f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            documentId: Long,
            w: Int,
            h: Int
    ) : this() {
        this.documentId = documentId
        this.w = w
        this.h = h
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(documentId)
        writeInt(w)
        writeInt(h)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        documentId = readLong()
        w = readInt()
        h = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTextImage) return false
        if (other === this) return true

        return documentId == other.documentId
                && w == other.w
                && h == other.h
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x81ccf4f
    }
}

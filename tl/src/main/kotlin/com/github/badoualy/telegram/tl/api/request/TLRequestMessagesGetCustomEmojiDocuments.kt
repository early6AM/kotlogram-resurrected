package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetCustomEmojiDocuments() : TLMethod<TLObjectVector<TLAbsDocument>>() {
    var documentId: TLLongVector = TLLongVector()

    private val _constructor: String = "messages.getCustomEmojiDocuments#d9ab0f54"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(documentId: TLLongVector) : this() {
        this.documentId = documentId
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsDocument> = tlDeserializer.readTLVector<TLAbsDocument>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(documentId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        documentId = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += documentId.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetCustomEmojiDocuments) return false
        if (other === this) return true

        return documentId == other.documentId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd9ab0f54.toInt()
    }
}

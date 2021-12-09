package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme
import com.github.badoualy.telegram.tl.api.TLInputThemeSlug
import com.github.badoualy.telegram.tl.api.TLTheme
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetTheme() : TLMethod<TLTheme>() {
    var format: String = ""

    var theme: TLAbsInputTheme = TLInputThemeSlug()

    var documentId: Long = 0L

    private val _constructor: String = "account.getTheme#8d9d742b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            format: String,
            theme: TLAbsInputTheme,
            documentId: Long
    ) : this() {
        this.format = format
        this.theme = theme
        this.documentId = documentId
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTheme = tlDeserializer.readTLObject(TLTheme::class, TLTheme.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(format)
        writeTLObject(theme)
        writeLong(documentId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        format = readString()
        theme = readTLObject<TLAbsInputTheme>()
        documentId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(format)
        size += theme.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetTheme) return false
        if (other === this) return true

        return format == other.format
                && theme == other.theme
                && documentId == other.documentId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8d9d742b.toInt()
    }
}

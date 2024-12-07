package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme
import com.github.badoualy.telegram.tl.api.TLInputThemeSettings
import com.github.badoualy.telegram.tl.api.TLInputThemeSlug
import com.github.badoualy.telegram.tl.api.TLTheme
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
class TLRequestAccountUpdateTheme() : TLMethod<TLTheme>() {
    var format: String = ""

    var theme: TLAbsInputTheme = TLInputThemeSlug()

    var slug: String? = null

    var title: String? = null

    var document: TLAbsInputDocument? = null

    var settings: TLObjectVector<TLInputThemeSettings>? = TLObjectVector()

    private val _constructor: String = "account.updateTheme#2bf40ccc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            format: String,
            theme: TLAbsInputTheme,
            slug: String?,
            title: String?,
            document: TLAbsInputDocument?,
            settings: TLObjectVector<TLInputThemeSettings>?
    ) : this() {
        this.format = format
        this.theme = theme
        this.slug = slug
        this.title = title
        this.document = document
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTheme = tlDeserializer.readTLObject(TLTheme::class, TLTheme.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(slug, 1)
        updateFlags(title, 2)
        updateFlags(document, 4)
        updateFlags(settings, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(format)
        writeTLObject(theme)
        doIfMask(1, slug, 1) { writeString(it) }
        doIfMask(1, title, 2) { writeString(it) }
        doIfMask(1, document, 4) { writeTLObject(it) }
        doIfMask(1, settings, 8) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        format = readString()
        theme = readTLObject<TLAbsInputTheme>()
        slug = readIfMask(1, 1) { readString() }
        title = readIfMask(1, 2) { readString() }
        document = readIfMask(1, 4) { readTLObject<TLAbsInputDocument>() }
        settings = readIfMask(1, 8) { readTLVector<TLInputThemeSettings>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(format)
        size += theme.computeSerializedSize()
        size += getIntIfMask(1, slug, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, title, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, document, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, settings, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdateTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && format == other.format
                && theme == other.theme
                && slug == other.slug
                && title == other.title
                && document == other.document
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2bf40ccc.toInt()
    }
}

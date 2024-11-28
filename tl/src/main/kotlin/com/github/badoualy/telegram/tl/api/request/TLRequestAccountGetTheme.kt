package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme
import com.github.badoualy.telegram.tl.api.TLInputThemeSlug
import com.github.badoualy.telegram.tl.api.TLTheme
import com.github.badoualy.telegram.tl.core.TLMethod
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
class TLRequestAccountGetTheme() : TLMethod<TLTheme>() {
    var format: String = ""

    var theme: TLAbsInputTheme = TLInputThemeSlug()

    private val _constructor: String = "account.getTheme#3a5869ec"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(format: String, theme: TLAbsInputTheme) : this() {
        this.format = format
        this.theme = theme
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTheme = tlDeserializer.readTLObject(TLTheme::class, TLTheme.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(format)
        writeTLObject(theme)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        format = readString()
        theme = readTLObject<TLAbsInputTheme>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(format)
        size += theme.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetTheme) return false
        if (other === this) return true

        return format == other.format
                && theme == other.theme
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3a5869ec.toInt()
    }
}

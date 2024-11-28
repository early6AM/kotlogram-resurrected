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
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestAccountSaveTheme() : TLMethod<TLBool>() {
    var theme: TLAbsInputTheme = TLInputThemeSlug()

    var unsave: Boolean = false

    private val _constructor: String = "account.saveTheme#f257106c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(theme: TLAbsInputTheme, unsave: Boolean) : this() {
        this.theme = theme
        this.unsave = unsave
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(theme)
        writeBoolean(unsave)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        theme = readTLObject<TLAbsInputTheme>()
        unsave = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += theme.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSaveTheme) return false
        if (other === this) return true

        return theme == other.theme
                && unsave == other.unsave
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf257106c.toInt()
    }
}

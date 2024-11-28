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
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputInvoiceSlug#c326caef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputInvoiceSlug() : TLAbsInputInvoice() {
    var slug: String = ""

    private val _constructor: String = "inputInvoiceSlug#c326caef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(slug: String) : this() {
        this.slug = slug
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(slug)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        slug = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(slug)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputInvoiceSlug) return false
        if (other === this) return true

        return slug == other.slug
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc326caef.toInt()
    }
}

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
 * webPageAttributeTheme#54b56617
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebPageAttributeTheme() : TLAbsWebPageAttribute() {
    var documents: TLObjectVector<TLAbsDocument>? = TLObjectVector()

    var settings: TLThemeSettings? = null

    private val _constructor: String = "webPageAttributeTheme#54b56617"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(documents: TLObjectVector<TLAbsDocument>?, settings: TLThemeSettings?) : this() {
        this.documents = documents
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(documents, 1)
        updateFlags(settings, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, documents, 1) { writeTLVector(it) }
        doIfMask(1, settings, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        documents = readIfMask(1, 1) { readTLVector<TLAbsDocument>() }
        settings = readIfMask(1, 2) { readTLObject<TLThemeSettings>(TLThemeSettings::class, TLThemeSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, documents, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, settings, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebPageAttributeTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && documents == other.documents
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x54b56617.toInt()
    }
}

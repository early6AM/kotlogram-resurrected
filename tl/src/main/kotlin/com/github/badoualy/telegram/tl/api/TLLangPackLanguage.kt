package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * langPackLanguage#eeca5ce3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLangPackLanguage() : TLObject() {
    @Transient
    var official: Boolean = false

    @Transient
    var rtl: Boolean = false

    @Transient
    var beta: Boolean = false

    var name: String = ""

    var nativeName: String = ""

    var langCode: String = ""

    var baseLangCode: String? = null

    var pluralCode: String = ""

    var stringsCount: Int = 0

    var translatedCount: Int = 0

    var translationsUrl: String = ""

    private val _constructor: String = "langPackLanguage#eeca5ce3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            official: Boolean,
            rtl: Boolean,
            beta: Boolean,
            name: String,
            nativeName: String,
            langCode: String,
            baseLangCode: String?,
            pluralCode: String,
            stringsCount: Int,
            translatedCount: Int,
            translationsUrl: String
    ) : this() {
        this.official = official
        this.rtl = rtl
        this.beta = beta
        this.name = name
        this.nativeName = nativeName
        this.langCode = langCode
        this.baseLangCode = baseLangCode
        this.pluralCode = pluralCode
        this.stringsCount = stringsCount
        this.translatedCount = translatedCount
        this.translationsUrl = translationsUrl
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(official, 1)
        updateFlags(rtl, 4)
        updateFlags(beta, 8)
        updateFlags(baseLangCode, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(name)
        writeString(nativeName)
        writeString(langCode)
        doIfMask(1, baseLangCode, 2) { writeString(it) }
        writeString(pluralCode)
        writeInt(stringsCount)
        writeInt(translatedCount)
        writeString(translationsUrl)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        official = isMask(1, 1)
        rtl = isMask(1, 4)
        beta = isMask(1, 8)
        name = readString()
        nativeName = readString()
        langCode = readString()
        baseLangCode = readIfMask(1, 2) { readString() }
        pluralCode = readString()
        stringsCount = readInt()
        translatedCount = readInt()
        translationsUrl = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(name)
        size += computeTLStringSerializedSize(nativeName)
        size += computeTLStringSerializedSize(langCode)
        size += getIntIfMask(1, baseLangCode, 2) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(pluralCode)
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(translationsUrl)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLangPackLanguage) return false
        if (other === this) return true

        return _flags == other._flags
                && official == other.official
                && rtl == other.rtl
                && beta == other.beta
                && name == other.name
                && nativeName == other.nativeName
                && langCode == other.langCode
                && baseLangCode == other.baseLangCode
                && pluralCode == other.pluralCode
                && stringsCount == other.stringsCount
                && translatedCount == other.translatedCount
                && translationsUrl == other.translationsUrl
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeeca5ce3.toInt()
    }
}

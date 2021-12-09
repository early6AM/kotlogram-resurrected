package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLLangPackDifference
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestLangpackGetDifference() : TLMethod<TLLangPackDifference>() {
    var langPack: String = ""

    var langCode: String = ""

    var fromVersion: Int = 0

    private val _constructor: String = "langpack.getDifference#cd984aa5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            langPack: String,
            langCode: String,
            fromVersion: Int
    ) : this() {
        this.langPack = langPack
        this.langCode = langCode
        this.fromVersion = fromVersion
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLLangPackDifference = tlDeserializer.readTLObject(TLLangPackDifference::class, TLLangPackDifference.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langPack)
        writeString(langCode)
        writeInt(fromVersion)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langPack = readString()
        langCode = readString()
        fromVersion = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langPack)
        size += computeTLStringSerializedSize(langCode)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestLangpackGetDifference) return false
        if (other === this) return true

        return langPack == other.langPack
                && langCode == other.langCode
                && fromVersion == other.fromVersion
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcd984aa5.toInt()
    }
}

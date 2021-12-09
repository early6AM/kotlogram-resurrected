package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetCountriesList() : TLMethod<TLAbsCountriesList>() {
    var langCode: String = ""

    var hash: Int = 0

    private val _constructor: String = "help.getCountriesList#735787a8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(langCode: String, hash: Int) : this() {
        this.langCode = langCode
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langCode)
        writeInt(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCode = readString()
        hash = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langCode)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetCountriesList) return false
        if (other === this) return true

        return langCode == other.langCode
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x735787a8
    }
}

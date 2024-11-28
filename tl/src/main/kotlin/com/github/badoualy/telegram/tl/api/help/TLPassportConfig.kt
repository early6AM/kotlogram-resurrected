package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * help.passportConfig#a098d6af
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPassportConfig() : TLAbsPassportConfig() {
    var hash: Int = 0

    var countriesLangs: TLDataJSON = TLDataJSON()

    private val _constructor: String = "help.passportConfig#a098d6af"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Int, countriesLangs: TLDataJSON) : this() {
        this.hash = hash
        this.countriesLangs = countriesLangs
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(hash)
        writeTLObject(countriesLangs)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readInt()
        countriesLangs = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += countriesLangs.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPassportConfig) return false
        if (other === this) return true

        return hash == other.hash
                && countriesLangs == other.countriesLangs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa098d6af.toInt()
    }
}

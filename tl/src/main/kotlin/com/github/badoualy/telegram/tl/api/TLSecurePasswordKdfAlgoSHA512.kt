package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * securePasswordKdfAlgoSHA512#86471d92
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecurePasswordKdfAlgoSHA512() : TLAbsSecurePasswordKdfAlgo() {
    var salt: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "securePasswordKdfAlgoSHA512#86471d92"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(salt: TLBytes) : this() {
        this.salt = salt
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(salt)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        salt = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(salt)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecurePasswordKdfAlgoSHA512) return false
        if (other === this) return true

        return salt == other.salt
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86471d92.toInt()
    }
}

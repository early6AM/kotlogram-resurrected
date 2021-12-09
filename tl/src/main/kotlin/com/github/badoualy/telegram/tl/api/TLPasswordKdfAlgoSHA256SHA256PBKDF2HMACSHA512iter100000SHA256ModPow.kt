package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow#3a912d4a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow() : TLAbsPasswordKdfAlgo() {
    var salt1: TLBytes = TLBytes.EMPTY

    var salt2: TLBytes = TLBytes.EMPTY

    var g: Int = 0

    var p: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow#3a912d4a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            salt1: TLBytes,
            salt2: TLBytes,
            g: Int,
            p: TLBytes
    ) : this() {
        this.salt1 = salt1
        this.salt2 = salt2
        this.g = g
        this.p = p
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(salt1)
        writeTLBytes(salt2)
        writeInt(g)
        writeTLBytes(p)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        salt1 = readTLBytes()
        salt2 = readTLBytes()
        g = readInt()
        p = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(salt1)
        size += computeTLBytesSerializedSize(salt2)
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(p)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) return false
        if (other === this) return true

        return salt1 == other.salt1
                && salt2 == other.salt2
                && g == other.g
                && p == other.p
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3a912d4a
    }
}

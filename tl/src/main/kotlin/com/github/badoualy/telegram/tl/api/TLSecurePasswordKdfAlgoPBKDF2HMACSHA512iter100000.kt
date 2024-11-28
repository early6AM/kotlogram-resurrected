package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * securePasswordKdfAlgoPBKDF2HMACSHA512iter100000#bbf2dda0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecurePasswordKdfAlgoPBKDF2HMACSHA512iter100000() : TLAbsSecurePasswordKdfAlgo() {
    var salt: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "securePasswordKdfAlgoPBKDF2HMACSHA512iter100000#bbf2dda0"

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
        if (other !is TLSecurePasswordKdfAlgoPBKDF2HMACSHA512iter100000) return false
        if (other === this) return true

        return salt == other.salt
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbbf2dda0.toInt()
    }
}

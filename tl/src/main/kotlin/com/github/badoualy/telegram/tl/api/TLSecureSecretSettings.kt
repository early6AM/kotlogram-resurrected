package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * secureSecretSettings#1527bcac
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureSecretSettings() : TLObject() {
    var secureAlgo: TLAbsSecurePasswordKdfAlgo = TLSecurePasswordKdfAlgoUnknown()

    var secureSecret: TLBytes = TLBytes.EMPTY

    var secureSecretId: Long = 0L

    private val _constructor: String = "secureSecretSettings#1527bcac"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            secureAlgo: TLAbsSecurePasswordKdfAlgo,
            secureSecret: TLBytes,
            secureSecretId: Long
    ) : this() {
        this.secureAlgo = secureAlgo
        this.secureSecret = secureSecret
        this.secureSecretId = secureSecretId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(secureAlgo)
        writeTLBytes(secureSecret)
        writeLong(secureSecretId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        secureAlgo = readTLObject<TLAbsSecurePasswordKdfAlgo>()
        secureSecret = readTLBytes()
        secureSecretId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += secureAlgo.computeSerializedSize()
        size += computeTLBytesSerializedSize(secureSecret)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureSecretSettings) return false
        if (other === this) return true

        return secureAlgo == other.secureAlgo
                && secureSecret == other.secureSecret
                && secureSecretId == other.secureSecretId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1527bcac
    }
}

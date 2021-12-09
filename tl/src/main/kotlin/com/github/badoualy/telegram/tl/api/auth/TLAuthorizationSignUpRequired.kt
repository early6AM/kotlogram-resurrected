package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.help.TLTermsOfService
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.authorizationSignUpRequired#44747e9a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorizationSignUpRequired() : TLAbsAuthorization() {
    var termsOfService: TLTermsOfService? = null

    private val _constructor: String = "auth.authorizationSignUpRequired#44747e9a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(termsOfService: TLTermsOfService?) : this() {
        this.termsOfService = termsOfService
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(termsOfService, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(termsOfService, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        termsOfService = readIfMask(1) { readTLObject<TLTermsOfService>(TLTermsOfService::class, TLTermsOfService.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(termsOfService, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorizationSignUpRequired) return false
        if (other === this) return true

        return _flags == other._flags
                && termsOfService == other.termsOfService
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x44747e9a
    }
}

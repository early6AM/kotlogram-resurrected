package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.loginTokenSuccess#390d5c5e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLoginTokenSuccess() : TLAbsLoginToken() {
    var authorization: TLAbsAuthorization = TLAuthorizationSignUpRequired()

    private val _constructor: String = "auth.loginTokenSuccess#390d5c5e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(authorization: TLAbsAuthorization) : this() {
        this.authorization = authorization
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(authorization)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        authorization = readTLObject<TLAbsAuthorization>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += authorization.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLoginTokenSuccess) return false
        if (other === this) return true

        return authorization == other.authorization
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x390d5c5e
    }
}

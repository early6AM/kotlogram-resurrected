package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsSecureValueError
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUsersSetSecureValueErrors() : TLMethod<TLBool>() {
    var id: TLAbsInputUser = TLInputUserEmpty()

    var errors: TLObjectVector<TLAbsSecureValueError> = TLObjectVector()

    private val _constructor: String = "users.setSecureValueErrors#90c894b5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>) : this() {
        this.id = id
        this.errors = errors
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(id)
        writeTLVector(errors)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readTLObject<TLAbsInputUser>()
        errors = readTLVector<TLAbsSecureValueError>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += id.computeSerializedSize()
        size += errors.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUsersSetSecureValueErrors) return false
        if (other === this) return true

        return id == other.id
                && errors == other.errors
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x90c894b5.toInt()
    }
}

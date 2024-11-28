package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAuthorization
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * account.authorizations#4bff8ea0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorizations() : TLObject() {
    var authorizationTtlDays: Int = 0

    var authorizations: TLObjectVector<TLAuthorization> = TLObjectVector()

    private val _constructor: String = "account.authorizations#4bff8ea0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(authorizationTtlDays: Int, authorizations: TLObjectVector<TLAuthorization>) : this() {
        this.authorizationTtlDays = authorizationTtlDays
        this.authorizations = authorizations
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(authorizationTtlDays)
        writeTLVector(authorizations)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        authorizationTtlDays = readInt()
        authorizations = readTLVector<TLAuthorization>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += authorizations.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorizations) return false
        if (other === this) return true

        return authorizationTtlDays == other.authorizationTtlDays
                && authorizations == other.authorizations
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4bff8ea0.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountChangeAuthorizationSettings() : TLMethod<TLBool>() {
    @Transient
    var confirmed: Boolean = false

    var hash: Long = 0L

    var encryptedRequestsDisabled: Boolean? = null

    var callRequestsDisabled: Boolean? = null

    private val _constructor: String = "account.changeAuthorizationSettings#40f48462"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            confirmed: Boolean,
            hash: Long,
            encryptedRequestsDisabled: Boolean?,
            callRequestsDisabled: Boolean?
    ) : this() {
        this.confirmed = confirmed
        this.hash = hash
        this.encryptedRequestsDisabled = encryptedRequestsDisabled
        this.callRequestsDisabled = callRequestsDisabled
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(confirmed, 8)
        updateFlags(encryptedRequestsDisabled, 1)
        updateFlags(callRequestsDisabled, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(hash)
        doIfMask(1, encryptedRequestsDisabled, 1) { writeBoolean(it) }
        doIfMask(1, callRequestsDisabled, 2) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        confirmed = isMask(1, 8)
        hash = readLong()
        encryptedRequestsDisabled = readIfMask(1, 1) { readBoolean() }
        callRequestsDisabled = readIfMask(1, 2) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, encryptedRequestsDisabled, 1) { SIZE_BOOLEAN }
        size += getIntIfMask(1, callRequestsDisabled, 2) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountChangeAuthorizationSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && confirmed == other.confirmed
                && hash == other.hash
                && encryptedRequestsDisabled == other.encryptedRequestsDisabled
                && callRequestsDisabled == other.callRequestsDisabled
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40f48462.toInt()
    }
}

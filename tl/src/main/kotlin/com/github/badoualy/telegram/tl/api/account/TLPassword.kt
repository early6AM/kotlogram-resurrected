package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsPasswordKdfAlgo
import com.github.badoualy.telegram.tl.api.TLAbsSecurePasswordKdfAlgo
import com.github.badoualy.telegram.tl.api.TLPasswordKdfAlgoUnknown
import com.github.badoualy.telegram.tl.api.TLSecurePasswordKdfAlgoUnknown
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
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
 * account.password#957b50fb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPassword() : TLObject() {
    @Transient
    var hasRecovery: Boolean = false

    @Transient
    var hasSecureValues: Boolean = false

    @Transient
    var hasPassword: Boolean = false

    var currentAlgo: TLAbsPasswordKdfAlgo? = null

    var srpB: TLBytes? = null

    var srpId: Long? = null

    var hint: String? = null

    var emailUnconfirmedPattern: String? = null

    var newAlgo: TLAbsPasswordKdfAlgo = TLPasswordKdfAlgoUnknown()

    var newSecureAlgo: TLAbsSecurePasswordKdfAlgo = TLSecurePasswordKdfAlgoUnknown()

    var secureRandom: TLBytes = TLBytes.EMPTY

    var pendingResetDate: Int? = null

    var loginEmailPattern: String? = null

    private val _constructor: String = "account.password#957b50fb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasRecovery: Boolean,
            hasSecureValues: Boolean,
            hasPassword: Boolean,
            currentAlgo: TLAbsPasswordKdfAlgo?,
            srpB: TLBytes?,
            srpId: Long?,
            hint: String?,
            emailUnconfirmedPattern: String?,
            newAlgo: TLAbsPasswordKdfAlgo,
            newSecureAlgo: TLAbsSecurePasswordKdfAlgo,
            secureRandom: TLBytes,
            pendingResetDate: Int?,
            loginEmailPattern: String?
    ) : this() {
        this.hasRecovery = hasRecovery
        this.hasSecureValues = hasSecureValues
        this.hasPassword = hasPassword
        this.currentAlgo = currentAlgo
        this.srpB = srpB
        this.srpId = srpId
        this.hint = hint
        this.emailUnconfirmedPattern = emailUnconfirmedPattern
        this.newAlgo = newAlgo
        this.newSecureAlgo = newSecureAlgo
        this.secureRandom = secureRandom
        this.pendingResetDate = pendingResetDate
        this.loginEmailPattern = loginEmailPattern
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasRecovery, 1)
        updateFlags(hasSecureValues, 2)
        updateFlags(hasPassword, 4)
        updateFlags(currentAlgo, 4)
        updateFlags(srpB, 4)
        updateFlags(srpId, 4)
        updateFlags(hint, 8)
        updateFlags(emailUnconfirmedPattern, 16)
        updateFlags(pendingResetDate, 32)
        updateFlags(loginEmailPattern, 64)

        // Following parameters might be forced to true by another field that updated the flags
        hasPassword = isMask(4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(currentAlgo, 4) { writeTLObject(it) }
        doIfMask(srpB, 4) { writeTLBytes(it) }
        doIfMask(srpId, 4) { writeLong(it) }
        doIfMask(hint, 8) { writeString(it) }
        doIfMask(emailUnconfirmedPattern, 16) { writeString(it) }
        writeTLObject(newAlgo)
        writeTLObject(newSecureAlgo)
        writeTLBytes(secureRandom)
        doIfMask(pendingResetDate, 32) { writeInt(it) }
        doIfMask(loginEmailPattern, 64) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasRecovery = isMask(1)
        hasSecureValues = isMask(2)
        hasPassword = isMask(4)
        currentAlgo = readIfMask(4) { readTLObject<TLAbsPasswordKdfAlgo>() }
        srpB = readIfMask(4) { readTLBytes() }
        srpId = readIfMask(4) { readLong() }
        hint = readIfMask(8) { readString() }
        emailUnconfirmedPattern = readIfMask(16) { readString() }
        newAlgo = readTLObject<TLAbsPasswordKdfAlgo>()
        newSecureAlgo = readTLObject<TLAbsSecurePasswordKdfAlgo>()
        secureRandom = readTLBytes()
        pendingResetDate = readIfMask(32) { readInt() }
        loginEmailPattern = readIfMask(64) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(currentAlgo, 4) { it.computeSerializedSize() }
        size += getIntIfMask(srpB, 4) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(srpId, 4) { SIZE_INT64 }
        size += getIntIfMask(hint, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(emailUnconfirmedPattern, 16) { computeTLStringSerializedSize(it) }
        size += newAlgo.computeSerializedSize()
        size += newSecureAlgo.computeSerializedSize()
        size += computeTLBytesSerializedSize(secureRandom)
        size += getIntIfMask(pendingResetDate, 32) { SIZE_INT32 }
        size += getIntIfMask(loginEmailPattern, 64) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPassword) return false
        if (other === this) return true

        return _flags == other._flags
                && hasRecovery == other.hasRecovery
                && hasSecureValues == other.hasSecureValues
                && hasPassword == other.hasPassword
                && currentAlgo == other.currentAlgo
                && srpB == other.srpB
                && srpId == other.srpId
                && hint == other.hint
                && emailUnconfirmedPattern == other.emailUnconfirmedPattern
                && newAlgo == other.newAlgo
                && newSecureAlgo == other.newSecureAlgo
                && secureRandom == other.secureRandom
                && pendingResetDate == other.pendingResetDate
                && loginEmailPattern == other.loginEmailPattern
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x957b50fb.toInt()
    }
}

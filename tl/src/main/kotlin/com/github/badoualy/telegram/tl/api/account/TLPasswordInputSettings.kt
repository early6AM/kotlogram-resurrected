package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsPasswordKdfAlgo
import com.github.badoualy.telegram.tl.api.TLSecureSecretSettings
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * account.passwordInputSettings#c23727c9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPasswordInputSettings() : TLObject() {
    var newAlgo: TLAbsPasswordKdfAlgo? = null

    var newPasswordHash: TLBytes? = null

    var hint: String? = null

    var email: String? = null

    var newSecureSettings: TLSecureSecretSettings? = null

    private val _constructor: String = "account.passwordInputSettings#c23727c9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            newAlgo: TLAbsPasswordKdfAlgo?,
            newPasswordHash: TLBytes?,
            hint: String?,
            email: String?,
            newSecureSettings: TLSecureSecretSettings?
    ) : this() {
        this.newAlgo = newAlgo
        this.newPasswordHash = newPasswordHash
        this.hint = hint
        this.email = email
        this.newSecureSettings = newSecureSettings
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(newAlgo, 1)
        updateFlags(newPasswordHash, 1)
        updateFlags(hint, 1)
        updateFlags(email, 2)
        updateFlags(newSecureSettings, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, newAlgo, 1) { writeTLObject(it) }
        doIfMask(1, newPasswordHash, 1) { writeTLBytes(it) }
        doIfMask(1, hint, 1) { writeString(it) }
        doIfMask(1, email, 2) { writeString(it) }
        doIfMask(1, newSecureSettings, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        newAlgo = readIfMask(1, 1) { readTLObject<TLAbsPasswordKdfAlgo>() }
        newPasswordHash = readIfMask(1, 1) { readTLBytes() }
        hint = readIfMask(1, 1) { readString() }
        email = readIfMask(1, 2) { readString() }
        newSecureSettings = readIfMask(1, 4) { readTLObject<TLSecureSecretSettings>(TLSecureSecretSettings::class, TLSecureSecretSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, newAlgo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, newPasswordHash, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(1, hint, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, email, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, newSecureSettings, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPasswordInputSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && newAlgo == other.newAlgo
                && newPasswordHash == other.newPasswordHash
                && hint == other.hint
                && email == other.email
                && newSecureSettings == other.newSecureSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc23727c9.toInt()
    }
}

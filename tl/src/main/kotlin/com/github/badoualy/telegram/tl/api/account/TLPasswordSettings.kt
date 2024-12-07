package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLSecureSecretSettings
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
 * account.passwordSettings#9a5c33e5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPasswordSettings() : TLObject() {
    var email: String? = null

    var secureSettings: TLSecureSecretSettings? = null

    private val _constructor: String = "account.passwordSettings#9a5c33e5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(email: String?, secureSettings: TLSecureSecretSettings?) : this() {
        this.email = email
        this.secureSettings = secureSettings
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(email, 1)
        updateFlags(secureSettings, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, email, 1) { writeString(it) }
        doIfMask(1, secureSettings, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        email = readIfMask(1, 1) { readString() }
        secureSettings = readIfMask(1, 2) { readTLObject<TLSecureSecretSettings>(TLSecureSecretSettings::class, TLSecureSecretSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, email, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, secureSettings, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPasswordSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && email == other.email
                && secureSettings == other.secureSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a5c33e5.toInt()
    }
}

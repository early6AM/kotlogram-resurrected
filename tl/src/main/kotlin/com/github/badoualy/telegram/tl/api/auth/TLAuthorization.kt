package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLUserEmpty
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * auth.authorization#2ea2c0d4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorization() : TLAbsAuthorization() {
    @Transient
    var setupPasswordRequired: Boolean = false

    var otherwiseReloginDays: Int? = null

    var tmpSessions: Int? = null

    var futureAuthToken: TLBytes? = null

    var user: TLAbsUser = TLUserEmpty()

    private val _constructor: String = "auth.authorization#2ea2c0d4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            setupPasswordRequired: Boolean,
            otherwiseReloginDays: Int?,
            tmpSessions: Int?,
            futureAuthToken: TLBytes?,
            user: TLAbsUser
    ) : this() {
        this.setupPasswordRequired = setupPasswordRequired
        this.otherwiseReloginDays = otherwiseReloginDays
        this.tmpSessions = tmpSessions
        this.futureAuthToken = futureAuthToken
        this.user = user
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(setupPasswordRequired, 2)
        updateFlags(otherwiseReloginDays, 2)
        updateFlags(tmpSessions, 1)
        updateFlags(futureAuthToken, 4)

        // Following parameters might be forced to true by another field that updated the flags
        setupPasswordRequired = isMask(1, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, otherwiseReloginDays, 2) { writeInt(it) }
        doIfMask(1, tmpSessions, 1) { writeInt(it) }
        doIfMask(1, futureAuthToken, 4) { writeTLBytes(it) }
        writeTLObject(user)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        setupPasswordRequired = isMask(1, 2)
        otherwiseReloginDays = readIfMask(1, 2) { readInt() }
        tmpSessions = readIfMask(1, 1) { readInt() }
        futureAuthToken = readIfMask(1, 4) { readTLBytes() }
        user = readTLObject<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, otherwiseReloginDays, 2) { SIZE_INT32 }
        size += getIntIfMask(1, tmpSessions, 1) { SIZE_INT32 }
        size += getIntIfMask(1, futureAuthToken, 4) { computeTLBytesSerializedSize(it) }
        size += user.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorization) return false
        if (other === this) return true

        return _flags == other._flags
                && setupPasswordRequired == other.setupPasswordRequired
                && otherwiseReloginDays == other.otherwiseReloginDays
                && tmpSessions == other.tmpSessions
                && futureAuthToken == other.futureAuthToken
                && user == other.user
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2ea2c0d4.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * authorization#ad01d61d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorization() : TLObject() {
    @Transient
    var current: Boolean = false

    @Transient
    var officialApp: Boolean = false

    @Transient
    var passwordPending: Boolean = false

    @Transient
    var encryptedRequestsDisabled: Boolean = false

    @Transient
    var callRequestsDisabled: Boolean = false

    @Transient
    var unconfirmed: Boolean = false

    var hash: Long = 0L

    var deviceModel: String = ""

    var platform: String = ""

    var systemVersion: String = ""

    var apiId: Int = 0

    var appName: String = ""

    var appVersion: String = ""

    var dateCreated: Int = 0

    var dateActive: Int = 0

    var ip: String = ""

    var country: String = ""

    var region: String = ""

    private val _constructor: String = "authorization#ad01d61d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            current: Boolean,
            officialApp: Boolean,
            passwordPending: Boolean,
            encryptedRequestsDisabled: Boolean,
            callRequestsDisabled: Boolean,
            unconfirmed: Boolean,
            hash: Long,
            deviceModel: String,
            platform: String,
            systemVersion: String,
            apiId: Int,
            appName: String,
            appVersion: String,
            dateCreated: Int,
            dateActive: Int,
            ip: String,
            country: String,
            region: String
    ) : this() {
        this.current = current
        this.officialApp = officialApp
        this.passwordPending = passwordPending
        this.encryptedRequestsDisabled = encryptedRequestsDisabled
        this.callRequestsDisabled = callRequestsDisabled
        this.unconfirmed = unconfirmed
        this.hash = hash
        this.deviceModel = deviceModel
        this.platform = platform
        this.systemVersion = systemVersion
        this.apiId = apiId
        this.appName = appName
        this.appVersion = appVersion
        this.dateCreated = dateCreated
        this.dateActive = dateActive
        this.ip = ip
        this.country = country
        this.region = region
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(current, 1)
        updateFlags(officialApp, 2)
        updateFlags(passwordPending, 4)
        updateFlags(encryptedRequestsDisabled, 8)
        updateFlags(callRequestsDisabled, 16)
        updateFlags(unconfirmed, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(hash)
        writeString(deviceModel)
        writeString(platform)
        writeString(systemVersion)
        writeInt(apiId)
        writeString(appName)
        writeString(appVersion)
        writeInt(dateCreated)
        writeInt(dateActive)
        writeString(ip)
        writeString(country)
        writeString(region)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        current = isMask(1)
        officialApp = isMask(2)
        passwordPending = isMask(4)
        encryptedRequestsDisabled = isMask(8)
        callRequestsDisabled = isMask(16)
        unconfirmed = isMask(32)
        hash = readLong()
        deviceModel = readString()
        platform = readString()
        systemVersion = readString()
        apiId = readInt()
        appName = readString()
        appVersion = readString()
        dateCreated = readInt()
        dateActive = readInt()
        ip = readString()
        country = readString()
        region = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(deviceModel)
        size += computeTLStringSerializedSize(platform)
        size += computeTLStringSerializedSize(systemVersion)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(appName)
        size += computeTLStringSerializedSize(appVersion)
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(country)
        size += computeTLStringSerializedSize(region)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorization) return false
        if (other === this) return true

        return _flags == other._flags
                && current == other.current
                && officialApp == other.officialApp
                && passwordPending == other.passwordPending
                && encryptedRequestsDisabled == other.encryptedRequestsDisabled
                && callRequestsDisabled == other.callRequestsDisabled
                && unconfirmed == other.unconfirmed
                && hash == other.hash
                && deviceModel == other.deviceModel
                && platform == other.platform
                && systemVersion == other.systemVersion
                && apiId == other.apiId
                && appName == other.appName
                && appVersion == other.appVersion
                && dateCreated == other.dateCreated
                && dateActive == other.dateActive
                && ip == other.ip
                && country == other.country
                && region == other.region
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xad01d61d.toInt()
    }
}

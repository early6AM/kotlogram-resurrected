package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLCodeSettings
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthSendCode() : TLMethod<TLSentCode>() {
    var phoneNumber: String = ""

    var apiId: Int = 0

    var apiHash: String = ""

    var settings: TLCodeSettings = TLCodeSettings()

    private val _constructor: String = "auth.sendCode#a677244f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            apiId: Int,
            apiHash: String,
            settings: TLCodeSettings
    ) : this() {
        this.phoneNumber = phoneNumber
        this.apiId = apiId
        this.apiHash = apiHash
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSentCode = tlDeserializer.readTLObject(TLSentCode::class, TLSentCode.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeInt(apiId)
        writeString(apiHash)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        apiId = readInt()
        apiHash = readString()
        settings = readTLObject<TLCodeSettings>(TLCodeSettings::class, TLCodeSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(apiHash)
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthSendCode) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && apiId == other.apiId
                && apiHash == other.apiHash
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa677244f.toInt()
    }
}

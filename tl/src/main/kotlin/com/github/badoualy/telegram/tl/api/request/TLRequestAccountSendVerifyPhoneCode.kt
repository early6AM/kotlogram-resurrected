package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
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
class TLRequestAccountSendVerifyPhoneCode() : TLMethod<TLSentCode>() {
    var phoneNumber: String = ""

    var settings: TLCodeSettings = TLCodeSettings()

    private val _constructor: String = "account.sendVerifyPhoneCode#a5a356f9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneNumber: String, settings: TLCodeSettings) : this() {
        this.phoneNumber = phoneNumber
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSentCode = tlDeserializer.readTLObject(TLSentCode::class, TLSentCode.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        settings = readTLObject<TLCodeSettings>(TLCodeSettings::class, TLCodeSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSendVerifyPhoneCode) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa5a356f9.toInt()
    }
}

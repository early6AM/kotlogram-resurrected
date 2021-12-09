package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP
import com.github.badoualy.telegram.tl.api.TLInputCheckPasswordEmpty
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdatePasswordSettings() : TLMethod<TLBool>() {
    var password: TLAbsInputCheckPasswordSRP = TLInputCheckPasswordEmpty()

    var newSettings: TLPasswordInputSettings = TLPasswordInputSettings()

    private val _constructor: String = "account.updatePasswordSettings#a59b102f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(password: TLAbsInputCheckPasswordSRP, newSettings: TLPasswordInputSettings) : this() {
        this.password = password
        this.newSettings = newSettings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(password)
        writeTLObject(newSettings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        password = readTLObject<TLAbsInputCheckPasswordSRP>()
        newSettings = readTLObject<TLPasswordInputSettings>(TLPasswordInputSettings::class, TLPasswordInputSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += password.computeSerializedSize()
        size += newSettings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdatePasswordSettings) return false
        if (other === this) return true

        return password == other.password
                && newSettings == other.newSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa59b102f.toInt()
    }
}

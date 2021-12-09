package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP
import com.github.badoualy.telegram.tl.api.TLInputCheckPasswordEmpty
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetPasswordSettings() : TLMethod<TLPasswordSettings>() {
    var password: TLAbsInputCheckPasswordSRP = TLInputCheckPasswordEmpty()

    private val _constructor: String = "account.getPasswordSettings#9cd4eaf9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(password: TLAbsInputCheckPasswordSRP) : this() {
        this.password = password
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPasswordSettings = tlDeserializer.readTLObject(TLPasswordSettings::class, TLPasswordSettings.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(password)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        password = readTLObject<TLAbsInputCheckPasswordSRP>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += password.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetPasswordSettings) return false
        if (other === this) return true

        return password == other.password
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9cd4eaf9.toInt()
    }
}

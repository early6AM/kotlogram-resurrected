package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthRecoverPassword() : TLMethod<TLAbsAuthorization>() {
    var code: String = ""

    var newSettings: TLPasswordInputSettings? = null

    private val _constructor: String = "auth.recoverPassword#37096c70"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(code: String, newSettings: TLPasswordInputSettings?) : this() {
        this.code = code
        this.newSettings = newSettings
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(newSettings, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(code)
        doIfMask(1, newSettings, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        code = readString()
        newSettings = readIfMask(1, 1) { readTLObject<TLPasswordInputSettings>(TLPasswordInputSettings::class, TLPasswordInputSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(code)
        size += getIntIfMask(1, newSettings, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthRecoverPassword) return false
        if (other === this) return true

        return _flags == other._flags
                && code == other.code
                && newSettings == other.newSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x37096c70.toInt()
    }
}

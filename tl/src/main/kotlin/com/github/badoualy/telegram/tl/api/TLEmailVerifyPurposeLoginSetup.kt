package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * emailVerifyPurposeLoginSetup#4345be73
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmailVerifyPurposeLoginSetup() : TLAbsEmailVerifyPurpose() {
    var phoneNumber: String = ""

    var phoneCodeHash: String = ""

    private val _constructor: String = "emailVerifyPurposeLoginSetup#4345be73"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneNumber: String, phoneCodeHash: String) : this() {
        this.phoneNumber = phoneNumber
        this.phoneCodeHash = phoneCodeHash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeString(phoneCodeHash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        phoneCodeHash = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(phoneCodeHash)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmailVerifyPurposeLoginSetup) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && phoneCodeHash == other.phoneCodeHash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4345be73.toInt()
    }
}

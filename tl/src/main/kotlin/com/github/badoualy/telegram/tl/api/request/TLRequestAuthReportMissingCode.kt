package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestAuthReportMissingCode() : TLMethod<TLBool>() {
    var phoneNumber: String = ""

    var phoneCodeHash: String = ""

    var mnc: String = ""

    private val _constructor: String = "auth.reportMissingCode#cb9deff6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            phoneCodeHash: String,
            mnc: String
    ) : this() {
        this.phoneNumber = phoneNumber
        this.phoneCodeHash = phoneCodeHash
        this.mnc = mnc
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeString(phoneCodeHash)
        writeString(mnc)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        phoneCodeHash = readString()
        mnc = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += computeTLStringSerializedSize(mnc)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthReportMissingCode) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && phoneCodeHash == other.phoneCodeHash
                && mnc == other.mnc
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcb9deff6.toInt()
    }
}

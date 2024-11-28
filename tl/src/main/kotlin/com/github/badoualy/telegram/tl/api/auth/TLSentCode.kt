package com.github.badoualy.telegram.tl.api.auth

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
 * auth.sentCode#5e002502
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCode() : TLAbsSentCode() {
    var type: TLAbsSentCodeType = TLSentCodeTypeCall()

    var phoneCodeHash: String = ""

    var nextType: TLAbsCodeType? = null

    var timeout: Int? = null

    private val _constructor: String = "auth.sentCode#5e002502"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: TLAbsSentCodeType,
            phoneCodeHash: String,
            nextType: TLAbsCodeType?,
            timeout: Int?
    ) : this() {
        this.type = type
        this.phoneCodeHash = phoneCodeHash
        this.nextType = nextType
        this.timeout = timeout
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nextType, 2)
        updateFlags(timeout, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
        writeString(phoneCodeHash)
        doIfMask(nextType, 2) { writeTLObject(it) }
        doIfMask(timeout, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        type = readTLObject<TLAbsSentCodeType>()
        phoneCodeHash = readString()
        nextType = readIfMask(2) { readTLObject<TLAbsCodeType>() }
        timeout = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += getIntIfMask(nextType, 2) { it.computeSerializedSize() }
        size += getIntIfMask(timeout, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCode) return false
        if (other === this) return true

        return _flags == other._flags
                && type == other.type
                && phoneCodeHash == other.phoneCodeHash
                && nextType == other.nextType
                && timeout == other.timeout
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5e002502.toInt()
    }
}

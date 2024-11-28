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
import kotlin.jvm.Transient

/**
 * secureRequiredType#829d99da
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureRequiredType() : TLAbsSecureRequiredType() {
    @Transient
    var nativeNames: Boolean = false

    @Transient
    var selfieRequired: Boolean = false

    @Transient
    var translationRequired: Boolean = false

    var type: TLAbsSecureValueType = TLSecureValueTypeUtilityBill()

    private val _constructor: String = "secureRequiredType#829d99da"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            nativeNames: Boolean,
            selfieRequired: Boolean,
            translationRequired: Boolean,
            type: TLAbsSecureValueType
    ) : this() {
        this.nativeNames = nativeNames
        this.selfieRequired = selfieRequired
        this.translationRequired = translationRequired
        this.type = type
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nativeNames, 1)
        updateFlags(selfieRequired, 2)
        updateFlags(translationRequired, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        nativeNames = isMask(1)
        selfieRequired = isMask(2)
        translationRequired = isMask(4)
        type = readTLObject<TLAbsSecureValueType>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureRequiredType) return false
        if (other === this) return true

        return _flags == other._flags
                && nativeNames == other.nativeNames
                && selfieRequired == other.selfieRequired
                && translationRequired == other.translationRequired
                && type == other.type
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x829d99da.toInt()
    }
}

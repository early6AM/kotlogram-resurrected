package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * secureValueErrorTranslationFiles#34636dd8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValueErrorTranslationFiles() : TLAbsSecureValueError() {
    override var type: TLAbsSecureValueType = TLSecureValueTypeUtilityBill()

    var fileHash: TLBytesVector = TLBytesVector()

    override var text: String = ""

    private val _constructor: String = "secureValueErrorTranslationFiles#34636dd8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: TLAbsSecureValueType,
            fileHash: TLBytesVector,
            text: String
    ) : this() {
        this.type = type
        this.fileHash = fileHash
        this.text = text
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(type)
        writeTLVector(fileHash)
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        type = readTLObject<TLAbsSecureValueType>()
        fileHash = readTLBytesVector()
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += type.computeSerializedSize()
        size += fileHash.computeSerializedSize()
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValueErrorTranslationFiles) return false
        if (other === this) return true

        return type == other.type
                && fileHash == other.fileHash
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x34636dd8.toInt()
    }
}

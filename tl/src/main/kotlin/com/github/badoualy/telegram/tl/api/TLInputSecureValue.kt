package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputSecureValue#db21d0a7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputSecureValue() : TLObject() {
    var type: TLAbsSecureValueType = TLSecureValueTypeUtilityBill()

    var data: TLSecureData? = null

    var frontSide: TLAbsInputSecureFile? = null

    var reverseSide: TLAbsInputSecureFile? = null

    var selfie: TLAbsInputSecureFile? = null

    var translation: TLObjectVector<TLAbsInputSecureFile>? = TLObjectVector()

    var files: TLObjectVector<TLAbsInputSecureFile>? = TLObjectVector()

    var plainData: TLAbsSecurePlainData? = null

    private val _constructor: String = "inputSecureValue#db21d0a7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: TLAbsSecureValueType,
            data: TLSecureData?,
            frontSide: TLAbsInputSecureFile?,
            reverseSide: TLAbsInputSecureFile?,
            selfie: TLAbsInputSecureFile?,
            translation: TLObjectVector<TLAbsInputSecureFile>?,
            files: TLObjectVector<TLAbsInputSecureFile>?,
            plainData: TLAbsSecurePlainData?
    ) : this() {
        this.type = type
        this.data = data
        this.frontSide = frontSide
        this.reverseSide = reverseSide
        this.selfie = selfie
        this.translation = translation
        this.files = files
        this.plainData = plainData
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(data, 1)
        updateFlags(frontSide, 2)
        updateFlags(reverseSide, 4)
        updateFlags(selfie, 8)
        updateFlags(translation, 64)
        updateFlags(files, 16)
        updateFlags(plainData, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
        doIfMask(1, data, 1) { writeTLObject(it) }
        doIfMask(1, frontSide, 2) { writeTLObject(it) }
        doIfMask(1, reverseSide, 4) { writeTLObject(it) }
        doIfMask(1, selfie, 8) { writeTLObject(it) }
        doIfMask(1, translation, 64) { writeTLVector(it) }
        doIfMask(1, files, 16) { writeTLVector(it) }
        doIfMask(1, plainData, 32) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        type = readTLObject<TLAbsSecureValueType>()
        data = readIfMask(1, 1) { readTLObject<TLSecureData>(TLSecureData::class, TLSecureData.CONSTRUCTOR_ID) }
        frontSide = readIfMask(1, 2) { readTLObject<TLAbsInputSecureFile>() }
        reverseSide = readIfMask(1, 4) { readTLObject<TLAbsInputSecureFile>() }
        selfie = readIfMask(1, 8) { readTLObject<TLAbsInputSecureFile>() }
        translation = readIfMask(1, 64) { readTLVector<TLAbsInputSecureFile>() }
        files = readIfMask(1, 16) { readTLVector<TLAbsInputSecureFile>() }
        plainData = readIfMask(1, 32) { readTLObject<TLAbsSecurePlainData>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        size += getIntIfMask(1, data, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, frontSide, 2) { it.computeSerializedSize() }
        size += getIntIfMask(1, reverseSide, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, selfie, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, translation, 64) { it.computeSerializedSize() }
        size += getIntIfMask(1, files, 16) { it.computeSerializedSize() }
        size += getIntIfMask(1, plainData, 32) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputSecureValue) return false
        if (other === this) return true

        return _flags == other._flags
                && type == other.type
                && data == other.data
                && frontSide == other.frontSide
                && reverseSide == other.reverseSide
                && selfie == other.selfie
                && translation == other.translation
                && files == other.files
                && plainData == other.plainData
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdb21d0a7.toInt()
    }
}

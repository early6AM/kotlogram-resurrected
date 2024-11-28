package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.api.TLAbsInputFile
import com.github.badoualy.telegram.tl.api.TLInputFileBig
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
class TLRequestAccountUploadTheme() : TLMethod<TLAbsDocument>() {
    var file: TLAbsInputFile = TLInputFileBig()

    var thumb: TLAbsInputFile? = null

    var fileName: String = ""

    var mimeType: String = ""

    private val _constructor: String = "account.uploadTheme#1c3db333"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            fileName: String,
            mimeType: String
    ) : this() {
        this.file = file
        this.thumb = thumb
        this.fileName = fileName
        this.mimeType = mimeType
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(thumb, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(file)
        doIfMask(thumb, 1) { writeTLObject(it) }
        writeString(fileName)
        writeString(mimeType)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        file = readTLObject<TLAbsInputFile>()
        thumb = readIfMask(1) { readTLObject<TLAbsInputFile>() }
        fileName = readString()
        mimeType = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += file.computeSerializedSize()
        size += getIntIfMask(thumb, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(fileName)
        size += computeTLStringSerializedSize(mimeType)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUploadTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && file == other.file
                && thumb == other.thumb
                && fileName == other.fileName
                && mimeType == other.mimeType
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1c3db333.toInt()
    }
}

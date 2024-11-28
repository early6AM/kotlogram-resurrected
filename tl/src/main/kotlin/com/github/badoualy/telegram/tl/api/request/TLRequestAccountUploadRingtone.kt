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
class TLRequestAccountUploadRingtone() : TLMethod<TLAbsDocument>() {
    var file: TLAbsInputFile = TLInputFileBig()

    var fileName: String = ""

    var mimeType: String = ""

    private val _constructor: String = "account.uploadRingtone#831a83a2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile,
            fileName: String,
            mimeType: String
    ) : this() {
        this.file = file
        this.fileName = fileName
        this.mimeType = mimeType
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(file)
        writeString(fileName)
        writeString(mimeType)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        file = readTLObject<TLAbsInputFile>()
        fileName = readString()
        mimeType = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += file.computeSerializedSize()
        size += computeTLStringSerializedSize(fileName)
        size += computeTLStringSerializedSize(mimeType)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUploadRingtone) return false
        if (other === this) return true

        return file == other.file
                && fileName == other.fileName
                && mimeType == other.mimeType
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x831a83a2.toInt()
    }
}

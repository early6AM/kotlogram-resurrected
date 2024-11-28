package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFile
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper
import com.github.badoualy.telegram.tl.api.TLInputFileBig
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUploadWallPaper() : TLMethod<TLAbsWallPaper>() {
    @Transient
    var forChat: Boolean = false

    var file: TLAbsInputFile = TLInputFileBig()

    var mimeType: String = ""

    var settings: TLWallPaperSettings = TLWallPaperSettings()

    private val _constructor: String = "account.uploadWallPaper#e39a8f03"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forChat: Boolean,
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ) : this() {
        this.forChat = forChat
        this.file = file
        this.mimeType = mimeType
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(forChat, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(file)
        writeString(mimeType)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forChat = isMask(1)
        file = readTLObject<TLAbsInputFile>()
        mimeType = readString()
        settings = readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += file.computeSerializedSize()
        size += computeTLStringSerializedSize(mimeType)
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUploadWallPaper) return false
        if (other === this) return true

        return _flags == other._flags
                && forChat == other.forChat
                && file == other.file
                && mimeType == other.mimeType
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe39a8f03.toInt()
    }
}

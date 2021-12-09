package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFile
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper
import com.github.badoualy.telegram.tl.api.TLInputFileBig
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUploadWallPaper() : TLMethod<TLAbsWallPaper>() {
    var file: TLAbsInputFile = TLInputFileBig()

    var mimeType: String = ""

    var settings: TLWallPaperSettings = TLWallPaperSettings()

    private val _constructor: String = "account.uploadWallPaper#dd853661"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ) : this() {
        this.file = file
        this.mimeType = mimeType
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(file)
        writeString(mimeType)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        file = readTLObject<TLAbsInputFile>()
        mimeType = readString()
        settings = readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += file.computeSerializedSize()
        size += computeTLStringSerializedSize(mimeType)
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUploadWallPaper) return false
        if (other === this) return true

        return file == other.file
                && mimeType == other.mimeType
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdd853661.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper
import com.github.badoualy.telegram.tl.api.TLInputWallPaperNoFile
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountSaveWallPaper() : TLMethod<TLBool>() {
    var wallpaper: TLAbsInputWallPaper = TLInputWallPaperNoFile()

    var unsave: Boolean = false

    var settings: TLWallPaperSettings = TLWallPaperSettings()

    private val _constructor: String = "account.saveWallPaper#6c5a5b37"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            wallpaper: TLAbsInputWallPaper,
            unsave: Boolean,
            settings: TLWallPaperSettings
    ) : this() {
        this.wallpaper = wallpaper
        this.unsave = unsave
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(wallpaper)
        writeBoolean(unsave)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        wallpaper = readTLObject<TLAbsInputWallPaper>()
        unsave = readBoolean()
        settings = readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += wallpaper.computeSerializedSize()
        size += SIZE_BOOLEAN
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSaveWallPaper) return false
        if (other === this) return true

        return wallpaper == other.wallpaper
                && unsave == other.unsave
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6c5a5b37
    }
}

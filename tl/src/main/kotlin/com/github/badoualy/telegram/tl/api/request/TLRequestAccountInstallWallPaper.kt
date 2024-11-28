package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper
import com.github.badoualy.telegram.tl.api.TLInputWallPaperSlug
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings
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
class TLRequestAccountInstallWallPaper() : TLMethod<TLBool>() {
    var wallpaper: TLAbsInputWallPaper = TLInputWallPaperSlug()

    var settings: TLWallPaperSettings = TLWallPaperSettings()

    private val _constructor: String = "account.installWallPaper#feed5769"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(wallpaper: TLAbsInputWallPaper, settings: TLWallPaperSettings) : this() {
        this.wallpaper = wallpaper
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(wallpaper)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        wallpaper = readTLObject<TLAbsInputWallPaper>()
        settings = readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += wallpaper.computeSerializedSize()
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountInstallWallPaper) return false
        if (other === this) return true

        return wallpaper == other.wallpaper
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfeed5769.toInt()
    }
}

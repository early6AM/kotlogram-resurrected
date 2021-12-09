package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputThemeSettings#8fde504f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputThemeSettings() : TLObject() {
    @Transient
    var messageColorsAnimated: Boolean = false

    var baseTheme: TLAbsBaseTheme = TLBaseThemeTinted()

    var accentColor: Int = 0

    var outboxAccentColor: Int? = null

    var messageColors: TLIntVector? = null

    var wallpaper: TLAbsInputWallPaper? = null

    var wallpaperSettings: TLWallPaperSettings? = null

    private val _constructor: String = "inputThemeSettings#8fde504f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            messageColorsAnimated: Boolean,
            baseTheme: TLAbsBaseTheme,
            accentColor: Int,
            outboxAccentColor: Int?,
            messageColors: TLIntVector?,
            wallpaper: TLAbsInputWallPaper?,
            wallpaperSettings: TLWallPaperSettings?
    ) : this() {
        this.messageColorsAnimated = messageColorsAnimated
        this.baseTheme = baseTheme
        this.accentColor = accentColor
        this.outboxAccentColor = outboxAccentColor
        this.messageColors = messageColors
        this.wallpaper = wallpaper
        this.wallpaperSettings = wallpaperSettings
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(messageColorsAnimated, 4)
        updateFlags(outboxAccentColor, 8)
        updateFlags(messageColors, 1)
        updateFlags(wallpaper, 2)
        updateFlags(wallpaperSettings, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(baseTheme)
        writeInt(accentColor)
        doIfMask(outboxAccentColor, 8) { writeInt(it) }
        doIfMask(messageColors, 1) { writeTLVector(it) }
        doIfMask(wallpaper, 2) { writeTLObject(it) }
        doIfMask(wallpaperSettings, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        messageColorsAnimated = isMask(4)
        baseTheme = readTLObject<TLAbsBaseTheme>()
        accentColor = readInt()
        outboxAccentColor = readIfMask(8) { readInt() }
        messageColors = readIfMask(1) { readTLIntVector() }
        wallpaper = readIfMask(2) { readTLObject<TLAbsInputWallPaper>() }
        wallpaperSettings = readIfMask(2) { readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += baseTheme.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(outboxAccentColor, 8) { SIZE_INT32 }
        size += getIntIfMask(messageColors, 1) { it.computeSerializedSize() }
        size += getIntIfMask(wallpaper, 2) { it.computeSerializedSize() }
        size += getIntIfMask(wallpaperSettings, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputThemeSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && messageColorsAnimated == other.messageColorsAnimated
                && baseTheme == other.baseTheme
                && accentColor == other.accentColor
                && outboxAccentColor == other.outboxAccentColor
                && messageColors == other.messageColors
                && wallpaper == other.wallpaper
                && wallpaperSettings == other.wallpaperSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8fde504f.toInt()
    }
}

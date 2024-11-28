package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLObject
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
 * themeSettings#fa58b6d4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLThemeSettings() : TLObject() {
    @Transient
    var messageColorsAnimated: Boolean = false

    var baseTheme: TLAbsBaseTheme = TLBaseThemeDay()

    var accentColor: Int = 0

    var outboxAccentColor: Int? = null

    var messageColors: TLIntVector? = null

    var wallpaper: TLAbsWallPaper? = null

    private val _constructor: String = "themeSettings#fa58b6d4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            messageColorsAnimated: Boolean,
            baseTheme: TLAbsBaseTheme,
            accentColor: Int,
            outboxAccentColor: Int?,
            messageColors: TLIntVector?,
            wallpaper: TLAbsWallPaper?
    ) : this() {
        this.messageColorsAnimated = messageColorsAnimated
        this.baseTheme = baseTheme
        this.accentColor = accentColor
        this.outboxAccentColor = outboxAccentColor
        this.messageColors = messageColors
        this.wallpaper = wallpaper
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(messageColorsAnimated, 4)
        updateFlags(outboxAccentColor, 8)
        updateFlags(messageColors, 1)
        updateFlags(wallpaper, 2)
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
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        messageColorsAnimated = isMask(4)
        baseTheme = readTLObject<TLAbsBaseTheme>()
        accentColor = readInt()
        outboxAccentColor = readIfMask(8) { readInt() }
        messageColors = readIfMask(1) { readTLIntVector() }
        wallpaper = readIfMask(2) { readTLObject<TLAbsWallPaper>() }
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
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLThemeSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && messageColorsAnimated == other.messageColorsAnimated
                && baseTheme == other.baseTheme
                && accentColor == other.accentColor
                && outboxAccentColor == other.outboxAccentColor
                && messageColors == other.messageColors
                && wallpaper == other.wallpaper
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa58b6d4.toInt()
    }
}

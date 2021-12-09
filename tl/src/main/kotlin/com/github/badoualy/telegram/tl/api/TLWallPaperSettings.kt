package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * wallPaperSettings#1dc1bca4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPaperSettings() : TLObject() {
    @Transient
    var blur: Boolean = false

    @Transient
    var motion: Boolean = false

    var backgroundColor: Int? = null

    var secondBackgroundColor: Int? = null

    var thirdBackgroundColor: Int? = null

    var fourthBackgroundColor: Int? = null

    var intensity: Int? = null

    var rotation: Int? = null

    private val _constructor: String = "wallPaperSettings#1dc1bca4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blur: Boolean,
            motion: Boolean,
            backgroundColor: Int?,
            secondBackgroundColor: Int?,
            thirdBackgroundColor: Int?,
            fourthBackgroundColor: Int?,
            intensity: Int?,
            rotation: Int?
    ) : this() {
        this.blur = blur
        this.motion = motion
        this.backgroundColor = backgroundColor
        this.secondBackgroundColor = secondBackgroundColor
        this.thirdBackgroundColor = thirdBackgroundColor
        this.fourthBackgroundColor = fourthBackgroundColor
        this.intensity = intensity
        this.rotation = rotation
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(blur, 2)
        updateFlags(motion, 4)
        updateFlags(backgroundColor, 1)
        updateFlags(secondBackgroundColor, 16)
        updateFlags(thirdBackgroundColor, 32)
        updateFlags(fourthBackgroundColor, 64)
        updateFlags(intensity, 8)
        updateFlags(rotation, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(backgroundColor, 1) { writeInt(it) }
        doIfMask(secondBackgroundColor, 16) { writeInt(it) }
        doIfMask(thirdBackgroundColor, 32) { writeInt(it) }
        doIfMask(fourthBackgroundColor, 64) { writeInt(it) }
        doIfMask(intensity, 8) { writeInt(it) }
        doIfMask(rotation, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blur = isMask(2)
        motion = isMask(4)
        backgroundColor = readIfMask(1) { readInt() }
        secondBackgroundColor = readIfMask(16) { readInt() }
        thirdBackgroundColor = readIfMask(32) { readInt() }
        fourthBackgroundColor = readIfMask(64) { readInt() }
        intensity = readIfMask(8) { readInt() }
        rotation = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(backgroundColor, 1) { SIZE_INT32 }
        size += getIntIfMask(secondBackgroundColor, 16) { SIZE_INT32 }
        size += getIntIfMask(thirdBackgroundColor, 32) { SIZE_INT32 }
        size += getIntIfMask(fourthBackgroundColor, 64) { SIZE_INT32 }
        size += getIntIfMask(intensity, 8) { SIZE_INT32 }
        size += getIntIfMask(rotation, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPaperSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && blur == other.blur
                && motion == other.motion
                && backgroundColor == other.backgroundColor
                && secondBackgroundColor == other.secondBackgroundColor
                && thirdBackgroundColor == other.thirdBackgroundColor
                && fourthBackgroundColor == other.fourthBackgroundColor
                && intensity == other.intensity
                && rotation == other.rotation
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1dc1bca4
    }
}

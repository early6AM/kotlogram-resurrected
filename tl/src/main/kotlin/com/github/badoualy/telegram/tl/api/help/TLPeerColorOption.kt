package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * help.peerColorOption#adec6ebe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerColorOption() : TLObject() {
    @Transient
    var hidden: Boolean = false

    var colorId: Int = 0

    var colors: TLAbsPeerColorSet? = null

    var darkColors: TLAbsPeerColorSet? = null

    var channelMinLevel: Int? = null

    var groupMinLevel: Int? = null

    private val _constructor: String = "help.peerColorOption#adec6ebe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hidden: Boolean,
            colorId: Int,
            colors: TLAbsPeerColorSet?,
            darkColors: TLAbsPeerColorSet?,
            channelMinLevel: Int?,
            groupMinLevel: Int?
    ) : this() {
        this.hidden = hidden
        this.colorId = colorId
        this.colors = colors
        this.darkColors = darkColors
        this.channelMinLevel = channelMinLevel
        this.groupMinLevel = groupMinLevel
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hidden, 1)
        updateFlags(colors, 2)
        updateFlags(darkColors, 4)
        updateFlags(channelMinLevel, 8)
        updateFlags(groupMinLevel, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(colorId)
        doIfMask(colors, 2) { writeTLObject(it) }
        doIfMask(darkColors, 4) { writeTLObject(it) }
        doIfMask(channelMinLevel, 8) { writeInt(it) }
        doIfMask(groupMinLevel, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hidden = isMask(1)
        colorId = readInt()
        colors = readIfMask(2) { readTLObject<TLAbsPeerColorSet>() }
        darkColors = readIfMask(4) { readTLObject<TLAbsPeerColorSet>() }
        channelMinLevel = readIfMask(8) { readInt() }
        groupMinLevel = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(colors, 2) { it.computeSerializedSize() }
        size += getIntIfMask(darkColors, 4) { it.computeSerializedSize() }
        size += getIntIfMask(channelMinLevel, 8) { SIZE_INT32 }
        size += getIntIfMask(groupMinLevel, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerColorOption) return false
        if (other === this) return true

        return _flags == other._flags
                && hidden == other.hidden
                && colorId == other.colorId
                && colors == other.colors
                && darkColors == other.darkColors
                && channelMinLevel == other.channelMinLevel
                && groupMinLevel == other.groupMinLevel
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xadec6ebe.toInt()
    }
}

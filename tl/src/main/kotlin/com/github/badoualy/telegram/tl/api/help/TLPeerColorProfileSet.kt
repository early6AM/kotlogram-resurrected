package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * help.peerColorProfileSet#767d61eb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerColorProfileSet() : TLAbsPeerColorSet() {
    var paletteColors: TLIntVector = TLIntVector()

    var bgColors: TLIntVector = TLIntVector()

    var storyColors: TLIntVector = TLIntVector()

    private val _constructor: String = "help.peerColorProfileSet#767d61eb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            paletteColors: TLIntVector,
            bgColors: TLIntVector,
            storyColors: TLIntVector
    ) : this() {
        this.paletteColors = paletteColors
        this.bgColors = bgColors
        this.storyColors = storyColors
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(paletteColors)
        writeTLVector(bgColors)
        writeTLVector(storyColors)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        paletteColors = readTLIntVector()
        bgColors = readTLIntVector()
        storyColors = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += paletteColors.computeSerializedSize()
        size += bgColors.computeSerializedSize()
        size += storyColors.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerColorProfileSet) return false
        if (other === this) return true

        return paletteColors == other.paletteColors
                && bgColors == other.bgColors
                && storyColors == other.storyColors
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x767d61eb.toInt()
    }
}

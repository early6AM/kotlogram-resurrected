package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * mediaAreaSuggestedReaction#14455871
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMediaAreaSuggestedReaction() : TLAbsMediaArea() {
    @Transient
    var dark: Boolean = false

    @Transient
    var flipped: Boolean = false

    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var reaction: TLAbsReaction = TLReactionEmpty()

    private val _constructor: String = "mediaAreaSuggestedReaction#14455871"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dark: Boolean,
            flipped: Boolean,
            coordinates: TLMediaAreaCoordinates,
            reaction: TLAbsReaction
    ) : this() {
        this.dark = dark
        this.flipped = flipped
        this.coordinates = coordinates
        this.reaction = reaction
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(dark, 1)
        updateFlags(flipped, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(coordinates)
        writeTLObject(reaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1, 1)
        flipped = isMask(1, 2)
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        reaction = readTLObject<TLAbsReaction>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += coordinates.computeSerializedSize()
        size += reaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMediaAreaSuggestedReaction) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && flipped == other.flipped
                && coordinates == other.coordinates
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x14455871.toInt()
    }
}

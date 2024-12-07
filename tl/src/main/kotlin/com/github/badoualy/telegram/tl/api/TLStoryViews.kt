package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * storyViews#8d595cd6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryViews() : TLObject() {
    @Transient
    var hasViewers: Boolean = false

    var viewsCount: Int = 0

    var forwardsCount: Int? = null

    var reactions: TLObjectVector<TLReactionCount>? = TLObjectVector()

    var reactionsCount: Int? = null

    var recentViewers: TLLongVector? = null

    private val _constructor: String = "storyViews#8d595cd6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasViewers: Boolean,
            viewsCount: Int,
            forwardsCount: Int?,
            reactions: TLObjectVector<TLReactionCount>?,
            reactionsCount: Int?,
            recentViewers: TLLongVector?
    ) : this() {
        this.hasViewers = hasViewers
        this.viewsCount = viewsCount
        this.forwardsCount = forwardsCount
        this.reactions = reactions
        this.reactionsCount = reactionsCount
        this.recentViewers = recentViewers
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(hasViewers, 2)
        updateFlags(forwardsCount, 4)
        updateFlags(reactions, 8)
        updateFlags(reactionsCount, 16)
        updateFlags(recentViewers, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(viewsCount)
        doIfMask(1, forwardsCount, 4) { writeInt(it) }
        doIfMask(1, reactions, 8) { writeTLVector(it) }
        doIfMask(1, reactionsCount, 16) { writeInt(it) }
        doIfMask(1, recentViewers, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasViewers = isMask(1, 2)
        viewsCount = readInt()
        forwardsCount = readIfMask(1, 4) { readInt() }
        reactions = readIfMask(1, 8) { readTLVector<TLReactionCount>() }
        reactionsCount = readIfMask(1, 16) { readInt() }
        recentViewers = readIfMask(1, 1) { readTLLongVector() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, forwardsCount, 4) { SIZE_INT32 }
        size += getIntIfMask(1, reactions, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, reactionsCount, 16) { SIZE_INT32 }
        size += getIntIfMask(1, recentViewers, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryViews) return false
        if (other === this) return true

        return _flags == other._flags
                && hasViewers == other.hasViewers
                && viewsCount == other.viewsCount
                && forwardsCount == other.forwardsCount
                && reactions == other.reactions
                && reactionsCount == other.reactionsCount
                && recentViewers == other.recentViewers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8d595cd6.toInt()
    }
}

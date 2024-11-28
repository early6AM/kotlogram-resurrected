package com.github.badoualy.telegram.tl.api

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

/**
 * reactionCount#a3d1cb80
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLReactionCount() : TLObject() {
    var chosenOrder: Int? = null

    var reaction: TLAbsReaction = TLReactionEmpty()

    var count: Int = 0

    private val _constructor: String = "reactionCount#a3d1cb80"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chosenOrder: Int?,
            reaction: TLAbsReaction,
            count: Int
    ) : this() {
        this.chosenOrder = chosenOrder
        this.reaction = reaction
        this.count = count
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(chosenOrder, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(chosenOrder, 1) { writeInt(it) }
        writeTLObject(reaction)
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chosenOrder = readIfMask(1) { readInt() }
        reaction = readTLObject<TLAbsReaction>()
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(chosenOrder, 1) { SIZE_INT32 }
        size += reaction.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLReactionCount) return false
        if (other === this) return true

        return _flags == other._flags
                && chosenOrder == other.chosenOrder
                && reaction == other.reaction
                && count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa3d1cb80.toInt()
    }
}

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
 * savedReactionTag#cb6ff828
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSavedReactionTag() : TLObject() {
    var reaction: TLAbsReaction = TLReactionEmpty()

    var title: String? = null

    var count: Int = 0

    private val _constructor: String = "savedReactionTag#cb6ff828"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            reaction: TLAbsReaction,
            title: String?,
            count: Int
    ) : this() {
        this.reaction = reaction
        this.title = title
        this.count = count
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(title, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(reaction)
        doIfMask(1, title, 1) { writeString(it) }
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        reaction = readTLObject<TLAbsReaction>()
        title = readIfMask(1, 1) { readString() }
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += reaction.computeSerializedSize()
        size += getIntIfMask(1, title, 1) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSavedReactionTag) return false
        if (other === this) return true

        return _flags == other._flags
                && reaction == other.reaction
                && title == other.title
                && count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcb6ff828.toInt()
    }
}

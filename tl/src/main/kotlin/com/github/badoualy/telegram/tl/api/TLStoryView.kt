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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * storyView#b0bdeac5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryView() : TLAbsStoryView() {
    @Transient
    override var blocked: Boolean = false

    @Transient
    override var blockedMyStoriesFrom: Boolean = false

    var userId: Long = 0L

    var date: Int = 0

    var reaction: TLAbsReaction? = null

    private val _constructor: String = "storyView#b0bdeac5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocked: Boolean,
            blockedMyStoriesFrom: Boolean,
            userId: Long,
            date: Int,
            reaction: TLAbsReaction?
    ) : this() {
        this.blocked = blocked
        this.blockedMyStoriesFrom = blockedMyStoriesFrom
        this.userId = userId
        this.date = date
        this.reaction = reaction
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(blocked, 1)
        updateFlags(blockedMyStoriesFrom, 2)
        updateFlags(reaction, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        writeInt(date)
        doIfMask(1, reaction, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blocked = isMask(1, 1)
        blockedMyStoriesFrom = isMask(1, 2)
        userId = readLong()
        date = readInt()
        reaction = readIfMask(1, 4) { readTLObject<TLAbsReaction>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(1, reaction, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryView) return false
        if (other === this) return true

        return _flags == other._flags
                && blocked == other.blocked
                && blockedMyStoriesFrom == other.blockedMyStoriesFrom
                && userId == other.userId
                && date == other.date
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb0bdeac5.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * messageReactions#4f2b9479
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageReactions() : TLObject() {
    @Transient
    var min: Boolean = false

    @Transient
    var canSeeList: Boolean = false

    var results: TLObjectVector<TLReactionCount> = TLObjectVector()

    var recentReactions: TLObjectVector<TLMessagePeerReaction>? = TLObjectVector()

    private val _constructor: String = "messageReactions#4f2b9479"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            min: Boolean,
            canSeeList: Boolean,
            results: TLObjectVector<TLReactionCount>,
            recentReactions: TLObjectVector<TLMessagePeerReaction>?
    ) : this() {
        this.min = min
        this.canSeeList = canSeeList
        this.results = results
        this.recentReactions = recentReactions
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(min, 1)
        updateFlags(canSeeList, 4)
        updateFlags(recentReactions, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(results)
        doIfMask(recentReactions, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        min = isMask(1)
        canSeeList = isMask(4)
        results = readTLVector<TLReactionCount>()
        recentReactions = readIfMask(2) { readTLVector<TLMessagePeerReaction>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += results.computeSerializedSize()
        size += getIntIfMask(recentReactions, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageReactions) return false
        if (other === this) return true

        return _flags == other._flags
                && min == other.min
                && canSeeList == other.canSeeList
                && results == other.results
                && recentReactions == other.recentReactions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4f2b9479.toInt()
    }
}

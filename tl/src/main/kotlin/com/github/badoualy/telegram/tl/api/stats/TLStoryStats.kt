package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLStatsGraphAsync
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
 * stats.storyStats#50cd067c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryStats() : TLObject() {
    var viewsGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var reactionsByEmotionGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    private val _constructor: String = "stats.storyStats#50cd067c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(viewsGraph: TLAbsStatsGraph, reactionsByEmotionGraph: TLAbsStatsGraph) : this() {
        this.viewsGraph = viewsGraph
        this.reactionsByEmotionGraph = reactionsByEmotionGraph
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(viewsGraph)
        writeTLObject(reactionsByEmotionGraph)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        viewsGraph = readTLObject<TLAbsStatsGraph>()
        reactionsByEmotionGraph = readTLObject<TLAbsStatsGraph>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += viewsGraph.computeSerializedSize()
        size += reactionsByEmotionGraph.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryStats) return false
        if (other === this) return true

        return viewsGraph == other.viewsGraph
                && reactionsByEmotionGraph == other.reactionsByEmotionGraph
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x50cd067c.toInt()
    }
}

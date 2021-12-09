package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLStatsGraphAsync
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * stats.messageStats#8999f295
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageStats() : TLObject() {
    var viewsGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    private val _constructor: String = "stats.messageStats#8999f295"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(viewsGraph: TLAbsStatsGraph) : this() {
        this.viewsGraph = viewsGraph
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(viewsGraph)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        viewsGraph = readTLObject<TLAbsStatsGraph>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += viewsGraph.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageStats) return false
        if (other === this) return true

        return viewsGraph == other.viewsGraph
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8999f295.toInt()
    }
}

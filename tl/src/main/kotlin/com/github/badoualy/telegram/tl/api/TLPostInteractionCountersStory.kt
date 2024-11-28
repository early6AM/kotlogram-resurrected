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

/**
 * postInteractionCountersStory#8a480e27
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPostInteractionCountersStory() : TLAbsPostInteractionCounters() {
    var storyId: Int = 0

    override var views: Int = 0

    override var forwards: Int = 0

    override var reactions: Int = 0

    private val _constructor: String = "postInteractionCountersStory#8a480e27"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            storyId: Int,
            views: Int,
            forwards: Int,
            reactions: Int
    ) : this() {
        this.storyId = storyId
        this.views = views
        this.forwards = forwards
        this.reactions = reactions
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(storyId)
        writeInt(views)
        writeInt(forwards)
        writeInt(reactions)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        storyId = readInt()
        views = readInt()
        forwards = readInt()
        reactions = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPostInteractionCountersStory) return false
        if (other === this) return true

        return storyId == other.storyId
                && views == other.views
                && forwards == other.forwards
                && reactions == other.reactions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8a480e27.toInt()
    }
}

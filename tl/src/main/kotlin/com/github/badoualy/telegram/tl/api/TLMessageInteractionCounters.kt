package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageInteractionCounters#ad4fc9bd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageInteractionCounters() : TLObject() {
    var msgId: Int = 0

    var views: Int = 0

    var forwards: Int = 0

    private val _constructor: String = "messageInteractionCounters#ad4fc9bd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            msgId: Int,
            views: Int,
            forwards: Int
    ) : this() {
        this.msgId = msgId
        this.views = views
        this.forwards = forwards
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(msgId)
        writeInt(views)
        writeInt(forwards)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        msgId = readInt()
        views = readInt()
        forwards = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageInteractionCounters) return false
        if (other === this) return true

        return msgId == other.msgId
                && views == other.views
                && forwards == other.forwards
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xad4fc9bd.toInt()
    }
}

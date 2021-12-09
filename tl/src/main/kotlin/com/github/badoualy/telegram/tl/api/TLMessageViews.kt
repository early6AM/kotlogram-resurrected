package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageViews#455b853d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageViews() : TLObject() {
    var views: Int? = null

    var forwards: Int? = null

    var replies: TLMessageReplies? = null

    private val _constructor: String = "messageViews#455b853d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            views: Int?,
            forwards: Int?,
            replies: TLMessageReplies?
    ) : this() {
        this.views = views
        this.forwards = forwards
        this.replies = replies
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(views, 1)
        updateFlags(forwards, 2)
        updateFlags(replies, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(views, 1) { writeInt(it) }
        doIfMask(forwards, 2) { writeInt(it) }
        doIfMask(replies, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        views = readIfMask(1) { readInt() }
        forwards = readIfMask(2) { readInt() }
        replies = readIfMask(4) { readTLObject<TLMessageReplies>(TLMessageReplies::class, TLMessageReplies.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(views, 1) { SIZE_INT32 }
        size += getIntIfMask(forwards, 2) { SIZE_INT32 }
        size += getIntIfMask(replies, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageViews) return false
        if (other === this) return true

        return _flags == other._flags
                && views == other.views
                && forwards == other.forwards
                && replies == other.replies
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x455b853d
    }
}

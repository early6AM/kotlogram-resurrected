package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.stories.TLAbsAllStories
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesGetAllStories() : TLMethod<TLAbsAllStories>() {
    @Transient
    var next: Boolean = false

    @Transient
    var hidden: Boolean = false

    var state: String? = null

    private val _constructor: String = "stories.getAllStories#eeb0d625"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            next: Boolean,
            hidden: Boolean,
            state: String?
    ) : this() {
        this.next = next
        this.hidden = hidden
        this.state = state
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(next, 2)
        updateFlags(hidden, 4)
        updateFlags(state, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, state, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        next = isMask(1, 2)
        hidden = isMask(1, 4)
        state = readIfMask(1, 1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, state, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesGetAllStories) return false
        if (other === this) return true

        return _flags == other._flags
                && next == other.next
                && hidden == other.hidden
                && state == other.state
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeeb0d625.toInt()
    }
}

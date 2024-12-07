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
import kotlin.jvm.Transient

/**
 * storyFwdHeader#b826e150
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryFwdHeader() : TLObject() {
    @Transient
    var modified: Boolean = false

    var from: TLAbsPeer? = null

    var fromName: String? = null

    var storyId: Int? = null

    private val _constructor: String = "storyFwdHeader#b826e150"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            modified: Boolean,
            from: TLAbsPeer?,
            fromName: String?,
            storyId: Int?
    ) : this() {
        this.modified = modified
        this.from = from
        this.fromName = fromName
        this.storyId = storyId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(modified, 8)
        updateFlags(from, 1)
        updateFlags(fromName, 2)
        updateFlags(storyId, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, from, 1) { writeTLObject(it) }
        doIfMask(1, fromName, 2) { writeString(it) }
        doIfMask(1, storyId, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        modified = isMask(1, 8)
        from = readIfMask(1, 1) { readTLObject<TLAbsPeer>() }
        fromName = readIfMask(1, 2) { readString() }
        storyId = readIfMask(1, 4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, from, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, fromName, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, storyId, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryFwdHeader) return false
        if (other === this) return true

        return _flags == other._flags
                && modified == other.modified
                && from == other.from
                && fromName == other.fromName
                && storyId == other.storyId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb826e150.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStatsLoadAsyncGraph() : TLMethod<TLAbsStatsGraph>() {
    var token: String = ""

    var x: Long? = null

    private val _constructor: String = "stats.loadAsyncGraph#621d5fa0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(token: String, x: Long?) : this() {
        this.token = token
        this.x = x
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(x, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(token)
        doIfMask(x, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        token = readString()
        x = readIfMask(1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(token)
        size += getIntIfMask(x, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStatsLoadAsyncGraph) return false
        if (other === this) return true

        return _flags == other._flags
                && token == other.token
                && x == other.x
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x621d5fa0
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateDialogFilter#26ffde7d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDialogFilter() : TLAbsUpdate() {
    var id: Int = 0

    var filter: TLDialogFilter? = null

    private val _constructor: String = "updateDialogFilter#26ffde7d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: Int, filter: TLDialogFilter?) : this() {
        this.id = id
        this.filter = filter
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(filter, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(filter, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readInt()
        filter = readIfMask(1) { readTLObject<TLDialogFilter>(TLDialogFilter::class, TLDialogFilter.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(filter, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateDialogFilter) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && filter == other.filter
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x26ffde7d
    }
}

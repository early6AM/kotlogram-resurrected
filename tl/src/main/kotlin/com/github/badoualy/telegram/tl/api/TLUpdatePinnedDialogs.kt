package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updatePinnedDialogs#fa0f3ca2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePinnedDialogs() : TLAbsUpdate() {
    var folderId: Int? = null

    var order: TLObjectVector<TLAbsDialogPeer>? = TLObjectVector()

    private val _constructor: String = "updatePinnedDialogs#fa0f3ca2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(folderId: Int?, order: TLObjectVector<TLAbsDialogPeer>?) : this() {
        this.folderId = folderId
        this.order = order
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(folderId, 2)
        updateFlags(order, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(folderId, 2) { writeInt(it) }
        doIfMask(order, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        folderId = readIfMask(2) { readInt() }
        order = readIfMask(1) { readTLVector<TLAbsDialogPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(folderId, 2) { SIZE_INT32 }
        size += getIntIfMask(order, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePinnedDialogs) return false
        if (other === this) return true

        return _flags == other._flags
                && folderId == other.folderId
                && order == other.order
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa0f3ca2.toInt()
    }
}

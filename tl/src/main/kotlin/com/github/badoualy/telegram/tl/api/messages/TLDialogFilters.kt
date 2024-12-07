package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDialogFilter
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * messages.dialogFilters#2ad93719
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialogFilters() : TLObject() {
    @Transient
    var tagsEnabled: Boolean = false

    var filters: TLObjectVector<TLAbsDialogFilter> = TLObjectVector()

    private val _constructor: String = "messages.dialogFilters#2ad93719"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(tagsEnabled: Boolean, filters: TLObjectVector<TLAbsDialogFilter>) : this() {
        this.tagsEnabled = tagsEnabled
        this.filters = filters
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(tagsEnabled, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(filters)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        tagsEnabled = isMask(1, 1)
        filters = readTLVector<TLAbsDialogFilter>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += filters.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialogFilters) return false
        if (other === this) return true

        return _flags == other._flags
                && tagsEnabled == other.tagsEnabled
                && filters == other.filters
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2ad93719.toInt()
    }
}

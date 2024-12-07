package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsSetBlocked() : TLMethod<TLBool>() {
    @Transient
    var myStoriesFrom: Boolean = false

    var id: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    var limit: Int = 0

    private val _constructor: String = "contacts.setBlocked#94c65c76"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            myStoriesFrom: Boolean,
            id: TLObjectVector<TLAbsInputPeer>,
            limit: Int
    ) : this() {
        this.myStoriesFrom = myStoriesFrom
        this.id = id
        this.limit = limit
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(myStoriesFrom, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(id)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        myStoriesFrom = isMask(1, 1)
        id = readTLVector<TLAbsInputPeer>()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsSetBlocked) return false
        if (other === this) return true

        return _flags == other._flags
                && myStoriesFrom == other.myStoriesFrom
                && id == other.id
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x94c65c76.toInt()
    }
}

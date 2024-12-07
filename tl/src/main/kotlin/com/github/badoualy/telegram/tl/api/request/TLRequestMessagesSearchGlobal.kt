package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter
import com.github.badoualy.telegram.tl.api.TLInputMessagesFilterEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
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
class TLRequestMessagesSearchGlobal() : TLMethod<TLAbsMessages>() {
    @Transient
    var broadcastsOnly: Boolean = false

    var folderId: Int? = null

    var q: String = ""

    var filter: TLAbsMessagesFilter = TLInputMessagesFilterEmpty()

    var minDate: Int = 0

    var maxDate: Int = 0

    var offsetRate: Int = 0

    var offsetPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var offsetId: Int = 0

    var limit: Int = 0

    private val _constructor: String = "messages.searchGlobal#4bc6589a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            broadcastsOnly: Boolean,
            folderId: Int?,
            q: String,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ) : this() {
        this.broadcastsOnly = broadcastsOnly
        this.folderId = folderId
        this.q = q
        this.filter = filter
        this.minDate = minDate
        this.maxDate = maxDate
        this.offsetRate = offsetRate
        this.offsetPeer = offsetPeer
        this.offsetId = offsetId
        this.limit = limit
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(broadcastsOnly, 2)
        updateFlags(folderId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, folderId, 1) { writeInt(it) }
        writeString(q)
        writeTLObject(filter)
        writeInt(minDate)
        writeInt(maxDate)
        writeInt(offsetRate)
        writeTLObject(offsetPeer)
        writeInt(offsetId)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        broadcastsOnly = isMask(1, 2)
        folderId = readIfMask(1, 1) { readInt() }
        q = readString()
        filter = readTLObject<TLAbsMessagesFilter>()
        minDate = readInt()
        maxDate = readInt()
        offsetRate = readInt()
        offsetPeer = readTLObject<TLAbsInputPeer>()
        offsetId = readInt()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, folderId, 1) { SIZE_INT32 }
        size += computeTLStringSerializedSize(q)
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += offsetPeer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSearchGlobal) return false
        if (other === this) return true

        return _flags == other._flags
                && broadcastsOnly == other.broadcastsOnly
                && folderId == other.folderId
                && q == other.q
                && filter == other.filter
                && minDate == other.minDate
                && maxDate == other.maxDate
                && offsetRate == other.offsetRate
                && offsetPeer == other.offsetPeer
                && offsetId == other.offsetId
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4bc6589a.toInt()
    }
}

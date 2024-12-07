package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetDialogs() : TLMethod<TLAbsDialogs>() {
    @Transient
    var excludePinned: Boolean = false

    var folderId: Int? = null

    var offsetDate: Int = 0

    var offsetId: Int = 0

    var offsetPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var limit: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "messages.getDialogs#a0f4cb4f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            excludePinned: Boolean,
            folderId: Int?,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ) : this() {
        this.excludePinned = excludePinned
        this.folderId = folderId
        this.offsetDate = offsetDate
        this.offsetId = offsetId
        this.offsetPeer = offsetPeer
        this.limit = limit
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(excludePinned, 1)
        updateFlags(folderId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, folderId, 2) { writeInt(it) }
        writeInt(offsetDate)
        writeInt(offsetId)
        writeTLObject(offsetPeer)
        writeInt(limit)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        excludePinned = isMask(1, 1)
        folderId = readIfMask(1, 2) { readInt() }
        offsetDate = readInt()
        offsetId = readInt()
        offsetPeer = readTLObject<TLAbsInputPeer>()
        limit = readInt()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, folderId, 2) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += offsetPeer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetDialogs) return false
        if (other === this) return true

        return _flags == other._flags
                && excludePinned == other.excludePinned
                && folderId == other.folderId
                && offsetDate == other.offsetDate
                && offsetId == other.offsetId
                && offsetPeer == other.offsetPeer
                && limit == other.limit
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa0f4cb4f.toInt()
    }
}

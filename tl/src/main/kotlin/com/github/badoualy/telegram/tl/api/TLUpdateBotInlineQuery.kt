package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBotInlineQuery#496f379c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotInlineQuery() : TLAbsUpdate() {
    var queryId: Long = 0L

    var userId: Long = 0L

    var query: String = ""

    var geo: TLAbsGeoPoint? = null

    var peerType: TLAbsInlineQueryPeerType? = null

    var offset: String = ""

    private val _constructor: String = "updateBotInlineQuery#496f379c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            userId: Long,
            query: String,
            geo: TLAbsGeoPoint?,
            peerType: TLAbsInlineQueryPeerType?,
            offset: String
    ) : this() {
        this.queryId = queryId
        this.userId = userId
        this.query = query
        this.geo = geo
        this.peerType = peerType
        this.offset = offset
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(geo, 1)
        updateFlags(peerType, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        writeLong(userId)
        writeString(query)
        doIfMask(geo, 1) { writeTLObject(it) }
        doIfMask(peerType, 2) { writeTLObject(it) }
        writeString(offset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        queryId = readLong()
        userId = readLong()
        query = readString()
        geo = readIfMask(1) { readTLObject<TLAbsGeoPoint>() }
        peerType = readIfMask(2) { readTLObject<TLAbsInlineQueryPeerType>() }
        offset = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(query)
        size += getIntIfMask(geo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(peerType, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(offset)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotInlineQuery) return false
        if (other === this) return true

        return _flags == other._flags
                && queryId == other.queryId
                && userId == other.userId
                && query == other.query
                && geo == other.geo
                && peerType == other.peerType
                && offset == other.offset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x496f379c.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateBotInlineSend#12f12a07
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotInlineSend() : TLAbsUpdate() {
    var userId: Long = 0L

    var query: String = ""

    var geo: TLAbsGeoPoint? = null

    var id: String = ""

    var msgId: TLAbsInputBotInlineMessageID? = null

    private val _constructor: String = "updateBotInlineSend#12f12a07"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            query: String,
            geo: TLAbsGeoPoint?,
            id: String,
            msgId: TLAbsInputBotInlineMessageID?
    ) : this() {
        this.userId = userId
        this.query = query
        this.geo = geo
        this.id = id
        this.msgId = msgId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(geo, 1)
        updateFlags(msgId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        writeString(query)
        doIfMask(geo, 1) { writeTLObject(it) }
        writeString(id)
        doIfMask(msgId, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userId = readLong()
        query = readString()
        geo = readIfMask(1) { readTLObject<TLAbsGeoPoint>() }
        id = readString()
        msgId = readIfMask(2) { readTLObject<TLAbsInputBotInlineMessageID>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(query)
        size += getIntIfMask(geo, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(id)
        size += getIntIfMask(msgId, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotInlineSend) return false
        if (other === this) return true

        return _flags == other._flags
                && userId == other.userId
                && query == other.query
                && geo == other.geo
                && id == other.id
                && msgId == other.msgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x12f12a07
    }
}

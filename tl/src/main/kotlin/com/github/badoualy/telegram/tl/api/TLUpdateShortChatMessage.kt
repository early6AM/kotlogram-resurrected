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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updateShortChatMessage#4d6deea5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateShortChatMessage() : TLAbsUpdates() {
    @Transient
    var out: Boolean = false

    @Transient
    var mentioned: Boolean = false

    @Transient
    var mediaUnread: Boolean = false

    @Transient
    var silent: Boolean = false

    var id: Int = 0

    var fromId: Long = 0L

    var chatId: Long = 0L

    var message: String = ""

    var pts: Int = 0

    var ptsCount: Int = 0

    var date: Int = 0

    var fwdFrom: TLMessageFwdHeader? = null

    var viaBotId: Long? = null

    var replyTo: TLAbsMessageReplyHeader? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var ttlPeriod: Int? = null

    private val _constructor: String = "updateShortChatMessage#4d6deea5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            mentioned: Boolean,
            mediaUnread: Boolean,
            silent: Boolean,
            id: Int,
            fromId: Long,
            chatId: Long,
            message: String,
            pts: Int,
            ptsCount: Int,
            date: Int,
            fwdFrom: TLMessageFwdHeader?,
            viaBotId: Long?,
            replyTo: TLAbsMessageReplyHeader?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            ttlPeriod: Int?
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.id = id
        this.fromId = fromId
        this.chatId = chatId
        this.message = message
        this.pts = pts
        this.ptsCount = ptsCount
        this.date = date
        this.fwdFrom = fwdFrom
        this.viaBotId = viaBotId
        this.replyTo = replyTo
        this.entities = entities
        this.ttlPeriod = ttlPeriod
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(fwdFrom, 4)
        updateFlags(viaBotId, 2048)
        updateFlags(replyTo, 8)
        updateFlags(entities, 128)
        updateFlags(ttlPeriod, 33554432)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeLong(fromId)
        writeLong(chatId)
        writeString(message)
        writeInt(pts)
        writeInt(ptsCount)
        writeInt(date)
        doIfMask(1, fwdFrom, 4) { writeTLObject(it) }
        doIfMask(1, viaBotId, 2048) { writeLong(it) }
        doIfMask(1, replyTo, 8) { writeTLObject(it) }
        doIfMask(1, entities, 128) { writeTLVector(it) }
        doIfMask(1, ttlPeriod, 33554432) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(1, 2)
        mentioned = isMask(1, 16)
        mediaUnread = isMask(1, 32)
        silent = isMask(1, 8192)
        id = readInt()
        fromId = readLong()
        chatId = readLong()
        message = readString()
        pts = readInt()
        ptsCount = readInt()
        date = readInt()
        fwdFrom = readIfMask(1, 4) { readTLObject<TLMessageFwdHeader>(TLMessageFwdHeader::class, TLMessageFwdHeader.CONSTRUCTOR_ID) }
        viaBotId = readIfMask(1, 2048) { readLong() }
        replyTo = readIfMask(1, 8) { readTLObject<TLAbsMessageReplyHeader>() }
        entities = readIfMask(1, 128) { readTLVector<TLAbsMessageEntity>() }
        ttlPeriod = readIfMask(1, 33554432) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(message)
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, fwdFrom, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, viaBotId, 2048) { SIZE_INT64 }
        size += getIntIfMask(1, replyTo, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, entities, 128) { it.computeSerializedSize() }
        size += getIntIfMask(1, ttlPeriod, 33554432) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateShortChatMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && mentioned == other.mentioned
                && mediaUnread == other.mediaUnread
                && silent == other.silent
                && id == other.id
                && fromId == other.fromId
                && chatId == other.chatId
                && message == other.message
                && pts == other.pts
                && ptsCount == other.ptsCount
                && date == other.date
                && fwdFrom == other.fwdFrom
                && viaBotId == other.viaBotId
                && replyTo == other.replyTo
                && entities == other.entities
                && ttlPeriod == other.ttlPeriod
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4d6deea5.toInt()
    }
}

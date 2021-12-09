package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageService#2b085862
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageService() : TLAbsMessage() {
    @Transient
    var out: Boolean = false

    @Transient
    var mentioned: Boolean = false

    @Transient
    var mediaUnread: Boolean = false

    @Transient
    var silent: Boolean = false

    @Transient
    var post: Boolean = false

    @Transient
    var legacy: Boolean = false

    override var id: Int = 0

    var fromId: TLAbsPeer? = null

    var peerId: TLAbsPeer = TLPeerChat()

    var replyTo: TLMessageReplyHeader? = null

    var date: Int = 0

    var action: TLAbsMessageAction = TLMessageActionEmpty()

    var ttlPeriod: Int? = null

    private val _constructor: String = "messageService#2b085862"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            mentioned: Boolean,
            mediaUnread: Boolean,
            silent: Boolean,
            post: Boolean,
            legacy: Boolean,
            id: Int,
            fromId: TLAbsPeer?,
            peerId: TLAbsPeer,
            replyTo: TLMessageReplyHeader?,
            date: Int,
            action: TLAbsMessageAction,
            ttlPeriod: Int?
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.post = post
        this.legacy = legacy
        this.id = id
        this.fromId = fromId
        this.peerId = peerId
        this.replyTo = replyTo
        this.date = date
        this.action = action
        this.ttlPeriod = ttlPeriod
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(post, 16384)
        updateFlags(legacy, 524288)
        updateFlags(fromId, 256)
        updateFlags(replyTo, 8)
        updateFlags(ttlPeriod, 33554432)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(fromId, 256) { writeTLObject(it) }
        writeTLObject(peerId)
        doIfMask(replyTo, 8) { writeTLObject(it) }
        writeInt(date)
        writeTLObject(action)
        doIfMask(ttlPeriod, 33554432) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(2)
        mentioned = isMask(16)
        mediaUnread = isMask(32)
        silent = isMask(8192)
        post = isMask(16384)
        legacy = isMask(524288)
        id = readInt()
        fromId = readIfMask(256) { readTLObject<TLAbsPeer>() }
        peerId = readTLObject<TLAbsPeer>()
        replyTo = readIfMask(8) { readTLObject<TLMessageReplyHeader>(TLMessageReplyHeader::class, TLMessageReplyHeader.CONSTRUCTOR_ID) }
        date = readInt()
        action = readTLObject<TLAbsMessageAction>()
        ttlPeriod = readIfMask(33554432) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(fromId, 256) { it.computeSerializedSize() }
        size += peerId.computeSerializedSize()
        size += getIntIfMask(replyTo, 8) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += action.computeSerializedSize()
        size += getIntIfMask(ttlPeriod, 33554432) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageService) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && mentioned == other.mentioned
                && mediaUnread == other.mediaUnread
                && silent == other.silent
                && post == other.post
                && legacy == other.legacy
                && id == other.id
                && fromId == other.fromId
                && peerId == other.peerId
                && replyTo == other.replyTo
                && date == other.date
                && action == other.action
                && ttlPeriod == other.ttlPeriod
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2b085862
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesEditMessage() : TLMethod<TLAbsUpdates>() {
    @Transient
    var noWebpage: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var message: String? = null

    var media: TLAbsInputMedia? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var scheduleDate: Int? = null

    private val _constructor: String = "messages.editMessage#48f71778"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ) : this() {
        this.noWebpage = noWebpage
        this.peer = peer
        this.id = id
        this.message = message
        this.media = media
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.scheduleDate = scheduleDate
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(message, 2048)
        updateFlags(media, 16384)
        updateFlags(replyMarkup, 4)
        updateFlags(entities, 8)
        updateFlags(scheduleDate, 32768)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(message, 2048) { writeString(it) }
        doIfMask(media, 16384) { writeTLObject(it) }
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
        doIfMask(entities, 8) { writeTLVector(it) }
        doIfMask(scheduleDate, 32768) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        message = readIfMask(2048) { readString() }
        media = readIfMask(16384) { readTLObject<TLAbsInputMedia>() }
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
        scheduleDate = readIfMask(32768) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(message, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(media, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(scheduleDate, 32768) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesEditMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && peer == other.peer
                && id == other.id
                && message == other.message
                && media == other.media
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && scheduleDate == other.scheduleDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x48f71778
    }
}

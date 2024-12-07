package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
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
 * starsTransaction#2db5418f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStarsTransaction() : TLObject() {
    @Transient
    var refund: Boolean = false

    @Transient
    var pending: Boolean = false

    @Transient
    var failed: Boolean = false

    @Transient
    var gift: Boolean = false

    var id: String = ""

    var stars: Long = 0L

    var date: Int = 0

    var peer: TLAbsStarsTransactionPeer = TLStarsTransactionPeerUnsupported()

    var title: String? = null

    var description: String? = null

    var photo: TLAbsWebDocument? = null

    var transactionDate: Int? = null

    var transactionUrl: String? = null

    var botPayload: TLBytes? = null

    var msgId: Int? = null

    var extendedMedia: TLObjectVector<TLAbsMessageMedia>? = TLObjectVector()

    private val _constructor: String = "starsTransaction#2db5418f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            refund: Boolean,
            pending: Boolean,
            failed: Boolean,
            gift: Boolean,
            id: String,
            stars: Long,
            date: Int,
            peer: TLAbsStarsTransactionPeer,
            title: String?,
            description: String?,
            photo: TLAbsWebDocument?,
            transactionDate: Int?,
            transactionUrl: String?,
            botPayload: TLBytes?,
            msgId: Int?,
            extendedMedia: TLObjectVector<TLAbsMessageMedia>?
    ) : this() {
        this.refund = refund
        this.pending = pending
        this.failed = failed
        this.gift = gift
        this.id = id
        this.stars = stars
        this.date = date
        this.peer = peer
        this.title = title
        this.description = description
        this.photo = photo
        this.transactionDate = transactionDate
        this.transactionUrl = transactionUrl
        this.botPayload = botPayload
        this.msgId = msgId
        this.extendedMedia = extendedMedia
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(refund, 8)
        updateFlags(pending, 16)
        updateFlags(failed, 64)
        updateFlags(gift, 1024)
        updateFlags(title, 1)
        updateFlags(description, 2)
        updateFlags(photo, 4)
        updateFlags(transactionDate, 32)
        updateFlags(transactionUrl, 32)
        updateFlags(botPayload, 128)
        updateFlags(msgId, 256)
        updateFlags(extendedMedia, 512)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(id)
        writeLong(stars)
        writeInt(date)
        writeTLObject(peer)
        doIfMask(1, title, 1) { writeString(it) }
        doIfMask(1, description, 2) { writeString(it) }
        doIfMask(1, photo, 4) { writeTLObject(it) }
        doIfMask(1, transactionDate, 32) { writeInt(it) }
        doIfMask(1, transactionUrl, 32) { writeString(it) }
        doIfMask(1, botPayload, 128) { writeTLBytes(it) }
        doIfMask(1, msgId, 256) { writeInt(it) }
        doIfMask(1, extendedMedia, 512) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        refund = isMask(1, 8)
        pending = isMask(1, 16)
        failed = isMask(1, 64)
        gift = isMask(1, 1024)
        id = readString()
        stars = readLong()
        date = readInt()
        peer = readTLObject<TLAbsStarsTransactionPeer>()
        title = readIfMask(1, 1) { readString() }
        description = readIfMask(1, 2) { readString() }
        photo = readIfMask(1, 4) { readTLObject<TLAbsWebDocument>() }
        transactionDate = readIfMask(1, 32) { readInt() }
        transactionUrl = readIfMask(1, 32) { readString() }
        botPayload = readIfMask(1, 128) { readTLBytes() }
        msgId = readIfMask(1, 256) { readInt() }
        extendedMedia = readIfMask(1, 512) { readTLVector<TLAbsMessageMedia>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(id)
        size += SIZE_INT64
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(1, title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, description, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, photo, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, transactionDate, 32) { SIZE_INT32 }
        size += getIntIfMask(1, transactionUrl, 32) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, botPayload, 128) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(1, msgId, 256) { SIZE_INT32 }
        size += getIntIfMask(1, extendedMedia, 512) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStarsTransaction) return false
        if (other === this) return true

        return _flags == other._flags
                && refund == other.refund
                && pending == other.pending
                && failed == other.failed
                && gift == other.gift
                && id == other.id
                && stars == other.stars
                && date == other.date
                && peer == other.peer
                && title == other.title
                && description == other.description
                && photo == other.photo
                && transactionDate == other.transactionDate
                && transactionUrl == other.transactionUrl
                && botPayload == other.botPayload
                && msgId == other.msgId
                && extendedMedia == other.extendedMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2db5418f.toInt()
    }
}

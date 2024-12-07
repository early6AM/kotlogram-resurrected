package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputQuickReplyShortcut
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendMessage() : TLMethod<TLAbsUpdates>() {
    @Transient
    var noWebpage: Boolean = false

    @Transient
    var silent: Boolean = false

    @Transient
    var background: Boolean = false

    @Transient
    var clearDraft: Boolean = false

    @Transient
    var noforwards: Boolean = false

    @Transient
    var updateStickersetsOrder: Boolean = false

    @Transient
    var invertMedia: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var replyTo: TLAbsInputReplyTo? = null

    var message: String = ""

    var randomId: Long = 0L

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var scheduleDate: Int? = null

    var sendAs: TLAbsInputPeer? = null

    var quickReplyShortcut: TLAbsInputQuickReplyShortcut? = null

    var effect: Long? = null

    private val _constructor: String = "messages.sendMessage#983f9745"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?,
            effect: Long?
    ) : this() {
        this.noWebpage = noWebpage
        this.silent = silent
        this.background = background
        this.clearDraft = clearDraft
        this.noforwards = noforwards
        this.updateStickersetsOrder = updateStickersetsOrder
        this.invertMedia = invertMedia
        this.peer = peer
        this.replyTo = replyTo
        this.message = message
        this.randomId = randomId
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.scheduleDate = scheduleDate
        this.sendAs = sendAs
        this.quickReplyShortcut = quickReplyShortcut
        this.effect = effect
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(clearDraft, 128)
        updateFlags(noforwards, 16384)
        updateFlags(updateStickersetsOrder, 32768)
        updateFlags(invertMedia, 65536)
        updateFlags(replyTo, 1)
        updateFlags(replyMarkup, 4)
        updateFlags(entities, 8)
        updateFlags(scheduleDate, 1024)
        updateFlags(sendAs, 8192)
        updateFlags(quickReplyShortcut, 131072)
        updateFlags(effect, 262144)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(replyTo, 1) { writeTLObject(it) }
        writeString(message)
        writeLong(randomId)
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
        doIfMask(entities, 8) { writeTLVector(it) }
        doIfMask(scheduleDate, 1024) { writeInt(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
        doIfMask(quickReplyShortcut, 131072) { writeTLObject(it) }
        doIfMask(effect, 262144) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        silent = isMask(32)
        background = isMask(64)
        clearDraft = isMask(128)
        noforwards = isMask(16384)
        updateStickersetsOrder = isMask(32768)
        invertMedia = isMask(65536)
        peer = readTLObject<TLAbsInputPeer>()
        replyTo = readIfMask(1) { readTLObject<TLAbsInputReplyTo>() }
        message = readString()
        randomId = readLong()
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
        scheduleDate = readIfMask(1024) { readInt() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
        quickReplyShortcut = readIfMask(131072) { readTLObject<TLAbsInputQuickReplyShortcut>() }
        effect = readIfMask(262144) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(replyTo, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(message)
        size += SIZE_INT64
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(scheduleDate, 1024) { SIZE_INT32 }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        size += getIntIfMask(quickReplyShortcut, 131072) { it.computeSerializedSize() }
        size += getIntIfMask(effect, 262144) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && silent == other.silent
                && background == other.background
                && clearDraft == other.clearDraft
                && noforwards == other.noforwards
                && updateStickersetsOrder == other.updateStickersetsOrder
                && invertMedia == other.invertMedia
                && peer == other.peer
                && replyTo == other.replyTo
                && message == other.message
                && randomId == other.randomId
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && scheduleDate == other.scheduleDate
                && sendAs == other.sendAs
                && quickReplyShortcut == other.quickReplyShortcut
                && effect == other.effect
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x983f9745.toInt()
    }
}

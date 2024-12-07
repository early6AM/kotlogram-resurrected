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
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
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
class TLRequestMessagesSendInlineBotResult() : TLMethod<TLAbsUpdates>() {
    @Transient
    var silent: Boolean = false

    @Transient
    var background: Boolean = false

    @Transient
    var clearDraft: Boolean = false

    @Transient
    var hideVia: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var replyTo: TLAbsInputReplyTo? = null

    var randomId: Long = 0L

    var queryId: Long = 0L

    var id: String = ""

    var scheduleDate: Int? = null

    var sendAs: TLAbsInputPeer? = null

    var quickReplyShortcut: TLAbsInputQuickReplyShortcut? = null

    private val _constructor: String = "messages.sendInlineBotResult#3ebee86a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            hideVia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            randomId: Long,
            queryId: Long,
            id: String,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?
    ) : this() {
        this.silent = silent
        this.background = background
        this.clearDraft = clearDraft
        this.hideVia = hideVia
        this.peer = peer
        this.replyTo = replyTo
        this.randomId = randomId
        this.queryId = queryId
        this.id = id
        this.scheduleDate = scheduleDate
        this.sendAs = sendAs
        this.quickReplyShortcut = quickReplyShortcut
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(clearDraft, 128)
        updateFlags(hideVia, 2048)
        updateFlags(replyTo, 1)
        updateFlags(scheduleDate, 1024)
        updateFlags(sendAs, 8192)
        updateFlags(quickReplyShortcut, 131072)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(replyTo, 1) { writeTLObject(it) }
        writeLong(randomId)
        writeLong(queryId)
        writeString(id)
        doIfMask(scheduleDate, 1024) { writeInt(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
        doIfMask(quickReplyShortcut, 131072) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        clearDraft = isMask(128)
        hideVia = isMask(2048)
        peer = readTLObject<TLAbsInputPeer>()
        replyTo = readIfMask(1) { readTLObject<TLAbsInputReplyTo>() }
        randomId = readLong()
        queryId = readLong()
        id = readString()
        scheduleDate = readIfMask(1024) { readInt() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
        quickReplyShortcut = readIfMask(131072) { readTLObject<TLAbsInputQuickReplyShortcut>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(replyTo, 1) { it.computeSerializedSize() }
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(id)
        size += getIntIfMask(scheduleDate, 1024) { SIZE_INT32 }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        size += getIntIfMask(quickReplyShortcut, 131072) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendInlineBotResult) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && background == other.background
                && clearDraft == other.clearDraft
                && hideVia == other.hideVia
                && peer == other.peer
                && replyTo == other.replyTo
                && randomId == other.randomId
                && queryId == other.queryId
                && id == other.id
                && scheduleDate == other.scheduleDate
                && sendAs == other.sendAs
                && quickReplyShortcut == other.quickReplyShortcut
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3ebee86a.toInt()
    }
}

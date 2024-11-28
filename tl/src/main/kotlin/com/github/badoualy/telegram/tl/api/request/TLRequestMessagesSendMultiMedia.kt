package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputSingleMedia
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
class TLRequestMessagesSendMultiMedia() : TLMethod<TLAbsUpdates>() {
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

    var multiMedia: TLObjectVector<TLInputSingleMedia> = TLObjectVector()

    var scheduleDate: Int? = null

    var sendAs: TLAbsInputPeer? = null

    private val _constructor: String = "messages.sendMultiMedia#456e8987"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ) : this() {
        this.silent = silent
        this.background = background
        this.clearDraft = clearDraft
        this.noforwards = noforwards
        this.updateStickersetsOrder = updateStickersetsOrder
        this.invertMedia = invertMedia
        this.peer = peer
        this.replyTo = replyTo
        this.multiMedia = multiMedia
        this.scheduleDate = scheduleDate
        this.sendAs = sendAs
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(clearDraft, 128)
        updateFlags(noforwards, 16384)
        updateFlags(updateStickersetsOrder, 32768)
        updateFlags(invertMedia, 65536)
        updateFlags(replyTo, 1)
        updateFlags(scheduleDate, 1024)
        updateFlags(sendAs, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(replyTo, 1) { writeTLObject(it) }
        writeTLVector(multiMedia)
        doIfMask(scheduleDate, 1024) { writeInt(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        clearDraft = isMask(128)
        noforwards = isMask(16384)
        updateStickersetsOrder = isMask(32768)
        invertMedia = isMask(65536)
        peer = readTLObject<TLAbsInputPeer>()
        replyTo = readIfMask(1) { readTLObject<TLAbsInputReplyTo>() }
        multiMedia = readTLVector<TLInputSingleMedia>()
        scheduleDate = readIfMask(1024) { readInt() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(replyTo, 1) { it.computeSerializedSize() }
        size += multiMedia.computeSerializedSize()
        size += getIntIfMask(scheduleDate, 1024) { SIZE_INT32 }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendMultiMedia) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && background == other.background
                && clearDraft == other.clearDraft
                && noforwards == other.noforwards
                && updateStickersetsOrder == other.updateStickersetsOrder
                && invertMedia == other.invertMedia
                && peer == other.peer
                && replyTo == other.replyTo
                && multiMedia == other.multiMedia
                && scheduleDate == other.scheduleDate
                && sendAs == other.sendAs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x456e8987.toInt()
    }
}

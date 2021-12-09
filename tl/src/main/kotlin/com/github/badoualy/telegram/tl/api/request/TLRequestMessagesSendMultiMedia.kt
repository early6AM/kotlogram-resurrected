package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputSingleMedia
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

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

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var replyToMsgId: Int? = null

    var multiMedia: TLObjectVector<TLInputSingleMedia> = TLObjectVector()

    var scheduleDate: Int? = null

    private val _constructor: String = "messages.sendMultiMedia#cc0110cb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?
    ) : this() {
        this.silent = silent
        this.background = background
        this.clearDraft = clearDraft
        this.peer = peer
        this.replyToMsgId = replyToMsgId
        this.multiMedia = multiMedia
        this.scheduleDate = scheduleDate
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(clearDraft, 128)
        updateFlags(replyToMsgId, 1)
        updateFlags(scheduleDate, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(replyToMsgId, 1) { writeInt(it) }
        writeTLVector(multiMedia)
        doIfMask(scheduleDate, 1024) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        clearDraft = isMask(128)
        peer = readTLObject<TLAbsInputPeer>()
        replyToMsgId = readIfMask(1) { readInt() }
        multiMedia = readTLVector<TLInputSingleMedia>()
        scheduleDate = readIfMask(1024) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(replyToMsgId, 1) { SIZE_INT32 }
        size += multiMedia.computeSerializedSize()
        size += getIntIfMask(scheduleDate, 1024) { SIZE_INT32 }
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
                && peer == other.peer
                && replyToMsgId == other.replyToMsgId
                && multiMedia == other.multiMedia
                && scheduleDate == other.scheduleDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcc0110cb.toInt()
    }
}

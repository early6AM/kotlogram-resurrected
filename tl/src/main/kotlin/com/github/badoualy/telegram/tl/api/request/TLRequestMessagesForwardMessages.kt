package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
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
class TLRequestMessagesForwardMessages() : TLMethod<TLAbsUpdates>() {
    @Transient
    var silent: Boolean = false

    @Transient
    var background: Boolean = false

    @Transient
    var withMyScore: Boolean = false

    @Transient
    var dropAuthor: Boolean = false

    @Transient
    var dropMediaCaptions: Boolean = false

    @Transient
    var noforwards: Boolean = false

    var fromPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: TLIntVector = TLIntVector()

    var randomId: TLLongVector = TLLongVector()

    var toPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var topMsgId: Int? = null

    var scheduleDate: Int? = null

    var sendAs: TLAbsInputPeer? = null

    private val _constructor: String = "messages.forwardMessages#c661bbc4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            dropAuthor: Boolean,
            dropMediaCaptions: Boolean,
            noforwards: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer,
            topMsgId: Int?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ) : this() {
        this.silent = silent
        this.background = background
        this.withMyScore = withMyScore
        this.dropAuthor = dropAuthor
        this.dropMediaCaptions = dropMediaCaptions
        this.noforwards = noforwards
        this.fromPeer = fromPeer
        this.id = id
        this.randomId = randomId
        this.toPeer = toPeer
        this.topMsgId = topMsgId
        this.scheduleDate = scheduleDate
        this.sendAs = sendAs
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(withMyScore, 256)
        updateFlags(dropAuthor, 2048)
        updateFlags(dropMediaCaptions, 4096)
        updateFlags(noforwards, 16384)
        updateFlags(topMsgId, 512)
        updateFlags(scheduleDate, 1024)
        updateFlags(sendAs, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(fromPeer)
        writeTLVector(id)
        writeTLVector(randomId)
        writeTLObject(toPeer)
        doIfMask(topMsgId, 512) { writeInt(it) }
        doIfMask(scheduleDate, 1024) { writeInt(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        withMyScore = isMask(256)
        dropAuthor = isMask(2048)
        dropMediaCaptions = isMask(4096)
        noforwards = isMask(16384)
        fromPeer = readTLObject<TLAbsInputPeer>()
        id = readTLIntVector()
        randomId = readTLLongVector()
        toPeer = readTLObject<TLAbsInputPeer>()
        topMsgId = readIfMask(512) { readInt() }
        scheduleDate = readIfMask(1024) { readInt() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += fromPeer.computeSerializedSize()
        size += id.computeSerializedSize()
        size += randomId.computeSerializedSize()
        size += toPeer.computeSerializedSize()
        size += getIntIfMask(topMsgId, 512) { SIZE_INT32 }
        size += getIntIfMask(scheduleDate, 1024) { SIZE_INT32 }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesForwardMessages) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && background == other.background
                && withMyScore == other.withMyScore
                && dropAuthor == other.dropAuthor
                && dropMediaCaptions == other.dropMediaCaptions
                && noforwards == other.noforwards
                && fromPeer == other.fromPeer
                && id == other.id
                && randomId == other.randomId
                && toPeer == other.toPeer
                && topMsgId == other.topMsgId
                && scheduleDate == other.scheduleDate
                && sendAs == other.sendAs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc661bbc4.toInt()
    }
}

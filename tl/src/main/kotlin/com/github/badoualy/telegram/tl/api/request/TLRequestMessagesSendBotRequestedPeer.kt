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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendBotRequestedPeer() : TLMethod<TLAbsUpdates>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var buttonId: Int = 0

    var requestedPeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    private val _constructor: String = "messages.sendBotRequestedPeer#91b2d060"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            msgId: Int,
            buttonId: Int,
            requestedPeers: TLObjectVector<TLAbsInputPeer>
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.buttonId = buttonId
        this.requestedPeers = requestedPeers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(msgId)
        writeInt(buttonId)
        writeTLVector(requestedPeers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        buttonId = readInt()
        requestedPeers = readTLVector<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += requestedPeers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendBotRequestedPeer) return false
        if (other === this) return true

        return peer == other.peer
                && msgId == other.msgId
                && buttonId == other.buttonId
                && requestedPeers == other.requestedPeers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x91b2d060.toInt()
    }
}

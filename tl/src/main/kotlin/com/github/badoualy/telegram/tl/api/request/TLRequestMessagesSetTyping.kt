package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLSendMessageChooseStickerAction
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
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
class TLRequestMessagesSetTyping() : TLMethod<TLBool>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var topMsgId: Int? = null

    var action: TLAbsSendMessageAction = TLSendMessageChooseStickerAction()

    private val _constructor: String = "messages.setTyping#58943ee2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            action: TLAbsSendMessageAction
    ) : this() {
        this.peer = peer
        this.topMsgId = topMsgId
        this.action = action
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(topMsgId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(topMsgId, 1) { writeInt(it) }
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        topMsgId = readIfMask(1) { readInt() }
        action = readTLObject<TLAbsSendMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(topMsgId, 1) { SIZE_INT32 }
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetTyping) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && topMsgId == other.topMsgId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x58943ee2.toInt()
    }
}

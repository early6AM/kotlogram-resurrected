package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputUserFromMessage#1da448e2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputUserFromMessage() : TLAbsInputUser() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var userId: Long = 0L

    private val _constructor: String = "inputUserFromMessage#1da448e2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            msgId: Int,
            userId: Long
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.userId = userId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(msgId)
        writeLong(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        userId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputUserFromMessage) return false
        if (other === this) return true

        return peer == other.peer
                && msgId == other.msgId
                && userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1da448e2
    }
}

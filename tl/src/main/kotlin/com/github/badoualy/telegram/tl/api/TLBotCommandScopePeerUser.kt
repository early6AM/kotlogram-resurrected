package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * botCommandScopePeerUser#a1321f3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotCommandScopePeerUser() : TLAbsBotCommandScope() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var userId: TLAbsInputUser = TLInputUserEmpty()

    private val _constructor: String = "botCommandScopePeerUser#a1321f3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsInputPeer, userId: TLAbsInputUser) : this() {
        this.peer = peer
        this.userId = userId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        userId = readTLObject<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += userId.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotCommandScopePeerUser) return false
        if (other === this) return true

        return peer == other.peer
                && userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa1321f3
    }
}

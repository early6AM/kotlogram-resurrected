package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updatePeerBlocked#246a4b22
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePeerBlocked() : TLAbsUpdate() {
    var peerId: TLAbsPeer = TLPeerChat()

    var blocked: Boolean = false

    private val _constructor: String = "updatePeerBlocked#246a4b22"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peerId: TLAbsPeer, blocked: Boolean) : this() {
        this.peerId = peerId
        this.blocked = blocked
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peerId)
        writeBoolean(blocked)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peerId = readTLObject<TLAbsPeer>()
        blocked = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peerId.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePeerBlocked) return false
        if (other === this) return true

        return peerId == other.peerId
                && blocked == other.blocked
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x246a4b22
    }
}

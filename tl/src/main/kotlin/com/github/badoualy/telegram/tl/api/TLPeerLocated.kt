package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * peerLocated#ca461b5d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerLocated() : TLAbsPeerLocated() {
    var peer: TLAbsPeer = TLPeerChat()

    override var expires: Int = 0

    var distance: Int = 0

    private val _constructor: String = "peerLocated#ca461b5d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            expires: Int,
            distance: Int
    ) : this() {
        this.peer = peer
        this.expires = expires
        this.distance = distance
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(expires)
        writeInt(distance)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        expires = readInt()
        distance = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerLocated) return false
        if (other === this) return true

        return peer == other.peer
                && expires == other.expires
                && distance == other.distance
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xca461b5d.toInt()
    }
}

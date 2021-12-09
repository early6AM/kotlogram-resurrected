package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updatePeerLocated#b4afcfb0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePeerLocated() : TLAbsUpdate() {
    var peers: TLObjectVector<TLAbsPeerLocated> = TLObjectVector()

    private val _constructor: String = "updatePeerLocated#b4afcfb0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peers: TLObjectVector<TLAbsPeerLocated>) : this() {
        this.peers = peers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(peers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peers = readTLVector<TLAbsPeerLocated>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePeerLocated) return false
        if (other === this) return true

        return peers == other.peers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb4afcfb0.toInt()
    }
}

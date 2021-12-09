package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelParticipantLeft#1b03f006
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantLeft() : TLAbsChannelParticipant() {
    var peer: TLAbsPeer = TLPeerChat()

    private val _constructor: String = "channelParticipantLeft#1b03f006"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsPeer) : this() {
        this.peer = peer
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantLeft) return false
        if (other === this) return true

        return peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1b03f006
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChatDefaultBannedRights#54c01850
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatDefaultBannedRights() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var defaultBannedRights: TLChatBannedRights = TLChatBannedRights()

    var version: Int = 0

    private val _constructor: String = "updateChatDefaultBannedRights#54c01850"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            defaultBannedRights: TLChatBannedRights,
            version: Int
    ) : this() {
        this.peer = peer
        this.defaultBannedRights = defaultBannedRights
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(defaultBannedRights)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        defaultBannedRights = readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID)
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += defaultBannedRights.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatDefaultBannedRights) return false
        if (other === this) return true

        return peer == other.peer
                && defaultBannedRights == other.defaultBannedRights
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x54c01850
    }
}

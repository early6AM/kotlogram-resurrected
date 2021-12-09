package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * folderPeer#e9baa668
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFolderPeer() : TLObject() {
    var peer: TLAbsPeer = TLPeerChat()

    var folderId: Int = 0

    private val _constructor: String = "folderPeer#e9baa668"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsPeer, folderId: Int) : this() {
        this.peer = peer
        this.folderId = folderId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(folderId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        folderId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFolderPeer) return false
        if (other === this) return true

        return peer == other.peer
                && folderId == other.folderId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe9baa668.toInt()
    }
}

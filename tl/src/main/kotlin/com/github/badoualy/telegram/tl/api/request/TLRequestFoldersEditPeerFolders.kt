package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputFolderPeer
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestFoldersEditPeerFolders() : TLMethod<TLAbsUpdates>() {
    var folderPeers: TLObjectVector<TLInputFolderPeer> = TLObjectVector()

    private val _constructor: String = "folders.editPeerFolders#6847d0ab"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(folderPeers: TLObjectVector<TLInputFolderPeer>) : this() {
        this.folderPeers = folderPeers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(folderPeers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        folderPeers = readTLVector<TLInputFolderPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += folderPeers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestFoldersEditPeerFolders) return false
        if (other === this) return true

        return folderPeers == other.folderPeers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6847d0ab
    }
}

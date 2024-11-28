package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateFolderPeers#19360dc0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateFolderPeers() : TLAbsUpdate() {
    var folderPeers: TLObjectVector<TLFolderPeer> = TLObjectVector()

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateFolderPeers#19360dc0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            folderPeers: TLObjectVector<TLFolderPeer>,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.folderPeers = folderPeers
        this.pts = pts
        this.ptsCount = ptsCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(folderPeers)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        folderPeers = readTLVector<TLFolderPeer>()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += folderPeers.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateFolderPeers) return false
        if (other === this) return true

        return folderPeers == other.folderPeers
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x19360dc0.toInt()
    }
}

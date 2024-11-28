package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * exportedChatlistInvite#c5181ac
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedChatlistInvite() : TLObject() {
    var title: String = ""

    var url: String = ""

    var peers: TLObjectVector<TLAbsPeer> = TLObjectVector()

    private val _constructor: String = "exportedChatlistInvite#c5181ac"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            url: String,
            peers: TLObjectVector<TLAbsPeer>
    ) : this() {
        this.title = title
        this.url = url
        this.peers = peers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(_flags)
        writeString(title)
        writeString(url)
        writeTLVector(peers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        url = readString()
        peers = readTLVector<TLAbsPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(url)
        size += peers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedChatlistInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && url == other.url
                && peers == other.peers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc5181ac.toInt()
    }
}

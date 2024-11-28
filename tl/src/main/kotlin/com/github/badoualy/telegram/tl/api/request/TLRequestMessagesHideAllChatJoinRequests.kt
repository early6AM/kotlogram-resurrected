package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesHideAllChatJoinRequests() : TLMethod<TLAbsUpdates>() {
    @Transient
    var approved: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var link: String? = null

    private val _constructor: String = "messages.hideAllChatJoinRequests#e085f4ea"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            approved: Boolean,
            peer: TLAbsInputPeer,
            link: String?
    ) : this() {
        this.approved = approved
        this.peer = peer
        this.link = link
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(approved, 1)
        updateFlags(link, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(link, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        approved = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        link = readIfMask(2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(link, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesHideAllChatJoinRequests) return false
        if (other === this) return true

        return _flags == other._flags
                && approved == other.approved
                && peer == other.peer
                && link == other.link
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe085f4ea.toInt()
    }
}

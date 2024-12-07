package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters
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
class TLRequestMessagesGetChatInviteImporters() : TLMethod<TLChatInviteImporters>() {
    @Transient
    var requested: Boolean = false

    @Transient
    var subscriptionExpired: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var link: String? = null

    var q: String? = null

    var offsetDate: Int = 0

    var offsetUser: TLAbsInputUser = TLInputUserEmpty()

    var limit: Int = 0

    private val _constructor: String = "messages.getChatInviteImporters#df04dd4e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            requested: Boolean,
            subscriptionExpired: Boolean,
            peer: TLAbsInputPeer,
            link: String?,
            q: String?,
            offsetDate: Int,
            offsetUser: TLAbsInputUser,
            limit: Int
    ) : this() {
        this.requested = requested
        this.subscriptionExpired = subscriptionExpired
        this.peer = peer
        this.link = link
        this.q = q
        this.offsetDate = offsetDate
        this.offsetUser = offsetUser
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLChatInviteImporters = tlDeserializer.readTLObject(TLChatInviteImporters::class, TLChatInviteImporters.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(requested, 1)
        updateFlags(subscriptionExpired, 8)
        updateFlags(link, 2)
        updateFlags(q, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(1, link, 2) { writeString(it) }
        doIfMask(1, q, 4) { writeString(it) }
        writeInt(offsetDate)
        writeTLObject(offsetUser)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        requested = isMask(1, 1)
        subscriptionExpired = isMask(1, 8)
        peer = readTLObject<TLAbsInputPeer>()
        link = readIfMask(1, 2) { readString() }
        q = readIfMask(1, 4) { readString() }
        offsetDate = readInt()
        offsetUser = readTLObject<TLAbsInputUser>()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(1, link, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, q, 4) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += offsetUser.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetChatInviteImporters) return false
        if (other === this) return true

        return _flags == other._flags
                && requested == other.requested
                && subscriptionExpired == other.subscriptionExpired
                && peer == other.peer
                && link == other.link
                && q == other.q
                && offsetDate == other.offsetDate
                && offsetUser == other.offsetUser
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdf04dd4e.toInt()
    }
}

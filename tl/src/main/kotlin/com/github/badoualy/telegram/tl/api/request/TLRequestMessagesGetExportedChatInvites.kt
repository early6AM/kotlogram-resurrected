package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetExportedChatInvites() : TLMethod<TLExportedChatInvites>() {
    @Transient
    var revoked: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var adminId: TLAbsInputUser = TLInputUserEmpty()

    var offsetDate: Int? = null

    var offsetLink: String? = null

    var limit: Int = 0

    private val _constructor: String = "messages.getExportedChatInvites#a2b5a3f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            adminId: TLAbsInputUser,
            offsetDate: Int?,
            offsetLink: String?,
            limit: Int
    ) : this() {
        this.revoked = revoked
        this.peer = peer
        this.adminId = adminId
        this.offsetDate = offsetDate
        this.offsetLink = offsetLink
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLExportedChatInvites = tlDeserializer.readTLObject(TLExportedChatInvites::class, TLExportedChatInvites.CONSTRUCTOR_ID)

    override fun computeFlags() {
        _flags = 0
        updateFlags(revoked, 8)
        updateFlags(offsetDate, 4)
        updateFlags(offsetLink, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(adminId)
        doIfMask(offsetDate, 4) { writeInt(it) }
        doIfMask(offsetLink, 4) { writeString(it) }
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        revoked = isMask(8)
        peer = readTLObject<TLAbsInputPeer>()
        adminId = readTLObject<TLAbsInputUser>()
        offsetDate = readIfMask(4) { readInt() }
        offsetLink = readIfMask(4) { readString() }
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += adminId.computeSerializedSize()
        size += getIntIfMask(offsetDate, 4) { SIZE_INT32 }
        size += getIntIfMask(offsetLink, 4) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetExportedChatInvites) return false
        if (other === this) return true

        return _flags == other._flags
                && revoked == other.revoked
                && peer == other.peer
                && adminId == other.adminId
                && offsetDate == other.offsetDate
                && offsetLink == other.offsetLink
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa2b5a3f6.toInt()
    }
}

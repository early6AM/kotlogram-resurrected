package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetChatInviteImporters() : TLMethod<TLChatInviteImporters>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var link: String = ""

    var offsetDate: Int = 0

    var offsetUser: TLAbsInputUser = TLInputUserEmpty()

    var limit: Int = 0

    private val _constructor: String = "messages.getChatInviteImporters#26fb7289"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            link: String,
            offsetDate: Int,
            offsetUser: TLAbsInputUser,
            limit: Int
    ) : this() {
        this.peer = peer
        this.link = link
        this.offsetDate = offsetDate
        this.offsetUser = offsetUser
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLChatInviteImporters = tlDeserializer.readTLObject(TLChatInviteImporters::class, TLChatInviteImporters.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeString(link)
        writeInt(offsetDate)
        writeTLObject(offsetUser)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        link = readString()
        offsetDate = readInt()
        offsetUser = readTLObject<TLAbsInputUser>()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += computeTLStringSerializedSize(link)
        size += SIZE_INT32
        size += offsetUser.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetChatInviteImporters) return false
        if (other === this) return true

        return peer == other.peer
                && link == other.link
                && offsetDate == other.offsetDate
                && offsetUser == other.offsetUser
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x26fb7289
    }
}

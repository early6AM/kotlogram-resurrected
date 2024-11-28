package com.github.badoualy.telegram.tl.api.chatlists

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsPeer
import com.github.badoualy.telegram.tl.api.TLAbsUser
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
 * chatlists.chatlistInvite#1dcd839d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatlistInvite() : TLAbsChatlistInvite() {
    var title: String = ""

    var emoticon: String? = null

    var peers: TLObjectVector<TLAbsPeer> = TLObjectVector()

    override var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "chatlists.chatlistInvite#1dcd839d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            emoticon: String?,
            peers: TLObjectVector<TLAbsPeer>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.title = title
        this.emoticon = emoticon
        this.peers = peers
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(emoticon, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        doIfMask(emoticon, 1) { writeString(it) }
        writeTLVector(peers)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        emoticon = readIfMask(1) { readString() }
        peers = readTLVector<TLAbsPeer>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(emoticon, 1) { computeTLStringSerializedSize(it) }
        size += peers.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatlistInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && emoticon == other.emoticon
                && peers == other.peers
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1dcd839d.toInt()
    }
}

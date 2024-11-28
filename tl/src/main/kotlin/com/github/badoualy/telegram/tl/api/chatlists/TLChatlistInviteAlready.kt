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
 * chatlists.chatlistInviteAlready#fa87f659
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatlistInviteAlready() : TLAbsChatlistInvite() {
    var filterId: Int = 0

    var missingPeers: TLObjectVector<TLAbsPeer> = TLObjectVector()

    var alreadyPeers: TLObjectVector<TLAbsPeer> = TLObjectVector()

    override var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "chatlists.chatlistInviteAlready#fa87f659"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            filterId: Int,
            missingPeers: TLObjectVector<TLAbsPeer>,
            alreadyPeers: TLObjectVector<TLAbsPeer>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.filterId = filterId
        this.missingPeers = missingPeers
        this.alreadyPeers = alreadyPeers
        this.chats = chats
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(filterId)
        writeTLVector(missingPeers)
        writeTLVector(alreadyPeers)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        filterId = readInt()
        missingPeers = readTLVector<TLAbsPeer>()
        alreadyPeers = readTLVector<TLAbsPeer>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += missingPeers.computeSerializedSize()
        size += alreadyPeers.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatlistInviteAlready) return false
        if (other === this) return true

        return filterId == other.filterId
                && missingPeers == other.missingPeers
                && alreadyPeers == other.alreadyPeers
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa87f659.toInt()
    }
}

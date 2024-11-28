package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBotChatInviteRequester#11dfa986
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotChatInviteRequester() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var date: Int = 0

    var userId: Long = 0L

    var about: String = ""

    var invite: TLAbsExportedChatInvite = TLChatInvitePublicJoinRequests()

    var qts: Int = 0

    private val _constructor: String = "updateBotChatInviteRequester#11dfa986"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            date: Int,
            userId: Long,
            about: String,
            invite: TLAbsExportedChatInvite,
            qts: Int
    ) : this() {
        this.peer = peer
        this.date = date
        this.userId = userId
        this.about = about
        this.invite = invite
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(date)
        writeLong(userId)
        writeString(about)
        writeTLObject(invite)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        date = readInt()
        userId = readLong()
        about = readString()
        invite = readTLObject<TLAbsExportedChatInvite>()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(about)
        size += invite.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotChatInviteRequester) return false
        if (other === this) return true

        return peer == other.peer
                && date == other.date
                && userId == other.userId
                && about == other.about
                && invite == other.invite
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x11dfa986.toInt()
    }
}

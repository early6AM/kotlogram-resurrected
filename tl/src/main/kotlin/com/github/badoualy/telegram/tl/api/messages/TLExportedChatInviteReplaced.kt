package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChatInviteExported
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.exportedChatInviteReplaced#222600ef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedChatInviteReplaced() : TLAbsExportedChatInvite() {
    override var invite: TLChatInviteExported = TLChatInviteExported()

    var newInvite: TLChatInviteExported = TLChatInviteExported()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.exportedChatInviteReplaced#222600ef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            invite: TLChatInviteExported,
            newInvite: TLChatInviteExported,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.invite = invite
        this.newInvite = newInvite
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(invite)
        writeTLObject(newInvite)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        invite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
        newInvite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += invite.computeSerializedSize()
        size += newInvite.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedChatInviteReplaced) return false
        if (other === this) return true

        return invite == other.invite
                && newInvite == other.newInvite
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x222600ef
    }
}

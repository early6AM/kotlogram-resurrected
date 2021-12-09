package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChatInviteExported
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.exportedChatInvite#1871be50
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedChatInvite() : TLAbsExportedChatInvite() {
    override var invite: TLChatInviteExported = TLChatInviteExported()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.exportedChatInvite#1871be50"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(invite: TLChatInviteExported, users: TLObjectVector<TLAbsUser>) : this() {
        this.invite = invite
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(invite)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        invite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += invite.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedChatInvite) return false
        if (other === this) return true

        return invite == other.invite
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1871be50
    }
}

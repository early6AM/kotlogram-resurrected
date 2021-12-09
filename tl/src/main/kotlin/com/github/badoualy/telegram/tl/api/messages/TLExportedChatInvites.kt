package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChatInviteExported
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.exportedChatInvites#bdc62dcc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedChatInvites() : TLObject() {
    var count: Int = 0

    var invites: TLObjectVector<TLChatInviteExported> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.exportedChatInvites#bdc62dcc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            invites: TLObjectVector<TLChatInviteExported>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.count = count
        this.invites = invites
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(count)
        writeTLVector(invites)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        count = readInt()
        invites = readTLVector<TLChatInviteExported>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += invites.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedChatInvites) return false
        if (other === this) return true

        return count == other.count
                && invites == other.invites
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbdc62dcc.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionExportedInviteRevoke#410a134e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionExportedInviteRevoke() : TLAbsChannelAdminLogEventAction() {
    var invite: TLChatInviteExported = TLChatInviteExported()

    private val _constructor: String = "channelAdminLogEventActionExportedInviteRevoke#410a134e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(invite: TLChatInviteExported) : this() {
        this.invite = invite
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(invite)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        invite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += invite.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionExportedInviteRevoke) return false
        if (other === this) return true

        return invite == other.invite
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x410a134e
    }
}

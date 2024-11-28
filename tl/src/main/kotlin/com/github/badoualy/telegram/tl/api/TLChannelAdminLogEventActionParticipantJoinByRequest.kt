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
 * channelAdminLogEventActionParticipantJoinByRequest#afb6144a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantJoinByRequest() : TLAbsChannelAdminLogEventAction() {
    var invite: TLAbsExportedChatInvite = TLChatInvitePublicJoinRequests()

    var approvedBy: Long = 0L

    private val _constructor: String = "channelAdminLogEventActionParticipantJoinByRequest#afb6144a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(invite: TLAbsExportedChatInvite, approvedBy: Long) : this() {
        this.invite = invite
        this.approvedBy = approvedBy
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(invite)
        writeLong(approvedBy)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        invite = readTLObject<TLAbsExportedChatInvite>()
        approvedBy = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += invite.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantJoinByRequest) return false
        if (other === this) return true

        return invite == other.invite
                && approvedBy == other.approvedBy
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xafb6144a.toInt()
    }
}

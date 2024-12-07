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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * channelAdminLogEventActionParticipantJoinByInvite#fe9fc158
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantJoinByInvite() : TLAbsChannelAdminLogEventAction() {
    @Transient
    var viaChatlist: Boolean = false

    var invite: TLAbsExportedChatInvite = TLChatInvitePublicJoinRequests()

    private val _constructor: String = "channelAdminLogEventActionParticipantJoinByInvite#fe9fc158"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(viaChatlist: Boolean, invite: TLAbsExportedChatInvite) : this() {
        this.viaChatlist = viaChatlist
        this.invite = invite
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(viaChatlist, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(invite)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viaChatlist = isMask(1, 1)
        invite = readTLObject<TLAbsExportedChatInvite>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += invite.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantJoinByInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && viaChatlist == other.viaChatlist
                && invite == other.invite
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfe9fc158.toInt()
    }
}

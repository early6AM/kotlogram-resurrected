package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionExportedInviteEdit#e90ebb59
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionExportedInviteEdit() : TLAbsChannelAdminLogEventAction() {
    var prevInvite: TLChatInviteExported = TLChatInviteExported()

    var newInvite: TLChatInviteExported = TLChatInviteExported()

    private val _constructor: String = "channelAdminLogEventActionExportedInviteEdit#e90ebb59"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevInvite: TLChatInviteExported, newInvite: TLChatInviteExported) : this() {
        this.prevInvite = prevInvite
        this.newInvite = newInvite
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevInvite)
        writeTLObject(newInvite)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevInvite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
        newInvite = readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevInvite.computeSerializedSize()
        size += newInvite.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionExportedInviteEdit) return false
        if (other === this) return true

        return prevInvite == other.prevInvite
                && newInvite == other.newInvite
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe90ebb59.toInt()
    }
}

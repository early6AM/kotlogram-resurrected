package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionDefaultBannedRights#2df5fc0a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionDefaultBannedRights() : TLAbsChannelAdminLogEventAction() {
    var prevBannedRights: TLChatBannedRights = TLChatBannedRights()

    var newBannedRights: TLChatBannedRights = TLChatBannedRights()

    private val _constructor: String = "channelAdminLogEventActionDefaultBannedRights#2df5fc0a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevBannedRights: TLChatBannedRights, newBannedRights: TLChatBannedRights) : this() {
        this.prevBannedRights = prevBannedRights
        this.newBannedRights = newBannedRights
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevBannedRights)
        writeTLObject(newBannedRights)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevBannedRights = readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID)
        newBannedRights = readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevBannedRights.computeSerializedSize()
        size += newBannedRights.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionDefaultBannedRights) return false
        if (other === this) return true

        return prevBannedRights == other.prevBannedRights
                && newBannedRights == other.newBannedRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2df5fc0a
    }
}

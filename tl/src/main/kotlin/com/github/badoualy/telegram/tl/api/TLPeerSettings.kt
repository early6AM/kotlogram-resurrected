package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * peerSettings#acd66c5e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerSettings() : TLObject() {
    @Transient
    var reportSpam: Boolean = false

    @Transient
    var addContact: Boolean = false

    @Transient
    var blockContact: Boolean = false

    @Transient
    var shareContact: Boolean = false

    @Transient
    var needContactsException: Boolean = false

    @Transient
    var reportGeo: Boolean = false

    @Transient
    var autoarchived: Boolean = false

    @Transient
    var inviteMembers: Boolean = false

    @Transient
    var requestChatBroadcast: Boolean = false

    @Transient
    var businessBotPaused: Boolean = false

    @Transient
    var businessBotCanReply: Boolean = false

    var geoDistance: Int? = null

    var requestChatTitle: String? = null

    var requestChatDate: Int? = null

    var businessBotId: Long? = null

    var businessBotManageUrl: String? = null

    private val _constructor: String = "peerSettings#acd66c5e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            reportSpam: Boolean,
            addContact: Boolean,
            blockContact: Boolean,
            shareContact: Boolean,
            needContactsException: Boolean,
            reportGeo: Boolean,
            autoarchived: Boolean,
            inviteMembers: Boolean,
            requestChatBroadcast: Boolean,
            businessBotPaused: Boolean,
            businessBotCanReply: Boolean,
            geoDistance: Int?,
            requestChatTitle: String?,
            requestChatDate: Int?,
            businessBotId: Long?,
            businessBotManageUrl: String?
    ) : this() {
        this.reportSpam = reportSpam
        this.addContact = addContact
        this.blockContact = blockContact
        this.shareContact = shareContact
        this.needContactsException = needContactsException
        this.reportGeo = reportGeo
        this.autoarchived = autoarchived
        this.inviteMembers = inviteMembers
        this.requestChatBroadcast = requestChatBroadcast
        this.businessBotPaused = businessBotPaused
        this.businessBotCanReply = businessBotCanReply
        this.geoDistance = geoDistance
        this.requestChatTitle = requestChatTitle
        this.requestChatDate = requestChatDate
        this.businessBotId = businessBotId
        this.businessBotManageUrl = businessBotManageUrl
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(reportSpam, 1)
        updateFlags(addContact, 2)
        updateFlags(blockContact, 4)
        updateFlags(shareContact, 8)
        updateFlags(needContactsException, 16)
        updateFlags(reportGeo, 32)
        updateFlags(autoarchived, 128)
        updateFlags(inviteMembers, 256)
        updateFlags(requestChatBroadcast, 1024)
        updateFlags(businessBotPaused, 2048)
        updateFlags(businessBotCanReply, 4096)
        updateFlags(geoDistance, 64)
        updateFlags(requestChatTitle, 512)
        updateFlags(requestChatDate, 512)
        updateFlags(businessBotId, 8192)
        updateFlags(businessBotManageUrl, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(geoDistance, 64) { writeInt(it) }
        doIfMask(requestChatTitle, 512) { writeString(it) }
        doIfMask(requestChatDate, 512) { writeInt(it) }
        doIfMask(businessBotId, 8192) { writeLong(it) }
        doIfMask(businessBotManageUrl, 8192) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        reportSpam = isMask(1)
        addContact = isMask(2)
        blockContact = isMask(4)
        shareContact = isMask(8)
        needContactsException = isMask(16)
        reportGeo = isMask(32)
        autoarchived = isMask(128)
        inviteMembers = isMask(256)
        requestChatBroadcast = isMask(1024)
        businessBotPaused = isMask(2048)
        businessBotCanReply = isMask(4096)
        geoDistance = readIfMask(64) { readInt() }
        requestChatTitle = readIfMask(512) { readString() }
        requestChatDate = readIfMask(512) { readInt() }
        businessBotId = readIfMask(8192) { readLong() }
        businessBotManageUrl = readIfMask(8192) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(geoDistance, 64) { SIZE_INT32 }
        size += getIntIfMask(requestChatTitle, 512) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(requestChatDate, 512) { SIZE_INT32 }
        size += getIntIfMask(businessBotId, 8192) { SIZE_INT64 }
        size += getIntIfMask(businessBotManageUrl, 8192) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && reportSpam == other.reportSpam
                && addContact == other.addContact
                && blockContact == other.blockContact
                && shareContact == other.shareContact
                && needContactsException == other.needContactsException
                && reportGeo == other.reportGeo
                && autoarchived == other.autoarchived
                && inviteMembers == other.inviteMembers
                && requestChatBroadcast == other.requestChatBroadcast
                && businessBotPaused == other.businessBotPaused
                && businessBotCanReply == other.businessBotCanReply
                && geoDistance == other.geoDistance
                && requestChatTitle == other.requestChatTitle
                && requestChatDate == other.requestChatDate
                && businessBotId == other.businessBotId
                && businessBotManageUrl == other.businessBotManageUrl
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xacd66c5e.toInt()
    }
}

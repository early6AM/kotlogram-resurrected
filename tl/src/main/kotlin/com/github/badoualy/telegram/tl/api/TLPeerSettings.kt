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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * peerSettings#a518110d
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

    var geoDistance: Int? = null

    var requestChatTitle: String? = null

    var requestChatDate: Int? = null

    private val _constructor: String = "peerSettings#a518110d"

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
            geoDistance: Int?,
            requestChatTitle: String?,
            requestChatDate: Int?
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
        this.geoDistance = geoDistance
        this.requestChatTitle = requestChatTitle
        this.requestChatDate = requestChatDate
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
        updateFlags(geoDistance, 64)
        updateFlags(requestChatTitle, 512)
        updateFlags(requestChatDate, 512)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(geoDistance, 64) { writeInt(it) }
        doIfMask(requestChatTitle, 512) { writeString(it) }
        doIfMask(requestChatDate, 512) { writeInt(it) }
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
        geoDistance = readIfMask(64) { readInt() }
        requestChatTitle = readIfMask(512) { readString() }
        requestChatDate = readIfMask(512) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(geoDistance, 64) { SIZE_INT32 }
        size += getIntIfMask(requestChatTitle, 512) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(requestChatDate, 512) { SIZE_INT32 }
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
                && geoDistance == other.geoDistance
                && requestChatTitle == other.requestChatTitle
                && requestChatDate == other.requestChatDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa518110d.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channel#8261ac61
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannel() : TLAbsChat() {
    @Transient
    var creator: Boolean = false

    @Transient
    var left: Boolean = false

    @Transient
    var broadcast: Boolean = false

    @Transient
    var verified: Boolean = false

    @Transient
    var megagroup: Boolean = false

    @Transient
    var restricted: Boolean = false

    @Transient
    var signatures: Boolean = false

    @Transient
    var min: Boolean = false

    @Transient
    var scam: Boolean = false

    @Transient
    var hasLink: Boolean = false

    @Transient
    var hasGeo: Boolean = false

    @Transient
    var slowmodeEnabled: Boolean = false

    @Transient
    var callActive: Boolean = false

    @Transient
    var callNotEmpty: Boolean = false

    @Transient
    var fake: Boolean = false

    @Transient
    var gigagroup: Boolean = false

    @Transient
    var noforwards: Boolean = false

    override var id: Long = 0L

    var accessHash: Long? = null

    var title: String = ""

    var username: String? = null

    var photo: TLAbsChatPhoto = TLChatPhotoEmpty()

    var date: Int = 0

    var restrictionReason: TLObjectVector<TLRestrictionReason>? = TLObjectVector()

    var adminRights: TLChatAdminRights? = null

    var bannedRights: TLChatBannedRights? = null

    var defaultBannedRights: TLChatBannedRights? = null

    var participantsCount: Int? = null

    private val _constructor: String = "channel#8261ac61"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            left: Boolean,
            broadcast: Boolean,
            verified: Boolean,
            megagroup: Boolean,
            restricted: Boolean,
            signatures: Boolean,
            min: Boolean,
            scam: Boolean,
            hasLink: Boolean,
            hasGeo: Boolean,
            slowmodeEnabled: Boolean,
            callActive: Boolean,
            callNotEmpty: Boolean,
            fake: Boolean,
            gigagroup: Boolean,
            noforwards: Boolean,
            id: Long,
            accessHash: Long?,
            title: String,
            username: String?,
            photo: TLAbsChatPhoto,
            date: Int,
            restrictionReason: TLObjectVector<TLRestrictionReason>?,
            adminRights: TLChatAdminRights?,
            bannedRights: TLChatBannedRights?,
            defaultBannedRights: TLChatBannedRights?,
            participantsCount: Int?
    ) : this() {
        this.creator = creator
        this.left = left
        this.broadcast = broadcast
        this.verified = verified
        this.megagroup = megagroup
        this.restricted = restricted
        this.signatures = signatures
        this.min = min
        this.scam = scam
        this.hasLink = hasLink
        this.hasGeo = hasGeo
        this.slowmodeEnabled = slowmodeEnabled
        this.callActive = callActive
        this.callNotEmpty = callNotEmpty
        this.fake = fake
        this.gigagroup = gigagroup
        this.noforwards = noforwards
        this.id = id
        this.accessHash = accessHash
        this.title = title
        this.username = username
        this.photo = photo
        this.date = date
        this.restrictionReason = restrictionReason
        this.adminRights = adminRights
        this.bannedRights = bannedRights
        this.defaultBannedRights = defaultBannedRights
        this.participantsCount = participantsCount
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(left, 4)
        updateFlags(broadcast, 32)
        updateFlags(verified, 128)
        updateFlags(megagroup, 256)
        updateFlags(restricted, 512)
        updateFlags(signatures, 2048)
        updateFlags(min, 4096)
        updateFlags(scam, 524288)
        updateFlags(hasLink, 1048576)
        updateFlags(hasGeo, 2097152)
        updateFlags(slowmodeEnabled, 4194304)
        updateFlags(callActive, 8388608)
        updateFlags(callNotEmpty, 16777216)
        updateFlags(fake, 33554432)
        updateFlags(gigagroup, 67108864)
        updateFlags(noforwards, 134217728)
        updateFlags(accessHash, 8192)
        updateFlags(username, 64)
        updateFlags(restrictionReason, 512)
        updateFlags(adminRights, 16384)
        updateFlags(bannedRights, 32768)
        updateFlags(defaultBannedRights, 262144)
        updateFlags(participantsCount, 131072)

        // Following parameters might be forced to true by another field that updated the flags
        restricted = isMask(512)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        doIfMask(accessHash, 8192) { writeLong(it) }
        writeString(title)
        doIfMask(username, 64) { writeString(it) }
        writeTLObject(photo)
        writeInt(date)
        doIfMask(restrictionReason, 512) { writeTLVector(it) }
        doIfMask(adminRights, 16384) { writeTLObject(it) }
        doIfMask(bannedRights, 32768) { writeTLObject(it) }
        doIfMask(defaultBannedRights, 262144) { writeTLObject(it) }
        doIfMask(participantsCount, 131072) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        left = isMask(4)
        broadcast = isMask(32)
        verified = isMask(128)
        megagroup = isMask(256)
        restricted = isMask(512)
        signatures = isMask(2048)
        min = isMask(4096)
        scam = isMask(524288)
        hasLink = isMask(1048576)
        hasGeo = isMask(2097152)
        slowmodeEnabled = isMask(4194304)
        callActive = isMask(8388608)
        callNotEmpty = isMask(16777216)
        fake = isMask(33554432)
        gigagroup = isMask(67108864)
        noforwards = isMask(134217728)
        id = readLong()
        accessHash = readIfMask(8192) { readLong() }
        title = readString()
        username = readIfMask(64) { readString() }
        photo = readTLObject<TLAbsChatPhoto>()
        date = readInt()
        restrictionReason = readIfMask(512) { readTLVector<TLRestrictionReason>() }
        adminRights = readIfMask(16384) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        bannedRights = readIfMask(32768) { readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID) }
        defaultBannedRights = readIfMask(262144) { readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID) }
        participantsCount = readIfMask(131072) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(accessHash, 8192) { SIZE_INT64 }
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(username, 64) { computeTLStringSerializedSize(it) }
        size += photo.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(restrictionReason, 512) { it.computeSerializedSize() }
        size += getIntIfMask(adminRights, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(bannedRights, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(defaultBannedRights, 262144) { it.computeSerializedSize() }
        size += getIntIfMask(participantsCount, 131072) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannel) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && left == other.left
                && broadcast == other.broadcast
                && verified == other.verified
                && megagroup == other.megagroup
                && restricted == other.restricted
                && signatures == other.signatures
                && min == other.min
                && scam == other.scam
                && hasLink == other.hasLink
                && hasGeo == other.hasGeo
                && slowmodeEnabled == other.slowmodeEnabled
                && callActive == other.callActive
                && callNotEmpty == other.callNotEmpty
                && fake == other.fake
                && gigagroup == other.gigagroup
                && noforwards == other.noforwards
                && id == other.id
                && accessHash == other.accessHash
                && title == other.title
                && username == other.username
                && photo == other.photo
                && date == other.date
                && restrictionReason == other.restrictionReason
                && adminRights == other.adminRights
                && bannedRights == other.bannedRights
                && defaultBannedRights == other.defaultBannedRights
                && participantsCount == other.participantsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8261ac61.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * channel#aadfc8f
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

    @Transient
    var joinToSend: Boolean = false

    @Transient
    var joinRequest: Boolean = false

    @Transient
    var forum: Boolean = false

    @Transient
    var storiesHidden: Boolean = false

    @Transient
    var storiesHiddenMin: Boolean = false

    @Transient
    var storiesUnavailable: Boolean = false

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

    var usernames: TLObjectVector<TLUsername>? = TLObjectVector()

    var storiesMaxId: Int? = null

    var color: TLPeerColor? = null

    var profileColor: TLPeerColor? = null

    var emojiStatus: TLAbsEmojiStatus? = null

    var level: Int? = null

    private val _constructor: String = "channel#aadfc8f"

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
            joinToSend: Boolean,
            joinRequest: Boolean,
            forum: Boolean,
            storiesHidden: Boolean,
            storiesHiddenMin: Boolean,
            storiesUnavailable: Boolean,
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
            participantsCount: Int?,
            usernames: TLObjectVector<TLUsername>?,
            storiesMaxId: Int?,
            color: TLPeerColor?,
            profileColor: TLPeerColor?,
            emojiStatus: TLAbsEmojiStatus?,
            level: Int?
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
        this.joinToSend = joinToSend
        this.joinRequest = joinRequest
        this.forum = forum
        this.storiesHidden = storiesHidden
        this.storiesHiddenMin = storiesHiddenMin
        this.storiesUnavailable = storiesUnavailable
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
        this.usernames = usernames
        this.storiesMaxId = storiesMaxId
        this.color = color
        this.profileColor = profileColor
        this.emojiStatus = emojiStatus
        this.level = level
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
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
        updateFlags(joinToSend, 268435456)
        updateFlags(joinRequest, 536870912)
        updateFlags(forum, 1073741824)
        updateFlags(storiesHidden, 2)
        updateFlags(storiesHiddenMin, 4)
        updateFlags(storiesUnavailable, 8)
        updateFlags(accessHash, 8192)
        updateFlags(username, 64)
        updateFlags(restrictionReason, 512)
        updateFlags(adminRights, 16384)
        updateFlags(bannedRights, 32768)
        updateFlags(defaultBannedRights, 262144)
        updateFlags(participantsCount, 131072)
        updateFlags(usernames, 1)
        updateFlags(storiesMaxId, 16)
        updateFlags(color, 128)
        updateFlags(profileColor, 256)
        updateFlags(emojiStatus, 512)
        updateFlags(level, 1024)

        // Following parameters might be forced to true by another field that updated the flags
        creator = isMask(1, 1)
        left = isMask(1, 4)
        verified = isMask(1, 128)
        megagroup = isMask(1, 256)
        restricted = isMask(1, 512)
        storiesHiddenMin = isMask(2, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(_flags2)
        writeLong(id)
        doIfMask(1, accessHash, 8192) { writeLong(it) }
        writeString(title)
        doIfMask(1, username, 64) { writeString(it) }
        writeTLObject(photo)
        writeInt(date)
        doIfMask(1, restrictionReason, 512) { writeTLVector(it) }
        doIfMask(1, adminRights, 16384) { writeTLObject(it) }
        doIfMask(1, bannedRights, 32768) { writeTLObject(it) }
        doIfMask(1, defaultBannedRights, 262144) { writeTLObject(it) }
        doIfMask(1, participantsCount, 131072) { writeInt(it) }
        doIfMask(2, usernames, 1) { writeTLVector(it) }
        doIfMask(2, storiesMaxId, 16) { writeInt(it) }
        doIfMask(2, color, 128) { writeTLObject(it) }
        doIfMask(2, profileColor, 256) { writeTLObject(it) }
        doIfMask(2, emojiStatus, 512) { writeTLObject(it) }
        doIfMask(2, level, 1024) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1, 1)
        left = isMask(1, 4)
        broadcast = isMask(1, 32)
        verified = isMask(1, 128)
        megagroup = isMask(1, 256)
        restricted = isMask(1, 512)
        signatures = isMask(1, 2048)
        min = isMask(1, 4096)
        scam = isMask(1, 524288)
        hasLink = isMask(1, 1048576)
        hasGeo = isMask(1, 2097152)
        slowmodeEnabled = isMask(1, 4194304)
        callActive = isMask(1, 8388608)
        callNotEmpty = isMask(1, 16777216)
        fake = isMask(1, 33554432)
        gigagroup = isMask(1, 67108864)
        noforwards = isMask(1, 134217728)
        joinToSend = isMask(1, 268435456)
        joinRequest = isMask(1, 536870912)
        forum = isMask(1, 1073741824)
        _flags2 = readInt()
        storiesHidden = isMask(2, 2)
        storiesHiddenMin = isMask(2, 4)
        storiesUnavailable = isMask(2, 8)
        id = readLong()
        accessHash = readIfMask(1, 8192) { readLong() }
        title = readString()
        username = readIfMask(1, 64) { readString() }
        photo = readTLObject<TLAbsChatPhoto>()
        date = readInt()
        restrictionReason = readIfMask(1, 512) { readTLVector<TLRestrictionReason>() }
        adminRights = readIfMask(1, 16384) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        bannedRights = readIfMask(1, 32768) { readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID) }
        defaultBannedRights = readIfMask(1, 262144) { readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID) }
        participantsCount = readIfMask(1, 131072) { readInt() }
        usernames = readIfMask(2, 1) { readTLVector<TLUsername>() }
        storiesMaxId = readIfMask(2, 16) { readInt() }
        color = readIfMask(2, 128) { readTLObject<TLPeerColor>(TLPeerColor::class, TLPeerColor.CONSTRUCTOR_ID) }
        profileColor = readIfMask(2, 256) { readTLObject<TLPeerColor>(TLPeerColor::class, TLPeerColor.CONSTRUCTOR_ID) }
        emojiStatus = readIfMask(2, 512) { readTLObject<TLAbsEmojiStatus>() }
        level = readIfMask(2, 1024) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, accessHash, 8192) { SIZE_INT64 }
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(1, username, 64) { computeTLStringSerializedSize(it) }
        size += photo.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, restrictionReason, 512) { it.computeSerializedSize() }
        size += getIntIfMask(1, adminRights, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(1, bannedRights, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(1, defaultBannedRights, 262144) { it.computeSerializedSize() }
        size += getIntIfMask(1, participantsCount, 131072) { SIZE_INT32 }
        size += getIntIfMask(2, usernames, 1) { it.computeSerializedSize() }
        size += getIntIfMask(2, storiesMaxId, 16) { SIZE_INT32 }
        size += getIntIfMask(2, color, 128) { it.computeSerializedSize() }
        size += getIntIfMask(2, profileColor, 256) { it.computeSerializedSize() }
        size += getIntIfMask(2, emojiStatus, 512) { it.computeSerializedSize() }
        size += getIntIfMask(2, level, 1024) { SIZE_INT32 }
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
                && joinToSend == other.joinToSend
                && joinRequest == other.joinRequest
                && forum == other.forum
                && _flags2 == other._flags2
                && storiesHidden == other.storiesHidden
                && storiesHiddenMin == other.storiesHiddenMin
                && storiesUnavailable == other.storiesUnavailable
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
                && usernames == other.usernames
                && storiesMaxId == other.storiesMaxId
                && color == other.color
                && profileColor == other.profileColor
                && emojiStatus == other.emojiStatus
                && level == other.level
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaadfc8f.toInt()
    }
}

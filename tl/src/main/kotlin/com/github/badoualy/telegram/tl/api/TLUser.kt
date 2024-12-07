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
 * user#83314fca
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUser() : TLAbsUser() {
    @Transient
    var self: Boolean = false

    @Transient
    var contact: Boolean = false

    @Transient
    var mutualContact: Boolean = false

    @Transient
    var deleted: Boolean = false

    @Transient
    var bot: Boolean = false

    @Transient
    var botChatHistory: Boolean = false

    @Transient
    var botNochats: Boolean = false

    @Transient
    var verified: Boolean = false

    @Transient
    var restricted: Boolean = false

    @Transient
    var min: Boolean = false

    @Transient
    var botInlineGeo: Boolean = false

    @Transient
    var support: Boolean = false

    @Transient
    var scam: Boolean = false

    @Transient
    var applyMinPhoto: Boolean = false

    @Transient
    var fake: Boolean = false

    @Transient
    var botAttachMenu: Boolean = false

    @Transient
    var premium: Boolean = false

    @Transient
    var attachMenuEnabled: Boolean = false

    @Transient
    var botCanEdit: Boolean = false

    @Transient
    var closeFriend: Boolean = false

    @Transient
    var storiesHidden: Boolean = false

    @Transient
    var storiesUnavailable: Boolean = false

    @Transient
    var contactRequirePremium: Boolean = false

    @Transient
    var botBusiness: Boolean = false

    @Transient
    var botHasMainApp: Boolean = false

    override var id: Long = 0L

    var accessHash: Long? = null

    var firstName: String? = null

    var lastName: String? = null

    var username: String? = null

    var phone: String? = null

    var photo: TLAbsUserProfilePhoto? = null

    var status: TLAbsUserStatus? = null

    var botInfoVersion: Int? = null

    var restrictionReason: TLObjectVector<TLRestrictionReason>? = TLObjectVector()

    var botInlinePlaceholder: String? = null

    var langCode: String? = null

    var emojiStatus: TLAbsEmojiStatus? = null

    var usernames: TLObjectVector<TLUsername>? = TLObjectVector()

    var storiesMaxId: Int? = null

    var color: TLPeerColor? = null

    var profileColor: TLPeerColor? = null

    var botActiveUsers: Int? = null

    private val _constructor: String = "user#83314fca"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            self: Boolean,
            contact: Boolean,
            mutualContact: Boolean,
            deleted: Boolean,
            bot: Boolean,
            botChatHistory: Boolean,
            botNochats: Boolean,
            verified: Boolean,
            restricted: Boolean,
            min: Boolean,
            botInlineGeo: Boolean,
            support: Boolean,
            scam: Boolean,
            applyMinPhoto: Boolean,
            fake: Boolean,
            botAttachMenu: Boolean,
            premium: Boolean,
            attachMenuEnabled: Boolean,
            botCanEdit: Boolean,
            closeFriend: Boolean,
            storiesHidden: Boolean,
            storiesUnavailable: Boolean,
            contactRequirePremium: Boolean,
            botBusiness: Boolean,
            botHasMainApp: Boolean,
            id: Long,
            accessHash: Long?,
            firstName: String?,
            lastName: String?,
            username: String?,
            phone: String?,
            photo: TLAbsUserProfilePhoto?,
            status: TLAbsUserStatus?,
            botInfoVersion: Int?,
            restrictionReason: TLObjectVector<TLRestrictionReason>?,
            botInlinePlaceholder: String?,
            langCode: String?,
            emojiStatus: TLAbsEmojiStatus?,
            usernames: TLObjectVector<TLUsername>?,
            storiesMaxId: Int?,
            color: TLPeerColor?,
            profileColor: TLPeerColor?,
            botActiveUsers: Int?
    ) : this() {
        this.self = self
        this.contact = contact
        this.mutualContact = mutualContact
        this.deleted = deleted
        this.bot = bot
        this.botChatHistory = botChatHistory
        this.botNochats = botNochats
        this.verified = verified
        this.restricted = restricted
        this.min = min
        this.botInlineGeo = botInlineGeo
        this.support = support
        this.scam = scam
        this.applyMinPhoto = applyMinPhoto
        this.fake = fake
        this.botAttachMenu = botAttachMenu
        this.premium = premium
        this.attachMenuEnabled = attachMenuEnabled
        this.botCanEdit = botCanEdit
        this.closeFriend = closeFriend
        this.storiesHidden = storiesHidden
        this.storiesUnavailable = storiesUnavailable
        this.contactRequirePremium = contactRequirePremium
        this.botBusiness = botBusiness
        this.botHasMainApp = botHasMainApp
        this.id = id
        this.accessHash = accessHash
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.phone = phone
        this.photo = photo
        this.status = status
        this.botInfoVersion = botInfoVersion
        this.restrictionReason = restrictionReason
        this.botInlinePlaceholder = botInlinePlaceholder
        this.langCode = langCode
        this.emojiStatus = emojiStatus
        this.usernames = usernames
        this.storiesMaxId = storiesMaxId
        this.color = color
        this.profileColor = profileColor
        this.botActiveUsers = botActiveUsers
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(self, 1024)
        updateFlags(contact, 2048)
        updateFlags(mutualContact, 4096)
        updateFlags(deleted, 8192)
        updateFlags(bot, 16384)
        updateFlags(botChatHistory, 32768)
        updateFlags(botNochats, 65536)
        updateFlags(verified, 131072)
        updateFlags(restricted, 262144)
        updateFlags(min, 1048576)
        updateFlags(botInlineGeo, 2097152)
        updateFlags(support, 8388608)
        updateFlags(scam, 16777216)
        updateFlags(applyMinPhoto, 33554432)
        updateFlags(fake, 67108864)
        updateFlags(botAttachMenu, 134217728)
        updateFlags(premium, 268435456)
        updateFlags(attachMenuEnabled, 536870912)
        updateFlags(botCanEdit, 2)
        updateFlags(closeFriend, 4)
        updateFlags(storiesHidden, 8)
        updateFlags(storiesUnavailable, 16)
        updateFlags(contactRequirePremium, 1024)
        updateFlags(botBusiness, 2048)
        updateFlags(botHasMainApp, 8192)
        updateFlags(accessHash, 1)
        updateFlags(firstName, 2)
        updateFlags(lastName, 4)
        updateFlags(username, 8)
        updateFlags(phone, 16)
        updateFlags(photo, 32)
        updateFlags(status, 64)
        updateFlags(botInfoVersion, 16384)
        updateFlags(restrictionReason, 262144)
        updateFlags(botInlinePlaceholder, 524288)
        updateFlags(langCode, 4194304)
        updateFlags(emojiStatus, 1073741824)
        updateFlags(usernames, 1)
        updateFlags(storiesMaxId, 32)
        updateFlags(color, 256)
        updateFlags(profileColor, 512)
        updateFlags(botActiveUsers, 4096)

        // Following parameters might be forced to true by another field that updated the flags
        self = isMask(1, 1024)
        contact = isMask(1, 2048)
        mutualContact = isMask(1, 4096)
        deleted = isMask(1, 8192)
        bot = isMask(1, 16384)
        restricted = isMask(1, 262144)
        botCanEdit = isMask(2, 2)
        closeFriend = isMask(2, 4)
        storiesHidden = isMask(2, 8)
        storiesUnavailable = isMask(2, 16)
        contactRequirePremium = isMask(2, 1024)
        botBusiness = isMask(2, 2048)
        botHasMainApp = isMask(2, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(_flags2)
        writeLong(id)
        doIfMask(1, accessHash, 1) { writeLong(it) }
        doIfMask(1, firstName, 2) { writeString(it) }
        doIfMask(1, lastName, 4) { writeString(it) }
        doIfMask(1, username, 8) { writeString(it) }
        doIfMask(1, phone, 16) { writeString(it) }
        doIfMask(1, photo, 32) { writeTLObject(it) }
        doIfMask(1, status, 64) { writeTLObject(it) }
        doIfMask(1, botInfoVersion, 16384) { writeInt(it) }
        doIfMask(1, restrictionReason, 262144) { writeTLVector(it) }
        doIfMask(1, botInlinePlaceholder, 524288) { writeString(it) }
        doIfMask(1, langCode, 4194304) { writeString(it) }
        doIfMask(1, emojiStatus, 1073741824) { writeTLObject(it) }
        doIfMask(2, usernames, 1) { writeTLVector(it) }
        doIfMask(2, storiesMaxId, 32) { writeInt(it) }
        doIfMask(2, color, 256) { writeTLObject(it) }
        doIfMask(2, profileColor, 512) { writeTLObject(it) }
        doIfMask(2, botActiveUsers, 4096) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        self = isMask(1, 1024)
        contact = isMask(1, 2048)
        mutualContact = isMask(1, 4096)
        deleted = isMask(1, 8192)
        bot = isMask(1, 16384)
        botChatHistory = isMask(1, 32768)
        botNochats = isMask(1, 65536)
        verified = isMask(1, 131072)
        restricted = isMask(1, 262144)
        min = isMask(1, 1048576)
        botInlineGeo = isMask(1, 2097152)
        support = isMask(1, 8388608)
        scam = isMask(1, 16777216)
        applyMinPhoto = isMask(1, 33554432)
        fake = isMask(1, 67108864)
        botAttachMenu = isMask(1, 134217728)
        premium = isMask(1, 268435456)
        attachMenuEnabled = isMask(1, 536870912)
        _flags2 = readInt()
        botCanEdit = isMask(2, 2)
        closeFriend = isMask(2, 4)
        storiesHidden = isMask(2, 8)
        storiesUnavailable = isMask(2, 16)
        contactRequirePremium = isMask(2, 1024)
        botBusiness = isMask(2, 2048)
        botHasMainApp = isMask(2, 8192)
        id = readLong()
        accessHash = readIfMask(1, 1) { readLong() }
        firstName = readIfMask(1, 2) { readString() }
        lastName = readIfMask(1, 4) { readString() }
        username = readIfMask(1, 8) { readString() }
        phone = readIfMask(1, 16) { readString() }
        photo = readIfMask(1, 32) { readTLObject<TLAbsUserProfilePhoto>() }
        status = readIfMask(1, 64) { readTLObject<TLAbsUserStatus>() }
        botInfoVersion = readIfMask(1, 16384) { readInt() }
        restrictionReason = readIfMask(1, 262144) { readTLVector<TLRestrictionReason>() }
        botInlinePlaceholder = readIfMask(1, 524288) { readString() }
        langCode = readIfMask(1, 4194304) { readString() }
        emojiStatus = readIfMask(1, 1073741824) { readTLObject<TLAbsEmojiStatus>() }
        usernames = readIfMask(2, 1) { readTLVector<TLUsername>() }
        storiesMaxId = readIfMask(2, 32) { readInt() }
        color = readIfMask(2, 256) { readTLObject<TLPeerColor>(TLPeerColor::class, TLPeerColor.CONSTRUCTOR_ID) }
        profileColor = readIfMask(2, 512) { readTLObject<TLPeerColor>(TLPeerColor::class, TLPeerColor.CONSTRUCTOR_ID) }
        botActiveUsers = readIfMask(2, 4096) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, accessHash, 1) { SIZE_INT64 }
        size += getIntIfMask(1, firstName, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, lastName, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, username, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, phone, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, photo, 32) { it.computeSerializedSize() }
        size += getIntIfMask(1, status, 64) { it.computeSerializedSize() }
        size += getIntIfMask(1, botInfoVersion, 16384) { SIZE_INT32 }
        size += getIntIfMask(1, restrictionReason, 262144) { it.computeSerializedSize() }
        size += getIntIfMask(1, botInlinePlaceholder, 524288) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, langCode, 4194304) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, emojiStatus, 1073741824) { it.computeSerializedSize() }
        size += getIntIfMask(2, usernames, 1) { it.computeSerializedSize() }
        size += getIntIfMask(2, storiesMaxId, 32) { SIZE_INT32 }
        size += getIntIfMask(2, color, 256) { it.computeSerializedSize() }
        size += getIntIfMask(2, profileColor, 512) { it.computeSerializedSize() }
        size += getIntIfMask(2, botActiveUsers, 4096) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUser) return false
        if (other === this) return true

        return _flags == other._flags
                && self == other.self
                && contact == other.contact
                && mutualContact == other.mutualContact
                && deleted == other.deleted
                && bot == other.bot
                && botChatHistory == other.botChatHistory
                && botNochats == other.botNochats
                && verified == other.verified
                && restricted == other.restricted
                && min == other.min
                && botInlineGeo == other.botInlineGeo
                && support == other.support
                && scam == other.scam
                && applyMinPhoto == other.applyMinPhoto
                && fake == other.fake
                && botAttachMenu == other.botAttachMenu
                && premium == other.premium
                && attachMenuEnabled == other.attachMenuEnabled
                && _flags2 == other._flags2
                && botCanEdit == other.botCanEdit
                && closeFriend == other.closeFriend
                && storiesHidden == other.storiesHidden
                && storiesUnavailable == other.storiesUnavailable
                && contactRequirePremium == other.contactRequirePremium
                && botBusiness == other.botBusiness
                && botHasMainApp == other.botHasMainApp
                && id == other.id
                && accessHash == other.accessHash
                && firstName == other.firstName
                && lastName == other.lastName
                && username == other.username
                && phone == other.phone
                && photo == other.photo
                && status == other.status
                && botInfoVersion == other.botInfoVersion
                && restrictionReason == other.restrictionReason
                && botInlinePlaceholder == other.botInlinePlaceholder
                && langCode == other.langCode
                && emojiStatus == other.emojiStatus
                && usernames == other.usernames
                && storiesMaxId == other.storiesMaxId
                && color == other.color
                && profileColor == other.profileColor
                && botActiveUsers == other.botActiveUsers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x83314fca.toInt()
    }
}

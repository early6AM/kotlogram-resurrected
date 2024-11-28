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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * chatInvite#cde0ec40
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInvite() : TLAbsChatInvite() {
    @Transient
    var channel: Boolean = false

    @Transient
    var broadcast: Boolean = false

    @Transient
    var _public: Boolean = false

    @Transient
    var megagroup: Boolean = false

    @Transient
    var requestNeeded: Boolean = false

    @Transient
    var verified: Boolean = false

    @Transient
    var scam: Boolean = false

    @Transient
    var fake: Boolean = false

    var title: String = ""

    var about: String? = null

    var photo: TLAbsPhoto = TLPhotoEmpty()

    var participantsCount: Int = 0

    var participants: TLObjectVector<TLAbsUser>? = TLObjectVector()

    var color: Int = 0

    private val _constructor: String = "chatInvite#cde0ec40"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: Boolean,
            broadcast: Boolean,
            _public: Boolean,
            megagroup: Boolean,
            requestNeeded: Boolean,
            verified: Boolean,
            scam: Boolean,
            fake: Boolean,
            title: String,
            about: String?,
            photo: TLAbsPhoto,
            participantsCount: Int,
            participants: TLObjectVector<TLAbsUser>?,
            color: Int
    ) : this() {
        this.channel = channel
        this.broadcast = broadcast
        this._public = _public
        this.megagroup = megagroup
        this.requestNeeded = requestNeeded
        this.verified = verified
        this.scam = scam
        this.fake = fake
        this.title = title
        this.about = about
        this.photo = photo
        this.participantsCount = participantsCount
        this.participants = participants
        this.color = color
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(channel, 1)
        updateFlags(broadcast, 2)
        updateFlags(_public, 4)
        updateFlags(megagroup, 8)
        updateFlags(requestNeeded, 64)
        updateFlags(verified, 128)
        updateFlags(scam, 256)
        updateFlags(fake, 512)
        updateFlags(about, 32)
        updateFlags(participants, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        doIfMask(about, 32) { writeString(it) }
        writeTLObject(photo)
        writeInt(participantsCount)
        doIfMask(participants, 16) { writeTLVector(it) }
        writeInt(color)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channel = isMask(1)
        broadcast = isMask(2)
        _public = isMask(4)
        megagroup = isMask(8)
        requestNeeded = isMask(64)
        verified = isMask(128)
        scam = isMask(256)
        fake = isMask(512)
        title = readString()
        about = readIfMask(32) { readString() }
        photo = readTLObject<TLAbsPhoto>()
        participantsCount = readInt()
        participants = readIfMask(16) { readTLVector<TLAbsUser>() }
        color = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(about, 32) { computeTLStringSerializedSize(it) }
        size += photo.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(participants, 16) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && channel == other.channel
                && broadcast == other.broadcast
                && _public == other._public
                && megagroup == other.megagroup
                && requestNeeded == other.requestNeeded
                && verified == other.verified
                && scam == other.scam
                && fake == other.fake
                && title == other.title
                && about == other.about
                && photo == other.photo
                && participantsCount == other.participantsCount
                && participants == other.participants
                && color == other.color
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcde0ec40.toInt()
    }
}

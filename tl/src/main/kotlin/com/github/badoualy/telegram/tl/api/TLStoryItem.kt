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
 * storyItem#af6365a1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryItem() : TLAbsStoryItem() {
    @Transient
    var pinned: Boolean = false

    @Transient
    var _public: Boolean = false

    @Transient
    var closeFriends: Boolean = false

    @Transient
    var min: Boolean = false

    @Transient
    var noforwards: Boolean = false

    @Transient
    var edited: Boolean = false

    @Transient
    var contacts: Boolean = false

    @Transient
    var selectedContacts: Boolean = false

    @Transient
    var out: Boolean = false

    override var id: Int = 0

    var date: Int = 0

    var fwdFrom: TLStoryFwdHeader? = null

    var expireDate: Int = 0

    var caption: String? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var media: TLAbsMessageMedia = TLMessageMediaEmpty()

    var mediaAreas: TLObjectVector<TLAbsMediaArea>? = TLObjectVector()

    var privacy: TLObjectVector<TLAbsPrivacyRule>? = TLObjectVector()

    var views: TLStoryViews? = null

    var sentReaction: TLAbsReaction? = null

    private val _constructor: String = "storyItem#af6365a1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            _public: Boolean,
            closeFriends: Boolean,
            min: Boolean,
            noforwards: Boolean,
            edited: Boolean,
            contacts: Boolean,
            selectedContacts: Boolean,
            out: Boolean,
            id: Int,
            date: Int,
            fwdFrom: TLStoryFwdHeader?,
            expireDate: Int,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            media: TLAbsMessageMedia,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            privacy: TLObjectVector<TLAbsPrivacyRule>?,
            views: TLStoryViews?,
            sentReaction: TLAbsReaction?
    ) : this() {
        this.pinned = pinned
        this._public = _public
        this.closeFriends = closeFriends
        this.min = min
        this.noforwards = noforwards
        this.edited = edited
        this.contacts = contacts
        this.selectedContacts = selectedContacts
        this.out = out
        this.id = id
        this.date = date
        this.fwdFrom = fwdFrom
        this.expireDate = expireDate
        this.caption = caption
        this.entities = entities
        this.media = media
        this.mediaAreas = mediaAreas
        this.privacy = privacy
        this.views = views
        this.sentReaction = sentReaction
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 32)
        updateFlags(_public, 128)
        updateFlags(closeFriends, 256)
        updateFlags(min, 512)
        updateFlags(noforwards, 1024)
        updateFlags(edited, 2048)
        updateFlags(contacts, 4096)
        updateFlags(selectedContacts, 8192)
        updateFlags(out, 65536)
        updateFlags(fwdFrom, 131072)
        updateFlags(caption, 1)
        updateFlags(entities, 2)
        updateFlags(mediaAreas, 16384)
        updateFlags(privacy, 4)
        updateFlags(views, 8)
        updateFlags(sentReaction, 32768)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeInt(date)
        doIfMask(fwdFrom, 131072) { writeTLObject(it) }
        writeInt(expireDate)
        doIfMask(caption, 1) { writeString(it) }
        doIfMask(entities, 2) { writeTLVector(it) }
        writeTLObject(media)
        doIfMask(mediaAreas, 16384) { writeTLVector(it) }
        doIfMask(privacy, 4) { writeTLVector(it) }
        doIfMask(views, 8) { writeTLObject(it) }
        doIfMask(sentReaction, 32768) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(32)
        _public = isMask(128)
        closeFriends = isMask(256)
        min = isMask(512)
        noforwards = isMask(1024)
        edited = isMask(2048)
        contacts = isMask(4096)
        selectedContacts = isMask(8192)
        out = isMask(65536)
        id = readInt()
        date = readInt()
        fwdFrom = readIfMask(131072) { readTLObject<TLStoryFwdHeader>(TLStoryFwdHeader::class, TLStoryFwdHeader.CONSTRUCTOR_ID) }
        expireDate = readInt()
        caption = readIfMask(1) { readString() }
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
        media = readTLObject<TLAbsMessageMedia>()
        mediaAreas = readIfMask(16384) { readTLVector<TLAbsMediaArea>() }
        privacy = readIfMask(4) { readTLVector<TLAbsPrivacyRule>() }
        views = readIfMask(8) { readTLObject<TLStoryViews>(TLStoryViews::class, TLStoryViews.CONSTRUCTOR_ID) }
        sentReaction = readIfMask(32768) { readTLObject<TLAbsReaction>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(fwdFrom, 131072) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += getIntIfMask(caption, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        size += media.computeSerializedSize()
        size += getIntIfMask(mediaAreas, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(privacy, 4) { it.computeSerializedSize() }
        size += getIntIfMask(views, 8) { it.computeSerializedSize() }
        size += getIntIfMask(sentReaction, 32768) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryItem) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && _public == other._public
                && closeFriends == other.closeFriends
                && min == other.min
                && noforwards == other.noforwards
                && edited == other.edited
                && contacts == other.contacts
                && selectedContacts == other.selectedContacts
                && out == other.out
                && id == other.id
                && date == other.date
                && fwdFrom == other.fwdFrom
                && expireDate == other.expireDate
                && caption == other.caption
                && entities == other.entities
                && media == other.media
                && mediaAreas == other.mediaAreas
                && privacy == other.privacy
                && views == other.views
                && sentReaction == other.sentReaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaf6365a1.toInt()
    }
}

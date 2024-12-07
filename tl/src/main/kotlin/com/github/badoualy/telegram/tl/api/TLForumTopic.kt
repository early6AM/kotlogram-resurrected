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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * forumTopic#71701da9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLForumTopic() : TLAbsForumTopic() {
    @Transient
    var my: Boolean = false

    @Transient
    var closed: Boolean = false

    @Transient
    var pinned: Boolean = false

    @Transient
    var short: Boolean = false

    @Transient
    var hidden: Boolean = false

    override var id: Int = 0

    var date: Int = 0

    var title: String = ""

    var iconColor: Int = 0

    var iconEmojiId: Long? = null

    var topMessage: Int = 0

    var readInboxMaxId: Int = 0

    var readOutboxMaxId: Int = 0

    var unreadCount: Int = 0

    var unreadMentionsCount: Int = 0

    var unreadReactionsCount: Int = 0

    var fromId: TLAbsPeer = TLPeerChat()

    var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var draft: TLAbsDraftMessage? = null

    private val _constructor: String = "forumTopic#71701da9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            my: Boolean,
            closed: Boolean,
            pinned: Boolean,
            short: Boolean,
            hidden: Boolean,
            id: Int,
            date: Int,
            title: String,
            iconColor: Int,
            iconEmojiId: Long?,
            topMessage: Int,
            readInboxMaxId: Int,
            readOutboxMaxId: Int,
            unreadCount: Int,
            unreadMentionsCount: Int,
            unreadReactionsCount: Int,
            fromId: TLAbsPeer,
            notifySettings: TLPeerNotifySettings,
            draft: TLAbsDraftMessage?
    ) : this() {
        this.my = my
        this.closed = closed
        this.pinned = pinned
        this.short = short
        this.hidden = hidden
        this.id = id
        this.date = date
        this.title = title
        this.iconColor = iconColor
        this.iconEmojiId = iconEmojiId
        this.topMessage = topMessage
        this.readInboxMaxId = readInboxMaxId
        this.readOutboxMaxId = readOutboxMaxId
        this.unreadCount = unreadCount
        this.unreadMentionsCount = unreadMentionsCount
        this.unreadReactionsCount = unreadReactionsCount
        this.fromId = fromId
        this.notifySettings = notifySettings
        this.draft = draft
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(my, 2)
        updateFlags(closed, 4)
        updateFlags(pinned, 8)
        updateFlags(short, 32)
        updateFlags(hidden, 64)
        updateFlags(iconEmojiId, 1)
        updateFlags(draft, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeInt(date)
        writeString(title)
        writeInt(iconColor)
        doIfMask(1, iconEmojiId, 1) { writeLong(it) }
        writeInt(topMessage)
        writeInt(readInboxMaxId)
        writeInt(readOutboxMaxId)
        writeInt(unreadCount)
        writeInt(unreadMentionsCount)
        writeInt(unreadReactionsCount)
        writeTLObject(fromId)
        writeTLObject(notifySettings)
        doIfMask(1, draft, 16) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        my = isMask(1, 2)
        closed = isMask(1, 4)
        pinned = isMask(1, 8)
        short = isMask(1, 32)
        hidden = isMask(1, 64)
        id = readInt()
        date = readInt()
        title = readString()
        iconColor = readInt()
        iconEmojiId = readIfMask(1, 1) { readLong() }
        topMessage = readInt()
        readInboxMaxId = readInt()
        readOutboxMaxId = readInt()
        unreadCount = readInt()
        unreadMentionsCount = readInt()
        unreadReactionsCount = readInt()
        fromId = readTLObject<TLAbsPeer>()
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        draft = readIfMask(1, 16) { readTLObject<TLAbsDraftMessage>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += SIZE_INT32
        size += getIntIfMask(1, iconEmojiId, 1) { SIZE_INT64 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += fromId.computeSerializedSize()
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(1, draft, 16) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLForumTopic) return false
        if (other === this) return true

        return _flags == other._flags
                && my == other.my
                && closed == other.closed
                && pinned == other.pinned
                && short == other.short
                && hidden == other.hidden
                && id == other.id
                && date == other.date
                && title == other.title
                && iconColor == other.iconColor
                && iconEmojiId == other.iconEmojiId
                && topMessage == other.topMessage
                && readInboxMaxId == other.readInboxMaxId
                && readOutboxMaxId == other.readOutboxMaxId
                && unreadCount == other.unreadCount
                && unreadMentionsCount == other.unreadMentionsCount
                && unreadReactionsCount == other.unreadReactionsCount
                && fromId == other.fromId
                && notifySettings == other.notifySettings
                && draft == other.draft
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x71701da9.toInt()
    }
}

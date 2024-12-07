package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * stickerSet#2dd14edc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickerSet() : TLObject() {
    @Transient
    var archived: Boolean = false

    @Transient
    var official: Boolean = false

    @Transient
    var masks: Boolean = false

    @Transient
    var emojis: Boolean = false

    @Transient
    var textColor: Boolean = false

    @Transient
    var channelEmojiStatus: Boolean = false

    @Transient
    var creator: Boolean = false

    var installedDate: Int? = null

    var id: Long = 0L

    var accessHash: Long = 0L

    var title: String = ""

    var shortName: String = ""

    var thumbs: TLObjectVector<TLAbsPhotoSize>? = TLObjectVector()

    var thumbDcId: Int? = null

    var thumbVersion: Int? = null

    var thumbDocumentId: Long? = null

    var count: Int = 0

    var hash: Int = 0

    private val _constructor: String = "stickerSet#2dd14edc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            archived: Boolean,
            official: Boolean,
            masks: Boolean,
            emojis: Boolean,
            textColor: Boolean,
            channelEmojiStatus: Boolean,
            creator: Boolean,
            installedDate: Int?,
            id: Long,
            accessHash: Long,
            title: String,
            shortName: String,
            thumbs: TLObjectVector<TLAbsPhotoSize>?,
            thumbDcId: Int?,
            thumbVersion: Int?,
            thumbDocumentId: Long?,
            count: Int,
            hash: Int
    ) : this() {
        this.archived = archived
        this.official = official
        this.masks = masks
        this.emojis = emojis
        this.textColor = textColor
        this.channelEmojiStatus = channelEmojiStatus
        this.creator = creator
        this.installedDate = installedDate
        this.id = id
        this.accessHash = accessHash
        this.title = title
        this.shortName = shortName
        this.thumbs = thumbs
        this.thumbDcId = thumbDcId
        this.thumbVersion = thumbVersion
        this.thumbDocumentId = thumbDocumentId
        this.count = count
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(archived, 2)
        updateFlags(official, 4)
        updateFlags(masks, 8)
        updateFlags(emojis, 128)
        updateFlags(textColor, 512)
        updateFlags(channelEmojiStatus, 1024)
        updateFlags(creator, 2048)
        updateFlags(installedDate, 1)
        updateFlags(thumbs, 16)
        updateFlags(thumbDcId, 16)
        updateFlags(thumbVersion, 16)
        updateFlags(thumbDocumentId, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, installedDate, 1) { writeInt(it) }
        writeLong(id)
        writeLong(accessHash)
        writeString(title)
        writeString(shortName)
        doIfMask(1, thumbs, 16) { writeTLVector(it) }
        doIfMask(1, thumbDcId, 16) { writeInt(it) }
        doIfMask(1, thumbVersion, 16) { writeInt(it) }
        doIfMask(1, thumbDocumentId, 256) { writeLong(it) }
        writeInt(count)
        writeInt(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        archived = isMask(1, 2)
        official = isMask(1, 4)
        masks = isMask(1, 8)
        emojis = isMask(1, 128)
        textColor = isMask(1, 512)
        channelEmojiStatus = isMask(1, 1024)
        creator = isMask(1, 2048)
        installedDate = readIfMask(1, 1) { readInt() }
        id = readLong()
        accessHash = readLong()
        title = readString()
        shortName = readString()
        thumbs = readIfMask(1, 16) { readTLVector<TLAbsPhotoSize>() }
        thumbDcId = readIfMask(1, 16) { readInt() }
        thumbVersion = readIfMask(1, 16) { readInt() }
        thumbDocumentId = readIfMask(1, 256) { readLong() }
        count = readInt()
        hash = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, installedDate, 1) { SIZE_INT32 }
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(shortName)
        size += getIntIfMask(1, thumbs, 16) { it.computeSerializedSize() }
        size += getIntIfMask(1, thumbDcId, 16) { SIZE_INT32 }
        size += getIntIfMask(1, thumbVersion, 16) { SIZE_INT32 }
        size += getIntIfMask(1, thumbDocumentId, 256) { SIZE_INT64 }
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickerSet) return false
        if (other === this) return true

        return _flags == other._flags
                && archived == other.archived
                && official == other.official
                && masks == other.masks
                && emojis == other.emojis
                && textColor == other.textColor
                && channelEmojiStatus == other.channelEmojiStatus
                && creator == other.creator
                && installedDate == other.installedDate
                && id == other.id
                && accessHash == other.accessHash
                && title == other.title
                && shortName == other.shortName
                && thumbs == other.thumbs
                && thumbDcId == other.thumbDcId
                && thumbVersion == other.thumbVersion
                && thumbDocumentId == other.thumbDocumentId
                && count == other.count
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2dd14edc.toInt()
    }
}

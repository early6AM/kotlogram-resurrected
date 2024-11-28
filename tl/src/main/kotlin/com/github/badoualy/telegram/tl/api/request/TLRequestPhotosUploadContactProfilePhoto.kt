package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFile
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsVideoSize
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhotosUploadContactProfilePhoto() : TLMethod<TLPhoto>() {
    @Transient
    var suggest: Boolean = false

    @Transient
    var save: Boolean = false

    var userId: TLAbsInputUser = TLInputUserEmpty()

    var file: TLAbsInputFile? = null

    var video: TLAbsInputFile? = null

    var videoStartTs: Double? = null

    var videoEmojiMarkup: TLAbsVideoSize? = null

    private val _constructor: String = "photos.uploadContactProfilePhoto#e14c4a71"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            suggest: Boolean,
            save: Boolean,
            userId: TLAbsInputUser,
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?,
            videoEmojiMarkup: TLAbsVideoSize?
    ) : this() {
        this.suggest = suggest
        this.save = save
        this.userId = userId
        this.file = file
        this.video = video
        this.videoStartTs = videoStartTs
        this.videoEmojiMarkup = videoEmojiMarkup
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPhoto = tlDeserializer.readTLObject(TLPhoto::class, TLPhoto.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(suggest, 8)
        updateFlags(save, 16)
        updateFlags(file, 1)
        updateFlags(video, 2)
        updateFlags(videoStartTs, 4)
        updateFlags(videoEmojiMarkup, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(userId)
        doIfMask(file, 1) { writeTLObject(it) }
        doIfMask(video, 2) { writeTLObject(it) }
        doIfMask(videoStartTs, 4) { writeDouble(it) }
        doIfMask(videoEmojiMarkup, 32) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        suggest = isMask(8)
        save = isMask(16)
        userId = readTLObject<TLAbsInputUser>()
        file = readIfMask(1) { readTLObject<TLAbsInputFile>() }
        video = readIfMask(2) { readTLObject<TLAbsInputFile>() }
        videoStartTs = readIfMask(4) { readDouble() }
        videoEmojiMarkup = readIfMask(32) { readTLObject<TLAbsVideoSize>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += userId.computeSerializedSize()
        size += getIntIfMask(file, 1) { it.computeSerializedSize() }
        size += getIntIfMask(video, 2) { it.computeSerializedSize() }
        size += getIntIfMask(videoStartTs, 4) { SIZE_DOUBLE }
        size += getIntIfMask(videoEmojiMarkup, 32) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhotosUploadContactProfilePhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && suggest == other.suggest
                && save == other.save
                && userId == other.userId
                && file == other.file
                && video == other.video
                && videoStartTs == other.videoStartTs
                && videoEmojiMarkup == other.videoEmojiMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe14c4a71.toInt()
    }
}

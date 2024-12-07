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
 * autoDownloadSettings#baa57628
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAutoDownloadSettings() : TLObject() {
    @Transient
    var disabled: Boolean = false

    @Transient
    var videoPreloadLarge: Boolean = false

    @Transient
    var audioPreloadNext: Boolean = false

    @Transient
    var phonecallsLessData: Boolean = false

    @Transient
    var storiesPreload: Boolean = false

    var photoSizeMax: Int = 0

    var videoSizeMax: Long = 0L

    var fileSizeMax: Long = 0L

    var videoUploadMaxbitrate: Int = 0

    var smallQueueActiveOperationsMax: Int = 0

    var largeQueueActiveOperationsMax: Int = 0

    private val _constructor: String = "autoDownloadSettings#baa57628"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            disabled: Boolean,
            videoPreloadLarge: Boolean,
            audioPreloadNext: Boolean,
            phonecallsLessData: Boolean,
            storiesPreload: Boolean,
            photoSizeMax: Int,
            videoSizeMax: Long,
            fileSizeMax: Long,
            videoUploadMaxbitrate: Int,
            smallQueueActiveOperationsMax: Int,
            largeQueueActiveOperationsMax: Int
    ) : this() {
        this.disabled = disabled
        this.videoPreloadLarge = videoPreloadLarge
        this.audioPreloadNext = audioPreloadNext
        this.phonecallsLessData = phonecallsLessData
        this.storiesPreload = storiesPreload
        this.photoSizeMax = photoSizeMax
        this.videoSizeMax = videoSizeMax
        this.fileSizeMax = fileSizeMax
        this.videoUploadMaxbitrate = videoUploadMaxbitrate
        this.smallQueueActiveOperationsMax = smallQueueActiveOperationsMax
        this.largeQueueActiveOperationsMax = largeQueueActiveOperationsMax
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(disabled, 1)
        updateFlags(videoPreloadLarge, 2)
        updateFlags(audioPreloadNext, 4)
        updateFlags(phonecallsLessData, 8)
        updateFlags(storiesPreload, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(photoSizeMax)
        writeLong(videoSizeMax)
        writeLong(fileSizeMax)
        writeInt(videoUploadMaxbitrate)
        writeInt(smallQueueActiveOperationsMax)
        writeInt(largeQueueActiveOperationsMax)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        disabled = isMask(1, 1)
        videoPreloadLarge = isMask(1, 2)
        audioPreloadNext = isMask(1, 4)
        phonecallsLessData = isMask(1, 8)
        storiesPreload = isMask(1, 16)
        photoSizeMax = readInt()
        videoSizeMax = readLong()
        fileSizeMax = readLong()
        videoUploadMaxbitrate = readInt()
        smallQueueActiveOperationsMax = readInt()
        largeQueueActiveOperationsMax = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAutoDownloadSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && disabled == other.disabled
                && videoPreloadLarge == other.videoPreloadLarge
                && audioPreloadNext == other.audioPreloadNext
                && phonecallsLessData == other.phonecallsLessData
                && storiesPreload == other.storiesPreload
                && photoSizeMax == other.photoSizeMax
                && videoSizeMax == other.videoSizeMax
                && fileSizeMax == other.fileSizeMax
                && videoUploadMaxbitrate == other.videoUploadMaxbitrate
                && smallQueueActiveOperationsMax == other.smallQueueActiveOperationsMax
                && largeQueueActiveOperationsMax == other.largeQueueActiveOperationsMax
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbaa57628.toInt()
    }
}

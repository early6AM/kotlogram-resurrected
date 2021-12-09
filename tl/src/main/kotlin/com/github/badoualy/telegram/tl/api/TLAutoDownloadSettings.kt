package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * autoDownloadSettings#e04232f3
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

    var photoSizeMax: Int = 0

    var videoSizeMax: Int = 0

    var fileSizeMax: Int = 0

    var videoUploadMaxbitrate: Int = 0

    private val _constructor: String = "autoDownloadSettings#e04232f3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            disabled: Boolean,
            videoPreloadLarge: Boolean,
            audioPreloadNext: Boolean,
            phonecallsLessData: Boolean,
            photoSizeMax: Int,
            videoSizeMax: Int,
            fileSizeMax: Int,
            videoUploadMaxbitrate: Int
    ) : this() {
        this.disabled = disabled
        this.videoPreloadLarge = videoPreloadLarge
        this.audioPreloadNext = audioPreloadNext
        this.phonecallsLessData = phonecallsLessData
        this.photoSizeMax = photoSizeMax
        this.videoSizeMax = videoSizeMax
        this.fileSizeMax = fileSizeMax
        this.videoUploadMaxbitrate = videoUploadMaxbitrate
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(disabled, 1)
        updateFlags(videoPreloadLarge, 2)
        updateFlags(audioPreloadNext, 4)
        updateFlags(phonecallsLessData, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(photoSizeMax)
        writeInt(videoSizeMax)
        writeInt(fileSizeMax)
        writeInt(videoUploadMaxbitrate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        disabled = isMask(1)
        videoPreloadLarge = isMask(2)
        audioPreloadNext = isMask(4)
        phonecallsLessData = isMask(8)
        photoSizeMax = readInt()
        videoSizeMax = readInt()
        fileSizeMax = readInt()
        videoUploadMaxbitrate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
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
                && photoSizeMax == other.photoSizeMax
                && videoSizeMax == other.videoSizeMax
                && fileSizeMax == other.fileSizeMax
                && videoUploadMaxbitrate == other.videoUploadMaxbitrate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe04232f3.toInt()
    }
}

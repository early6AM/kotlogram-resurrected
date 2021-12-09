package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputChatUploadedPhoto#c642724e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputChatUploadedPhoto() : TLAbsInputChatPhoto() {
    var file: TLAbsInputFile? = null

    var video: TLAbsInputFile? = null

    var videoStartTs: Double? = null

    private val _constructor: String = "inputChatUploadedPhoto#c642724e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?
    ) : this() {
        this.file = file
        this.video = video
        this.videoStartTs = videoStartTs
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(file, 1)
        updateFlags(video, 2)
        updateFlags(videoStartTs, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(file, 1) { writeTLObject(it) }
        doIfMask(video, 2) { writeTLObject(it) }
        doIfMask(videoStartTs, 4) { writeDouble(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        file = readIfMask(1) { readTLObject<TLAbsInputFile>() }
        video = readIfMask(2) { readTLObject<TLAbsInputFile>() }
        videoStartTs = readIfMask(4) { readDouble() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(file, 1) { it.computeSerializedSize() }
        size += getIntIfMask(video, 2) { it.computeSerializedSize() }
        size += getIntIfMask(videoStartTs, 4) { SIZE_DOUBLE }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputChatUploadedPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && file == other.file
                && video == other.video
                && videoStartTs == other.videoStartTs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc642724e.toInt()
    }
}

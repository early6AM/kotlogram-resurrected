package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneToggleGroupCallRecord() : TLMethod<TLAbsUpdates>() {
    @Transient
    var start: Boolean = false

    @Transient
    var video: Boolean = false

    var call: TLInputGroupCall = TLInputGroupCall()

    var title: String? = null

    var videoPortrait: Boolean? = null

    private val _constructor: String = "phone.toggleGroupCallRecord#f128c708"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            start: Boolean,
            video: Boolean,
            call: TLInputGroupCall,
            title: String?,
            videoPortrait: Boolean?
    ) : this() {
        this.start = start
        this.video = video
        this.call = call
        this.title = title
        this.videoPortrait = videoPortrait
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(start, 1)
        updateFlags(video, 4)
        updateFlags(title, 2)
        // If field is not serialized force it to false
        if (videoPortrait != null && !isMask(4)) videoPortrait = null
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(call)
        doIfMask(title, 2) { writeString(it) }
        doIfMask(videoPortrait, 4) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        start = isMask(1)
        video = isMask(4)
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        title = readIfMask(2) { readString() }
        videoPortrait = readIfMask(4) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += call.computeSerializedSize()
        size += getIntIfMask(title, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(videoPortrait, 4) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneToggleGroupCallRecord) return false
        if (other === this) return true

        return _flags == other._flags
                && start == other.start
                && video == other.video
                && call == other.call
                && title == other.title
                && videoPortrait == other.videoPortrait
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf128c708.toInt()
    }
}

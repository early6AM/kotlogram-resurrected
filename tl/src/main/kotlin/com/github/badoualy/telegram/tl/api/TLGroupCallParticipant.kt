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
 * groupCallParticipant#eba636fe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupCallParticipant() : TLObject() {
    @Transient
    var muted: Boolean = false

    @Transient
    var left: Boolean = false

    @Transient
    var canSelfUnmute: Boolean = false

    @Transient
    var justJoined: Boolean = false

    @Transient
    var versioned: Boolean = false

    @Transient
    var min: Boolean = false

    @Transient
    var mutedByYou: Boolean = false

    @Transient
    var volumeByAdmin: Boolean = false

    @Transient
    var self: Boolean = false

    @Transient
    var videoJoined: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var date: Int = 0

    var activeDate: Int? = null

    var source: Int = 0

    var volume: Int? = null

    var about: String? = null

    var raiseHandRating: Long? = null

    var video: TLGroupCallParticipantVideo? = null

    var presentation: TLGroupCallParticipantVideo? = null

    private val _constructor: String = "groupCallParticipant#eba636fe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            muted: Boolean,
            left: Boolean,
            canSelfUnmute: Boolean,
            justJoined: Boolean,
            versioned: Boolean,
            min: Boolean,
            mutedByYou: Boolean,
            volumeByAdmin: Boolean,
            self: Boolean,
            videoJoined: Boolean,
            peer: TLAbsPeer,
            date: Int,
            activeDate: Int?,
            source: Int,
            volume: Int?,
            about: String?,
            raiseHandRating: Long?,
            video: TLGroupCallParticipantVideo?,
            presentation: TLGroupCallParticipantVideo?
    ) : this() {
        this.muted = muted
        this.left = left
        this.canSelfUnmute = canSelfUnmute
        this.justJoined = justJoined
        this.versioned = versioned
        this.min = min
        this.mutedByYou = mutedByYou
        this.volumeByAdmin = volumeByAdmin
        this.self = self
        this.videoJoined = videoJoined
        this.peer = peer
        this.date = date
        this.activeDate = activeDate
        this.source = source
        this.volume = volume
        this.about = about
        this.raiseHandRating = raiseHandRating
        this.video = video
        this.presentation = presentation
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(muted, 1)
        updateFlags(left, 2)
        updateFlags(canSelfUnmute, 4)
        updateFlags(justJoined, 16)
        updateFlags(versioned, 32)
        updateFlags(min, 256)
        updateFlags(mutedByYou, 512)
        updateFlags(volumeByAdmin, 1024)
        updateFlags(self, 4096)
        updateFlags(videoJoined, 32768)
        updateFlags(activeDate, 8)
        updateFlags(volume, 128)
        updateFlags(about, 2048)
        updateFlags(raiseHandRating, 8192)
        updateFlags(video, 64)
        updateFlags(presentation, 16384)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(date)
        doIfMask(1, activeDate, 8) { writeInt(it) }
        writeInt(source)
        doIfMask(1, volume, 128) { writeInt(it) }
        doIfMask(1, about, 2048) { writeString(it) }
        doIfMask(1, raiseHandRating, 8192) { writeLong(it) }
        doIfMask(1, video, 64) { writeTLObject(it) }
        doIfMask(1, presentation, 16384) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        muted = isMask(1, 1)
        left = isMask(1, 2)
        canSelfUnmute = isMask(1, 4)
        justJoined = isMask(1, 16)
        versioned = isMask(1, 32)
        min = isMask(1, 256)
        mutedByYou = isMask(1, 512)
        volumeByAdmin = isMask(1, 1024)
        self = isMask(1, 4096)
        videoJoined = isMask(1, 32768)
        peer = readTLObject<TLAbsPeer>()
        date = readInt()
        activeDate = readIfMask(1, 8) { readInt() }
        source = readInt()
        volume = readIfMask(1, 128) { readInt() }
        about = readIfMask(1, 2048) { readString() }
        raiseHandRating = readIfMask(1, 8192) { readLong() }
        video = readIfMask(1, 64) { readTLObject<TLGroupCallParticipantVideo>(TLGroupCallParticipantVideo::class, TLGroupCallParticipantVideo.CONSTRUCTOR_ID) }
        presentation = readIfMask(1, 16384) { readTLObject<TLGroupCallParticipantVideo>(TLGroupCallParticipantVideo::class, TLGroupCallParticipantVideo.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, activeDate, 8) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(1, volume, 128) { SIZE_INT32 }
        size += getIntIfMask(1, about, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, raiseHandRating, 8192) { SIZE_INT64 }
        size += getIntIfMask(1, video, 64) { it.computeSerializedSize() }
        size += getIntIfMask(1, presentation, 16384) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupCallParticipant) return false
        if (other === this) return true

        return _flags == other._flags
                && muted == other.muted
                && left == other.left
                && canSelfUnmute == other.canSelfUnmute
                && justJoined == other.justJoined
                && versioned == other.versioned
                && min == other.min
                && mutedByYou == other.mutedByYou
                && volumeByAdmin == other.volumeByAdmin
                && self == other.self
                && videoJoined == other.videoJoined
                && peer == other.peer
                && date == other.date
                && activeDate == other.activeDate
                && source == other.source
                && volume == other.volume
                && about == other.about
                && raiseHandRating == other.raiseHandRating
                && video == other.video
                && presentation == other.presentation
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeba636fe.toInt()
    }
}

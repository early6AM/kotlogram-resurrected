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
 * groupCall#d597650c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupCall() : TLAbsGroupCall() {
    @Transient
    var joinMuted: Boolean = false

    @Transient
    var canChangeJoinMuted: Boolean = false

    @Transient
    var joinDateAsc: Boolean = false

    @Transient
    var scheduleStartSubscribed: Boolean = false

    @Transient
    var canStartVideo: Boolean = false

    @Transient
    var recordVideoActive: Boolean = false

    @Transient
    var rtmpStream: Boolean = false

    @Transient
    var listenersHidden: Boolean = false

    override var id: Long = 0L

    override var accessHash: Long = 0L

    var participantsCount: Int = 0

    var title: String? = null

    var streamDcId: Int? = null

    var recordStartDate: Int? = null

    var scheduleDate: Int? = null

    var unmutedVideoCount: Int? = null

    var unmutedVideoLimit: Int = 0

    var version: Int = 0

    private val _constructor: String = "groupCall#d597650c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            joinMuted: Boolean,
            canChangeJoinMuted: Boolean,
            joinDateAsc: Boolean,
            scheduleStartSubscribed: Boolean,
            canStartVideo: Boolean,
            recordVideoActive: Boolean,
            rtmpStream: Boolean,
            listenersHidden: Boolean,
            id: Long,
            accessHash: Long,
            participantsCount: Int,
            title: String?,
            streamDcId: Int?,
            recordStartDate: Int?,
            scheduleDate: Int?,
            unmutedVideoCount: Int?,
            unmutedVideoLimit: Int,
            version: Int
    ) : this() {
        this.joinMuted = joinMuted
        this.canChangeJoinMuted = canChangeJoinMuted
        this.joinDateAsc = joinDateAsc
        this.scheduleStartSubscribed = scheduleStartSubscribed
        this.canStartVideo = canStartVideo
        this.recordVideoActive = recordVideoActive
        this.rtmpStream = rtmpStream
        this.listenersHidden = listenersHidden
        this.id = id
        this.accessHash = accessHash
        this.participantsCount = participantsCount
        this.title = title
        this.streamDcId = streamDcId
        this.recordStartDate = recordStartDate
        this.scheduleDate = scheduleDate
        this.unmutedVideoCount = unmutedVideoCount
        this.unmutedVideoLimit = unmutedVideoLimit
        this.version = version
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(joinMuted, 2)
        updateFlags(canChangeJoinMuted, 4)
        updateFlags(joinDateAsc, 64)
        updateFlags(scheduleStartSubscribed, 256)
        updateFlags(canStartVideo, 512)
        updateFlags(recordVideoActive, 2048)
        updateFlags(rtmpStream, 4096)
        updateFlags(listenersHidden, 8192)
        updateFlags(title, 8)
        updateFlags(streamDcId, 16)
        updateFlags(recordStartDate, 32)
        updateFlags(scheduleDate, 128)
        updateFlags(unmutedVideoCount, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeInt(participantsCount)
        doIfMask(title, 8) { writeString(it) }
        doIfMask(streamDcId, 16) { writeInt(it) }
        doIfMask(recordStartDate, 32) { writeInt(it) }
        doIfMask(scheduleDate, 128) { writeInt(it) }
        doIfMask(unmutedVideoCount, 1024) { writeInt(it) }
        writeInt(unmutedVideoLimit)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        joinMuted = isMask(2)
        canChangeJoinMuted = isMask(4)
        joinDateAsc = isMask(64)
        scheduleStartSubscribed = isMask(256)
        canStartVideo = isMask(512)
        recordVideoActive = isMask(2048)
        rtmpStream = isMask(4096)
        listenersHidden = isMask(8192)
        id = readLong()
        accessHash = readLong()
        participantsCount = readInt()
        title = readIfMask(8) { readString() }
        streamDcId = readIfMask(16) { readInt() }
        recordStartDate = readIfMask(32) { readInt() }
        scheduleDate = readIfMask(128) { readInt() }
        unmutedVideoCount = readIfMask(1024) { readInt() }
        unmutedVideoLimit = readInt()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(title, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(streamDcId, 16) { SIZE_INT32 }
        size += getIntIfMask(recordStartDate, 32) { SIZE_INT32 }
        size += getIntIfMask(scheduleDate, 128) { SIZE_INT32 }
        size += getIntIfMask(unmutedVideoCount, 1024) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupCall) return false
        if (other === this) return true

        return _flags == other._flags
                && joinMuted == other.joinMuted
                && canChangeJoinMuted == other.canChangeJoinMuted
                && joinDateAsc == other.joinDateAsc
                && scheduleStartSubscribed == other.scheduleStartSubscribed
                && canStartVideo == other.canStartVideo
                && recordVideoActive == other.recordVideoActive
                && rtmpStream == other.rtmpStream
                && listenersHidden == other.listenersHidden
                && id == other.id
                && accessHash == other.accessHash
                && participantsCount == other.participantsCount
                && title == other.title
                && streamDcId == other.streamDcId
                && recordStartDate == other.recordStartDate
                && scheduleDate == other.scheduleDate
                && unmutedVideoCount == other.unmutedVideoCount
                && unmutedVideoLimit == other.unmutedVideoLimit
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd597650c.toInt()
    }
}

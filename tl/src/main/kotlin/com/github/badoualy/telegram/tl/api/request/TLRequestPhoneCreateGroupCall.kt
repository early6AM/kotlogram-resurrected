package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneCreateGroupCall() : TLMethod<TLAbsUpdates>() {
    @Transient
    var rtmpStream: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var randomId: Int = 0

    var title: String? = null

    var scheduleDate: Int? = null

    private val _constructor: String = "phone.createGroupCall#48cdc6d8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            rtmpStream: Boolean,
            peer: TLAbsInputPeer,
            randomId: Int,
            title: String?,
            scheduleDate: Int?
    ) : this() {
        this.rtmpStream = rtmpStream
        this.peer = peer
        this.randomId = randomId
        this.title = title
        this.scheduleDate = scheduleDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(rtmpStream, 4)
        updateFlags(title, 1)
        updateFlags(scheduleDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(randomId)
        doIfMask(title, 1) { writeString(it) }
        doIfMask(scheduleDate, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        rtmpStream = isMask(4)
        peer = readTLObject<TLAbsInputPeer>()
        randomId = readInt()
        title = readIfMask(1) { readString() }
        scheduleDate = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(scheduleDate, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneCreateGroupCall) return false
        if (other === this) return true

        return _flags == other._flags
                && rtmpStream == other.rtmpStream
                && peer == other.peer
                && randomId == other.randomId
                && title == other.title
                && scheduleDate == other.scheduleDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x48cdc6d8.toInt()
    }
}

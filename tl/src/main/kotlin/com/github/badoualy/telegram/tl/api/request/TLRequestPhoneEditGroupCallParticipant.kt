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
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneEditGroupCallParticipant() : TLMethod<TLAbsUpdates>() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var participant: TLAbsInputPeer = TLInputPeerEmpty()

    var muted: Boolean? = null

    var volume: Int? = null

    var raiseHand: Boolean? = null

    var videoStopped: Boolean? = null

    var videoPaused: Boolean? = null

    var presentationPaused: Boolean? = null

    private val _constructor: String = "phone.editGroupCallParticipant#a5273abf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            call: TLInputGroupCall,
            participant: TLAbsInputPeer,
            muted: Boolean?,
            volume: Int?,
            raiseHand: Boolean?,
            videoStopped: Boolean?,
            videoPaused: Boolean?,
            presentationPaused: Boolean?
    ) : this() {
        this.call = call
        this.participant = participant
        this.muted = muted
        this.volume = volume
        this.raiseHand = raiseHand
        this.videoStopped = videoStopped
        this.videoPaused = videoPaused
        this.presentationPaused = presentationPaused
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(muted, 1)
        updateFlags(volume, 2)
        updateFlags(raiseHand, 4)
        updateFlags(videoStopped, 8)
        updateFlags(videoPaused, 16)
        updateFlags(presentationPaused, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(call)
        writeTLObject(participant)
        doIfMask(muted, 1) { writeBoolean(it) }
        doIfMask(volume, 2) { writeInt(it) }
        doIfMask(raiseHand, 4) { writeBoolean(it) }
        doIfMask(videoStopped, 8) { writeBoolean(it) }
        doIfMask(videoPaused, 16) { writeBoolean(it) }
        doIfMask(presentationPaused, 32) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        participant = readTLObject<TLAbsInputPeer>()
        muted = readIfMask(1) { readBoolean() }
        volume = readIfMask(2) { readInt() }
        raiseHand = readIfMask(4) { readBoolean() }
        videoStopped = readIfMask(8) { readBoolean() }
        videoPaused = readIfMask(16) { readBoolean() }
        presentationPaused = readIfMask(32) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += call.computeSerializedSize()
        size += participant.computeSerializedSize()
        size += getIntIfMask(muted, 1) { SIZE_BOOLEAN }
        size += getIntIfMask(volume, 2) { SIZE_INT32 }
        size += getIntIfMask(raiseHand, 4) { SIZE_BOOLEAN }
        size += getIntIfMask(videoStopped, 8) { SIZE_BOOLEAN }
        size += getIntIfMask(videoPaused, 16) { SIZE_BOOLEAN }
        size += getIntIfMask(presentationPaused, 32) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneEditGroupCallParticipant) return false
        if (other === this) return true

        return _flags == other._flags
                && call == other.call
                && participant == other.participant
                && muted == other.muted
                && volume == other.volume
                && raiseHand == other.raiseHand
                && videoStopped == other.videoStopped
                && videoPaused == other.videoPaused
                && presentationPaused == other.presentationPaused
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa5273abf.toInt()
    }
}

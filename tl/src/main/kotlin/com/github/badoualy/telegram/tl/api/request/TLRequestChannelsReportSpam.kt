package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLIntVector
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
class TLRequestChannelsReportSpam() : TLMethod<TLBool>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var participant: TLAbsInputPeer = TLInputPeerEmpty()

    var id: TLIntVector = TLIntVector()

    private val _constructor: String = "channels.reportSpam#f44a8315"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            id: TLIntVector
    ) : this() {
        this.channel = channel
        this.participant = participant
        this.id = id
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(participant)
        writeTLVector(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        participant = readTLObject<TLAbsInputPeer>()
        id = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += participant.computeSerializedSize()
        size += id.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsReportSpam) return false
        if (other === this) return true

        return channel == other.channel
                && participant == other.participant
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf44a8315.toInt()
    }
}

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
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputMediaAreaChannelPost#2271f2bf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaAreaChannelPost() : TLAbsMediaArea() {
    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var msgId: Int = 0

    private val _constructor: String = "inputMediaAreaChannelPost#2271f2bf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            coordinates: TLMediaAreaCoordinates,
            channel: TLAbsInputChannel,
            msgId: Int
    ) : this() {
        this.coordinates = coordinates
        this.channel = channel
        this.msgId = msgId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(coordinates)
        writeTLObject(channel)
        writeInt(msgId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        channel = readTLObject<TLAbsInputChannel>()
        msgId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += coordinates.computeSerializedSize()
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaAreaChannelPost) return false
        if (other === this) return true

        return coordinates == other.coordinates
                && channel == other.channel
                && msgId == other.msgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2271f2bf.toInt()
    }
}

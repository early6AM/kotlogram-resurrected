package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionGeoProximityReached#98e0d697
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionGeoProximityReached() : TLAbsMessageAction() {
    var fromId: TLAbsPeer = TLPeerChat()

    var toId: TLAbsPeer = TLPeerChat()

    var distance: Int = 0

    private val _constructor: String = "messageActionGeoProximityReached#98e0d697"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromId: TLAbsPeer,
            toId: TLAbsPeer,
            distance: Int
    ) : this() {
        this.fromId = fromId
        this.toId = toId
        this.distance = distance
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(fromId)
        writeTLObject(toId)
        writeInt(distance)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        fromId = readTLObject<TLAbsPeer>()
        toId = readTLObject<TLAbsPeer>()
        distance = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += fromId.computeSerializedSize()
        size += toId.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionGeoProximityReached) return false
        if (other === this) return true

        return fromId == other.fromId
                && toId == other.toId
                && distance == other.distance
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98e0d697.toInt()
    }
}

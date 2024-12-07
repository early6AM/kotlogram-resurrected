package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBotDeleteBusinessMessage#a02a982e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotDeleteBusinessMessage() : TLAbsUpdate() {
    var connectionId: String = ""

    var peer: TLAbsPeer = TLPeerChat()

    var messages: TLIntVector = TLIntVector()

    var qts: Int = 0

    private val _constructor: String = "updateBotDeleteBusinessMessage#a02a982e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            connectionId: String,
            peer: TLAbsPeer,
            messages: TLIntVector,
            qts: Int
    ) : this() {
        this.connectionId = connectionId
        this.peer = peer
        this.messages = messages
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(connectionId)
        writeTLObject(peer)
        writeTLVector(messages)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        connectionId = readString()
        peer = readTLObject<TLAbsPeer>()
        messages = readTLIntVector()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(connectionId)
        size += peer.computeSerializedSize()
        size += messages.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotDeleteBusinessMessage) return false
        if (other === this) return true

        return connectionId == other.connectionId
                && peer == other.peer
                && messages == other.messages
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa02a982e.toInt()
    }
}

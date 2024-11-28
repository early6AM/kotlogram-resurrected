package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updatePendingJoinRequests#7063c3db
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePendingJoinRequests() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var requestsPending: Int = 0

    var recentRequesters: TLLongVector = TLLongVector()

    private val _constructor: String = "updatePendingJoinRequests#7063c3db"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            requestsPending: Int,
            recentRequesters: TLLongVector
    ) : this() {
        this.peer = peer
        this.requestsPending = requestsPending
        this.recentRequesters = recentRequesters
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(requestsPending)
        writeTLVector(recentRequesters)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        requestsPending = readInt()
        recentRequesters = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += recentRequesters.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePendingJoinRequests) return false
        if (other === this) return true

        return peer == other.peer
                && requestsPending == other.requestsPending
                && recentRequesters == other.recentRequesters
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7063c3db.toInt()
    }
}

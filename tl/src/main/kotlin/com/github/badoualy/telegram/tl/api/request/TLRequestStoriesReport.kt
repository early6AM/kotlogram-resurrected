package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsReportReason
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputReportReasonFake
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
class TLRequestStoriesReport() : TLMethod<TLBool>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: TLIntVector = TLIntVector()

    var reason: TLAbsReportReason = TLInputReportReasonFake()

    var message: String = ""

    private val _constructor: String = "stories.report#1923fa8c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ) : this() {
        this.peer = peer
        this.id = id
        this.reason = reason
        this.message = message
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLVector(id)
        writeTLObject(reason)
        writeString(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        id = readTLIntVector()
        reason = readTLObject<TLAbsReportReason>()
        message = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += id.computeSerializedSize()
        size += reason.computeSerializedSize()
        size += computeTLStringSerializedSize(message)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesReport) return false
        if (other === this) return true

        return peer == other.peer
                && id == other.id
                && reason == other.reason
                && message == other.message
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1923fa8c.toInt()
    }
}

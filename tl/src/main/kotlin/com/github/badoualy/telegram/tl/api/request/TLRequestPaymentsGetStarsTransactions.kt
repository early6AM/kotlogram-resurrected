package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.payments.TLStarsStatus
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
class TLRequestPaymentsGetStarsTransactions() : TLMethod<TLStarsStatus>() {
    @Transient
    var inbound: Boolean = false

    @Transient
    var outbound: Boolean = false

    @Transient
    var ascending: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var offset: String = ""

    var limit: Int = 0

    private val _constructor: String = "payments.getStarsTransactions#97938d5a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inbound: Boolean,
            outbound: Boolean,
            ascending: Boolean,
            peer: TLAbsInputPeer,
            offset: String,
            limit: Int
    ) : this() {
        this.inbound = inbound
        this.outbound = outbound
        this.ascending = ascending
        this.peer = peer
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStarsStatus = tlDeserializer.readTLObject(TLStarsStatus::class, TLStarsStatus.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(inbound, 1)
        updateFlags(outbound, 2)
        updateFlags(ascending, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeString(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inbound = isMask(1, 1)
        outbound = isMask(1, 2)
        ascending = isMask(1, 4)
        peer = readTLObject<TLAbsInputPeer>()
        offset = readString()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += computeTLStringSerializedSize(offset)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetStarsTransactions) return false
        if (other === this) return true

        return _flags == other._flags
                && inbound == other.inbound
                && outbound == other.outbound
                && ascending == other.ascending
                && peer == other.peer
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x97938d5a.toInt()
    }
}

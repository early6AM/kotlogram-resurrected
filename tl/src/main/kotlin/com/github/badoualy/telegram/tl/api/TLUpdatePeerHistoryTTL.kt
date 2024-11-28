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
 * updatePeerHistoryTTL#bb9bb9a5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePeerHistoryTTL() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var ttlPeriod: Int? = null

    private val _constructor: String = "updatePeerHistoryTTL#bb9bb9a5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsPeer, ttlPeriod: Int?) : this() {
        this.peer = peer
        this.ttlPeriod = ttlPeriod
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ttlPeriod, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(ttlPeriod, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsPeer>()
        ttlPeriod = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(ttlPeriod, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePeerHistoryTTL) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && ttlPeriod == other.ttlPeriod
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbb9bb9a5.toInt()
    }
}

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
import com.github.badoualy.telegram.tl.api.stats.TLStoryStats
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
class TLRequestStatsGetStoryStats() : TLMethod<TLStoryStats>() {
    @Transient
    var dark: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    private val _constructor: String = "stats.getStoryStats#374fef40"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dark: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ) : this() {
        this.dark = dark
        this.peer = peer
        this.id = id
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStoryStats = tlDeserializer.readTLObject(TLStoryStats::class, TLStoryStats.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(dark, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1, 1)
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStatsGetStoryStats) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && peer == other.peer
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x374fef40.toInt()
    }
}

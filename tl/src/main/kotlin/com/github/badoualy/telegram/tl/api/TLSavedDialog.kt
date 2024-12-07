package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * savedDialog#bd87cb6c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSavedDialog() : TLObject() {
    @Transient
    var pinned: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var topMessage: Int = 0

    private val _constructor: String = "savedDialog#bd87cb6c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            peer: TLAbsPeer,
            topMessage: Int
    ) : this() {
        this.pinned = pinned
        this.peer = peer
        this.topMessage = topMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(pinned, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(topMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(1, 4)
        peer = readTLObject<TLAbsPeer>()
        topMessage = readInt()
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
        if (other !is TLSavedDialog) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && peer == other.peer
                && topMessage == other.topMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbd87cb6c.toInt()
    }
}

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
 * sendAsPeer#b81c7034
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendAsPeer() : TLObject() {
    @Transient
    var premiumRequired: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    private val _constructor: String = "sendAsPeer#b81c7034"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(premiumRequired: Boolean, peer: TLAbsPeer) : this() {
        this.premiumRequired = premiumRequired
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(premiumRequired, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        premiumRequired = isMask(1)
        peer = readTLObject<TLAbsPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendAsPeer) return false
        if (other === this) return true

        return _flags == other._flags
                && premiumRequired == other.premiumRequired
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb81c7034.toInt()
    }
}

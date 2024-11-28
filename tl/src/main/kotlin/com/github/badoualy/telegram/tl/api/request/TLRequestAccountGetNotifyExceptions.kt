package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
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
class TLRequestAccountGetNotifyExceptions() : TLMethod<TLAbsUpdates>() {
    @Transient
    var compareSound: Boolean = false

    @Transient
    var compareStories: Boolean = false

    var peer: TLAbsInputNotifyPeer? = null

    private val _constructor: String = "account.getNotifyExceptions#53577479"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            compareSound: Boolean,
            compareStories: Boolean,
            peer: TLAbsInputNotifyPeer?
    ) : this() {
        this.compareSound = compareSound
        this.compareStories = compareStories
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(compareSound, 2)
        updateFlags(compareStories, 4)
        updateFlags(peer, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(peer, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        compareSound = isMask(2)
        compareStories = isMask(4)
        peer = readIfMask(1) { readTLObject<TLAbsInputNotifyPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(peer, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetNotifyExceptions) return false
        if (other === this) return true

        return _flags == other._flags
                && compareSound == other.compareSound
                && compareStories == other.compareStories
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x53577479.toInt()
    }
}

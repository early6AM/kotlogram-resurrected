package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLStringVector
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
 * phoneCallProtocol#fc878fc8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallProtocol() : TLObject() {
    @Transient
    var udpP2p: Boolean = false

    @Transient
    var udpReflector: Boolean = false

    var minLayer: Int = 0

    var maxLayer: Int = 0

    var libraryVersions: TLStringVector = TLStringVector()

    private val _constructor: String = "phoneCallProtocol#fc878fc8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            udpP2p: Boolean,
            udpReflector: Boolean,
            minLayer: Int,
            maxLayer: Int,
            libraryVersions: TLStringVector
    ) : this() {
        this.udpP2p = udpP2p
        this.udpReflector = udpReflector
        this.minLayer = minLayer
        this.maxLayer = maxLayer
        this.libraryVersions = libraryVersions
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(udpP2p, 1)
        updateFlags(udpReflector, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(minLayer)
        writeInt(maxLayer)
        writeTLVector(libraryVersions)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        udpP2p = isMask(1)
        udpReflector = isMask(2)
        minLayer = readInt()
        maxLayer = readInt()
        libraryVersions = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += libraryVersions.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallProtocol) return false
        if (other === this) return true

        return _flags == other._flags
                && udpP2p == other.udpP2p
                && udpReflector == other.udpReflector
                && minLayer == other.minLayer
                && maxLayer == other.maxLayer
                && libraryVersions == other.libraryVersions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfc878fc8.toInt()
    }
}

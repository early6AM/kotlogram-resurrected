package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * sponsoredMessage#2a3c381f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSponsoredMessage() : TLObject() {
    var randomId: TLBytes = TLBytes.EMPTY

    var fromId: TLAbsPeer = TLPeerChat()

    var startParam: String? = null

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "sponsoredMessage#2a3c381f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            randomId: TLBytes,
            fromId: TLAbsPeer,
            startParam: String?,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.randomId = randomId
        this.fromId = fromId
        this.startParam = startParam
        this.message = message
        this.entities = entities
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(startParam, 1)
        updateFlags(entities, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLBytes(randomId)
        writeTLObject(fromId)
        doIfMask(startParam, 1) { writeString(it) }
        writeString(message)
        doIfMask(entities, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        randomId = readTLBytes()
        fromId = readTLObject<TLAbsPeer>()
        startParam = readIfMask(1) { readString() }
        message = readString()
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(randomId)
        size += fromId.computeSerializedSize()
        size += getIntIfMask(startParam, 1) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSponsoredMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && randomId == other.randomId
                && fromId == other.fromId
                && startParam == other.startParam
                && message == other.message
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2a3c381f
    }
}

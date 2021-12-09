package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageEmpty#90a6ca84
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageEmpty() : TLAbsMessage() {
    override var id: Int = 0

    var peerId: TLAbsPeer? = null

    private val _constructor: String = "messageEmpty#90a6ca84"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: Int, peerId: TLAbsPeer?) : this() {
        this.id = id
        this.peerId = peerId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(peerId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(peerId, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readInt()
        peerId = readIfMask(1) { readTLObject<TLAbsPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(peerId, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageEmpty) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && peerId == other.peerId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x90a6ca84.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * peerSelfLocated#f8ec284b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerSelfLocated() : TLAbsPeerLocated() {
    override var expires: Int = 0

    private val _constructor: String = "peerSelfLocated#f8ec284b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(expires: Int) : this() {
        this.expires = expires
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(expires)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        expires = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerSelfLocated) return false
        if (other === this) return true

        return expires == other.expires
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf8ec284b.toInt()
    }
}

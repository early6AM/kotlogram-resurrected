package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesGetPeerMaxIDs() : TLMethod<TLIntVector>() {
    var id: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    private val _constructor: String = "stories.getPeerMaxIDs#535983c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: TLObjectVector<TLAbsInputPeer>) : this() {
        this.id = id
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLIntVector = tlDeserializer.readTLIntVector()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readTLVector<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += id.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesGetPeerMaxIDs) return false
        if (other === this) return true

        return id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x535983c3.toInt()
    }
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputCheckPasswordSRP#d27ff082
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputCheckPasswordSRP() : TLAbsInputCheckPasswordSRP() {
    var srpId: Long = 0L

    var a: TLBytes = TLBytes.EMPTY

    var m1: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "inputCheckPasswordSRP#d27ff082"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            srpId: Long,
            a: TLBytes,
            m1: TLBytes
    ) : this() {
        this.srpId = srpId
        this.a = a
        this.m1 = m1
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(srpId)
        writeTLBytes(a)
        writeTLBytes(m1)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        srpId = readLong()
        a = readTLBytes()
        m1 = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(a)
        size += computeTLBytesSerializedSize(m1)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputCheckPasswordSRP) return false
        if (other === this) return true

        return srpId == other.srpId
                && a == other.a
                && m1 == other.m1
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd27ff082.toInt()
    }
}

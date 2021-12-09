package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updatePhoneCallSignalingData#2661bf09
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePhoneCallSignalingData() : TLAbsUpdate() {
    var phoneCallId: Long = 0L

    var data: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "updatePhoneCallSignalingData#2661bf09"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneCallId: Long, data: TLBytes) : this() {
        this.phoneCallId = phoneCallId
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(phoneCallId)
        writeTLBytes(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneCallId = readLong()
        data = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePhoneCallSignalingData) return false
        if (other === this) return true

        return phoneCallId == other.phoneCallId
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2661bf09
    }
}

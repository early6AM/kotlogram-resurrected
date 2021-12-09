package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * contactStatus#16d9703b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContactStatus() : TLObject() {
    var userId: Long = 0L

    var status: TLAbsUserStatus = TLUserStatusEmpty()

    private val _constructor: String = "contactStatus#16d9703b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Long, status: TLAbsUserStatus) : this() {
        this.userId = userId
        this.status = status
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeTLObject(status)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        status = readTLObject<TLAbsUserStatus>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += status.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContactStatus) return false
        if (other === this) return true

        return userId == other.userId
                && status == other.status
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x16d9703b
    }
}

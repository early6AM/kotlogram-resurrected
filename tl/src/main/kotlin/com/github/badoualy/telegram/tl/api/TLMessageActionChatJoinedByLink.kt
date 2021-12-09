package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionChatJoinedByLink#31224c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionChatJoinedByLink() : TLAbsMessageAction() {
    var inviterId: Long = 0L

    private val _constructor: String = "messageActionChatJoinedByLink#31224c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(inviterId: Long) : this() {
        this.inviterId = inviterId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(inviterId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        inviterId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionChatJoinedByLink) return false
        if (other === this) return true

        return inviterId == other.inviterId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x31224c3
    }
}

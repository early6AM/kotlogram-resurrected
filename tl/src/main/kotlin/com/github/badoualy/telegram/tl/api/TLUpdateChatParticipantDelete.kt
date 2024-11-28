package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * updateChatParticipantDelete#e32f3d77
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatParticipantDelete() : TLAbsUpdate() {
    var chatId: Long = 0L

    var userId: Long = 0L

    var version: Int = 0

    private val _constructor: String = "updateChatParticipantDelete#e32f3d77"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Long,
            userId: Long,
            version: Int
    ) : this() {
        this.chatId = chatId
        this.userId = userId
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(chatId)
        writeLong(userId)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readLong()
        userId = readLong()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatParticipantDelete) return false
        if (other === this) return true

        return chatId == other.chatId
                && userId == other.userId
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe32f3d77.toInt()
    }
}

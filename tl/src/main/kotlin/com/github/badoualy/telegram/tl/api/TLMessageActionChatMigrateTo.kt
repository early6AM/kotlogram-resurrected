package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionChatMigrateTo#e1037f92
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionChatMigrateTo() : TLAbsMessageAction() {
    var channelId: Long = 0L

    private val _constructor: String = "messageActionChatMigrateTo#e1037f92"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Long) : this() {
        this.channelId = channelId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionChatMigrateTo) return false
        if (other === this) return true

        return channelId == other.channelId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe1037f92.toInt()
    }
}

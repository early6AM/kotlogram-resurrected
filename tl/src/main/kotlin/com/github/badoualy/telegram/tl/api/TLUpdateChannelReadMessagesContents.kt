package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChannelReadMessagesContents#44bdd535
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelReadMessagesContents() : TLAbsUpdate() {
    var channelId: Long = 0L

    var messages: TLIntVector = TLIntVector()

    private val _constructor: String = "updateChannelReadMessagesContents#44bdd535"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Long, messages: TLIntVector) : this() {
        this.channelId = channelId
        this.messages = messages
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeTLVector(messages)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        messages = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += messages.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelReadMessagesContents) return false
        if (other === this) return true

        return channelId == other.channelId
                && messages == other.messages
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x44bdd535
    }
}

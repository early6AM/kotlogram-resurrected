package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsSetDiscussionGroup() : TLMethod<TLBool>() {
    var broadcast: TLAbsInputChannel = TLInputChannelEmpty()

    var group: TLAbsInputChannel = TLInputChannelEmpty()

    private val _constructor: String = "channels.setDiscussionGroup#40582bb2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(broadcast: TLAbsInputChannel, group: TLAbsInputChannel) : this() {
        this.broadcast = broadcast
        this.group = group
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(broadcast)
        writeTLObject(group)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        broadcast = readTLObject<TLAbsInputChannel>()
        group = readTLObject<TLAbsInputChannel>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += broadcast.computeSerializedSize()
        size += group.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsSetDiscussionGroup) return false
        if (other === this) return true

        return broadcast == other.broadcast
                && group == other.group
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40582bb2
    }
}

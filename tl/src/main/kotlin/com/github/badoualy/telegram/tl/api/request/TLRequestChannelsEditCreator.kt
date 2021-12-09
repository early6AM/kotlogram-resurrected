package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.TLInputCheckPasswordEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsEditCreator() : TLMethod<TLAbsUpdates>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var userId: TLAbsInputUser = TLInputUserEmpty()

    var password: TLAbsInputCheckPasswordSRP = TLInputCheckPasswordEmpty()

    private val _constructor: String = "channels.editCreator#8f38cd1f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            password: TLAbsInputCheckPasswordSRP
    ) : this() {
        this.channel = channel
        this.userId = userId
        this.password = password
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(userId)
        writeTLObject(password)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        userId = readTLObject<TLAbsInputUser>()
        password = readTLObject<TLAbsInputCheckPasswordSRP>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += userId.computeSerializedSize()
        size += password.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsEditCreator) return false
        if (other === this) return true

        return channel == other.channel
                && userId == other.userId
                && password == other.password
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8f38cd1f.toInt()
    }
}

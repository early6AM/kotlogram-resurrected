package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLSponsoredMessage
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
 * messages.sponsoredMessages#c9ee1d87
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSponsoredMessages() : TLAbsSponsoredMessages() {
    var postsBetween: Int? = null

    var messages: TLObjectVector<TLSponsoredMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.sponsoredMessages#c9ee1d87"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            postsBetween: Int?,
            messages: TLObjectVector<TLSponsoredMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.postsBetween = postsBetween
        this.messages = messages
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(postsBetween, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(postsBetween, 1) { writeInt(it) }
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        postsBetween = readIfMask(1) { readInt() }
        messages = readTLVector<TLSponsoredMessage>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(postsBetween, 1) { SIZE_INT32 }
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSponsoredMessages) return false
        if (other === this) return true

        return _flags == other._flags
                && postsBetween == other.postsBetween
                && messages == other.messages
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9ee1d87.toInt()
    }
}

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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * requestPeerTypeBroadcast#339bef6c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPeerTypeBroadcast() : TLAbsRequestPeerType() {
    @Transient
    var creator: Boolean = false

    var hasUsername: Boolean? = null

    var userAdminRights: TLChatAdminRights? = null

    var botAdminRights: TLChatAdminRights? = null

    private val _constructor: String = "requestPeerTypeBroadcast#339bef6c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            hasUsername: Boolean?,
            userAdminRights: TLChatAdminRights?,
            botAdminRights: TLChatAdminRights?
    ) : this() {
        this.creator = creator
        this.hasUsername = hasUsername
        this.userAdminRights = userAdminRights
        this.botAdminRights = botAdminRights
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(hasUsername, 8)
        updateFlags(userAdminRights, 2)
        updateFlags(botAdminRights, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(hasUsername, 8) { writeBoolean(it) }
        doIfMask(userAdminRights, 2) { writeTLObject(it) }
        doIfMask(botAdminRights, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        hasUsername = readIfMask(8) { readBoolean() }
        userAdminRights = readIfMask(2) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        botAdminRights = readIfMask(4) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(hasUsername, 8) { SIZE_BOOLEAN }
        size += getIntIfMask(userAdminRights, 2) { it.computeSerializedSize() }
        size += getIntIfMask(botAdminRights, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPeerTypeBroadcast) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && hasUsername == other.hasUsername
                && userAdminRights == other.userAdminRights
                && botAdminRights == other.botAdminRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x339bef6c.toInt()
    }
}

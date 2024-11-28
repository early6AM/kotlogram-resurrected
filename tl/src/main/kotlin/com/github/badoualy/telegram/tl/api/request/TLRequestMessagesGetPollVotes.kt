package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLVotesList
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetPollVotes() : TLMethod<TLVotesList>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var option: TLBytes? = null

    var offset: String? = null

    var limit: Int = 0

    private val _constructor: String = "messages.getPollVotes#b86e380e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            id: Int,
            option: TLBytes?,
            offset: String?,
            limit: Int
    ) : this() {
        this.peer = peer
        this.id = id
        this.option = option
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLVotesList = tlDeserializer.readTLObject(TLVotesList::class, TLVotesList.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(option, 1)
        updateFlags(offset, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(option, 1) { writeTLBytes(it) }
        doIfMask(offset, 2) { writeString(it) }
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        option = readIfMask(1) { readTLBytes() }
        offset = readIfMask(2) { readString() }
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(option, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(offset, 2) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetPollVotes) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && id == other.id
                && option == other.option
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb86e380e.toInt()
    }
}

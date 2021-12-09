package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsMessageUserVote
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.votesList#823f649
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLVotesList() : TLObject() {
    var count: Int = 0

    var votes: TLObjectVector<TLAbsMessageUserVote> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var nextOffset: String? = null

    private val _constructor: String = "messages.votesList#823f649"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            votes: TLObjectVector<TLAbsMessageUserVote>,
            users: TLObjectVector<TLAbsUser>,
            nextOffset: String?
    ) : this() {
        this.count = count
        this.votes = votes
        this.users = users
        this.nextOffset = nextOffset
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(nextOffset, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeTLVector(votes)
        writeTLVector(users)
        doIfMask(nextOffset, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        count = readInt()
        votes = readTLVector<TLAbsMessageUserVote>()
        users = readTLVector<TLAbsUser>()
        nextOffset = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += votes.computeSerializedSize()
        size += users.computeSerializedSize()
        size += getIntIfMask(nextOffset, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLVotesList) return false
        if (other === this) return true

        return _flags == other._flags
                && count == other.count
                && votes == other.votes
                && users == other.users
                && nextOffset == other.nextOffset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x823f649
    }
}

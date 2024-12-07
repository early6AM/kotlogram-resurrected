package com.github.badoualy.telegram.tl.api.stories

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLPeerStories
import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * stories.allStories#6efc5e81
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAllStories() : TLAbsAllStories() {
    @Transient
    var hasMore: Boolean = false

    var count: Int = 0

    override var state: String = ""

    var peerStories: TLObjectVector<TLPeerStories> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    override var stealthMode: TLStoriesStealthMode = TLStoriesStealthMode()

    private val _constructor: String = "stories.allStories#6efc5e81"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasMore: Boolean,
            count: Int,
            state: String,
            peerStories: TLObjectVector<TLPeerStories>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            stealthMode: TLStoriesStealthMode
    ) : this() {
        this.hasMore = hasMore
        this.count = count
        this.state = state
        this.peerStories = peerStories
        this.chats = chats
        this.users = users
        this.stealthMode = stealthMode
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(hasMore, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeString(state)
        writeTLVector(peerStories)
        writeTLVector(chats)
        writeTLVector(users)
        writeTLObject(stealthMode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasMore = isMask(1, 1)
        count = readInt()
        state = readString()
        peerStories = readTLVector<TLPeerStories>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        stealthMode = readTLObject<TLStoriesStealthMode>(TLStoriesStealthMode::class, TLStoriesStealthMode.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(state)
        size += peerStories.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += stealthMode.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAllStories) return false
        if (other === this) return true

        return _flags == other._flags
                && hasMore == other.hasMore
                && count == other.count
                && state == other.state
                && peerStories == other.peerStories
                && chats == other.chats
                && users == other.users
                && stealthMode == other.stealthMode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6efc5e81.toInt()
    }
}

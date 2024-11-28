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
import com.github.badoualy.telegram.tl.api.stories.TLStoryViewsList
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesGetStoryViewsList() : TLMethod<TLStoryViewsList>() {
    @Transient
    var justContacts: Boolean = false

    @Transient
    var reactionsFirst: Boolean = false

    @Transient
    var forwardsFirst: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var q: String? = null

    var id: Int = 0

    var offset: String = ""

    var limit: Int = 0

    private val _constructor: String = "stories.getStoryViewsList#7ed23c57"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            justContacts: Boolean,
            reactionsFirst: Boolean,
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            q: String?,
            id: Int,
            offset: String,
            limit: Int
    ) : this() {
        this.justContacts = justContacts
        this.reactionsFirst = reactionsFirst
        this.forwardsFirst = forwardsFirst
        this.peer = peer
        this.q = q
        this.id = id
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStoryViewsList = tlDeserializer.readTLObject(TLStoryViewsList::class, TLStoryViewsList.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(justContacts, 1)
        updateFlags(reactionsFirst, 4)
        updateFlags(forwardsFirst, 8)
        updateFlags(q, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(q, 2) { writeString(it) }
        writeInt(id)
        writeString(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        justContacts = isMask(1)
        reactionsFirst = isMask(4)
        forwardsFirst = isMask(8)
        peer = readTLObject<TLAbsInputPeer>()
        q = readIfMask(2) { readString() }
        id = readInt()
        offset = readString()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(q, 2) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += computeTLStringSerializedSize(offset)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesGetStoryViewsList) return false
        if (other === this) return true

        return _flags == other._flags
                && justContacts == other.justContacts
                && reactionsFirst == other.reactionsFirst
                && forwardsFirst == other.forwardsFirst
                && peer == other.peer
                && q == other.q
                && id == other.id
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7ed23c57.toInt()
    }
}

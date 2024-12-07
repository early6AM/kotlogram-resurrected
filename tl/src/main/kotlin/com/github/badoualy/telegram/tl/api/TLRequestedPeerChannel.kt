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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * requestedPeerChannel#8ba403e4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestedPeerChannel() : TLAbsRequestedPeer() {
    var channelId: Long = 0L

    var title: String? = null

    var username: String? = null

    override var photo: TLAbsPhoto? = null

    private val _constructor: String = "requestedPeerChannel#8ba403e4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            title: String?,
            username: String?,
            photo: TLAbsPhoto?
    ) : this() {
        this.channelId = channelId
        this.title = title
        this.username = username
        this.photo = photo
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(title, 1)
        updateFlags(username, 2)
        updateFlags(photo, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(channelId)
        doIfMask(1, title, 1) { writeString(it) }
        doIfMask(1, username, 2) { writeString(it) }
        doIfMask(1, photo, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channelId = readLong()
        title = readIfMask(1, 1) { readString() }
        username = readIfMask(1, 2) { readString() }
        photo = readIfMask(1, 4) { readTLObject<TLAbsPhoto>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, username, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, photo, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestedPeerChannel) return false
        if (other === this) return true

        return _flags == other._flags
                && channelId == other.channelId
                && title == other.title
                && username == other.username
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8ba403e4.toInt()
    }
}

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
 * requestedPeerChat#7307544f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestedPeerChat() : TLAbsRequestedPeer() {
    var chatId: Long = 0L

    var title: String? = null

    override var photo: TLAbsPhoto? = null

    private val _constructor: String = "requestedPeerChat#7307544f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Long,
            title: String?,
            photo: TLAbsPhoto?
    ) : this() {
        this.chatId = chatId
        this.title = title
        this.photo = photo
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(title, 1)
        updateFlags(photo, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(chatId)
        doIfMask(1, title, 1) { writeString(it) }
        doIfMask(1, photo, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chatId = readLong()
        title = readIfMask(1, 1) { readString() }
        photo = readIfMask(1, 4) { readTLObject<TLAbsPhoto>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, photo, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestedPeerChat) return false
        if (other === this) return true

        return _flags == other._flags
                && chatId == other.chatId
                && title == other.title
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7307544f.toInt()
    }
}

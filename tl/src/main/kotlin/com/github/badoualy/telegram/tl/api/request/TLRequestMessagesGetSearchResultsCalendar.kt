package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter
import com.github.badoualy.telegram.tl.api.TLInputMessagesFilterEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsCalendar
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
class TLRequestMessagesGetSearchResultsCalendar() : TLMethod<TLSearchResultsCalendar>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var savedPeerId: TLAbsInputPeer? = null

    var filter: TLAbsMessagesFilter = TLInputMessagesFilterEmpty()

    var offsetId: Int = 0

    var offsetDate: Int = 0

    private val _constructor: String = "messages.getSearchResultsCalendar#6aa3f6bd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            filter: TLAbsMessagesFilter,
            offsetId: Int,
            offsetDate: Int
    ) : this() {
        this.peer = peer
        this.savedPeerId = savedPeerId
        this.filter = filter
        this.offsetId = offsetId
        this.offsetDate = offsetDate
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSearchResultsCalendar = tlDeserializer.readTLObject(TLSearchResultsCalendar::class, TLSearchResultsCalendar.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(savedPeerId, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(savedPeerId, 4) { writeTLObject(it) }
        writeTLObject(filter)
        writeInt(offsetId)
        writeInt(offsetDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        savedPeerId = readIfMask(4) { readTLObject<TLAbsInputPeer>() }
        filter = readTLObject<TLAbsMessagesFilter>()
        offsetId = readInt()
        offsetDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(savedPeerId, 4) { it.computeSerializedSize() }
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetSearchResultsCalendar) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && savedPeerId == other.savedPeerId
                && filter == other.filter
                && offsetId == other.offsetId
                && offsetDate == other.offsetDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6aa3f6bd.toInt()
    }
}

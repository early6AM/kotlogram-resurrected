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
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
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
class TLRequestMessagesDeleteSavedHistory() : TLMethod<TLAffectedHistory>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var maxId: Int = 0

    var minDate: Int? = null

    var maxDate: Int? = null

    private val _constructor: String = "messages.deleteSavedHistory#6e98102b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            maxId: Int,
            minDate: Int?,
            maxDate: Int?
    ) : this() {
        this.peer = peer
        this.maxId = maxId
        this.minDate = minDate
        this.maxDate = maxDate
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAffectedHistory = tlDeserializer.readTLObject(TLAffectedHistory::class, TLAffectedHistory.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(minDate, 4)
        updateFlags(maxDate, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(maxId)
        doIfMask(1, minDate, 4) { writeInt(it) }
        doIfMask(1, maxDate, 8) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        maxId = readInt()
        minDate = readIfMask(1, 4) { readInt() }
        maxDate = readIfMask(1, 8) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, minDate, 4) { SIZE_INT32 }
        size += getIntIfMask(1, maxDate, 8) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesDeleteSavedHistory) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && maxId == other.maxId
                && minDate == other.minDate
                && maxDate == other.maxDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6e98102b.toInt()
    }
}

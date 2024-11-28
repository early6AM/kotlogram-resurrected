package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
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
class TLRequestMessagesExportChatInvite() : TLMethod<TLAbsExportedChatInvite>() {
    @Transient
    var legacyRevokePermanent: Boolean = false

    @Transient
    var requestNeeded: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var expireDate: Int? = null

    var usageLimit: Int? = null

    var title: String? = null

    private val _constructor: String = "messages.exportChatInvite#a02ce5d5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            legacyRevokePermanent: Boolean,
            requestNeeded: Boolean,
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?,
            title: String?
    ) : this() {
        this.legacyRevokePermanent = legacyRevokePermanent
        this.requestNeeded = requestNeeded
        this.peer = peer
        this.expireDate = expireDate
        this.usageLimit = usageLimit
        this.title = title
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(legacyRevokePermanent, 4)
        updateFlags(requestNeeded, 8)
        updateFlags(expireDate, 1)
        updateFlags(usageLimit, 2)
        updateFlags(title, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(expireDate, 1) { writeInt(it) }
        doIfMask(usageLimit, 2) { writeInt(it) }
        doIfMask(title, 16) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        legacyRevokePermanent = isMask(4)
        requestNeeded = isMask(8)
        peer = readTLObject<TLAbsInputPeer>()
        expireDate = readIfMask(1) { readInt() }
        usageLimit = readIfMask(2) { readInt() }
        title = readIfMask(16) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(expireDate, 1) { SIZE_INT32 }
        size += getIntIfMask(usageLimit, 2) { SIZE_INT32 }
        size += getIntIfMask(title, 16) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesExportChatInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && legacyRevokePermanent == other.legacyRevokePermanent
                && requestNeeded == other.requestNeeded
                && peer == other.peer
                && expireDate == other.expireDate
                && usageLimit == other.usageLimit
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa02ce5d5.toInt()
    }
}

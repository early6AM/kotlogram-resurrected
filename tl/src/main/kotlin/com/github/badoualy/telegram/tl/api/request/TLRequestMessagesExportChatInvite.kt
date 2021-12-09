package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLChatInviteExported
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesExportChatInvite() : TLMethod<TLChatInviteExported>() {
    @Transient
    var legacyRevokePermanent: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var expireDate: Int? = null

    var usageLimit: Int? = null

    private val _constructor: String = "messages.exportChatInvite#14b9bcd7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            legacyRevokePermanent: Boolean,
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?
    ) : this() {
        this.legacyRevokePermanent = legacyRevokePermanent
        this.peer = peer
        this.expireDate = expireDate
        this.usageLimit = usageLimit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLChatInviteExported = tlDeserializer.readTLObject(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID)

    override fun computeFlags() {
        _flags = 0
        updateFlags(legacyRevokePermanent, 4)
        updateFlags(expireDate, 1)
        updateFlags(usageLimit, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(expireDate, 1) { writeInt(it) }
        doIfMask(usageLimit, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        legacyRevokePermanent = isMask(4)
        peer = readTLObject<TLAbsInputPeer>()
        expireDate = readIfMask(1) { readInt() }
        usageLimit = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(expireDate, 1) { SIZE_INT32 }
        size += getIntIfMask(usageLimit, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesExportChatInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && legacyRevokePermanent == other.legacyRevokePermanent
                && peer == other.peer
                && expireDate == other.expireDate
                && usageLimit == other.usageLimit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x14b9bcd7
    }
}

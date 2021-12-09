package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsPeer
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLPeerChat
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * help.promoData#8c39793f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPromoData() : TLAbsPromoData() {
    @Transient
    var proxy: Boolean = false

    override var expires: Int = 0

    var peer: TLAbsPeer = TLPeerChat()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var psaType: String? = null

    var psaMessage: String? = null

    private val _constructor: String = "help.promoData#8c39793f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            proxy: Boolean,
            expires: Int,
            peer: TLAbsPeer,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            psaType: String?,
            psaMessage: String?
    ) : this() {
        this.proxy = proxy
        this.expires = expires
        this.peer = peer
        this.chats = chats
        this.users = users
        this.psaType = psaType
        this.psaMessage = psaMessage
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(proxy, 1)
        updateFlags(psaType, 2)
        updateFlags(psaMessage, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(expires)
        writeTLObject(peer)
        writeTLVector(chats)
        writeTLVector(users)
        doIfMask(psaType, 2) { writeString(it) }
        doIfMask(psaMessage, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        proxy = isMask(1)
        expires = readInt()
        peer = readTLObject<TLAbsPeer>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        psaType = readIfMask(2) { readString() }
        psaMessage = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += getIntIfMask(psaType, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(psaMessage, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPromoData) return false
        if (other === this) return true

        return _flags == other._flags
                && proxy == other.proxy
                && expires == other.expires
                && peer == other.peer
                && chats == other.chats
                && users == other.users
                && psaType == other.psaType
                && psaMessage == other.psaMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c39793f.toInt()
    }
}

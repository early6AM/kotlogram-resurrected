package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAutoSaveSettings
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestAccountSaveAutoSaveSettings() : TLMethod<TLBool>() {
    @Transient
    var users: Boolean = false

    @Transient
    var chats: Boolean = false

    @Transient
    var broadcasts: Boolean = false

    var peer: TLAbsInputPeer? = null

    var settings: TLAutoSaveSettings = TLAutoSaveSettings()

    private val _constructor: String = "account.saveAutoSaveSettings#d69b8361"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            users: Boolean,
            chats: Boolean,
            broadcasts: Boolean,
            peer: TLAbsInputPeer?,
            settings: TLAutoSaveSettings
    ) : this() {
        this.users = users
        this.chats = chats
        this.broadcasts = broadcasts
        this.peer = peer
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(users, 1)
        updateFlags(chats, 2)
        updateFlags(broadcasts, 4)
        updateFlags(peer, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(peer, 8) { writeTLObject(it) }
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        users = isMask(1)
        chats = isMask(2)
        broadcasts = isMask(4)
        peer = readIfMask(8) { readTLObject<TLAbsInputPeer>() }
        settings = readTLObject<TLAutoSaveSettings>(TLAutoSaveSettings::class, TLAutoSaveSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(peer, 8) { it.computeSerializedSize() }
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSaveAutoSaveSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && users == other.users
                && chats == other.chats
                && broadcasts == other.broadcasts
                && peer == other.peer
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd69b8361.toInt()
    }
}

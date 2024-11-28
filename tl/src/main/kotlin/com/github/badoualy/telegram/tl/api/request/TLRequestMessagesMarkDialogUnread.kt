package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDialogPeer
import com.github.badoualy.telegram.tl.api.TLInputDialogPeer
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
class TLRequestMessagesMarkDialogUnread() : TLMethod<TLBool>() {
    @Transient
    var unread: Boolean = false

    var peer: TLAbsInputDialogPeer = TLInputDialogPeer()

    private val _constructor: String = "messages.markDialogUnread#c286d98f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(unread: Boolean, peer: TLAbsInputDialogPeer) : this() {
        this.unread = unread
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(unread, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        unread = isMask(1)
        peer = readTLObject<TLAbsInputDialogPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesMarkDialogUnread) return false
        if (other === this) return true

        return _flags == other._flags
                && unread == other.unread
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc286d98f.toInt()
    }
}

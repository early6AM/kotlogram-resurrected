package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChatReactions
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLChatReactionsNone
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSetChatAvailableReactions() : TLMethod<TLAbsUpdates>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var availableReactions: TLAbsChatReactions = TLChatReactionsNone()

    private val _constructor: String = "messages.setChatAvailableReactions#feb16771"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsInputPeer, availableReactions: TLAbsChatReactions) : this() {
        this.peer = peer
        this.availableReactions = availableReactions
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(availableReactions)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        availableReactions = readTLObject<TLAbsChatReactions>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += availableReactions.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetChatAvailableReactions) return false
        if (other === this) return true

        return peer == other.peer
                && availableReactions == other.availableReactions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfeb16771.toInt()
    }
}

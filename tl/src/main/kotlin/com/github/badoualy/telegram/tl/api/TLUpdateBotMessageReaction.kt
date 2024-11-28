package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBotMessageReaction#ac21d3ce
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotMessageReaction() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var msgId: Int = 0

    var date: Int = 0

    var actor: TLAbsPeer = TLPeerChat()

    var oldReactions: TLObjectVector<TLAbsReaction> = TLObjectVector()

    var newReactions: TLObjectVector<TLAbsReaction> = TLObjectVector()

    var qts: Int = 0

    private val _constructor: String = "updateBotMessageReaction#ac21d3ce"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            msgId: Int,
            date: Int,
            actor: TLAbsPeer,
            oldReactions: TLObjectVector<TLAbsReaction>,
            newReactions: TLObjectVector<TLAbsReaction>,
            qts: Int
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.date = date
        this.actor = actor
        this.oldReactions = oldReactions
        this.newReactions = newReactions
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(msgId)
        writeInt(date)
        writeTLObject(actor)
        writeTLVector(oldReactions)
        writeTLVector(newReactions)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        msgId = readInt()
        date = readInt()
        actor = readTLObject<TLAbsPeer>()
        oldReactions = readTLVector<TLAbsReaction>()
        newReactions = readTLVector<TLAbsReaction>()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += actor.computeSerializedSize()
        size += oldReactions.computeSerializedSize()
        size += newReactions.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotMessageReaction) return false
        if (other === this) return true

        return peer == other.peer
                && msgId == other.msgId
                && date == other.date
                && actor == other.actor
                && oldReactions == other.oldReactions
                && newReactions == other.newReactions
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xac21d3ce.toInt()
    }
}

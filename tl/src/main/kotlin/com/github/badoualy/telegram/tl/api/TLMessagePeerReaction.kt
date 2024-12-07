package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * messagePeerReaction#8c79b63c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessagePeerReaction() : TLObject() {
    @Transient
    var big: Boolean = false

    @Transient
    var unread: Boolean = false

    @Transient
    var my: Boolean = false

    var peerId: TLAbsPeer = TLPeerChat()

    var date: Int = 0

    var reaction: TLAbsReaction = TLReactionEmpty()

    private val _constructor: String = "messagePeerReaction#8c79b63c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            big: Boolean,
            unread: Boolean,
            my: Boolean,
            peerId: TLAbsPeer,
            date: Int,
            reaction: TLAbsReaction
    ) : this() {
        this.big = big
        this.unread = unread
        this.my = my
        this.peerId = peerId
        this.date = date
        this.reaction = reaction
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(big, 1)
        updateFlags(unread, 2)
        updateFlags(my, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peerId)
        writeInt(date)
        writeTLObject(reaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        big = isMask(1, 1)
        unread = isMask(1, 2)
        my = isMask(1, 4)
        peerId = readTLObject<TLAbsPeer>()
        date = readInt()
        reaction = readTLObject<TLAbsReaction>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peerId.computeSerializedSize()
        size += SIZE_INT32
        size += reaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessagePeerReaction) return false
        if (other === this) return true

        return _flags == other._flags
                && big == other.big
                && unread == other.unread
                && my == other.my
                && peerId == other.peerId
                && date == other.date
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c79b63c.toInt()
    }
}

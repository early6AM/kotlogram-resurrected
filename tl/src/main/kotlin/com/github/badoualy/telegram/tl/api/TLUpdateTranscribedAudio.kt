package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updateTranscribedAudio#84cd5a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateTranscribedAudio() : TLAbsUpdate() {
    @Transient
    var pending: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var msgId: Int = 0

    var transcriptionId: Long = 0L

    var text: String = ""

    private val _constructor: String = "updateTranscribedAudio#84cd5a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pending: Boolean,
            peer: TLAbsPeer,
            msgId: Int,
            transcriptionId: Long,
            text: String
    ) : this() {
        this.pending = pending
        this.peer = peer
        this.msgId = msgId
        this.transcriptionId = transcriptionId
        this.text = text
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pending, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(msgId)
        writeLong(transcriptionId)
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pending = isMask(1)
        peer = readTLObject<TLAbsPeer>()
        msgId = readInt()
        transcriptionId = readLong()
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateTranscribedAudio) return false
        if (other === this) return true

        return _flags == other._flags
                && pending == other.pending
                && peer == other.peer
                && msgId == other.msgId
                && transcriptionId == other.transcriptionId
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x84cd5a.toInt()
    }
}

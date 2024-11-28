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
import kotlin.jvm.Transient

/**
 * dialogFilterChatlist#d64a04a8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialogFilterChatlist() : TLAbsDialogFilter() {
    @Transient
    var hasMyInvites: Boolean = false

    var id: Int = 0

    var title: String = ""

    var emoticon: String? = null

    var pinnedPeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    var includePeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    private val _constructor: String = "dialogFilterChatlist#d64a04a8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasMyInvites: Boolean,
            id: Int,
            title: String,
            emoticon: String?,
            pinnedPeers: TLObjectVector<TLAbsInputPeer>,
            includePeers: TLObjectVector<TLAbsInputPeer>
    ) : this() {
        this.hasMyInvites = hasMyInvites
        this.id = id
        this.title = title
        this.emoticon = emoticon
        this.pinnedPeers = pinnedPeers
        this.includePeers = includePeers
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasMyInvites, 67108864)
        updateFlags(emoticon, 33554432)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(title)
        doIfMask(emoticon, 33554432) { writeString(it) }
        writeTLVector(pinnedPeers)
        writeTLVector(includePeers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasMyInvites = isMask(67108864)
        id = readInt()
        title = readString()
        emoticon = readIfMask(33554432) { readString() }
        pinnedPeers = readTLVector<TLAbsInputPeer>()
        includePeers = readTLVector<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(emoticon, 33554432) { computeTLStringSerializedSize(it) }
        size += pinnedPeers.computeSerializedSize()
        size += includePeers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialogFilterChatlist) return false
        if (other === this) return true

        return _flags == other._flags
                && hasMyInvites == other.hasMyInvites
                && id == other.id
                && title == other.title
                && emoticon == other.emoticon
                && pinnedPeers == other.pinnedPeers
                && includePeers == other.includePeers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd64a04a8.toInt()
    }
}

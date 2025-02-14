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
 * dialogFilter#7438f7e8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialogFilter() : TLAbsDialogFilter() {
    @Transient
    var contacts: Boolean = false

    @Transient
    var nonContacts: Boolean = false

    @Transient
    var groups: Boolean = false

    @Transient
    var broadcasts: Boolean = false

    @Transient
    var bots: Boolean = false

    @Transient
    var excludeMuted: Boolean = false

    @Transient
    var excludeRead: Boolean = false

    @Transient
    var excludeArchived: Boolean = false

    var id: Int = 0

    var title: String = ""

    var emoticon: String? = null

    var pinnedPeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    var includePeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    var excludePeers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    private val _constructor: String = "dialogFilter#7438f7e8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            contacts: Boolean,
            nonContacts: Boolean,
            groups: Boolean,
            broadcasts: Boolean,
            bots: Boolean,
            excludeMuted: Boolean,
            excludeRead: Boolean,
            excludeArchived: Boolean,
            id: Int,
            title: String,
            emoticon: String?,
            pinnedPeers: TLObjectVector<TLAbsInputPeer>,
            includePeers: TLObjectVector<TLAbsInputPeer>,
            excludePeers: TLObjectVector<TLAbsInputPeer>
    ) : this() {
        this.contacts = contacts
        this.nonContacts = nonContacts
        this.groups = groups
        this.broadcasts = broadcasts
        this.bots = bots
        this.excludeMuted = excludeMuted
        this.excludeRead = excludeRead
        this.excludeArchived = excludeArchived
        this.id = id
        this.title = title
        this.emoticon = emoticon
        this.pinnedPeers = pinnedPeers
        this.includePeers = includePeers
        this.excludePeers = excludePeers
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(contacts, 1)
        updateFlags(nonContacts, 2)
        updateFlags(groups, 4)
        updateFlags(broadcasts, 8)
        updateFlags(bots, 16)
        updateFlags(excludeMuted, 2048)
        updateFlags(excludeRead, 4096)
        updateFlags(excludeArchived, 8192)
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
        writeTLVector(excludePeers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        contacts = isMask(1)
        nonContacts = isMask(2)
        groups = isMask(4)
        broadcasts = isMask(8)
        bots = isMask(16)
        excludeMuted = isMask(2048)
        excludeRead = isMask(4096)
        excludeArchived = isMask(8192)
        id = readInt()
        title = readString()
        emoticon = readIfMask(33554432) { readString() }
        pinnedPeers = readTLVector<TLAbsInputPeer>()
        includePeers = readTLVector<TLAbsInputPeer>()
        excludePeers = readTLVector<TLAbsInputPeer>()
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
        size += excludePeers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialogFilter) return false
        if (other === this) return true

        return _flags == other._flags
                && contacts == other.contacts
                && nonContacts == other.nonContacts
                && groups == other.groups
                && broadcasts == other.broadcasts
                && bots == other.bots
                && excludeMuted == other.excludeMuted
                && excludeRead == other.excludeRead
                && excludeArchived == other.excludeArchived
                && id == other.id
                && title == other.title
                && emoticon == other.emoticon
                && pinnedPeers == other.pinnedPeers
                && includePeers == other.includePeers
                && excludePeers == other.excludePeers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7438f7e8.toInt()
    }
}

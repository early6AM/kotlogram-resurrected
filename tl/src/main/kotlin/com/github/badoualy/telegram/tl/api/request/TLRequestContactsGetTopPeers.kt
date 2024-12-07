package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsGetTopPeers() : TLMethod<TLAbsTopPeers>() {
    @Transient
    var correspondents: Boolean = false

    @Transient
    var botsPm: Boolean = false

    @Transient
    var botsInline: Boolean = false

    @Transient
    var phoneCalls: Boolean = false

    @Transient
    var forwardUsers: Boolean = false

    @Transient
    var forwardChats: Boolean = false

    @Transient
    var groups: Boolean = false

    @Transient
    var channels: Boolean = false

    @Transient
    var botsApp: Boolean = false

    var offset: Int = 0

    var limit: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "contacts.getTopPeers#973478b6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            forwardUsers: Boolean,
            forwardChats: Boolean,
            groups: Boolean,
            channels: Boolean,
            botsApp: Boolean,
            offset: Int,
            limit: Int,
            hash: Long
    ) : this() {
        this.correspondents = correspondents
        this.botsPm = botsPm
        this.botsInline = botsInline
        this.phoneCalls = phoneCalls
        this.forwardUsers = forwardUsers
        this.forwardChats = forwardChats
        this.groups = groups
        this.channels = channels
        this.botsApp = botsApp
        this.offset = offset
        this.limit = limit
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(correspondents, 1)
        updateFlags(botsPm, 2)
        updateFlags(botsInline, 4)
        updateFlags(phoneCalls, 8)
        updateFlags(forwardUsers, 16)
        updateFlags(forwardChats, 32)
        updateFlags(groups, 1024)
        updateFlags(channels, 32768)
        updateFlags(botsApp, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(offset)
        writeInt(limit)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        correspondents = isMask(1, 1)
        botsPm = isMask(1, 2)
        botsInline = isMask(1, 4)
        phoneCalls = isMask(1, 8)
        forwardUsers = isMask(1, 16)
        forwardChats = isMask(1, 32)
        groups = isMask(1, 1024)
        channels = isMask(1, 32768)
        botsApp = isMask(1, 65536)
        offset = readInt()
        limit = readInt()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsGetTopPeers) return false
        if (other === this) return true

        return _flags == other._flags
                && correspondents == other.correspondents
                && botsPm == other.botsPm
                && botsInline == other.botsInline
                && phoneCalls == other.phoneCalls
                && forwardUsers == other.forwardUsers
                && forwardChats == other.forwardChats
                && groups == other.groups
                && channels == other.channels
                && botsApp == other.botsApp
                && offset == other.offset
                && limit == other.limit
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x973478b6.toInt()
    }
}

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
 * globalPrivacySettings#734c4ccb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGlobalPrivacySettings() : TLObject() {
    @Transient
    var archiveAndMuteNewNoncontactPeers: Boolean = false

    @Transient
    var keepArchivedUnmuted: Boolean = false

    @Transient
    var keepArchivedFolders: Boolean = false

    private val _constructor: String = "globalPrivacySettings#734c4ccb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            archiveAndMuteNewNoncontactPeers: Boolean,
            keepArchivedUnmuted: Boolean,
            keepArchivedFolders: Boolean
    ) : this() {
        this.archiveAndMuteNewNoncontactPeers = archiveAndMuteNewNoncontactPeers
        this.keepArchivedUnmuted = keepArchivedUnmuted
        this.keepArchivedFolders = keepArchivedFolders
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(archiveAndMuteNewNoncontactPeers, 1)
        updateFlags(keepArchivedUnmuted, 2)
        updateFlags(keepArchivedFolders, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        archiveAndMuteNewNoncontactPeers = isMask(1)
        keepArchivedUnmuted = isMask(2)
        keepArchivedFolders = isMask(4)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGlobalPrivacySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && archiveAndMuteNewNoncontactPeers == other.archiveAndMuteNewNoncontactPeers
                && keepArchivedUnmuted == other.keepArchivedUnmuted
                && keepArchivedFolders == other.keepArchivedFolders
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x734c4ccb.toInt()
    }
}

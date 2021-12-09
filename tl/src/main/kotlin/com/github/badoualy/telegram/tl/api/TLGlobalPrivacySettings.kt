package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * globalPrivacySettings#bea2f424
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGlobalPrivacySettings() : TLObject() {
    var archiveAndMuteNewNoncontactPeers: Boolean? = null

    private val _constructor: String = "globalPrivacySettings#bea2f424"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(archiveAndMuteNewNoncontactPeers: Boolean?) : this() {
        this.archiveAndMuteNewNoncontactPeers = archiveAndMuteNewNoncontactPeers
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(archiveAndMuteNewNoncontactPeers, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(archiveAndMuteNewNoncontactPeers, 1) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        archiveAndMuteNewNoncontactPeers = readIfMask(1) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(archiveAndMuteNewNoncontactPeers, 1) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGlobalPrivacySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && archiveAndMuteNewNoncontactPeers == other.archiveAndMuteNewNoncontactPeers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbea2f424.toInt()
    }
}

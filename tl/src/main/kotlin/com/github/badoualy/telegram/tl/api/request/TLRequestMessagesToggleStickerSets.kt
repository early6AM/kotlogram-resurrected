package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesToggleStickerSets() : TLMethod<TLBool>() {
    @Transient
    var uninstall: Boolean = false

    @Transient
    var archive: Boolean = false

    @Transient
    var unarchive: Boolean = false

    var stickersets: TLObjectVector<TLAbsInputStickerSet> = TLObjectVector()

    private val _constructor: String = "messages.toggleStickerSets#b5052fea"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            uninstall: Boolean,
            archive: Boolean,
            unarchive: Boolean,
            stickersets: TLObjectVector<TLAbsInputStickerSet>
    ) : this() {
        this.uninstall = uninstall
        this.archive = archive
        this.unarchive = unarchive
        this.stickersets = stickersets
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(uninstall, 1)
        updateFlags(archive, 2)
        updateFlags(unarchive, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(stickersets)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        uninstall = isMask(1)
        archive = isMask(2)
        unarchive = isMask(4)
        stickersets = readTLVector<TLAbsInputStickerSet>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += stickersets.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesToggleStickerSets) return false
        if (other === this) return true

        return _flags == other._flags
                && uninstall == other.uninstall
                && archive == other.archive
                && unarchive == other.unarchive
                && stickersets == other.stickersets
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb5052fea.toInt()
    }
}

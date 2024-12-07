package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSetChatWallPaper() : TLMethod<TLAbsUpdates>() {
    @Transient
    var forBoth: Boolean = false

    @Transient
    var revert: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var wallpaper: TLAbsInputWallPaper? = null

    var settings: TLWallPaperSettings? = null

    var id: Int? = null

    private val _constructor: String = "messages.setChatWallPaper#8ffacae1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forBoth: Boolean,
            revert: Boolean,
            peer: TLAbsInputPeer,
            wallpaper: TLAbsInputWallPaper?,
            settings: TLWallPaperSettings?,
            id: Int?
    ) : this() {
        this.forBoth = forBoth
        this.revert = revert
        this.peer = peer
        this.wallpaper = wallpaper
        this.settings = settings
        this.id = id
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(forBoth, 8)
        updateFlags(revert, 16)
        updateFlags(wallpaper, 1)
        updateFlags(settings, 4)
        updateFlags(id, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(1, wallpaper, 1) { writeTLObject(it) }
        doIfMask(1, settings, 4) { writeTLObject(it) }
        doIfMask(1, id, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forBoth = isMask(1, 8)
        revert = isMask(1, 16)
        peer = readTLObject<TLAbsInputPeer>()
        wallpaper = readIfMask(1, 1) { readTLObject<TLAbsInputWallPaper>() }
        settings = readIfMask(1, 4) { readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID) }
        id = readIfMask(1, 2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(1, wallpaper, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, settings, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, id, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetChatWallPaper) return false
        if (other === this) return true

        return _flags == other._flags
                && forBoth == other.forBoth
                && revert == other.revert
                && peer == other.peer
                && wallpaper == other.wallpaper
                && settings == other.settings
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8ffacae1.toInt()
    }
}

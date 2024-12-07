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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updatePeerWallpaper#ae3f101d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePeerWallpaper() : TLAbsUpdate() {
    @Transient
    var wallpaperOverridden: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var wallpaper: TLAbsWallPaper? = null

    private val _constructor: String = "updatePeerWallpaper#ae3f101d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            wallpaperOverridden: Boolean,
            peer: TLAbsPeer,
            wallpaper: TLAbsWallPaper?
    ) : this() {
        this.wallpaperOverridden = wallpaperOverridden
        this.peer = peer
        this.wallpaper = wallpaper
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(wallpaperOverridden, 2)
        updateFlags(wallpaper, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(1, wallpaper, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        wallpaperOverridden = isMask(1, 2)
        peer = readTLObject<TLAbsPeer>()
        wallpaper = readIfMask(1, 1) { readTLObject<TLAbsWallPaper>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(1, wallpaper, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePeerWallpaper) return false
        if (other === this) return true

        return _flags == other._flags
                && wallpaperOverridden == other.wallpaperOverridden
                && peer == other.peer
                && wallpaper == other.wallpaper
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xae3f101d.toInt()
    }
}

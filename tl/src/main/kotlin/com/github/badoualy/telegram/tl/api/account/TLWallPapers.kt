package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.wallPapers#cdc3858c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPapers() : TLAbsWallPapers() {
    var hash: Long = 0L

    var wallpapers: TLObjectVector<TLAbsWallPaper> = TLObjectVector()

    private val _constructor: String = "account.wallPapers#cdc3858c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Long, wallpapers: TLObjectVector<TLAbsWallPaper>) : this() {
        this.hash = hash
        this.wallpapers = wallpapers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(wallpapers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        wallpapers = readTLVector<TLAbsWallPaper>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += wallpapers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPapers) return false
        if (other === this) return true

        return hash == other.hash
                && wallpapers == other.wallpapers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcdc3858c.toInt()
    }
}

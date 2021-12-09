package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetMultiWallPapers() : TLMethod<TLObjectVector<TLAbsWallPaper>>() {
    var wallpapers: TLObjectVector<TLAbsInputWallPaper> = TLObjectVector()

    private val _constructor: String = "account.getMultiWallPapers#65ad71dc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(wallpapers: TLObjectVector<TLAbsInputWallPaper>) : this() {
        this.wallpapers = wallpapers
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsWallPaper> = tlDeserializer.readTLVector<TLAbsWallPaper>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(wallpapers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        wallpapers = readTLVector<TLAbsInputWallPaper>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += wallpapers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetMultiWallPapers) return false
        if (other === this) return true

        return wallpapers == other.wallpapers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x65ad71dc
    }
}

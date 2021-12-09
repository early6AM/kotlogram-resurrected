package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper
import com.github.badoualy.telegram.tl.api.TLInputWallPaperNoFile
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetWallPaper() : TLMethod<TLAbsWallPaper>() {
    var wallpaper: TLAbsInputWallPaper = TLInputWallPaperNoFile()

    private val _constructor: String = "account.getWallPaper#fc8ddbea"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(wallpaper: TLAbsInputWallPaper) : this() {
        this.wallpaper = wallpaper
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(wallpaper)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        wallpaper = readTLObject<TLAbsInputWallPaper>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += wallpaper.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetWallPaper) return false
        if (other === this) return true

        return wallpaper == other.wallpaper
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfc8ddbea.toInt()
    }
}

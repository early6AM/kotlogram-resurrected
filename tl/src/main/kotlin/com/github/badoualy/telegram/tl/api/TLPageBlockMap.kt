package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockMap#a44f3ef6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockMap() : TLAbsPageBlock() {
    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    var zoom: Int = 0

    var w: Int = 0

    var h: Int = 0

    var caption: TLPageCaption = TLPageCaption()

    private val _constructor: String = "pageBlockMap#a44f3ef6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geo: TLAbsGeoPoint,
            zoom: Int,
            w: Int,
            h: Int,
            caption: TLPageCaption
    ) : this() {
        this.geo = geo
        this.zoom = zoom
        this.w = w
        this.h = h
        this.caption = caption
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(geo)
        writeInt(zoom)
        writeInt(w)
        writeInt(h)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        geo = readTLObject<TLAbsGeoPoint>()
        zoom = readInt()
        w = readInt()
        h = readInt()
        caption = readTLObject<TLPageCaption>(TLPageCaption::class, TLPageCaption.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += geo.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockMap) return false
        if (other === this) return true

        return geo == other.geo
                && zoom == other.zoom
                && w == other.w
                && h == other.h
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa44f3ef6.toInt()
    }
}

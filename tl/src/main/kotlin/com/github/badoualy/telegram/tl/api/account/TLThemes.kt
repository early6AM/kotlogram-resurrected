package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.TLTheme
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.themes#9a3d8c6d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLThemes() : TLAbsThemes() {
    var hash: Long = 0L

    var themes: TLObjectVector<TLTheme> = TLObjectVector()

    private val _constructor: String = "account.themes#9a3d8c6d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Long, themes: TLObjectVector<TLTheme>) : this() {
        this.hash = hash
        this.themes = themes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(themes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        themes = readTLVector<TLTheme>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += themes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLThemes) return false
        if (other === this) return true

        return hash == other.hash
                && themes == other.themes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a3d8c6d.toInt()
    }
}

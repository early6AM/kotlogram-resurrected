package com.github.badoualy.telegram.tl.api

/**
 * channelLocationEmpty#bfb5ad8b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelLocationEmpty : TLAbsChannelLocation() {
    private val _constructor: String = "channelLocationEmpty#bfb5ad8b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelLocationEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbfb5ad8b.toInt()
    }
}

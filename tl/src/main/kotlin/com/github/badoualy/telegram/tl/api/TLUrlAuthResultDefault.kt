package com.github.badoualy.telegram.tl.api

/**
 * urlAuthResultDefault#a9d6db1f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUrlAuthResultDefault : TLAbsUrlAuthResult() {
    private val _constructor: String = "urlAuthResultDefault#a9d6db1f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUrlAuthResultDefault) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa9d6db1f.toInt()
    }
}

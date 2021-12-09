package com.github.badoualy.telegram.tl.api

/**
 * inputNotifyBroadcasts#b1db7c7e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputNotifyBroadcasts : TLAbsInputNotifyPeer() {
    private val _constructor: String = "inputNotifyBroadcasts#b1db7c7e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputNotifyBroadcasts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb1db7c7e.toInt()
    }
}

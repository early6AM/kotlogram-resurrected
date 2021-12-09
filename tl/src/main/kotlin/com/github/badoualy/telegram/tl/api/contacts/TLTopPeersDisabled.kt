package com.github.badoualy.telegram.tl.api.contacts

/**
 * contacts.topPeersDisabled#b52c939d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeersDisabled : TLAbsTopPeers() {
    private val _constructor: String = "contacts.topPeersDisabled#b52c939d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeersDisabled) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb52c939d.toInt()
    }
}

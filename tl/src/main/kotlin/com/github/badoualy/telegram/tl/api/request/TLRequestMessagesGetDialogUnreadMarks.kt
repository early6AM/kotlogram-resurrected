package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLAbsDialogPeer
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetDialogUnreadMarks : TLMethod<TLObjectVector<TLAbsDialogPeer>>() {
    private val _constructor: String = "messages.getDialogUnreadMarks#22e24e22"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsDialogPeer> = tlDeserializer.readTLVector<TLAbsDialogPeer>()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetDialogUnreadMarks) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x22e24e22
    }
}

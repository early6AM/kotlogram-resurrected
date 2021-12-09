package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLSavedPhoneContact
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsGetSaved : TLMethod<TLObjectVector<TLSavedPhoneContact>>() {
    private val _constructor: String = "contacts.getSaved#82f1e39f"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLSavedPhoneContact> = tlDeserializer.readTLVector<TLSavedPhoneContact>()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsGetSaved) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x82f1e39f.toInt()
    }
}

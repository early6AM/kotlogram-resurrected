package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetPassword : TLMethod<TLPassword>() {
    private val _constructor: String = "account.getPassword#548a30f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPassword = tlDeserializer.readTLObject(TLPassword::class, TLPassword.CONSTRUCTOR_ID)

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetPassword) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x548a30f5
    }
}

package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.resetPasswordFailedWait#e3779861
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLResetPasswordFailedWait() : TLAbsResetPasswordResult() {
    var retryDate: Int = 0

    private val _constructor: String = "account.resetPasswordFailedWait#e3779861"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(retryDate: Int) : this() {
        this.retryDate = retryDate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(retryDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        retryDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLResetPasswordFailedWait) return false
        if (other === this) return true

        return retryDate == other.retryDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe3779861.toInt()
    }
}

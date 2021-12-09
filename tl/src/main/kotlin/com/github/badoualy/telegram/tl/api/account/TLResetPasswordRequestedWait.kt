package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.resetPasswordRequestedWait#e9effc7d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLResetPasswordRequestedWait() : TLAbsResetPasswordResult() {
    var untilDate: Int = 0

    private val _constructor: String = "account.resetPasswordRequestedWait#e9effc7d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(untilDate: Int) : this() {
        this.untilDate = untilDate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(untilDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        untilDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLResetPasswordRequestedWait) return false
        if (other === this) return true

        return untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe9effc7d.toInt()
    }
}

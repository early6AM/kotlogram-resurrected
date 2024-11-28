package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP
import com.github.badoualy.telegram.tl.api.TLInputCheckPasswordEmpty
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetTmpPassword() : TLMethod<TLTmpPassword>() {
    var password: TLAbsInputCheckPasswordSRP = TLInputCheckPasswordEmpty()

    var period: Int = 0

    private val _constructor: String = "account.getTmpPassword#449e0b51"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(password: TLAbsInputCheckPasswordSRP, period: Int) : this() {
        this.password = password
        this.period = period
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTmpPassword = tlDeserializer.readTLObject(TLTmpPassword::class, TLTmpPassword.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(password)
        writeInt(period)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        password = readTLObject<TLAbsInputCheckPasswordSRP>()
        period = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += password.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetTmpPassword) return false
        if (other === this) return true

        return password == other.password
                && period == other.period
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x449e0b51.toInt()
    }
}

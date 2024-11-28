package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall
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
class TLRequestPhoneGetGroupCall() : TLMethod<TLGroupCall>() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var limit: Int = 0

    private val _constructor: String = "phone.getGroupCall#41845db"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(call: TLInputGroupCall, limit: Int) : this() {
        this.call = call
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLGroupCall = tlDeserializer.readTLObject(TLGroupCall::class, TLGroupCall.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneGetGroupCall) return false
        if (other === this) return true

        return call == other.call
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x41845db.toInt()
    }
}

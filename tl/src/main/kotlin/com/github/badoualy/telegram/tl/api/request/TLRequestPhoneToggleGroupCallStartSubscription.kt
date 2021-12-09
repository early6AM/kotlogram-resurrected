package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneToggleGroupCallStartSubscription() : TLMethod<TLAbsUpdates>() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var subscribed: Boolean = false

    private val _constructor: String = "phone.toggleGroupCallStartSubscription#219c34e6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(call: TLInputGroupCall, subscribed: Boolean) : this() {
        this.call = call
        this.subscribed = subscribed
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeBoolean(subscribed)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        subscribed = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneToggleGroupCallStartSubscription) return false
        if (other === this) return true

        return call == other.call
                && subscribed == other.subscribed
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x219c34e6
    }
}

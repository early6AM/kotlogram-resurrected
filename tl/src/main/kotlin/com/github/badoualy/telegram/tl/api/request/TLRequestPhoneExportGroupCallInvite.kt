package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneExportGroupCallInvite() : TLMethod<TLExportedGroupCallInvite>() {
    @Transient
    var canSelfUnmute: Boolean = false

    var call: TLInputGroupCall = TLInputGroupCall()

    private val _constructor: String = "phone.exportGroupCallInvite#e6aa647f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(canSelfUnmute: Boolean, call: TLInputGroupCall) : this() {
        this.canSelfUnmute = canSelfUnmute
        this.call = call
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLExportedGroupCallInvite = tlDeserializer.readTLObject(TLExportedGroupCallInvite::class, TLExportedGroupCallInvite.CONSTRUCTOR_ID)

    override fun computeFlags() {
        _flags = 0
        updateFlags(canSelfUnmute, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(call)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canSelfUnmute = isMask(1)
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += call.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneExportGroupCallInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && canSelfUnmute == other.canSelfUnmute
                && call == other.call
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe6aa647f.toInt()
    }
}

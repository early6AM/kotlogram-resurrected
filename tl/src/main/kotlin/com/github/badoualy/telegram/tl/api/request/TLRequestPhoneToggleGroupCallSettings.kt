package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneToggleGroupCallSettings() : TLMethod<TLAbsUpdates>() {
    @Transient
    var resetInviteHash: Boolean = false

    var call: TLInputGroupCall = TLInputGroupCall()

    var joinMuted: Boolean? = null

    private val _constructor: String = "phone.toggleGroupCallSettings#74bbb43d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            resetInviteHash: Boolean,
            call: TLInputGroupCall,
            joinMuted: Boolean?
    ) : this() {
        this.resetInviteHash = resetInviteHash
        this.call = call
        this.joinMuted = joinMuted
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(resetInviteHash, 2)
        updateFlags(joinMuted, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(call)
        doIfMask(joinMuted, 1) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        resetInviteHash = isMask(2)
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        joinMuted = readIfMask(1) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += call.computeSerializedSize()
        size += getIntIfMask(joinMuted, 1) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneToggleGroupCallSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && resetInviteHash == other.resetInviteHash
                && call == other.call
                && joinMuted == other.joinMuted
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x74bbb43d.toInt()
    }
}

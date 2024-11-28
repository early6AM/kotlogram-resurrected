package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLPremiumGiftCodeOption
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
class TLRequestPaymentsGetPremiumGiftCodeOptions() : TLMethod<TLObjectVector<TLPremiumGiftCodeOption>>() {
    var boostPeer: TLAbsInputPeer? = null

    private val _constructor: String = "payments.getPremiumGiftCodeOptions#2757ba54"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(boostPeer: TLAbsInputPeer?) : this() {
        this.boostPeer = boostPeer
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLPremiumGiftCodeOption> = tlDeserializer.readTLVector<TLPremiumGiftCodeOption>()

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(boostPeer, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(boostPeer, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        boostPeer = readIfMask(1) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(boostPeer, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetPremiumGiftCodeOptions) return false
        if (other === this) return true

        return _flags == other._flags
                && boostPeer == other.boostPeer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2757ba54.toInt()
    }
}

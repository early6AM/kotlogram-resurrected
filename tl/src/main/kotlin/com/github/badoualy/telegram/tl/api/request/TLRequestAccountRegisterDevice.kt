package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLLongVector
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
class TLRequestAccountRegisterDevice() : TLMethod<TLBool>() {
    @Transient
    var noMuted: Boolean = false

    var tokenType: Int = 0

    var token: String = ""

    var appSandbox: Boolean = false

    var secret: TLBytes = TLBytes.EMPTY

    var otherUids: TLLongVector = TLLongVector()

    private val _constructor: String = "account.registerDevice#ec86017a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noMuted: Boolean,
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLLongVector
    ) : this() {
        this.noMuted = noMuted
        this.tokenType = tokenType
        this.token = token
        this.appSandbox = appSandbox
        this.secret = secret
        this.otherUids = otherUids
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noMuted, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(tokenType)
        writeString(token)
        writeBoolean(appSandbox)
        writeTLBytes(secret)
        writeTLVector(otherUids)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noMuted = isMask(1)
        tokenType = readInt()
        token = readString()
        appSandbox = readBoolean()
        secret = readTLBytes()
        otherUids = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(token)
        size += SIZE_BOOLEAN
        size += computeTLBytesSerializedSize(secret)
        size += otherUids.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountRegisterDevice) return false
        if (other === this) return true

        return _flags == other._flags
                && noMuted == other.noMuted
                && tokenType == other.tokenType
                && token == other.token
                && appSandbox == other.appSandbox
                && secret == other.secret
                && otherUids == other.otherUids
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xec86017a.toInt()
    }
}

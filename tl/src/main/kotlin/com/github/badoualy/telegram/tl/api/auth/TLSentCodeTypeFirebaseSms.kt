package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * auth.sentCodeTypeFirebaseSms#9fd736
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCodeTypeFirebaseSms() : TLAbsSentCodeType() {
    var nonce: TLBytes? = null

    var playIntegrityProjectId: Long? = null

    var playIntegrityNonce: TLBytes? = null

    var receipt: String? = null

    var pushTimeout: Int? = null

    var length: Int = 0

    private val _constructor: String = "auth.sentCodeTypeFirebaseSms#9fd736"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            nonce: TLBytes?,
            playIntegrityProjectId: Long?,
            playIntegrityNonce: TLBytes?,
            receipt: String?,
            pushTimeout: Int?,
            length: Int
    ) : this() {
        this.nonce = nonce
        this.playIntegrityProjectId = playIntegrityProjectId
        this.playIntegrityNonce = playIntegrityNonce
        this.receipt = receipt
        this.pushTimeout = pushTimeout
        this.length = length
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(nonce, 1)
        updateFlags(playIntegrityProjectId, 4)
        updateFlags(playIntegrityNonce, 4)
        updateFlags(receipt, 2)
        updateFlags(pushTimeout, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, nonce, 1) { writeTLBytes(it) }
        doIfMask(1, playIntegrityProjectId, 4) { writeLong(it) }
        doIfMask(1, playIntegrityNonce, 4) { writeTLBytes(it) }
        doIfMask(1, receipt, 2) { writeString(it) }
        doIfMask(1, pushTimeout, 2) { writeInt(it) }
        writeInt(length)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        nonce = readIfMask(1, 1) { readTLBytes() }
        playIntegrityProjectId = readIfMask(1, 4) { readLong() }
        playIntegrityNonce = readIfMask(1, 4) { readTLBytes() }
        receipt = readIfMask(1, 2) { readString() }
        pushTimeout = readIfMask(1, 2) { readInt() }
        length = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, nonce, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(1, playIntegrityProjectId, 4) { SIZE_INT64 }
        size += getIntIfMask(1, playIntegrityNonce, 4) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(1, receipt, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, pushTimeout, 2) { SIZE_INT32 }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCodeTypeFirebaseSms) return false
        if (other === this) return true

        return _flags == other._flags
                && nonce == other.nonce
                && playIntegrityProjectId == other.playIntegrityProjectId
                && playIntegrityNonce == other.playIntegrityNonce
                && receipt == other.receipt
                && pushTimeout == other.pushTimeout
                && length == other.length
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9fd736.toInt()
    }
}

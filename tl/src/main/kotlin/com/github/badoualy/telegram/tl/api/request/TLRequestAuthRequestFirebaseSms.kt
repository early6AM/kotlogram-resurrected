package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestAuthRequestFirebaseSms() : TLMethod<TLBool>() {
    var phoneNumber: String = ""

    var phoneCodeHash: String = ""

    var safetyNetToken: String? = null

    var playIntegrityToken: String? = null

    var iosPushSecret: String? = null

    private val _constructor: String = "auth.requestFirebaseSms#8e39261e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            phoneCodeHash: String,
            safetyNetToken: String?,
            playIntegrityToken: String?,
            iosPushSecret: String?
    ) : this() {
        this.phoneNumber = phoneNumber
        this.phoneCodeHash = phoneCodeHash
        this.safetyNetToken = safetyNetToken
        this.playIntegrityToken = playIntegrityToken
        this.iosPushSecret = iosPushSecret
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(safetyNetToken, 1)
        updateFlags(playIntegrityToken, 4)
        updateFlags(iosPushSecret, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(phoneNumber)
        writeString(phoneCodeHash)
        doIfMask(1, safetyNetToken, 1) { writeString(it) }
        doIfMask(1, playIntegrityToken, 4) { writeString(it) }
        doIfMask(1, iosPushSecret, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phoneNumber = readString()
        phoneCodeHash = readString()
        safetyNetToken = readIfMask(1, 1) { readString() }
        playIntegrityToken = readIfMask(1, 4) { readString() }
        iosPushSecret = readIfMask(1, 2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += getIntIfMask(1, safetyNetToken, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, playIntegrityToken, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, iosPushSecret, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthRequestFirebaseSms) return false
        if (other === this) return true

        return _flags == other._flags
                && phoneNumber == other.phoneNumber
                && phoneCodeHash == other.phoneCodeHash
                && safetyNetToken == other.safetyNetToken
                && playIntegrityToken == other.playIntegrityToken
                && iosPushSecret == other.iosPushSecret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8e39261e.toInt()
    }
}

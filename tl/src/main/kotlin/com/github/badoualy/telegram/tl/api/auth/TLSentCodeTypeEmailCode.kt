package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * auth.sentCodeTypeEmailCode#f450f59b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCodeTypeEmailCode() : TLAbsSentCodeType() {
    @Transient
    var appleSigninAllowed: Boolean = false

    @Transient
    var googleSigninAllowed: Boolean = false

    var emailPattern: String = ""

    var length: Int = 0

    var resetAvailablePeriod: Int? = null

    var resetPendingDate: Int? = null

    private val _constructor: String = "auth.sentCodeTypeEmailCode#f450f59b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            appleSigninAllowed: Boolean,
            googleSigninAllowed: Boolean,
            emailPattern: String,
            length: Int,
            resetAvailablePeriod: Int?,
            resetPendingDate: Int?
    ) : this() {
        this.appleSigninAllowed = appleSigninAllowed
        this.googleSigninAllowed = googleSigninAllowed
        this.emailPattern = emailPattern
        this.length = length
        this.resetAvailablePeriod = resetAvailablePeriod
        this.resetPendingDate = resetPendingDate
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(appleSigninAllowed, 1)
        updateFlags(googleSigninAllowed, 2)
        updateFlags(resetAvailablePeriod, 8)
        updateFlags(resetPendingDate, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(emailPattern)
        writeInt(length)
        doIfMask(1, resetAvailablePeriod, 8) { writeInt(it) }
        doIfMask(1, resetPendingDate, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        appleSigninAllowed = isMask(1, 1)
        googleSigninAllowed = isMask(1, 2)
        emailPattern = readString()
        length = readInt()
        resetAvailablePeriod = readIfMask(1, 8) { readInt() }
        resetPendingDate = readIfMask(1, 16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(emailPattern)
        size += SIZE_INT32
        size += getIntIfMask(1, resetAvailablePeriod, 8) { SIZE_INT32 }
        size += getIntIfMask(1, resetPendingDate, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCodeTypeEmailCode) return false
        if (other === this) return true

        return _flags == other._flags
                && appleSigninAllowed == other.appleSigninAllowed
                && googleSigninAllowed == other.googleSigninAllowed
                && emailPattern == other.emailPattern
                && length == other.length
                && resetAvailablePeriod == other.resetAvailablePeriod
                && resetPendingDate == other.resetPendingDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf450f59b.toInt()
    }
}

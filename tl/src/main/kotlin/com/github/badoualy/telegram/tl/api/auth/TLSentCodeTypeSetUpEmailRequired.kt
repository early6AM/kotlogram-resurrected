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
 * auth.sentCodeTypeSetUpEmailRequired#a5491dea
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCodeTypeSetUpEmailRequired() : TLAbsSentCodeType() {
    @Transient
    var appleSigninAllowed: Boolean = false

    @Transient
    var googleSigninAllowed: Boolean = false

    private val _constructor: String = "auth.sentCodeTypeSetUpEmailRequired#a5491dea"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(appleSigninAllowed: Boolean, googleSigninAllowed: Boolean) : this() {
        this.appleSigninAllowed = appleSigninAllowed
        this.googleSigninAllowed = googleSigninAllowed
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(appleSigninAllowed, 1)
        updateFlags(googleSigninAllowed, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        appleSigninAllowed = isMask(1)
        googleSigninAllowed = isMask(2)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCodeTypeSetUpEmailRequired) return false
        if (other === this) return true

        return _flags == other._flags
                && appleSigninAllowed == other.appleSigninAllowed
                && googleSigninAllowed == other.googleSigninAllowed
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa5491dea.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode
import com.github.badoualy.telegram.tl.api.auth.TLSentCodeSuccess
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * account.emailVerifiedLogin#e1bb0d61
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmailVerifiedLogin() : TLAbsEmailVerified() {
    override var email: String = ""

    var sentCode: TLAbsSentCode = TLSentCodeSuccess()

    private val _constructor: String = "account.emailVerifiedLogin#e1bb0d61"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(email: String, sentCode: TLAbsSentCode) : this() {
        this.email = email
        this.sentCode = sentCode
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(email)
        writeTLObject(sentCode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        email = readString()
        sentCode = readTLObject<TLAbsSentCode>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(email)
        size += sentCode.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmailVerifiedLogin) return false
        if (other === this) return true

        return email == other.email
                && sentCode == other.sentCode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe1bb0d61.toInt()
    }
}

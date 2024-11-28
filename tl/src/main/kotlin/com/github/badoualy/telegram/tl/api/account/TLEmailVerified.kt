package com.github.badoualy.telegram.tl.api.account

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

/**
 * account.emailVerified#2b96cd1b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmailVerified() : TLAbsEmailVerified() {
    override var email: String = ""

    private val _constructor: String = "account.emailVerified#2b96cd1b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(email: String) : this() {
        this.email = email
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(email)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        email = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(email)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmailVerified) return false
        if (other === this) return true

        return email == other.email
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2b96cd1b.toInt()
    }
}

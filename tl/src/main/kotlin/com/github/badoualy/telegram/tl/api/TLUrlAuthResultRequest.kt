package com.github.badoualy.telegram.tl.api

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
 * urlAuthResultRequest#92d33a0e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUrlAuthResultRequest() : TLAbsUrlAuthResult() {
    @Transient
    var requestWriteAccess: Boolean = false

    var bot: TLAbsUser = TLUserEmpty()

    var domain: String = ""

    private val _constructor: String = "urlAuthResultRequest#92d33a0e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            requestWriteAccess: Boolean,
            bot: TLAbsUser,
            domain: String
    ) : this() {
        this.requestWriteAccess = requestWriteAccess
        this.bot = bot
        this.domain = domain
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(requestWriteAccess, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(bot)
        writeString(domain)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        requestWriteAccess = isMask(1)
        bot = readTLObject<TLAbsUser>()
        domain = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += bot.computeSerializedSize()
        size += computeTLStringSerializedSize(domain)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUrlAuthResultRequest) return false
        if (other === this) return true

        return _flags == other._flags
                && requestWriteAccess == other.requestWriteAccess
                && bot == other.bot
                && domain == other.domain
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x92d33a0e.toInt()
    }
}

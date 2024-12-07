package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
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
class TLRequestChannelsGetAdminedPublicChannels() : TLMethod<TLAbsChats>() {
    @Transient
    var byLocation: Boolean = false

    @Transient
    var checkLimit: Boolean = false

    @Transient
    var forPersonal: Boolean = false

    private val _constructor: String = "channels.getAdminedPublicChannels#f8b036af"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            byLocation: Boolean,
            checkLimit: Boolean,
            forPersonal: Boolean
    ) : this() {
        this.byLocation = byLocation
        this.checkLimit = checkLimit
        this.forPersonal = forPersonal
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(byLocation, 1)
        updateFlags(checkLimit, 2)
        updateFlags(forPersonal, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        byLocation = isMask(1, 1)
        checkLimit = isMask(1, 2)
        forPersonal = isMask(1, 4)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsGetAdminedPublicChannels) return false
        if (other === this) return true

        return _flags == other._flags
                && byLocation == other.byLocation
                && checkLimit == other.checkLimit
                && forPersonal == other.forPersonal
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf8b036af.toInt()
    }
}

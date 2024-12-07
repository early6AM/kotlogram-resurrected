package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * availableEffect#93c3e27e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAvailableEffect() : TLObject() {
    @Transient
    var premiumRequired: Boolean = false

    var id: Long = 0L

    var emoticon: String = ""

    var staticIconId: Long? = null

    var effectStickerId: Long = 0L

    var effectAnimationId: Long? = null

    private val _constructor: String = "availableEffect#93c3e27e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            premiumRequired: Boolean,
            id: Long,
            emoticon: String,
            staticIconId: Long?,
            effectStickerId: Long,
            effectAnimationId: Long?
    ) : this() {
        this.premiumRequired = premiumRequired
        this.id = id
        this.emoticon = emoticon
        this.staticIconId = staticIconId
        this.effectStickerId = effectStickerId
        this.effectAnimationId = effectAnimationId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(premiumRequired, 4)
        updateFlags(staticIconId, 1)
        updateFlags(effectAnimationId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(emoticon)
        doIfMask(1, staticIconId, 1) { writeLong(it) }
        writeLong(effectStickerId)
        doIfMask(1, effectAnimationId, 2) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        premiumRequired = isMask(1, 4)
        id = readLong()
        emoticon = readString()
        staticIconId = readIfMask(1, 1) { readLong() }
        effectStickerId = readLong()
        effectAnimationId = readIfMask(1, 2) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(emoticon)
        size += getIntIfMask(1, staticIconId, 1) { SIZE_INT64 }
        size += SIZE_INT64
        size += getIntIfMask(1, effectAnimationId, 2) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAvailableEffect) return false
        if (other === this) return true

        return _flags == other._flags
                && premiumRequired == other.premiumRequired
                && id == other.id
                && emoticon == other.emoticon
                && staticIconId == other.staticIconId
                && effectStickerId == other.effectStickerId
                && effectAnimationId == other.effectAnimationId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x93c3e27e.toInt()
    }
}

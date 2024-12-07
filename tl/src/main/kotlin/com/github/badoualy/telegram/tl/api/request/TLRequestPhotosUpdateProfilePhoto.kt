package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputPhotoEmpty
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
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
class TLRequestPhotosUpdateProfilePhoto() : TLMethod<TLPhoto>() {
    @Transient
    var fallback: Boolean = false

    var bot: TLAbsInputUser? = null

    var id: TLAbsInputPhoto = TLInputPhotoEmpty()

    private val _constructor: String = "photos.updateProfilePhoto#9e82039"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fallback: Boolean,
            bot: TLAbsInputUser?,
            id: TLAbsInputPhoto
    ) : this() {
        this.fallback = fallback
        this.bot = bot
        this.id = id
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPhoto = tlDeserializer.readTLObject(TLPhoto::class, TLPhoto.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(fallback, 1)
        updateFlags(bot, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, bot, 2) { writeTLObject(it) }
        writeTLObject(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fallback = isMask(1, 1)
        bot = readIfMask(1, 2) { readTLObject<TLAbsInputUser>() }
        id = readTLObject<TLAbsInputPhoto>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, bot, 2) { it.computeSerializedSize() }
        size += id.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhotosUpdateProfilePhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && fallback == other.fallback
                && bot == other.bot
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9e82039.toInt()
    }
}

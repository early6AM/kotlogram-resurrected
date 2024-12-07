package com.github.badoualy.telegram.tl.api.smsjobs

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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * smsjobs.status#2aee9191
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStatus() : TLObject() {
    @Transient
    var allowInternational: Boolean = false

    var recentSent: Int = 0

    var recentSince: Int = 0

    var recentRemains: Int = 0

    var totalSent: Int = 0

    var totalSince: Int = 0

    var lastGiftSlug: String? = null

    var termsUrl: String = ""

    private val _constructor: String = "smsjobs.status#2aee9191"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            allowInternational: Boolean,
            recentSent: Int,
            recentSince: Int,
            recentRemains: Int,
            totalSent: Int,
            totalSince: Int,
            lastGiftSlug: String?,
            termsUrl: String
    ) : this() {
        this.allowInternational = allowInternational
        this.recentSent = recentSent
        this.recentSince = recentSince
        this.recentRemains = recentRemains
        this.totalSent = totalSent
        this.totalSince = totalSince
        this.lastGiftSlug = lastGiftSlug
        this.termsUrl = termsUrl
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(allowInternational, 1)
        updateFlags(lastGiftSlug, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(recentSent)
        writeInt(recentSince)
        writeInt(recentRemains)
        writeInt(totalSent)
        writeInt(totalSince)
        doIfMask(lastGiftSlug, 2) { writeString(it) }
        writeString(termsUrl)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        allowInternational = isMask(1)
        recentSent = readInt()
        recentSince = readInt()
        recentRemains = readInt()
        totalSent = readInt()
        totalSince = readInt()
        lastGiftSlug = readIfMask(2) { readString() }
        termsUrl = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(lastGiftSlug, 2) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(termsUrl)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStatus) return false
        if (other === this) return true

        return _flags == other._flags
                && allowInternational == other.allowInternational
                && recentSent == other.recentSent
                && recentSince == other.recentSince
                && recentRemains == other.recentRemains
                && totalSent == other.totalSent
                && totalSince == other.totalSince
                && lastGiftSlug == other.lastGiftSlug
                && termsUrl == other.termsUrl
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2aee9191.toInt()
    }
}

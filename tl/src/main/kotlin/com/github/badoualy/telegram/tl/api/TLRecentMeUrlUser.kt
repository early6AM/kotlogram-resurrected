package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * recentMeUrlUser#b92c09e2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRecentMeUrlUser() : TLAbsRecentMeUrl() {
    override var url: String = ""

    var userId: Long = 0L

    private val _constructor: String = "recentMeUrlUser#b92c09e2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(url: String, userId: Long) : this() {
        this.url = url
        this.userId = userId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeLong(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        userId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRecentMeUrlUser) return false
        if (other === this) return true

        return url == other.url
                && userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb92c09e2.toInt()
    }
}

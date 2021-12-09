package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * restrictionReason#d072acb4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRestrictionReason() : TLObject() {
    var platform: String = ""

    var reason: String = ""

    var text: String = ""

    private val _constructor: String = "restrictionReason#d072acb4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            platform: String,
            reason: String,
            text: String
    ) : this() {
        this.platform = platform
        this.reason = reason
        this.text = text
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(platform)
        writeString(reason)
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        platform = readString()
        reason = readString()
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(platform)
        size += computeTLStringSerializedSize(reason)
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRestrictionReason) return false
        if (other === this) return true

        return platform == other.platform
                && reason == other.reason
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd072acb4.toInt()
    }
}

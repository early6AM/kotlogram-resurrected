package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLBusinessChatLink
import com.github.badoualy.telegram.tl.api.TLInputBusinessChatLink
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountCreateBusinessChatLink() : TLMethod<TLBusinessChatLink>() {
    var link: TLInputBusinessChatLink = TLInputBusinessChatLink()

    private val _constructor: String = "account.createBusinessChatLink#8851e68e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(link: TLInputBusinessChatLink) : this() {
        this.link = link
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLBusinessChatLink = tlDeserializer.readTLObject(TLBusinessChatLink::class, TLBusinessChatLink.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(link)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        link = readTLObject<TLInputBusinessChatLink>(TLInputBusinessChatLink::class, TLInputBusinessChatLink.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += link.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountCreateBusinessChatLink) return false
        if (other === this) return true

        return link == other.link
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8851e68e.toInt()
    }
}

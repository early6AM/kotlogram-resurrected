package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLBankCardOpenUrl
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * payments.bankCardData#3e24e573
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBankCardData() : TLObject() {
    var title: String = ""

    var openUrls: TLObjectVector<TLBankCardOpenUrl> = TLObjectVector()

    private val _constructor: String = "payments.bankCardData#3e24e573"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(title: String, openUrls: TLObjectVector<TLBankCardOpenUrl>) : this() {
        this.title = title
        this.openUrls = openUrls
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(title)
        writeTLVector(openUrls)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        title = readString()
        openUrls = readTLVector<TLBankCardOpenUrl>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(title)
        size += openUrls.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBankCardData) return false
        if (other === this) return true

        return title == other.title
                && openUrls == other.openUrls
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3e24e573
    }
}

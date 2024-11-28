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

/**
 * keyboardButtonRequestPeer#53d7bfd8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonRequestPeer() : TLAbsKeyboardButton() {
    override var text: String = ""

    var buttonId: Int = 0

    var peerType: TLAbsRequestPeerType = TLRequestPeerTypeUser()

    var maxQuantity: Int = 0

    private val _constructor: String = "keyboardButtonRequestPeer#53d7bfd8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            text: String,
            buttonId: Int,
            peerType: TLAbsRequestPeerType,
            maxQuantity: Int
    ) : this() {
        this.text = text
        this.buttonId = buttonId
        this.peerType = peerType
        this.maxQuantity = maxQuantity
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(text)
        writeInt(buttonId)
        writeTLObject(peerType)
        writeInt(maxQuantity)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        text = readString()
        buttonId = readInt()
        peerType = readTLObject<TLAbsRequestPeerType>()
        maxQuantity = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(text)
        size += SIZE_INT32
        size += peerType.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonRequestPeer) return false
        if (other === this) return true

        return text == other.text
                && buttonId == other.buttonId
                && peerType == other.peerType
                && maxQuantity == other.maxQuantity
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x53d7bfd8.toInt()
    }
}

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
 * inputKeyboardButtonRequestPeer#c9662d05
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputKeyboardButtonRequestPeer() : TLAbsKeyboardButton() {
    @Transient
    var nameRequested: Boolean = false

    @Transient
    var usernameRequested: Boolean = false

    @Transient
    var photoRequested: Boolean = false

    override var text: String = ""

    var buttonId: Int = 0

    var peerType: TLAbsRequestPeerType = TLRequestPeerTypeUser()

    var maxQuantity: Int = 0

    private val _constructor: String = "inputKeyboardButtonRequestPeer#c9662d05"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            nameRequested: Boolean,
            usernameRequested: Boolean,
            photoRequested: Boolean,
            text: String,
            buttonId: Int,
            peerType: TLAbsRequestPeerType,
            maxQuantity: Int
    ) : this() {
        this.nameRequested = nameRequested
        this.usernameRequested = usernameRequested
        this.photoRequested = photoRequested
        this.text = text
        this.buttonId = buttonId
        this.peerType = peerType
        this.maxQuantity = maxQuantity
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nameRequested, 1)
        updateFlags(usernameRequested, 2)
        updateFlags(photoRequested, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        writeInt(buttonId)
        writeTLObject(peerType)
        writeInt(maxQuantity)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        nameRequested = isMask(1)
        usernameRequested = isMask(2)
        photoRequested = isMask(4)
        text = readString()
        buttonId = readInt()
        peerType = readTLObject<TLAbsRequestPeerType>()
        maxQuantity = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += SIZE_INT32
        size += peerType.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputKeyboardButtonRequestPeer) return false
        if (other === this) return true

        return _flags == other._flags
                && nameRequested == other.nameRequested
                && usernameRequested == other.usernameRequested
                && photoRequested == other.photoRequested
                && text == other.text
                && buttonId == other.buttonId
                && peerType == other.peerType
                && maxQuantity == other.maxQuantity
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9662d05.toInt()
    }
}

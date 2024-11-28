package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * keyboardButtonSwitchInline#93b9fbb5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonSwitchInline() : TLAbsKeyboardButton() {
    @Transient
    var samePeer: Boolean = false

    override var text: String = ""

    var query: String = ""

    var peerTypes: TLObjectVector<TLAbsInlineQueryPeerType>? = TLObjectVector()

    private val _constructor: String = "keyboardButtonSwitchInline#93b9fbb5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            samePeer: Boolean,
            text: String,
            query: String,
            peerTypes: TLObjectVector<TLAbsInlineQueryPeerType>?
    ) : this() {
        this.samePeer = samePeer
        this.text = text
        this.query = query
        this.peerTypes = peerTypes
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(samePeer, 1)
        updateFlags(peerTypes, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        writeString(query)
        doIfMask(peerTypes, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        samePeer = isMask(1)
        text = readString()
        query = readString()
        peerTypes = readIfMask(2) { readTLVector<TLAbsInlineQueryPeerType>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += computeTLStringSerializedSize(query)
        size += getIntIfMask(peerTypes, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonSwitchInline) return false
        if (other === this) return true

        return _flags == other._flags
                && samePeer == other.samePeer
                && text == other.text
                && query == other.query
                && peerTypes == other.peerTypes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x93b9fbb5.toInt()
    }
}

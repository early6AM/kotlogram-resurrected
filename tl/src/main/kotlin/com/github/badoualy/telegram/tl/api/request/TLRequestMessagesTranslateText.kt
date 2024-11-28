package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLTextWithEntities
import com.github.badoualy.telegram.tl.api.messages.TLTranslateResult
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
class TLRequestMessagesTranslateText() : TLMethod<TLTranslateResult>() {
    var peer: TLAbsInputPeer? = null

    var id: TLIntVector? = null

    var text: TLObjectVector<TLTextWithEntities>? = TLObjectVector()

    var toLang: String = ""

    private val _constructor: String = "messages.translateText#63183030"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer?,
            id: TLIntVector?,
            text: TLObjectVector<TLTextWithEntities>?,
            toLang: String
    ) : this() {
        this.peer = peer
        this.id = id
        this.text = text
        this.toLang = toLang
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTranslateResult = tlDeserializer.readTLObject(TLTranslateResult::class, TLTranslateResult.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(peer, 1)
        updateFlags(id, 1)
        updateFlags(text, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(peer, 1) { writeTLObject(it) }
        doIfMask(id, 1) { writeTLVector(it) }
        doIfMask(text, 2) { writeTLVector(it) }
        writeString(toLang)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readIfMask(1) { readTLObject<TLAbsInputPeer>() }
        id = readIfMask(1) { readTLIntVector() }
        text = readIfMask(2) { readTLVector<TLTextWithEntities>() }
        toLang = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(peer, 1) { it.computeSerializedSize() }
        size += getIntIfMask(id, 1) { it.computeSerializedSize() }
        size += getIntIfMask(text, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(toLang)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesTranslateText) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && id == other.id
                && text == other.text
                && toLang == other.toLang
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x63183030.toInt()
    }
}

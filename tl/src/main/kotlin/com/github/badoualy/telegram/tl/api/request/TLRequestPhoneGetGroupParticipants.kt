package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants
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
class TLRequestPhoneGetGroupParticipants() : TLMethod<TLGroupParticipants>() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var ids: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    var sources: TLIntVector = TLIntVector()

    var offset: String = ""

    var limit: Int = 0

    private val _constructor: String = "phone.getGroupParticipants#c558d8ab"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            call: TLInputGroupCall,
            ids: TLObjectVector<TLAbsInputPeer>,
            sources: TLIntVector,
            offset: String,
            limit: Int
    ) : this() {
        this.call = call
        this.ids = ids
        this.sources = sources
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLGroupParticipants = tlDeserializer.readTLObject(TLGroupParticipants::class, TLGroupParticipants.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeTLVector(ids)
        writeTLVector(sources)
        writeString(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        ids = readTLVector<TLAbsInputPeer>()
        sources = readTLIntVector()
        offset = readString()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += ids.computeSerializedSize()
        size += sources.computeSerializedSize()
        size += computeTLStringSerializedSize(offset)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneGetGroupParticipants) return false
        if (other === this) return true

        return call == other.call
                && ids == other.ids
                && sources == other.sources
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc558d8ab.toInt()
    }
}

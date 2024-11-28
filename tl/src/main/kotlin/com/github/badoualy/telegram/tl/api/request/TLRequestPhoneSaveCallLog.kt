package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFile
import com.github.badoualy.telegram.tl.api.TLInputFileBig
import com.github.badoualy.telegram.tl.api.TLInputPhoneCall
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestPhoneSaveCallLog() : TLMethod<TLBool>() {
    var peer: TLInputPhoneCall = TLInputPhoneCall()

    var file: TLAbsInputFile = TLInputFileBig()

    private val _constructor: String = "phone.saveCallLog#41248786"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLInputPhoneCall, file: TLAbsInputFile) : this() {
        this.peer = peer
        this.file = file
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(file)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputPhoneCall>(TLInputPhoneCall::class, TLInputPhoneCall.CONSTRUCTOR_ID)
        file = readTLObject<TLAbsInputFile>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += file.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneSaveCallLog) return false
        if (other === this) return true

        return peer == other.peer
                && file == other.file
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x41248786.toInt()
    }
}

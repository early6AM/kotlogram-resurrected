package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLAbsLoginToken
import com.github.badoualy.telegram.tl.core.TLLongVector
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
class TLRequestAuthExportLoginToken() : TLMethod<TLAbsLoginToken>() {
    var apiId: Int = 0

    var apiHash: String = ""

    var exceptIds: TLLongVector = TLLongVector()

    private val _constructor: String = "auth.exportLoginToken#b7e085fe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            apiId: Int,
            apiHash: String,
            exceptIds: TLLongVector
    ) : this() {
        this.apiId = apiId
        this.apiHash = apiHash
        this.exceptIds = exceptIds
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(apiId)
        writeString(apiHash)
        writeTLVector(exceptIds)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        apiId = readInt()
        apiHash = readString()
        exceptIds = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(apiHash)
        size += exceptIds.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthExportLoginToken) return false
        if (other === this) return true

        return apiId == other.apiId
                && apiHash == other.apiHash
                && exceptIds == other.exceptIds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb7e085fe.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * auth.loginTokenMigrateTo#68e9916
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLoginTokenMigrateTo() : TLAbsLoginToken() {
    var dcId: Int = 0

    var token: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "auth.loginTokenMigrateTo#68e9916"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(dcId: Int, token: TLBytes) : this() {
        this.dcId = dcId
        this.token = token
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(dcId)
        writeTLBytes(token)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        dcId = readInt()
        token = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(token)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLoginTokenMigrateTo) return false
        if (other === this) return true

        return dcId == other.dcId
                && token == other.token
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x68e9916.toInt()
    }
}

package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class PQInnerTemp @JvmOverloads constructor(pq: ByteArray = ByteArray(0),
                                            p: ByteArray = ByteArray(0),
                                            q: ByteArray = ByteArray(0),
                                            nonce: ByteArray = ByteArray(0),
                                            serverNonce: ByteArray = ByteArray(0),
                                            newNonce: ByteArray = ByteArray(0),
                                            var expiresIn: Int = 0)
    : PQInner(pq, p, q, nonce, serverNonce, newNonce) {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        super.serializeBody(tlSerializer)
        writeInt(expiresIn)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        super.deserializeBody(tlDeserializer)
        expiresIn = readInt()
    }

    override fun toString() = "p_q_inner_data_temp#3c6a84d4"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1013613780
    }
}

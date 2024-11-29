package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import java.io.IOException

/**
 * Basic object for RPC methods. It contains special methods for deserializing result of RPC method call.
 *
 * @param <T> return type of method
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLMethod<T : TLObject> : TLObject() {

    @Transient
    var response: T? = null

    @Throws(IOException::class)
    fun deserializeResponse(data: ByteArray, context: TLContext) =
            deserializeResponse(TLStreamDeserializer(data, context))

    @Throws(IOException::class)
    fun deserializeResponse(tlDeserializer: TLDeserializer): T {
        response = deserializeResponse_(tlDeserializer)
        println(response)
        return response!!
    }

    @Throws(IOException::class)
    protected open fun deserializeResponse_(tlDeserializer: TLDeserializer): T = tlDeserializer.readTLObject()
}
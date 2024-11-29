package com.github.badoualy.telegram

import com.github.badoualy.telegram.tl.api.TLApiContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLStreamSerializerFactory
import com.google.gson.GsonBuilder
import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex
import java.io.File
import java.io.IOException

object DecodeHexDump {

    private val gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()

    @Throws(IOException::class, DecoderException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 1) {
            System.err.println("${Thread.currentThread().id} Usage: java -jar tl-decoder.jar <input>")
            System.exit(-1)
        }
        val file = File(args[0])
        println("${Thread.currentThread().id} Using input ${file.absolutePath}")

        val payload = Hex(Charsets.UTF_8).decode(file.readText()) as ByteArray

        val tlObject = TLStreamSerializerFactory.createDeserializer(payload, TLApiContext)
                .readTLObject<TLObject>()

        println("${Thread.currentThread().id} Found ${tlObject.javaClass.canonicalName}\n\n")
        println(gson.toJson(tlObject))
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsJSONValue
import com.github.badoualy.telegram.tl.api.TLInputClientProxy
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestInitConnection<T : TLObject>() : TLMethod<T>() {
    var apiId: Int = 0

    var deviceModel: String = ""

    var systemVersion: String = ""

    var appVersion: String = ""

    var systemLangCode: String = ""

    var langPack: String = ""

    var langCode: String = ""

    var proxy: TLInputClientProxy? = null

    var params: TLAbsJSONValue? = null

    var query: TLMethod<T>? = null

    private val _constructor: String = "initConnection#c1cd5ea9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            proxy: TLInputClientProxy?,
            params: TLAbsJSONValue?,
            query: TLMethod<T>?
    ) : this() {
        this.apiId = apiId
        this.deviceModel = deviceModel
        this.systemVersion = systemVersion
        this.appVersion = appVersion
        this.systemLangCode = systemLangCode
        this.langPack = langPack
        this.langCode = langCode
        this.proxy = proxy
        this.params = params
        this.query = query
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): T = query!!.deserializeResponse(tlDeserializer)

    override fun computeFlags() {
        _flags = 0
        updateFlags(proxy, 1)
        updateFlags(params, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(apiId)
        writeString(deviceModel)
        writeString(systemVersion)
        writeString(appVersion)
        writeString(systemLangCode)
        writeString(langPack)
        writeString(langCode)
        doIfMask(proxy, 1) { writeTLObject(it) }
        doIfMask(params, 2) { writeTLObject(it) }
        writeTLMethod(query!!)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        apiId = readInt()
        deviceModel = readString()
        systemVersion = readString()
        appVersion = readString()
        systemLangCode = readString()
        langPack = readString()
        langCode = readString()
        proxy = readIfMask(1) { readTLObject<TLInputClientProxy>(TLInputClientProxy::class, TLInputClientProxy.CONSTRUCTOR_ID) }
        params = readIfMask(2) { readTLObject<TLAbsJSONValue>() }
        query = readTLMethod()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(deviceModel)
        size += computeTLStringSerializedSize(systemVersion)
        size += computeTLStringSerializedSize(appVersion)
        size += computeTLStringSerializedSize(systemLangCode)
        size += computeTLStringSerializedSize(langPack)
        size += computeTLStringSerializedSize(langCode)
        size += getIntIfMask(proxy, 1) { it.computeSerializedSize() }
        size += getIntIfMask(params, 2) { it.computeSerializedSize() }
        size += query!!.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestInitConnection<*>) return false
        if (other === this) return true

        return _flags == other._flags
                && apiId == other.apiId
                && deviceModel == other.deviceModel
                && systemVersion == other.systemVersion
                && appVersion == other.appVersion
                && systemLangCode == other.systemLangCode
                && langPack == other.langPack
                && langCode == other.langCode
                && proxy == other.proxy
                && params == other.params
                && query == other.query
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc1cd5ea9.toInt()
    }
}

package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsBotCommandScope
import com.github.badoualy.telegram.tl.api.TLBotCommand
import com.github.badoualy.telegram.tl.api.TLBotCommandScopeDefault
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
class TLRequestBotsGetBotCommands() : TLMethod<TLObjectVector<TLBotCommand>>() {
    var scope: TLAbsBotCommandScope = TLBotCommandScopeDefault()

    var langCode: String = ""

    private val _constructor: String = "bots.getBotCommands#e34c0dd6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(scope: TLAbsBotCommandScope, langCode: String) : this() {
        this.scope = scope
        this.langCode = langCode
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLBotCommand> = tlDeserializer.readTLVector<TLBotCommand>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(scope)
        writeString(langCode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        scope = readTLObject<TLAbsBotCommandScope>()
        langCode = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += scope.computeSerializedSize()
        size += computeTLStringSerializedSize(langCode)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestBotsGetBotCommands) return false
        if (other === this) return true

        return scope == other.scope
                && langCode == other.langCode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe34c0dd6.toInt()
    }
}

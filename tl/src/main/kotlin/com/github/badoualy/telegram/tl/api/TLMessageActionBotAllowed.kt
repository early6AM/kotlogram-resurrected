package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messageActionBotAllowed#c516d679
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionBotAllowed() : TLAbsMessageAction() {
    @Transient
    var attachMenu: Boolean = false

    @Transient
    var fromRequest: Boolean = false

    var domain: String? = null

    var app: TLAbsBotApp? = null

    private val _constructor: String = "messageActionBotAllowed#c516d679"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            attachMenu: Boolean,
            fromRequest: Boolean,
            domain: String?,
            app: TLAbsBotApp?
    ) : this() {
        this.attachMenu = attachMenu
        this.fromRequest = fromRequest
        this.domain = domain
        this.app = app
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(attachMenu, 2)
        updateFlags(fromRequest, 8)
        updateFlags(domain, 1)
        updateFlags(app, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, domain, 1) { writeString(it) }
        doIfMask(1, app, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        attachMenu = isMask(1, 2)
        fromRequest = isMask(1, 8)
        domain = readIfMask(1, 1) { readString() }
        app = readIfMask(1, 4) { readTLObject<TLAbsBotApp>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, domain, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, app, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionBotAllowed) return false
        if (other === this) return true

        return _flags == other._flags
                && attachMenu == other.attachMenu
                && fromRequest == other.fromRequest
                && domain == other.domain
                && app == other.app
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc516d679.toInt()
    }
}

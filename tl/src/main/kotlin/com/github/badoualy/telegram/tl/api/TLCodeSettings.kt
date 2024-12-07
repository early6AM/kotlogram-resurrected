package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.core.TLObject
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
 * codeSettings#ad253d78
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCodeSettings() : TLObject() {
    @Transient
    var allowFlashcall: Boolean = false

    @Transient
    var currentNumber: Boolean = false

    @Transient
    var allowAppHash: Boolean = false

    @Transient
    var allowMissedCall: Boolean = false

    @Transient
    var allowFirebase: Boolean = false

    @Transient
    var unknownNumber: Boolean = false

    var logoutTokens: TLBytesVector? = null

    var token: String? = null

    var appSandbox: Boolean? = null

    private val _constructor: String = "codeSettings#ad253d78"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            allowFlashcall: Boolean,
            currentNumber: Boolean,
            allowAppHash: Boolean,
            allowMissedCall: Boolean,
            allowFirebase: Boolean,
            unknownNumber: Boolean,
            logoutTokens: TLBytesVector?,
            token: String?,
            appSandbox: Boolean?
    ) : this() {
        this.allowFlashcall = allowFlashcall
        this.currentNumber = currentNumber
        this.allowAppHash = allowAppHash
        this.allowMissedCall = allowMissedCall
        this.allowFirebase = allowFirebase
        this.unknownNumber = unknownNumber
        this.logoutTokens = logoutTokens
        this.token = token
        this.appSandbox = appSandbox
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(allowFlashcall, 1)
        updateFlags(currentNumber, 2)
        updateFlags(allowAppHash, 16)
        updateFlags(allowMissedCall, 32)
        updateFlags(allowFirebase, 128)
        updateFlags(unknownNumber, 512)
        updateFlags(logoutTokens, 64)
        updateFlags(token, 256)
        // If field is not serialized force it to false
        if (appSandbox != null && !isMask(256)) appSandbox = null
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(logoutTokens, 64) { writeTLVector(it) }
        doIfMask(token, 256) { writeString(it) }
        doIfMask(appSandbox, 256) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        allowFlashcall = isMask(1)
        currentNumber = isMask(2)
        allowAppHash = isMask(16)
        allowMissedCall = isMask(32)
        allowFirebase = isMask(128)
        unknownNumber = isMask(512)
        logoutTokens = readIfMask(64) { readTLBytesVector() }
        token = readIfMask(256) { readString() }
        appSandbox = readIfMask(256) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(logoutTokens, 64) { it.computeSerializedSize() }
        size += getIntIfMask(token, 256) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(appSandbox, 256) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCodeSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && allowFlashcall == other.allowFlashcall
                && currentNumber == other.currentNumber
                && allowAppHash == other.allowAppHash
                && allowMissedCall == other.allowMissedCall
                && allowFirebase == other.allowFirebase
                && unknownNumber == other.unknownNumber
                && logoutTokens == other.logoutTokens
                && token == other.token
                && appSandbox == other.appSandbox
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xad253d78.toInt()
    }
}

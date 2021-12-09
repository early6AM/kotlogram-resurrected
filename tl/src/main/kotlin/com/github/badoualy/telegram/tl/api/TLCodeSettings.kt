package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * codeSettings#debebe83
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

    private val _constructor: String = "codeSettings#debebe83"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            allowFlashcall: Boolean,
            currentNumber: Boolean,
            allowAppHash: Boolean
    ) : this() {
        this.allowFlashcall = allowFlashcall
        this.currentNumber = currentNumber
        this.allowAppHash = allowAppHash
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(allowFlashcall, 1)
        updateFlags(currentNumber, 2)
        updateFlags(allowAppHash, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        allowFlashcall = isMask(1)
        currentNumber = isMask(2)
        allowAppHash = isMask(16)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdebebe83.toInt()
    }
}

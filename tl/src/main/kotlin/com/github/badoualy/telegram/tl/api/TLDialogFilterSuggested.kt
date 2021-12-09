package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * dialogFilterSuggested#77744d4a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDialogFilterSuggested() : TLObject() {
    var filter: TLDialogFilter = TLDialogFilter()

    var description: String = ""

    private val _constructor: String = "dialogFilterSuggested#77744d4a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(filter: TLDialogFilter, description: String) : this() {
        this.filter = filter
        this.description = description
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(filter)
        writeString(description)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        filter = readTLObject<TLDialogFilter>(TLDialogFilter::class, TLDialogFilter.CONSTRUCTOR_ID)
        description = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += filter.computeSerializedSize()
        size += computeTLStringSerializedSize(description)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDialogFilterSuggested) return false
        if (other === this) return true

        return filter == other.filter
                && description == other.description
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x77744d4a
    }
}

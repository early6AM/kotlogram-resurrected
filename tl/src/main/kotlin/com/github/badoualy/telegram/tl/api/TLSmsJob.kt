package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * smsJob#e6a1eeb8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSmsJob() : TLObject() {
    var jobId: String = ""

    var phoneNumber: String = ""

    var text: String = ""

    private val _constructor: String = "smsJob#e6a1eeb8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            jobId: String,
            phoneNumber: String,
            text: String
    ) : this() {
        this.jobId = jobId
        this.phoneNumber = phoneNumber
        this.text = text
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(jobId)
        writeString(phoneNumber)
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        jobId = readString()
        phoneNumber = readString()
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(jobId)
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSmsJob) return false
        if (other === this) return true

        return jobId == other.jobId
                && phoneNumber == other.phoneNumber
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe6a1eeb8.toInt()
    }
}

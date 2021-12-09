package com.github.badoualy.telegram.tl.api

/**
 * inputReportReasonOther#c1e4a2b1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReportReasonOther : TLAbsReportReason() {
    private val _constructor: String = "inputReportReasonOther#c1e4a2b1"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReportReasonOther) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc1e4a2b1.toInt()
    }
}

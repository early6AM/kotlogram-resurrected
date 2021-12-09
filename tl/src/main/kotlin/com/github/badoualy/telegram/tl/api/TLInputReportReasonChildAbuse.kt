package com.github.badoualy.telegram.tl.api

/**
 * inputReportReasonChildAbuse#adf44ee3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReportReasonChildAbuse : TLAbsReportReason() {
    private val _constructor: String = "inputReportReasonChildAbuse#adf44ee3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReportReasonChildAbuse) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xadf44ee3.toInt()
    }
}

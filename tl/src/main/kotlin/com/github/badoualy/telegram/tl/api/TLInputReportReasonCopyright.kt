package com.github.badoualy.telegram.tl.api

/**
 * inputReportReasonCopyright#9b89f93a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReportReasonCopyright : TLAbsReportReason() {
    private val _constructor: String = "inputReportReasonCopyright#9b89f93a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReportReasonCopyright) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9b89f93a.toInt()
    }
}

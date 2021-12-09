package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputReportReasonChildAbuse#adf44ee3][TLInputReportReasonChildAbuse]
 * * [inputReportReasonCopyright#9b89f93a][TLInputReportReasonCopyright]
 * * [inputReportReasonFake#f5ddd6e7][TLInputReportReasonFake]
 * * [inputReportReasonGeoIrrelevant#dbd4feed][TLInputReportReasonGeoIrrelevant]
 * * [inputReportReasonOther#c1e4a2b1][TLInputReportReasonOther]
 * * [inputReportReasonPornography#2e59d922][TLInputReportReasonPornography]
 * * [inputReportReasonSpam#58dbcab8][TLInputReportReasonSpam]
 * * [inputReportReasonViolence#1e22c78d][TLInputReportReasonViolence]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsReportReason : TLObject()

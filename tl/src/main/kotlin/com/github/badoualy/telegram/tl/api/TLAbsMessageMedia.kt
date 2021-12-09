package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messageMediaContact#70322949][TLMessageMediaContact]
 * * [messageMediaDice#3f7ee58b][TLMessageMediaDice]
 * * [messageMediaDocument#9cb070d7][TLMessageMediaDocument]
 * * [messageMediaEmpty#3ded6320][TLMessageMediaEmpty]
 * * [messageMediaGame#fdb19008][TLMessageMediaGame]
 * * [messageMediaGeo#56e0d474][TLMessageMediaGeo]
 * * [messageMediaGeoLive#b940c666][TLMessageMediaGeoLive]
 * * [messageMediaInvoice#84551347][TLMessageMediaInvoice]
 * * [messageMediaPhoto#695150d7][TLMessageMediaPhoto]
 * * [messageMediaPoll#4bd6e798][TLMessageMediaPoll]
 * * [messageMediaUnsupported#9f84f49e][TLMessageMediaUnsupported]
 * * [messageMediaVenue#2ec0533f][TLMessageMediaVenue]
 * * [messageMediaWebPage#a32dd600][TLMessageMediaWebPage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageMedia : TLObject()

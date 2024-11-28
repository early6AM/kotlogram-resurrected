package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messageMediaContact#70322949][TLMessageMediaContact]
 * * [messageMediaDice#3f7ee58b][TLMessageMediaDice]
 * * [messageMediaDocument#4cf4d72d][TLMessageMediaDocument]
 * * [messageMediaEmpty#3ded6320][TLMessageMediaEmpty]
 * * [messageMediaGame#fdb19008][TLMessageMediaGame]
 * * [messageMediaGeo#56e0d474][TLMessageMediaGeo]
 * * [messageMediaGeoLive#b940c666][TLMessageMediaGeoLive]
 * * [messageMediaGiveaway#daad85b0][TLMessageMediaGiveaway]
 * * [messageMediaGiveawayResults#c6991068][TLMessageMediaGiveawayResults]
 * * [messageMediaInvoice#f6a548d3][TLMessageMediaInvoice]
 * * [messageMediaPhoto#695150d7][TLMessageMediaPhoto]
 * * [messageMediaPoll#4bd6e798][TLMessageMediaPoll]
 * * [messageMediaStory#68cb6283][TLMessageMediaStory]
 * * [messageMediaUnsupported#9f84f49e][TLMessageMediaUnsupported]
 * * [messageMediaVenue#2ec0533f][TLMessageMediaVenue]
 * * [messageMediaWebPage#ddf10c3b][TLMessageMediaWebPage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageMedia : TLObject()

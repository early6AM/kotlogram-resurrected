package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputMediaContact#f8ab7dfb][TLInputMediaContact]
 * * [inputMediaDice#e66fbf7b][TLInputMediaDice]
 * * [inputMediaDocument#33473058][TLInputMediaDocument]
 * * [inputMediaDocumentExternal#fb52dc99][TLInputMediaDocumentExternal]
 * * [inputMediaEmpty#9664f57f][TLInputMediaEmpty]
 * * [inputMediaGame#d33f43f3][TLInputMediaGame]
 * * [inputMediaGeoLive#971fa843][TLInputMediaGeoLive]
 * * [inputMediaGeoPoint#f9c44144][TLInputMediaGeoPoint]
 * * [inputMediaInvoice#d9799874][TLInputMediaInvoice]
 * * [inputMediaPhoto#b3ba0635][TLInputMediaPhoto]
 * * [inputMediaPhotoExternal#e5bbfe1a][TLInputMediaPhotoExternal]
 * * [inputMediaPoll#f94e5f1][TLInputMediaPoll]
 * * [inputMediaUploadedDocument#5b38c6c1][TLInputMediaUploadedDocument]
 * * [inputMediaUploadedPhoto#1e287d04][TLInputMediaUploadedPhoto]
 * * [inputMediaVenue#c13d1c11][TLInputMediaVenue]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputMedia : TLObject()

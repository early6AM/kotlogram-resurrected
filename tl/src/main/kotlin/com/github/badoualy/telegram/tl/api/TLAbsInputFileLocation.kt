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
 * * [inputDocumentFileLocation#bad07584][TLInputDocumentFileLocation]
 * * [inputEncryptedFileLocation#f5235d55][TLInputEncryptedFileLocation]
 * * [inputFileLocation#dfdaabe1][TLInputFileLocation]
 * * [inputGroupCallStream#598a92a][TLInputGroupCallStream]
 * * [inputPeerPhotoFileLocation#37257e99][TLInputPeerPhotoFileLocation]
 * * [inputPhotoFileLocation#40181ffe][TLInputPhotoFileLocation]
 * * [inputPhotoLegacyFileLocation#d83466f3][TLInputPhotoLegacyFileLocation]
 * * [inputSecureFileLocation#cbc7ee28][TLInputSecureFileLocation]
 * * [inputStickerSetThumb#9d84f3db][TLInputStickerSetThumb]
 * * [inputTakeoutFileLocation#29be5899][TLInputTakeoutFileLocation]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputFileLocation : TLObject()

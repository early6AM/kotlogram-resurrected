package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [photoCachedSize#21e1ad6][TLPhotoCachedSize]
 * * [photoPathSize#d8214d41][TLPhotoPathSize]
 * * [photoSize#75c78e60][TLPhotoSize]
 * * [photoSizeEmpty#e17e23c][TLPhotoSizeEmpty]
 * * [photoSizeProgressive#fa3efb95][TLPhotoSizeProgressive]
 * * [photoStrippedSize#e0b0bc2e][TLPhotoStrippedSize]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhotoSize : TLObject() {
    abstract var type: String
}

package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputWebFileGeoPointLocation#9f2221c9][TLInputWebFileGeoPointLocation]
 * * [inputWebFileLocation#c239d686][TLInputWebFileLocation]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputWebFileLocation : TLObject() {
    abstract var accessHash: Long
}

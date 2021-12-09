package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [pageListOrderedItemBlocks#98dd8936][TLPageListOrderedItemBlocks]
 * * [pageListOrderedItemText#5e068047][TLPageListOrderedItemText]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPageListOrderedItem : TLObject() {
    abstract var num: String
}

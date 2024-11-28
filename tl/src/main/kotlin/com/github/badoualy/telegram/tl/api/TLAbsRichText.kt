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
 * * [textAnchor#35553762][TLTextAnchor]
 * * [textBold#6724abc4][TLTextBold]
 * * [textConcat#7e6260d7][TLTextConcat]
 * * [textEmail#de5a0dd6][TLTextEmail]
 * * [textEmpty#dc3d824f][TLTextEmpty]
 * * [textFixed#6c3f19b9][TLTextFixed]
 * * [textImage#81ccf4f][TLTextImage]
 * * [textItalic#d912a59c][TLTextItalic]
 * * [textMarked#34b8621][TLTextMarked]
 * * [textPhone#1ccb966a][TLTextPhone]
 * * [textPlain#744694e0][TLTextPlain]
 * * [textStrike#9bf8bb95][TLTextStrike]
 * * [textSubscript#ed6a8504][TLTextSubscript]
 * * [textSuperscript#c7fb5e01][TLTextSuperscript]
 * * [textUnderline#c12622c4][TLTextUnderline]
 * * [textUrl#3c2884c1][TLTextUrl]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsRichText : TLObject()

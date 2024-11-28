package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [messagePeerVote#b6cc2d5c][TLMessagePeerVote]
 * * [messagePeerVoteInputOption#74cda504][TLMessagePeerVoteInputOption]
 * * [messagePeerVoteMultiple#4628f6e6][TLMessagePeerVoteMultiple]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessagePeerVote : TLObject() {
    abstract var peer: TLAbsPeer

    abstract var date: Int
}

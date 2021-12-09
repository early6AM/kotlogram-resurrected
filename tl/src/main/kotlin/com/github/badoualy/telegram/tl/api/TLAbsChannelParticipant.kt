package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelParticipant#c00c07c0][TLChannelParticipant]
 * * [channelParticipantAdmin#34c3bb53][TLChannelParticipantAdmin]
 * * [channelParticipantBanned#6df8014e][TLChannelParticipantBanned]
 * * [channelParticipantCreator#2fe601d3][TLChannelParticipantCreator]
 * * [channelParticipantLeft#1b03f006][TLChannelParticipantLeft]
 * * [channelParticipantSelf#28a8bc67][TLChannelParticipantSelf]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelParticipant : TLObject()

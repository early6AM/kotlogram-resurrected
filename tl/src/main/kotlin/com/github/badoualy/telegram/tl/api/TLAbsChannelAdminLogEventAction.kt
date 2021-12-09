package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelAdminLogEventActionChangeAbout#55188a2e][TLChannelAdminLogEventActionChangeAbout]
 * * [channelAdminLogEventActionChangeHistoryTTL#6e941a38][TLChannelAdminLogEventActionChangeHistoryTTL]
 * * [channelAdminLogEventActionChangeLinkedChat#50c7ac8][TLChannelAdminLogEventActionChangeLinkedChat]
 * * [channelAdminLogEventActionChangeLocation#e6b76ae][TLChannelAdminLogEventActionChangeLocation]
 * * [channelAdminLogEventActionChangePhoto#434bd2af][TLChannelAdminLogEventActionChangePhoto]
 * * [channelAdminLogEventActionChangeStickerSet#b1c3caa7][TLChannelAdminLogEventActionChangeStickerSet]
 * * [channelAdminLogEventActionChangeTitle#e6dfb825][TLChannelAdminLogEventActionChangeTitle]
 * * [channelAdminLogEventActionChangeUsername#6a4afc38][TLChannelAdminLogEventActionChangeUsername]
 * * [channelAdminLogEventActionDefaultBannedRights#2df5fc0a][TLChannelAdminLogEventActionDefaultBannedRights]
 * * [channelAdminLogEventActionDeleteMessage#42e047bb][TLChannelAdminLogEventActionDeleteMessage]
 * * [channelAdminLogEventActionDiscardGroupCall#db9f9140][TLChannelAdminLogEventActionDiscardGroupCall]
 * * [channelAdminLogEventActionEditMessage#709b2405][TLChannelAdminLogEventActionEditMessage]
 * * [channelAdminLogEventActionExportedInviteDelete#5a50fca4][TLChannelAdminLogEventActionExportedInviteDelete]
 * * [channelAdminLogEventActionExportedInviteEdit#e90ebb59][TLChannelAdminLogEventActionExportedInviteEdit]
 * * [channelAdminLogEventActionExportedInviteRevoke#410a134e][TLChannelAdminLogEventActionExportedInviteRevoke]
 * * [channelAdminLogEventActionParticipantInvite#e31c34d8][TLChannelAdminLogEventActionParticipantInvite]
 * * [channelAdminLogEventActionParticipantJoin#183040d3][TLChannelAdminLogEventActionParticipantJoin]
 * * [channelAdminLogEventActionParticipantJoinByInvite#5cdada77][TLChannelAdminLogEventActionParticipantJoinByInvite]
 * * [channelAdminLogEventActionParticipantLeave#f89777f2][TLChannelAdminLogEventActionParticipantLeave]
 * * [channelAdminLogEventActionParticipantMute#f92424d2][TLChannelAdminLogEventActionParticipantMute]
 * * [channelAdminLogEventActionParticipantToggleAdmin#d5676710][TLChannelAdminLogEventActionParticipantToggleAdmin]
 * * [channelAdminLogEventActionParticipantToggleBan#e6d83d7e][TLChannelAdminLogEventActionParticipantToggleBan]
 * * [channelAdminLogEventActionParticipantUnmute#e64429c0][TLChannelAdminLogEventActionParticipantUnmute]
 * * [channelAdminLogEventActionParticipantVolume#3e7f6847][TLChannelAdminLogEventActionParticipantVolume]
 * * [channelAdminLogEventActionStartGroupCall#23209745][TLChannelAdminLogEventActionStartGroupCall]
 * * [channelAdminLogEventActionStopPoll#8f079643][TLChannelAdminLogEventActionStopPoll]
 * * [channelAdminLogEventActionToggleGroupCallSetting#56d6a247][TLChannelAdminLogEventActionToggleGroupCallSetting]
 * * [channelAdminLogEventActionToggleInvites#1b7907ae][TLChannelAdminLogEventActionToggleInvites]
 * * [channelAdminLogEventActionTogglePreHistoryHidden#5f5c95f1][TLChannelAdminLogEventActionTogglePreHistoryHidden]
 * * [channelAdminLogEventActionToggleSignatures#26ae0971][TLChannelAdminLogEventActionToggleSignatures]
 * * [channelAdminLogEventActionToggleSlowMode#53909779][TLChannelAdminLogEventActionToggleSlowMode]
 * * [channelAdminLogEventActionUpdatePinned#e9e82c18][TLChannelAdminLogEventActionUpdatePinned]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelAdminLogEventAction : TLObject()

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
 * * [channelAdminLogEventActionChangeAbout#55188a2e][TLChannelAdminLogEventActionChangeAbout]
 * * [channelAdminLogEventActionChangeAvailableReactions#be4e0ef8][TLChannelAdminLogEventActionChangeAvailableReactions]
 * * [channelAdminLogEventActionChangeEmojiStatus#3ea9feb1][TLChannelAdminLogEventActionChangeEmojiStatus]
 * * [channelAdminLogEventActionChangeHistoryTTL#6e941a38][TLChannelAdminLogEventActionChangeHistoryTTL]
 * * [channelAdminLogEventActionChangeLinkedChat#50c7ac8][TLChannelAdminLogEventActionChangeLinkedChat]
 * * [channelAdminLogEventActionChangeLocation#e6b76ae][TLChannelAdminLogEventActionChangeLocation]
 * * [channelAdminLogEventActionChangePeerColor#5796e780][TLChannelAdminLogEventActionChangePeerColor]
 * * [channelAdminLogEventActionChangePhoto#434bd2af][TLChannelAdminLogEventActionChangePhoto]
 * * [channelAdminLogEventActionChangeProfilePeerColor#5e477b25][TLChannelAdminLogEventActionChangeProfilePeerColor]
 * * [channelAdminLogEventActionChangeStickerSet#b1c3caa7][TLChannelAdminLogEventActionChangeStickerSet]
 * * [channelAdminLogEventActionChangeTitle#e6dfb825][TLChannelAdminLogEventActionChangeTitle]
 * * [channelAdminLogEventActionChangeUsername#6a4afc38][TLChannelAdminLogEventActionChangeUsername]
 * * [channelAdminLogEventActionChangeUsernames#f04fb3a9][TLChannelAdminLogEventActionChangeUsernames]
 * * [channelAdminLogEventActionChangeWallpaper#31bb5d52][TLChannelAdminLogEventActionChangeWallpaper]
 * * [channelAdminLogEventActionCreateTopic#58707d28][TLChannelAdminLogEventActionCreateTopic]
 * * [channelAdminLogEventActionDefaultBannedRights#2df5fc0a][TLChannelAdminLogEventActionDefaultBannedRights]
 * * [channelAdminLogEventActionDeleteMessage#42e047bb][TLChannelAdminLogEventActionDeleteMessage]
 * * [channelAdminLogEventActionDeleteTopic#ae168909][TLChannelAdminLogEventActionDeleteTopic]
 * * [channelAdminLogEventActionDiscardGroupCall#db9f9140][TLChannelAdminLogEventActionDiscardGroupCall]
 * * [channelAdminLogEventActionEditMessage#709b2405][TLChannelAdminLogEventActionEditMessage]
 * * [channelAdminLogEventActionEditTopic#f06fe208][TLChannelAdminLogEventActionEditTopic]
 * * [channelAdminLogEventActionExportedInviteDelete#5a50fca4][TLChannelAdminLogEventActionExportedInviteDelete]
 * * [channelAdminLogEventActionExportedInviteEdit#e90ebb59][TLChannelAdminLogEventActionExportedInviteEdit]
 * * [channelAdminLogEventActionExportedInviteRevoke#410a134e][TLChannelAdminLogEventActionExportedInviteRevoke]
 * * [channelAdminLogEventActionParticipantInvite#e31c34d8][TLChannelAdminLogEventActionParticipantInvite]
 * * [channelAdminLogEventActionParticipantJoin#183040d3][TLChannelAdminLogEventActionParticipantJoin]
 * * [channelAdminLogEventActionParticipantJoinByInvite#fe9fc158][TLChannelAdminLogEventActionParticipantJoinByInvite]
 * * [channelAdminLogEventActionParticipantJoinByRequest#afb6144a][TLChannelAdminLogEventActionParticipantJoinByRequest]
 * * [channelAdminLogEventActionParticipantLeave#f89777f2][TLChannelAdminLogEventActionParticipantLeave]
 * * [channelAdminLogEventActionParticipantMute#f92424d2][TLChannelAdminLogEventActionParticipantMute]
 * * [channelAdminLogEventActionParticipantToggleAdmin#d5676710][TLChannelAdminLogEventActionParticipantToggleAdmin]
 * * [channelAdminLogEventActionParticipantToggleBan#e6d83d7e][TLChannelAdminLogEventActionParticipantToggleBan]
 * * [channelAdminLogEventActionParticipantUnmute#e64429c0][TLChannelAdminLogEventActionParticipantUnmute]
 * * [channelAdminLogEventActionParticipantVolume#3e7f6847][TLChannelAdminLogEventActionParticipantVolume]
 * * [channelAdminLogEventActionPinTopic#5d8d353b][TLChannelAdminLogEventActionPinTopic]
 * * [channelAdminLogEventActionSendMessage#278f2868][TLChannelAdminLogEventActionSendMessage]
 * * [channelAdminLogEventActionStartGroupCall#23209745][TLChannelAdminLogEventActionStartGroupCall]
 * * [channelAdminLogEventActionStopPoll#8f079643][TLChannelAdminLogEventActionStopPoll]
 * * [channelAdminLogEventActionToggleAntiSpam#64f36dfc][TLChannelAdminLogEventActionToggleAntiSpam]
 * * [channelAdminLogEventActionToggleForum#2cc6383][TLChannelAdminLogEventActionToggleForum]
 * * [channelAdminLogEventActionToggleGroupCallSetting#56d6a247][TLChannelAdminLogEventActionToggleGroupCallSetting]
 * * [channelAdminLogEventActionToggleInvites#1b7907ae][TLChannelAdminLogEventActionToggleInvites]
 * * [channelAdminLogEventActionToggleNoForwards#cb2ac766][TLChannelAdminLogEventActionToggleNoForwards]
 * * [channelAdminLogEventActionTogglePreHistoryHidden#5f5c95f1][TLChannelAdminLogEventActionTogglePreHistoryHidden]
 * * [channelAdminLogEventActionToggleSignatures#26ae0971][TLChannelAdminLogEventActionToggleSignatures]
 * * [channelAdminLogEventActionToggleSlowMode#53909779][TLChannelAdminLogEventActionToggleSlowMode]
 * * [channelAdminLogEventActionUpdatePinned#e9e82c18][TLChannelAdminLogEventActionUpdatePinned]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelAdminLogEventAction : TLObject()

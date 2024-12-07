package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQuerySyncExecutor
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLAbsEmailVerified
import com.github.badoualy.telegram.tl.api.account.TLAbsEmojiStatuses
import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtone
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtones
import com.github.badoualy.telegram.tl.api.account.TLAbsThemes
import com.github.badoualy.telegram.tl.api.account.TLAbsWallPapers
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations
import com.github.badoualy.telegram.tl.api.account.TLBusinessChatLinks
import com.github.badoualy.telegram.tl.api.account.TLConnectedBots
import com.github.badoualy.telegram.tl.api.account.TLContentSettings
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.api.account.TLResolvedBusinessChatLinks
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode
import com.github.badoualy.telegram.tl.api.account.TLTakeout
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword
import com.github.badoualy.telegram.tl.api.account.TLWebAuthorizations
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLAbsLoginToken
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLLoggedOut
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.api.bots.TLBotInfo
import com.github.badoualy.telegram.tl.api.bots.TLPopularAppBots
import com.github.badoualy.telegram.tl.api.bots.TLPreviewInfo
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAbsSponsoredMessageReportResult
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.channels.TLSendAsPeers
import com.github.badoualy.telegram.tl.api.chatlists.TLAbsChatlistInvite
import com.github.badoualy.telegram.tl.api.chatlists.TLChatlistUpdates
import com.github.badoualy.telegram.tl.api.chatlists.TLExportedInvites
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.api.contacts.TLContactBirthdays
import com.github.badoualy.telegram.tl.api.contacts.TLFound
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.api.fragment.TLCollectibleInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsAppConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsPassportConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsPeerColors
import com.github.badoualy.telegram.tl.api.help.TLAbsPromoData
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsTimezonesList
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLPremiumPromo
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.help.TLSupportName
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsAvailableEffects
import com.github.badoualy.telegram.tl.api.messages.TLAbsAvailableReactions
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsEmojiGroups
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsQuickReplies
import com.github.badoualy.telegram.tl.api.messages.TLAbsReactions
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedReactionTags
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.api.messages.TLAbsSponsoredMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers
import com.github.badoualy.telegram.tl.api.messages.TLAffectedFoundMessages
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers
import com.github.badoualy.telegram.tl.api.messages.TLBotApp
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.api.messages.TLChatAdminsWithInvites
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters
import com.github.badoualy.telegram.tl.api.messages.TLCheckedHistoryImportPeer
import com.github.badoualy.telegram.tl.api.messages.TLDialogFilters
import com.github.badoualy.telegram.tl.api.messages.TLDiscussionMessage
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics
import com.github.badoualy.telegram.tl.api.messages.TLHighScores
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImport
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImportParsed
import com.github.badoualy.telegram.tl.api.messages.TLInactiveChats
import com.github.badoualy.telegram.tl.api.messages.TLInvitedUsers
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData
import com.github.badoualy.telegram.tl.api.messages.TLMessageReactionsList
import com.github.badoualy.telegram.tl.api.messages.TLMessageViews
import com.github.badoualy.telegram.tl.api.messages.TLMyStickers
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs
import com.github.badoualy.telegram.tl.api.messages.TLPeerSettings
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsCalendar
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsPositions
import com.github.badoualy.telegram.tl.api.messages.TLTranscribedAudio
import com.github.badoualy.telegram.tl.api.messages.TLTranslateResult
import com.github.badoualy.telegram.tl.api.messages.TLVotesList
import com.github.badoualy.telegram.tl.api.messages.TLWebPage
import com.github.badoualy.telegram.tl.api.payments.TLAbsGiveawayInfo
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentForm
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentReceipt
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.api.payments.TLBankCardData
import com.github.badoualy.telegram.tl.api.payments.TLCheckedGiftCode
import com.github.badoualy.telegram.tl.api.payments.TLExportedInvoice
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueAdsAccountUrl
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueStats
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueWithdrawalUrl
import com.github.badoualy.telegram.tl.api.payments.TLStarsStatus
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamChannels
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamRtmpUrl
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants
import com.github.badoualy.telegram.tl.api.phone.TLJoinAsPeers
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.premium.TLBoostsList
import com.github.badoualy.telegram.tl.api.premium.TLBoostsStatus
import com.github.badoualy.telegram.tl.api.premium.TLMyBoosts
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountAcceptAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCancelPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangeAuthorizationSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangePhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountClearRecentEmojiStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCreateBusinessChatLink
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCreateTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeclinePasswordReset
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAccount
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAutoSaveExceptions
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteBusinessChatLink
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDisablePeerConnectedBot
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountEditBusinessChatLink
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountFinishTakeoutSession
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAllSecureValues
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizationForm
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAutoDownloadSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAutoSaveSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetBotBusinessConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetBusinessChatLinks
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChannelDefaultEmojiStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChannelRestrictedStatusEmojis
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChatThemes
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetConnectedBots
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContactSignUpNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContentSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultBackgroundEmojis
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultEmojiStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultGroupPhotoEmojis
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetDefaultProfilePhotoEmojis
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetGlobalPrivacySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetMultiWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifyExceptions
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPrivacy
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetReactionsNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetRecentEmojiStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetSavedRingtones
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetThemes
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetTmpPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWebAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInitTakeoutSession
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInstallTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInstallWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInvalidateSignInCodes
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountRegisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReorderUsernames
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportPeer
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResendPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResolveBusinessChatLink
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveAutoDownloadSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveAutoSaveSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveRingtone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendChangePhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendConfirmPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyEmailCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAuthorizationTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContactSignUpNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContentSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetGlobalPrivacySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetPrivacy
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetReactionsNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleConnectedBotPaused
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleSponsoredMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountToggleUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUnregisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBirthday
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessAwayMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessGreetingMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessIntro
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessLocation
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateBusinessWorkHours
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateColor
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateConnectedBot
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateDeviceLocked
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateEmojiStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePersonalChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateProfile
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadRingtone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUploadWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyPhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthAcceptLoginToken
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthBindTempAuthKey
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCancelCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCheckPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCheckRecoveryPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthDropTempAuthKeys
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthExportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthExportLoginToken
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportBotAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportLoginToken
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportWebTokenAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthLogOut
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRecoverPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthReportMissingCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestFirebaseSms
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestPasswordRecovery
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetLoginEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignIn
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignUp
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAddPreviewMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAllowSendMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsCanSendMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsDeletePreviewMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsEditPreviewMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotMenuButton
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPopularAppBots
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPreviewInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetPreviewMedias
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsInvokeWebViewCustomMethod
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsReorderPreviewMedias
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsReorderUsernames
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsResetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSendCustomRequest
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotBroadcastDefaultAdminRights
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotGroupDefaultAdminRights
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotMenuButton
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsToggleUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsClickSponsoredMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsConvertToGigagroup
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateForumTopic
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeactivateAllUsernames
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteParticipantHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteTopicHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditBanned
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditCreator
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditForumTopic
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditLocation
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsExportMessageLink
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminLog
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminedPublicChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannelRecommendations
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetForumTopics
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetForumTopicsByID
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetFullChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetGroupsForDiscussion
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetInactiveChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetLeftChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipant
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetSendAs
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetSponsoredMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsInviteToChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsJoinChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsLeaveChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReorderPinnedForumTopics
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReorderUsernames
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportAntiSpamFalsePositive
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportSponsoredMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsRestrictSponsoredMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSearchPosts
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetBoostsToUnblockRestrictions
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetDiscussionGroup
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetEmojiStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleAntiSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleForum
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleJoinRequest
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleJoinToSend
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleParticipantsHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsTogglePreHistoryHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSignatures
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSlowMode
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleViewForumAsMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateColor
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateEmojiStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdatePinnedForumTopic
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsViewSponsoredMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsCheckChatlistInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsDeleteExportedInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsEditExportedInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsExportChatlistInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetChatlistUpdates
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetExportedInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsGetLeaveChatlistSuggestions
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsHideChatlistUpdates
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsJoinChatlistInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsJoinChatlistUpdates
import com.github.badoualy.telegram.tl.api.request.TLRequestChatlistsLeaveChatlist
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAcceptContact
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAddContact
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlock
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlockFromReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteByPhones
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsEditCloseFriends
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsExportContactToken
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBirthdays
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBlocked
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContactIDs
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetLocated
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContactToken
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetTopPeerRating
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolvePhone
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolveUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSetBlocked
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsToggleTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsUnblock
import com.github.badoualy.telegram.tl.api.request.TLRequestFoldersEditPeerFolders
import com.github.badoualy.telegram.tl.api.request.TLRequestFragmentGetCollectibleInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpAcceptTermsOfService
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpDismissSuggestion
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpEditUserInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCdnConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCountriesList
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetDeepLinkInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetInviteText
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPassportConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPeerColors
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPeerProfileColors
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPremiumPromo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPromoData
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetRecentMeUrls
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupport
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupportName
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTimezonesList
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetUserInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpHidePromoData
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSaveAppLog
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSetBotUpdatesStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsg
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsgs
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithApnsSecret
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithBusinessConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithGooglePlayIntegrity
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithMessagesRange
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithTakeout
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithoutUpdates
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLangPack
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLanguage
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLanguages
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetStrings
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAcceptEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAcceptUrlAuth
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAddChatUser
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckHistoryImport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckHistoryImportPeer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckQuickReplyShortcut
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearAllDrafts
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCreateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChatUser
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteFactCheck
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeletePhoneCallHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteQuickReplyMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteQuickReplyShortcut
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteRevokedExportedChatInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteSavedHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDiscardEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAbout
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatDefaultBannedRights
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditFactCheck
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditInlineBotMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditQuickReplyShortcut
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesExportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesFaveSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesForwardMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAdminsWithInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllDrafts
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetArchivedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachMenuBot
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachMenuBots
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAvailableEffects
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAvailableReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotApp
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChatInviteImporters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCommonChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCustomEmojiDocuments
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDefaultHistoryTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDefaultTagReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDhConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogFilters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogUnreadMarks
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDiscussionMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDocumentByHash
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiGroups
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywords
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsLanguages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiProfilePhotoGroups
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStatusGroups
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStickerGroups
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiURL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExtendedMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFactCheck
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFavedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedEmojiStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFullChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMaskStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageEditData
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageReactionsList
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageReadParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesViews
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMyStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOldFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOnlines
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOutboxReadDate
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedSavedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollVotes
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetQuickReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetQuickReplyMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentLocations
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedGifs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedReactionTags
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchCounters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchResultsCalendar
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchResultsPositions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSplitRanges
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSuggestedDialogFilters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetTopReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPagePreview
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHideAllChatJoinRequests
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHideChatJoinRequest
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHidePeerSettingsBar
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesImportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInitHistoryImport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMarkDialogUnread
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMigrateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesProlongWebView
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRateTranscribedAudio
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadDiscussion
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadEncryptedHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedQueue
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedSavedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderQuickReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportEncryptedSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportReaction
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestAppWebView
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestMainWebView
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestSimpleWebView
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestUrlAuth
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestWebView
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDefaultSendAs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDraft
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveGif
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveRecentSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchCustomEmoji
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchEmojiStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchGlobal
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchSentMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendBotRequestedPeer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncrypted
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedService
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendInlineBotResult
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMultiMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendQuickReplyMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendReaction
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScreenshotNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendVote
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendWebViewData
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendWebViewResultMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotShippingResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatAvailableReactions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetDefaultHistoryTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetDefaultReaction
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetEncryptedTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetHistoryTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartBot
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartHistoryImport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleBotInAttachMenu
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogFilterTags
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogPin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleNoForwards
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTogglePeerTranslations
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleSavedDialogPin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTranscribeAudio
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesTranslateText
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUninstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUnpinAllMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFilter
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFiltersOrder
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdatePinnedMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateSavedReactionTag
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadImportedMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsApplyGiftCode
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsAssignAppStoreTransaction
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsAssignPlayMarketTransaction
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsCanPurchasePremium
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsCheckGiftCode
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsClearSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsExportInvoice
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetBankCardData
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetGiveawayInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentReceipt
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPremiumGiftCodeOptions
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsGiftOptions
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueAdsAccountUrl
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueStats
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsRevenueWithdrawalUrl
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTopupOptions
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTransactions
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetStarsTransactionsByID
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsLaunchPrepaidGiveaway
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsRefundStarsCharge
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendPaymentForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendStarsForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsValidateRequestedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneAcceptCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneCheckGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneConfirmCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneCreateGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneDiscardCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneDiscardGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneEditGroupCallParticipant
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneEditGroupCallTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneExportGroupCallInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetCallConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallJoinAs
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallStreamChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupCallStreamRtmpUrl
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneInviteToGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCallPresentation
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCallPresentation
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneReceivedCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneRequestCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallDebug
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallLog
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveDefaultGroupCallJoinAs
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSendSignalingData
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSetCallRating
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneStartScheduledGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallRecord
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneToggleGroupCallStartSubscription
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosDeletePhotos
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosGetUserPhotos
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUpdateProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadContactProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumApplyBoost
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetBoostsList
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetBoostsStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetMyBoosts
import com.github.badoualy.telegram.tl.api.request.TLRequestPremiumGetUserBoosts
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsFinishJob
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsGetSmsJob
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsGetStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsIsEligibleToJoin
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsJoin
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsLeave
import com.github.badoualy.telegram.tl.api.request.TLRequestSmsjobsUpdateSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueTransactions
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastRevenueWithdrawalUrl
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMegagroupStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessagePublicForwards
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessageStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetStoryPublicForwards
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetStoryStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsLoadAsyncGraph
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersAddStickerToSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeStickerPosition
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCheckShortName
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCreateStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersDeleteStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRemoveStickerFromSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRenameStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersReplaceSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSetStickerSetThumb
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSuggestShortName
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesActivateStealthMode
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesCanSendStory
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesDeleteStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesEditStory
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesExportStoryLink
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetAllReadPeerStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetAllStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetChatsToSend
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPeerMaxIDs
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPeerStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetPinnedStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesArchive
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesByID
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoriesViews
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoryReactionsList
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesGetStoryViewsList
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesIncrementStoryViews
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesReadStories
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesReport
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSearchPosts
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSendReaction
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesSendStory
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesToggleAllStoriesHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePeerStoriesHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePinned
import com.github.badoualy.telegram.tl.api.request.TLRequestStoriesTogglePinnedToTop
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetChannelDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetState
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFileHashes
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFileHashes
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetWebFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadReuploadCdnFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveBigFilePart
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveFilePart
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetFullUser
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetIsPremiumRequiredToContact
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetUsers
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersSetSecureValueErrors
import com.github.badoualy.telegram.tl.api.smsjobs.TLEligibleToJoin
import com.github.badoualy.telegram.tl.api.smsjobs.TLStatus
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueStats
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueTransactions
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastRevenueWithdrawalUrl
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastStats
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats
import com.github.badoualy.telegram.tl.api.stats.TLPublicForwards
import com.github.badoualy.telegram.tl.api.stats.TLStoryStats
import com.github.badoualy.telegram.tl.api.stickers.TLSuggestedShortName
import com.github.badoualy.telegram.tl.api.stories.TLAbsAllStories
import com.github.badoualy.telegram.tl.api.stories.TLFoundStories
import com.github.badoualy.telegram.tl.api.stories.TLPeerStories
import com.github.badoualy.telegram.tl.api.stories.TLStories
import com.github.badoualy.telegram.tl.api.stories.TLStoryReactionsList
import com.github.badoualy.telegram.tl.api.stories.TLStoryViews
import com.github.badoualy.telegram.tl.api.stories.TLStoryViewsList
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.api.users.TLUserFull
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

abstract class TelegramSyncApiWrapper : TelegramSyncApi, RpcQuerySyncExecutor {
    @Throws(RpcErrorException::class, IOException::class)
    override fun accountAcceptAuthorization(
            botId: Long,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): TLBool = executeMethod(TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCancelPasswordEmail(): TLBool = executeMethod(TLRequestAccountCancelPasswordEmail())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountChangeAuthorizationSettings(
            confirmed: Boolean,
            hash: Long,
            encryptedRequestsDisabled: Boolean?,
            callRequestsDisabled: Boolean?
    ): TLBool = executeMethod(TLRequestAccountChangeAuthorizationSettings(confirmed, hash, encryptedRequestsDisabled, callRequestsDisabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAbsUser = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCheckUsername(username: String): TLBool = executeMethod(TLRequestAccountCheckUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountClearRecentEmojiStatuses(): TLBool = executeMethod(TLRequestAccountClearRecentEmojiStatuses())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountConfirmPasswordEmail(code: String): TLBool = executeMethod(TLRequestAccountConfirmPasswordEmail(code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): TLBool = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCreateBusinessChatLink(link: TLInputBusinessChatLink): TLBusinessChatLink = executeMethod(TLRequestAccountCreateBusinessChatLink(link))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCreateTheme(
            slug: String,
            title: String,
            document: TLAbsInputDocument?,
            settings: TLObjectVector<TLInputThemeSettings>?
    ): TLTheme = executeMethod(TLRequestAccountCreateTheme(slug, title, document, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeclinePasswordReset(): TLBool = executeMethod(TLRequestAccountDeclinePasswordReset())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteAccount(reason: String, password: TLAbsInputCheckPasswordSRP?): TLBool = executeMethod(TLRequestAccountDeleteAccount(reason, password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteAutoSaveExceptions(): TLBool = executeMethod(TLRequestAccountDeleteAutoSaveExceptions())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteBusinessChatLink(slug: String): TLBool = executeMethod(TLRequestAccountDeleteBusinessChatLink(slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteSecureValue(types: TLObjectVector<TLAbsSecureValueType>): TLBool = executeMethod(TLRequestAccountDeleteSecureValue(types))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDisablePeerConnectedBot(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestAccountDisablePeerConnectedBot(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountEditBusinessChatLink(slug: String, link: TLInputBusinessChatLink): TLBusinessChatLink = executeMethod(TLRequestAccountEditBusinessChatLink(slug, link))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountFinishTakeoutSession(success: Boolean): TLBool = executeMethod(TLRequestAccountFinishTakeoutSession(success))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAccountTTL(): TLAccountDaysTTL = executeMethod(TLRequestAccountGetAccountTTL())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAllSecureValues(): TLObjectVector<TLSecureValue> = executeMethod(TLRequestAccountGetAllSecureValues())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizationForm(
            botId: Long,
            scope: String,
            publicKey: String
    ): TLAuthorizationForm = executeMethod(TLRequestAccountGetAuthorizationForm(botId, scope, publicKey))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizations(): TLAuthorizations = executeMethod(TLRequestAccountGetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAutoDownloadSettings(): com.github.badoualy.telegram.tl.api.account.TLAutoDownloadSettings = executeMethod(TLRequestAccountGetAutoDownloadSettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAutoSaveSettings(): com.github.badoualy.telegram.tl.api.account.TLAutoSaveSettings = executeMethod(TLRequestAccountGetAutoSaveSettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetBotBusinessConnection(connectionId: String): TLAbsUpdates = executeMethod(TLRequestAccountGetBotBusinessConnection(connectionId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetBusinessChatLinks(): TLBusinessChatLinks = executeMethod(TLRequestAccountGetBusinessChatLinks())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetChannelDefaultEmojiStatuses(hash: Long): TLAbsEmojiStatuses = executeMethod(TLRequestAccountGetChannelDefaultEmojiStatuses(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetChannelRestrictedStatusEmojis(hash: Long): TLAbsEmojiList = executeMethod(TLRequestAccountGetChannelRestrictedStatusEmojis(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetChatThemes(hash: Long): TLAbsThemes = executeMethod(TLRequestAccountGetChatThemes(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetConnectedBots(): TLConnectedBots = executeMethod(TLRequestAccountGetConnectedBots())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetContactSignUpNotification(): TLBool = executeMethod(TLRequestAccountGetContactSignUpNotification())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetContentSettings(): TLContentSettings = executeMethod(TLRequestAccountGetContentSettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetDefaultBackgroundEmojis(hash: Long): TLAbsEmojiList = executeMethod(TLRequestAccountGetDefaultBackgroundEmojis(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetDefaultEmojiStatuses(hash: Long): TLAbsEmojiStatuses = executeMethod(TLRequestAccountGetDefaultEmojiStatuses(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetDefaultGroupPhotoEmojis(hash: Long): TLAbsEmojiList = executeMethod(TLRequestAccountGetDefaultGroupPhotoEmojis(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetDefaultProfilePhotoEmojis(hash: Long): TLAbsEmojiList = executeMethod(TLRequestAccountGetDefaultProfilePhotoEmojis(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetGlobalPrivacySettings(): TLGlobalPrivacySettings = executeMethod(TLRequestAccountGetGlobalPrivacySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetMultiWallPapers(wallpapers: TLObjectVector<TLAbsInputWallPaper>): TLObjectVector<TLAbsWallPaper> = executeMethod(TLRequestAccountGetMultiWallPapers(wallpapers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetNotifyExceptions(
            compareSound: Boolean,
            compareStories: Boolean,
            peer: TLAbsInputNotifyPeer?
    ): TLAbsUpdates = executeMethod(TLRequestAccountGetNotifyExceptions(compareSound, compareStories, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): TLPeerNotifySettings = executeMethod(TLRequestAccountGetNotifySettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPassword(): TLPassword = executeMethod(TLRequestAccountGetPassword())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPasswordSettings(password: TLAbsInputCheckPasswordSRP): TLPasswordSettings = executeMethod(TLRequestAccountGetPasswordSettings(password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): TLPrivacyRules = executeMethod(TLRequestAccountGetPrivacy(key))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetReactionsNotifySettings(): TLReactionsNotifySettings = executeMethod(TLRequestAccountGetReactionsNotifySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetRecentEmojiStatuses(hash: Long): TLAbsEmojiStatuses = executeMethod(TLRequestAccountGetRecentEmojiStatuses(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetSavedRingtones(hash: Long): TLAbsSavedRingtones = executeMethod(TLRequestAccountGetSavedRingtones(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): TLObjectVector<TLSecureValue> = executeMethod(TLRequestAccountGetSecureValue(types))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetTheme(format: String, theme: TLAbsInputTheme): TLTheme = executeMethod(TLRequestAccountGetTheme(format, theme))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetThemes(format: String, hash: Long): TLAbsThemes = executeMethod(TLRequestAccountGetThemes(format, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetTmpPassword(password: TLAbsInputCheckPasswordSRP, period: Int): TLTmpPassword = executeMethod(TLRequestAccountGetTmpPassword(password, period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWallPaper(wallpaper: TLAbsInputWallPaper): TLAbsWallPaper = executeMethod(TLRequestAccountGetWallPaper(wallpaper))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWallPapers(hash: Long): TLAbsWallPapers = executeMethod(TLRequestAccountGetWallPapers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWebAuthorizations(): TLWebAuthorizations = executeMethod(TLRequestAccountGetWebAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountInitTakeoutSession(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Long?
    ): TLTakeout = executeMethod(TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountInstallTheme(
            dark: Boolean,
            theme: TLAbsInputTheme?,
            format: String?,
            baseTheme: TLAbsBaseTheme?
    ): TLBool = executeMethod(TLRequestAccountInstallTheme(dark, theme, format, baseTheme))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountInstallWallPaper(wallpaper: TLAbsInputWallPaper, settings: TLWallPaperSettings): TLBool = executeMethod(TLRequestAccountInstallWallPaper(wallpaper, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountInvalidateSignInCodes(codes: TLStringVector): TLBool = executeMethod(TLRequestAccountInvalidateSignInCodes(codes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountRegisterDevice(
            noMuted: Boolean,
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLLongVector
    ): TLBool = executeMethod(TLRequestAccountRegisterDevice(noMuted, tokenType, token, appSandbox, secret, otherUids))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReorderUsernames(order: TLStringVector): TLBool = executeMethod(TLRequestAccountReorderUsernames(order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReportPeer(
            peer: TLAbsInputPeer,
            reason: TLAbsReportReason,
            message: String
    ): TLBool = executeMethod(TLRequestAccountReportPeer(peer, reason, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReportProfilePhoto(
            peer: TLAbsInputPeer,
            photoId: TLAbsInputPhoto,
            reason: TLAbsReportReason,
            message: String
    ): TLBool = executeMethod(TLRequestAccountReportProfilePhoto(peer, photoId, reason, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResendPasswordEmail(): TLBool = executeMethod(TLRequestAccountResendPasswordEmail())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetAuthorization(hash: Long): TLBool = executeMethod(TLRequestAccountResetAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetNotifySettings(): TLBool = executeMethod(TLRequestAccountResetNotifySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetPassword(): TLAbsResetPasswordResult = executeMethod(TLRequestAccountResetPassword())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetWallPapers(): TLBool = executeMethod(TLRequestAccountResetWallPapers())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetWebAuthorization(hash: Long): TLBool = executeMethod(TLRequestAccountResetWebAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetWebAuthorizations(): TLBool = executeMethod(TLRequestAccountResetWebAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResolveBusinessChatLink(slug: String): TLResolvedBusinessChatLinks = executeMethod(TLRequestAccountResolveBusinessChatLink(slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveAutoDownloadSettings(
            low: Boolean,
            high: Boolean,
            settings: TLAutoDownloadSettings
    ): TLBool = executeMethod(TLRequestAccountSaveAutoDownloadSettings(low, high, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveAutoSaveSettings(
            users: Boolean,
            chats: Boolean,
            broadcasts: Boolean,
            peer: TLAbsInputPeer?,
            settings: TLAutoSaveSettings
    ): TLBool = executeMethod(TLRequestAccountSaveAutoSaveSettings(users, chats, broadcasts, peer, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveRingtone(id: TLAbsInputDocument, unsave: Boolean): TLAbsSavedRingtone = executeMethod(TLRequestAccountSaveRingtone(id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): TLSecureValue = executeMethod(TLRequestAccountSaveSecureValue(value, secureSecretId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveTheme(theme: TLAbsInputTheme, unsave: Boolean): TLBool = executeMethod(TLRequestAccountSaveTheme(theme, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveWallPaper(
            wallpaper: TLAbsInputWallPaper,
            unsave: Boolean,
            settings: TLWallPaperSettings
    ): TLBool = executeMethod(TLRequestAccountSaveWallPaper(wallpaper, unsave, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendChangePhoneCode(phoneNumber: String, settings: TLCodeSettings): TLAbsSentCode = executeMethod(TLRequestAccountSendChangePhoneCode(phoneNumber, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendConfirmPhoneCode(hash: String, settings: TLCodeSettings): TLAbsSentCode = executeMethod(TLRequestAccountSendConfirmPhoneCode(hash, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendVerifyEmailCode(purpose: TLAbsEmailVerifyPurpose, email: String): TLSentEmailCode = executeMethod(TLRequestAccountSendVerifyEmailCode(purpose, email))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendVerifyPhoneCode(phoneNumber: String, settings: TLCodeSettings): TLAbsSentCode = executeMethod(TLRequestAccountSendVerifyPhoneCode(phoneNumber, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): TLBool = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetAuthorizationTTL(authorizationTtlDays: Int): TLBool = executeMethod(TLRequestAccountSetAuthorizationTTL(authorizationTtlDays))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetContactSignUpNotification(silent: Boolean): TLBool = executeMethod(TLRequestAccountSetContactSignUpNotification(silent))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetContentSettings(sensitiveEnabled: Boolean): TLBool = executeMethod(TLRequestAccountSetContentSettings(sensitiveEnabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetGlobalPrivacySettings(settings: TLGlobalPrivacySettings): TLGlobalPrivacySettings = executeMethod(TLRequestAccountSetGlobalPrivacySettings(settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): TLPrivacyRules = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetReactionsNotifySettings(settings: TLReactionsNotifySettings): TLReactionsNotifySettings = executeMethod(TLRequestAccountSetReactionsNotifySettings(settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountToggleConnectedBotPaused(peer: TLAbsInputPeer, paused: Boolean): TLBool = executeMethod(TLRequestAccountToggleConnectedBotPaused(peer, paused))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountToggleSponsoredMessages(enabled: Boolean): TLBool = executeMethod(TLRequestAccountToggleSponsoredMessages(enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountToggleUsername(username: String, active: Boolean): TLBool = executeMethod(TLRequestAccountToggleUsername(username, active))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLLongVector
    ): TLBool = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token, otherUids))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBirthday(birthday: TLBirthday?): TLBool = executeMethod(TLRequestAccountUpdateBirthday(birthday))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBusinessAwayMessage(message: TLInputBusinessAwayMessage?): TLBool = executeMethod(TLRequestAccountUpdateBusinessAwayMessage(message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBusinessGreetingMessage(message: TLInputBusinessGreetingMessage?): TLBool = executeMethod(TLRequestAccountUpdateBusinessGreetingMessage(message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBusinessIntro(intro: TLInputBusinessIntro?): TLBool = executeMethod(TLRequestAccountUpdateBusinessIntro(intro))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBusinessLocation(geoPoint: TLAbsInputGeoPoint?, address: String?): TLBool = executeMethod(TLRequestAccountUpdateBusinessLocation(geoPoint, address))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateBusinessWorkHours(businessWorkHours: TLBusinessWorkHours?): TLBool = executeMethod(TLRequestAccountUpdateBusinessWorkHours(businessWorkHours))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateColor(
            forProfile: Boolean,
            color: Int?,
            backgroundEmojiId: Long?
    ): TLBool = executeMethod(TLRequestAccountUpdateColor(forProfile, color, backgroundEmojiId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateConnectedBot(
            canReply: Boolean,
            deleted: Boolean,
            bot: TLAbsInputUser,
            recipients: TLInputBusinessBotRecipients
    ): TLAbsUpdates = executeMethod(TLRequestAccountUpdateConnectedBot(canReply, deleted, bot, recipients))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateDeviceLocked(period: Int): TLBool = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateEmojiStatus(emojiStatus: TLAbsEmojiStatus): TLBool = executeMethod(TLRequestAccountUpdateEmojiStatus(emojiStatus))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): TLBool = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdatePasswordSettings(password: TLAbsInputCheckPasswordSRP, newSettings: TLPasswordInputSettings): TLBool = executeMethod(TLRequestAccountUpdatePasswordSettings(password, newSettings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdatePersonalChannel(channel: TLAbsInputChannel): TLBool = executeMethod(TLRequestAccountUpdatePersonalChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): TLAbsUser = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateStatus(offline: Boolean): TLBool = executeMethod(TLRequestAccountUpdateStatus(offline))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateTheme(
            format: String,
            theme: TLAbsInputTheme,
            slug: String?,
            title: String?,
            document: TLAbsInputDocument?,
            settings: TLObjectVector<TLInputThemeSettings>?
    ): TLTheme = executeMethod(TLRequestAccountUpdateTheme(format, theme, slug, title, document, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateUsername(username: String): TLAbsUser = executeMethod(TLRequestAccountUpdateUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUploadRingtone(
            file: TLAbsInputFile,
            fileName: String,
            mimeType: String
    ): TLAbsDocument = executeMethod(TLRequestAccountUploadRingtone(file, fileName, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUploadTheme(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            fileName: String,
            mimeType: String
    ): TLAbsDocument = executeMethod(TLRequestAccountUploadTheme(file, thumb, fileName, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUploadWallPaper(
            forChat: Boolean,
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ): TLAbsWallPaper = executeMethod(TLRequestAccountUploadWallPaper(forChat, file, mimeType, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountVerifyEmail(purpose: TLAbsEmailVerifyPurpose, verification: TLAbsEmailVerification): TLAbsEmailVerified = executeMethod(TLRequestAccountVerifyEmail(purpose, verification))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountVerifyPhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLBool = executeMethod(TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authAcceptLoginToken(token: TLBytes): TLAuthorization = executeMethod(TLRequestAuthAcceptLoginToken(token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): TLBool = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): TLBool = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPassword(password: TLAbsInputCheckPasswordSRP): TLAbsAuthorization = executeMethod(TLRequestAuthCheckPassword(password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckRecoveryPassword(code: String): TLBool = executeMethod(TLRequestAuthCheckRecoveryPassword(code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): TLBool = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authExportAuthorization(dcId: Int): TLExportedAuthorization = executeMethod(TLRequestAuthExportAuthorization(dcId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authExportLoginToken(
            apiId: Int,
            apiHash: String,
            exceptIds: TLLongVector
    ): TLAbsLoginToken = executeMethod(TLRequestAuthExportLoginToken(apiId, apiHash, exceptIds))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportAuthorization(id: Long, bytes: TLBytes): TLAbsAuthorization = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): TLAbsAuthorization = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportLoginToken(token: TLBytes): TLAbsLoginToken = executeMethod(TLRequestAuthImportLoginToken(token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportWebTokenAuthorization(
            apiId: Int,
            apiHash: String,
            webAuthToken: String
    ): TLAbsAuthorization = executeMethod(TLRequestAuthImportWebTokenAuthorization(apiId, apiHash, webAuthToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authLogOut(): TLLoggedOut = executeMethod(TLRequestAuthLogOut())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRecoverPassword(code: String, newSettings: TLPasswordInputSettings?): TLAbsAuthorization = executeMethod(TLRequestAuthRecoverPassword(code, newSettings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authReportMissingCode(
            phoneNumber: String,
            phoneCodeHash: String,
            mnc: String
    ): TLBool = executeMethod(TLRequestAuthReportMissingCode(phoneNumber, phoneCodeHash, mnc))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRequestFirebaseSms(
            phoneNumber: String,
            phoneCodeHash: String,
            safetyNetToken: String?,
            playIntegrityToken: String?,
            iosPushSecret: String?
    ): TLBool = executeMethod(TLRequestAuthRequestFirebaseSms(phoneNumber, phoneCodeHash, safetyNetToken, playIntegrityToken, iosPushSecret))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRequestPasswordRecovery(): TLPasswordRecovery = executeMethod(TLRequestAuthRequestPasswordRecovery())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResendCode(
            phoneNumber: String,
            phoneCodeHash: String,
            reason: String?
    ): TLAbsSentCode = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash, reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResetAuthorizations(): TLBool = executeMethod(TLRequestAuthResetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResetLoginEmail(phoneNumber: String, phoneCodeHash: String): TLAbsSentCode = executeMethod(TLRequestAuthResetLoginEmail(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(
            phoneNumber: String,
            apiId: Int,
            apiHash: String,
            settings: TLCodeSettings
    ): TLAbsSentCode = executeMethod(TLRequestAuthSendCode(phoneNumber, apiId, apiHash, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String?,
            emailVerification: TLAbsEmailVerification?
    ): TLAbsAuthorization = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode, emailVerification))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignUp(
            noJoinedNotifications: Boolean,
            phoneNumber: String,
            phoneCodeHash: String,
            firstName: String,
            lastName: String
    ): TLAbsAuthorization = executeMethod(TLRequestAuthSignUp(noJoinedNotifications, phoneNumber, phoneCodeHash, firstName, lastName))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAddPreviewMedia(
            bot: TLAbsInputUser,
            langCode: String,
            media: TLAbsInputMedia
    ): TLBotPreviewMedia = executeMethod(TLRequestBotsAddPreviewMedia(bot, langCode, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAllowSendMessage(bot: TLAbsInputUser): TLAbsUpdates = executeMethod(TLRequestBotsAllowSendMessage(bot))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): TLBool = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsCanSendMessage(bot: TLAbsInputUser): TLBool = executeMethod(TLRequestBotsCanSendMessage(bot))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsDeletePreviewMedia(
            bot: TLAbsInputUser,
            langCode: String,
            media: TLObjectVector<TLAbsInputMedia>
    ): TLBool = executeMethod(TLRequestBotsDeletePreviewMedia(bot, langCode, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsEditPreviewMedia(
            bot: TLAbsInputUser,
            langCode: String,
            media: TLAbsInputMedia,
            newMedia: TLAbsInputMedia
    ): TLBotPreviewMedia = executeMethod(TLRequestBotsEditPreviewMedia(bot, langCode, media, newMedia))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetBotCommands(scope: TLAbsBotCommandScope, langCode: String): TLObjectVector<TLBotCommand> = executeMethod(TLRequestBotsGetBotCommands(scope, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetBotInfo(bot: TLAbsInputUser?, langCode: String): TLBotInfo = executeMethod(TLRequestBotsGetBotInfo(bot, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetBotMenuButton(userId: TLAbsInputUser): TLAbsBotMenuButton = executeMethod(TLRequestBotsGetBotMenuButton(userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetPopularAppBots(offset: String, limit: Int): TLPopularAppBots = executeMethod(TLRequestBotsGetPopularAppBots(offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetPreviewInfo(bot: TLAbsInputUser, langCode: String): TLPreviewInfo = executeMethod(TLRequestBotsGetPreviewInfo(bot, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsGetPreviewMedias(bot: TLAbsInputUser): TLObjectVector<TLBotPreviewMedia> = executeMethod(TLRequestBotsGetPreviewMedias(bot))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsInvokeWebViewCustomMethod(
            bot: TLAbsInputUser,
            customMethod: String,
            params: TLDataJSON
    ): TLDataJSON = executeMethod(TLRequestBotsInvokeWebViewCustomMethod(bot, customMethod, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsReorderPreviewMedias(
            bot: TLAbsInputUser,
            langCode: String,
            order: TLObjectVector<TLAbsInputMedia>
    ): TLBool = executeMethod(TLRequestBotsReorderPreviewMedias(bot, langCode, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsReorderUsernames(bot: TLAbsInputUser, order: TLStringVector): TLBool = executeMethod(TLRequestBotsReorderUsernames(bot, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsResetBotCommands(scope: TLAbsBotCommandScope, langCode: String): TLBool = executeMethod(TLRequestBotsResetBotCommands(scope, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): TLDataJSON = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSetBotBroadcastDefaultAdminRights(adminRights: TLChatAdminRights): TLBool = executeMethod(TLRequestBotsSetBotBroadcastDefaultAdminRights(adminRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSetBotCommands(
            scope: TLAbsBotCommandScope,
            langCode: String,
            commands: TLObjectVector<TLBotCommand>
    ): TLBool = executeMethod(TLRequestBotsSetBotCommands(scope, langCode, commands))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSetBotGroupDefaultAdminRights(adminRights: TLChatAdminRights): TLBool = executeMethod(TLRequestBotsSetBotGroupDefaultAdminRights(adminRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSetBotInfo(
            bot: TLAbsInputUser?,
            langCode: String,
            name: String?,
            about: String?,
            description: String?
    ): TLBool = executeMethod(TLRequestBotsSetBotInfo(bot, langCode, name, about, description))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSetBotMenuButton(userId: TLAbsInputUser, button: TLAbsBotMenuButton): TLBool = executeMethod(TLRequestBotsSetBotMenuButton(userId, button))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsToggleUsername(
            bot: TLAbsInputUser,
            username: String,
            active: Boolean
    ): TLBool = executeMethod(TLRequestBotsToggleUsername(bot, username, active))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsClickSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): TLBool = executeMethod(TLRequestChannelsClickSponsoredMessage(channel, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsConvertToGigagroup(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsConvertToGigagroup(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            forum: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?,
            ttlPeriod: Int?
    ): TLAbsUpdates = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, forImport, forum, title, about, geoPoint, address, ttlPeriod))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCreateForumTopic(
            channel: TLAbsInputChannel,
            title: String,
            iconColor: Int?,
            iconEmojiId: Long?,
            randomId: Long,
            sendAs: TLAbsInputPeer?
    ): TLAbsUpdates = executeMethod(TLRequestChannelsCreateForumTopic(channel, title, iconColor, iconEmojiId, randomId, sendAs))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeactivateAllUsernames(channel: TLAbsInputChannel): TLBool = executeMethod(TLRequestChannelsDeactivateAllUsernames(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsDeleteChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteHistory(
            forEveryone: Boolean,
            channel: TLAbsInputChannel,
            maxId: Int
    ): TLAbsUpdates = executeMethod(TLRequestChannelsDeleteHistory(forEveryone, channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteParticipantHistory(channel: TLAbsInputChannel, participant: TLAbsInputPeer): TLAffectedHistory = executeMethod(TLRequestChannelsDeleteParticipantHistory(channel, participant))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteTopicHistory(channel: TLAbsInputChannel, topMsgId: Int): TLAffectedHistory = executeMethod(TLRequestChannelsDeleteTopicHistory(channel, topMsgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChatAdminRights,
            rank: String
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights, rank))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            bannedRights: TLChatBannedRights
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditBanned(channel, participant, bannedRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditCreator(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            password: TLAbsInputCheckPasswordSRP
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditCreator(channel, userId, password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditForumTopic(
            channel: TLAbsInputChannel,
            topicId: Int,
            title: String?,
            iconEmojiId: Long?,
            closed: Boolean?,
            hidden: Boolean?
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditForumTopic(channel, topicId, title, iconEmojiId, closed, hidden))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditLocation(
            channel: TLAbsInputChannel,
            geoPoint: TLAbsInputGeoPoint,
            address: String
    ): TLBool = executeMethod(TLRequestChannelsEditLocation(channel, geoPoint, address))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): TLAbsUpdates = executeMethod(TLRequestChannelsEditTitle(channel, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportMessageLink(
            grouped: Boolean,
            thread: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): TLExportedMessageLink = executeMethod(TLRequestChannelsExportMessageLink(grouped, thread, channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): TLAdminLogResults = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminedPublicChannels(
            byLocation: Boolean,
            checkLimit: Boolean,
            forPersonal: Boolean
    ): TLAbsChats = executeMethod(TLRequestChannelsGetAdminedPublicChannels(byLocation, checkLimit, forPersonal))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetChannelRecommendations(channel: TLAbsInputChannel?): TLAbsChats = executeMethod(TLRequestChannelsGetChannelRecommendations(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): TLAbsChats = executeMethod(TLRequestChannelsGetChannels(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetForumTopics(
            channel: TLAbsInputChannel,
            q: String?,
            offsetDate: Int,
            offsetId: Int,
            offsetTopic: Int,
            limit: Int
    ): TLForumTopics = executeMethod(TLRequestChannelsGetForumTopics(channel, q, offsetDate, offsetId, offsetTopic, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetForumTopicsByID(channel: TLAbsInputChannel, topics: TLIntVector): TLForumTopics = executeMethod(TLRequestChannelsGetForumTopicsByID(channel, topics))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetFullChannel(channel: TLAbsInputChannel): TLChatFull = executeMethod(TLRequestChannelsGetFullChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetGroupsForDiscussion(): TLAbsChats = executeMethod(TLRequestChannelsGetGroupsForDiscussion())

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetInactiveChannels(): TLInactiveChats = executeMethod(TLRequestChannelsGetInactiveChannels())

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetLeftChannels(offset: Int): TLAbsChats = executeMethod(TLRequestChannelsGetLeftChannels(offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLObjectVector<TLAbsInputMessage>): TLAbsMessages = executeMethod(TLRequestChannelsGetMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipant(channel: TLAbsInputChannel, participant: TLAbsInputPeer): TLChannelParticipant = executeMethod(TLRequestChannelsGetParticipant(channel, participant))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Long
    ): TLAbsChannelParticipants = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetSendAs(peer: TLAbsInputPeer): TLSendAsPeers = executeMethod(TLRequestChannelsGetSendAs(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetSponsoredMessages(channel: TLAbsInputChannel): TLAbsSponsoredMessages = executeMethod(TLRequestChannelsGetSponsoredMessages(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): TLInvitedUsers = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsJoinChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsJoinChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsLeaveChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsLeaveChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): TLBool = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReorderPinnedForumTopics(
            force: Boolean,
            channel: TLAbsInputChannel,
            order: TLIntVector
    ): TLAbsUpdates = executeMethod(TLRequestChannelsReorderPinnedForumTopics(force, channel, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReorderUsernames(channel: TLAbsInputChannel, order: TLStringVector): TLBool = executeMethod(TLRequestChannelsReorderUsernames(channel, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportAntiSpamFalsePositive(channel: TLAbsInputChannel, msgId: Int): TLBool = executeMethod(TLRequestChannelsReportAntiSpamFalsePositive(channel, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            id: TLIntVector
    ): TLBool = executeMethod(TLRequestChannelsReportSpam(channel, participant, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportSponsoredMessage(
            channel: TLAbsInputChannel,
            randomId: TLBytes,
            option: TLBytes
    ): TLAbsSponsoredMessageReportResult = executeMethod(TLRequestChannelsReportSponsoredMessage(channel, randomId, option))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsRestrictSponsoredMessages(channel: TLAbsInputChannel, restricted: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsRestrictSponsoredMessages(channel, restricted))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSearchPosts(
            hashtag: String,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages = executeMethod(TLRequestChannelsSearchPosts(hashtag, offsetRate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetBoostsToUnblockRestrictions(channel: TLAbsInputChannel, boosts: Int): TLAbsUpdates = executeMethod(TLRequestChannelsSetBoostsToUnblockRestrictions(channel, boosts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetDiscussionGroup(broadcast: TLAbsInputChannel, group: TLAbsInputChannel): TLBool = executeMethod(TLRequestChannelsSetDiscussionGroup(broadcast, group))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetEmojiStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestChannelsSetEmojiStickers(channel, stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleAntiSpam(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleAntiSpam(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleForum(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleForum(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleJoinRequest(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleJoinRequest(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleJoinToSend(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleJoinToSend(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleParticipantsHidden(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleParticipantsHidden(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleSlowMode(channel: TLAbsInputChannel, seconds: Int): TLAbsUpdates = executeMethod(TLRequestChannelsToggleSlowMode(channel, seconds))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleUsername(
            channel: TLAbsInputChannel,
            username: String,
            active: Boolean
    ): TLBool = executeMethod(TLRequestChannelsToggleUsername(channel, username, active))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleViewForumAsMessages(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleViewForumAsMessages(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateColor(
            forProfile: Boolean,
            channel: TLAbsInputChannel,
            color: Int?,
            backgroundEmojiId: Long?
    ): TLAbsUpdates = executeMethod(TLRequestChannelsUpdateColor(forProfile, channel, color, backgroundEmojiId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateEmojiStatus(channel: TLAbsInputChannel, emojiStatus: TLAbsEmojiStatus): TLAbsUpdates = executeMethod(TLRequestChannelsUpdateEmojiStatus(channel, emojiStatus))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdatePinnedForumTopic(
            channel: TLAbsInputChannel,
            topicId: Int,
            pinned: Boolean
    ): TLAbsUpdates = executeMethod(TLRequestChannelsUpdatePinnedForumTopic(channel, topicId, pinned))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsViewSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): TLBool = executeMethod(TLRequestChannelsViewSponsoredMessage(channel, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsCheckChatlistInvite(slug: String): TLAbsChatlistInvite = executeMethod(TLRequestChatlistsCheckChatlistInvite(slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsDeleteExportedInvite(chatlist: TLInputChatlistDialogFilter, slug: String): TLBool = executeMethod(TLRequestChatlistsDeleteExportedInvite(chatlist, slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsEditExportedInvite(
            chatlist: TLInputChatlistDialogFilter,
            slug: String,
            title: String?,
            peers: TLObjectVector<TLAbsInputPeer>?
    ): TLExportedChatlistInvite = executeMethod(TLRequestChatlistsEditExportedInvite(chatlist, slug, title, peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsExportChatlistInvite(
            chatlist: TLInputChatlistDialogFilter,
            title: String,
            peers: TLObjectVector<TLAbsInputPeer>
    ): com.github.badoualy.telegram.tl.api.chatlists.TLExportedChatlistInvite = executeMethod(TLRequestChatlistsExportChatlistInvite(chatlist, title, peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsGetChatlistUpdates(chatlist: TLInputChatlistDialogFilter): TLChatlistUpdates = executeMethod(TLRequestChatlistsGetChatlistUpdates(chatlist))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsGetExportedInvites(chatlist: TLInputChatlistDialogFilter): TLExportedInvites = executeMethod(TLRequestChatlistsGetExportedInvites(chatlist))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsGetLeaveChatlistSuggestions(chatlist: TLInputChatlistDialogFilter): TLObjectVector<TLAbsPeer> = executeMethod(TLRequestChatlistsGetLeaveChatlistSuggestions(chatlist))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsHideChatlistUpdates(chatlist: TLInputChatlistDialogFilter): TLBool = executeMethod(TLRequestChatlistsHideChatlistUpdates(chatlist))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsJoinChatlistInvite(slug: String, peers: TLObjectVector<TLAbsInputPeer>): TLAbsUpdates = executeMethod(TLRequestChatlistsJoinChatlistInvite(slug, peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsJoinChatlistUpdates(chatlist: TLInputChatlistDialogFilter, peers: TLObjectVector<TLAbsInputPeer>): TLAbsUpdates = executeMethod(TLRequestChatlistsJoinChatlistUpdates(chatlist, peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun chatlistsLeaveChatlist(chatlist: TLInputChatlistDialogFilter, peers: TLObjectVector<TLAbsInputPeer>): TLAbsUpdates = executeMethod(TLRequestChatlistsLeaveChatlist(chatlist, peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsAcceptContact(id: TLAbsInputUser): TLAbsUpdates = executeMethod(TLRequestContactsAcceptContact(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsAddContact(
            addPhonePrivacyException: Boolean,
            id: TLAbsInputUser,
            firstName: String,
            lastName: String,
            phone: String
    ): TLAbsUpdates = executeMethod(TLRequestContactsAddContact(addPhonePrivacyException, id, firstName, lastName, phone))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsBlock(myStoriesFrom: Boolean, id: TLAbsInputPeer): TLBool = executeMethod(TLRequestContactsBlock(myStoriesFrom, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsBlockFromReplies(
            deleteMessage: Boolean,
            deleteHistory: Boolean,
            reportSpam: Boolean,
            msgId: Int
    ): TLAbsUpdates = executeMethod(TLRequestContactsBlockFromReplies(deleteMessage, deleteHistory, reportSpam, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteByPhones(phones: TLStringVector): TLBool = executeMethod(TLRequestContactsDeleteByPhones(phones))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): TLAbsUpdates = executeMethod(TLRequestContactsDeleteContacts(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsEditCloseFriends(id: TLLongVector): TLBool = executeMethod(TLRequestContactsEditCloseFriends(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsExportContactToken(): TLExportedContactToken = executeMethod(TLRequestContactsExportContactToken())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetBirthdays(): TLContactBirthdays = executeMethod(TLRequestContactsGetBirthdays())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetBlocked(
            myStoriesFrom: Boolean,
            offset: Int,
            limit: Int
    ): TLAbsBlocked = executeMethod(TLRequestContactsGetBlocked(myStoriesFrom, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetContactIDs(hash: Long): TLIntVector = executeMethod(TLRequestContactsGetContactIDs(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetContacts(hash: Long): TLAbsContacts = executeMethod(TLRequestContactsGetContacts(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetLocated(
            background: Boolean,
            geoPoint: TLAbsInputGeoPoint,
            selfExpires: Int?
    ): TLAbsUpdates = executeMethod(TLRequestContactsGetLocated(background, geoPoint, selfExpires))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetSaved(): TLObjectVector<TLSavedPhoneContact> = executeMethod(TLRequestContactsGetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetStatuses(): TLObjectVector<TLContactStatus> = executeMethod(TLRequestContactsGetStatuses())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            forwardUsers: Boolean,
            forwardChats: Boolean,
            groups: Boolean,
            channels: Boolean,
            botsApp: Boolean,
            offset: Int,
            limit: Int,
            hash: Long
    ): TLAbsTopPeers = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, forwardUsers, forwardChats, groups, channels, botsApp, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportContactToken(token: String): TLAbsUser = executeMethod(TLRequestContactsImportContactToken(token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): TLImportedContacts = executeMethod(TLRequestContactsImportContacts(contacts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetSaved(): TLBool = executeMethod(TLRequestContactsResetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResolvePhone(phone: String): TLResolvedPeer = executeMethod(TLRequestContactsResolvePhone(phone))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResolveUsername(username: String): TLResolvedPeer = executeMethod(TLRequestContactsResolveUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsSearch(q: String, limit: Int): TLFound = executeMethod(TLRequestContactsSearch(q, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsSetBlocked(
            myStoriesFrom: Boolean,
            id: TLObjectVector<TLAbsInputPeer>,
            limit: Int
    ): TLBool = executeMethod(TLRequestContactsSetBlocked(myStoriesFrom, id, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsToggleTopPeers(enabled: Boolean): TLBool = executeMethod(TLRequestContactsToggleTopPeers(enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsUnblock(myStoriesFrom: Boolean, id: TLAbsInputPeer): TLBool = executeMethod(TLRequestContactsUnblock(myStoriesFrom, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun foldersEditPeerFolders(folderPeers: TLObjectVector<TLInputFolderPeer>): TLAbsUpdates = executeMethod(TLRequestFoldersEditPeerFolders(folderPeers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun fragmentGetCollectibleInfo(collectible: TLAbsInputCollectible): TLCollectibleInfo = executeMethod(TLRequestFragmentGetCollectibleInfo(collectible))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpAcceptTermsOfService(id: TLDataJSON): TLBool = executeMethod(TLRequestHelpAcceptTermsOfService(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpDismissSuggestion(peer: TLAbsInputPeer, suggestion: String): TLBool = executeMethod(TLRequestHelpDismissSuggestion(peer, suggestion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpEditUserInfo(
            userId: TLAbsInputUser,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>
    ): TLAbsUserInfo = executeMethod(TLRequestHelpEditUserInfo(userId, message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppConfig(hash: Int): TLAbsAppConfig = executeMethod(TLRequestHelpGetAppConfig(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppUpdate(source: String): TLAbsAppUpdate = executeMethod(TLRequestHelpGetAppUpdate(source))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetCdnConfig(): TLCdnConfig = executeMethod(TLRequestHelpGetCdnConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetConfig(): TLConfig = executeMethod(TLRequestHelpGetConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetCountriesList(langCode: String, hash: Int): TLAbsCountriesList = executeMethod(TLRequestHelpGetCountriesList(langCode, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetDeepLinkInfo(path: String): TLAbsDeepLinkInfo = executeMethod(TLRequestHelpGetDeepLinkInfo(path))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetInviteText(): TLInviteText = executeMethod(TLRequestHelpGetInviteText())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetNearestDc(): TLNearestDc = executeMethod(TLRequestHelpGetNearestDc())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetPassportConfig(hash: Int): TLAbsPassportConfig = executeMethod(TLRequestHelpGetPassportConfig(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetPeerColors(hash: Int): TLAbsPeerColors = executeMethod(TLRequestHelpGetPeerColors(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetPeerProfileColors(hash: Int): TLAbsPeerColors = executeMethod(TLRequestHelpGetPeerProfileColors(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetPremiumPromo(): TLPremiumPromo = executeMethod(TLRequestHelpGetPremiumPromo())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetPromoData(): TLAbsPromoData = executeMethod(TLRequestHelpGetPromoData())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetRecentMeUrls(referer: String): TLRecentMeUrls = executeMethod(TLRequestHelpGetRecentMeUrls(referer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetSupport(): TLSupport = executeMethod(TLRequestHelpGetSupport())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetSupportName(): TLSupportName = executeMethod(TLRequestHelpGetSupportName())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetTermsOfServiceUpdate(): TLAbsTermsOfServiceUpdate = executeMethod(TLRequestHelpGetTermsOfServiceUpdate())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetTimezonesList(hash: Int): TLAbsTimezonesList = executeMethod(TLRequestHelpGetTimezonesList(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetUserInfo(userId: TLAbsInputUser): TLAbsUserInfo = executeMethod(TLRequestHelpGetUserInfo(userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpHidePromoData(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestHelpHidePromoData(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): TLBool = executeMethod(TLRequestHelpSaveAppLog(events))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): TLBool = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            proxy: TLInputClientProxy?,
            params: TLAbsJSONValue?,
            query: TLMethod<T>?
    ): T = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, params, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithApnsSecret(
            nonce: String,
            secret: String,
            query: TLMethod<T>?
    ): T = executeMethod(TLRequestInvokeWithApnsSecret(nonce, secret, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithBusinessConnection(connectionId: String, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithBusinessConnection(connectionId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithGooglePlayIntegrity(
            nonce: String,
            token: String,
            query: TLMethod<T>?
    ): T = executeMethod(TLRequestInvokeWithGooglePlayIntegrity(nonce, token, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithLayer(layer, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithMessagesRange(range: TLMessageRange, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithMessagesRange(range, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithTakeout(takeoutId: Long, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithTakeout(takeoutId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithoutUpdates(query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetDifference(
            langPack: String,
            langCode: String,
            fromVersion: Int
    ): TLLangPackDifference = executeMethod(TLRequestLangpackGetDifference(langPack, langCode, fromVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLangPack(langPack: String, langCode: String): TLLangPackDifference = executeMethod(TLRequestLangpackGetLangPack(langPack, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLanguage(langPack: String, langCode: String): TLLangPackLanguage = executeMethod(TLRequestLangpackGetLanguage(langPack, langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLanguages(langPack: String): TLObjectVector<TLLangPackLanguage> = executeMethod(TLRequestLangpackGetLanguages(langPack))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetStrings(
            langPack: String,
            langCode: String,
            keys: TLStringVector
    ): TLObjectVector<TLAbsLangPackString> = executeMethod(TLRequestLangpackGetStrings(langPack, langCode, keys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAcceptUrlAuth(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): TLAbsUrlAuthResult = executeMethod(TLRequestMessagesAcceptUrlAuth(writeAllowed, peer, msgId, buttonId, url))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAddChatUser(
            chatId: Long,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): TLInvitedUsers = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckChatInvite(hash: String): TLAbsChatInvite = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckHistoryImport(importHead: String): TLHistoryImportParsed = executeMethod(TLRequestMessagesCheckHistoryImport(importHead))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckHistoryImportPeer(peer: TLAbsInputPeer): TLCheckedHistoryImportPeer = executeMethod(TLRequestMessagesCheckHistoryImportPeer(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckQuickReplyShortcut(shortcut: String): TLBool = executeMethod(TLRequestMessagesCheckQuickReplyShortcut(shortcut))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearAllDrafts(): TLBool = executeMethod(TLRequestMessagesClearAllDrafts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearRecentReactions(): TLBool = executeMethod(TLRequestMessagesClearRecentReactions())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearRecentStickers(attached: Boolean): TLBool = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCreateChat(
            users: TLObjectVector<TLAbsInputUser>,
            title: String,
            ttlPeriod: Int?
    ): TLInvitedUsers = executeMethod(TLRequestMessagesCreateChat(users, title, ttlPeriod))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteChat(chatId: Long): TLBool = executeMethod(TLRequestMessagesDeleteChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteChatUser(
            revokeHistory: Boolean,
            chatId: Long,
            userId: TLAbsInputUser
    ): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteChatUser(revokeHistory, chatId, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteExportedChatInvite(peer: TLAbsInputPeer, link: String): TLBool = executeMethod(TLRequestMessagesDeleteExportedChatInvite(peer, link))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteFactCheck(peer: TLAbsInputPeer, msgId: Int): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteFactCheck(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteHistory(
            justClear: Boolean,
            revoke: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int,
            minDate: Int?,
            maxDate: Int?
    ): TLAffectedHistory = executeMethod(TLRequestMessagesDeleteHistory(justClear, revoke, peer, maxId, minDate, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeletePhoneCallHistory(revoke: Boolean): TLAffectedFoundMessages = executeMethod(TLRequestMessagesDeletePhoneCallHistory(revoke))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteQuickReplyMessages(shortcutId: Int, id: TLIntVector): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteQuickReplyMessages(shortcutId, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteQuickReplyShortcut(shortcutId: Int): TLBool = executeMethod(TLRequestMessagesDeleteQuickReplyShortcut(shortcutId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteRevokedExportedChatInvites(peer: TLAbsInputPeer, adminId: TLAbsInputUser): TLBool = executeMethod(TLRequestMessagesDeleteRevokedExportedChatInvites(peer, adminId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteSavedHistory(
            peer: TLAbsInputPeer,
            maxId: Int,
            minDate: Int?,
            maxDate: Int?
    ): TLAffectedHistory = executeMethod(TLRequestMessagesDeleteSavedHistory(peer, maxId, minDate, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteScheduledMessages(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDiscardEncryption(deleteHistory: Boolean, chatId: Int): TLBool = executeMethod(TLRequestMessagesDiscardEncryption(deleteHistory, chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatAbout(peer: TLAbsInputPeer, about: String): TLBool = executeMethod(TLRequestMessagesEditChatAbout(peer, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatAdmin(
            chatId: Long,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): TLBool = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatDefaultBannedRights(peer: TLAbsInputPeer, bannedRights: TLChatBannedRights): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatDefaultBannedRights(peer, bannedRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatPhoto(chatId: Long, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatTitle(chatId: Long, title: String): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditExportedChatInvite(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            link: String,
            expireDate: Int?,
            usageLimit: Int?,
            requestNeeded: Boolean?,
            title: String?
    ): com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite = executeMethod(TLRequestMessagesEditExportedChatInvite(revoked, peer, link, expireDate, usageLimit, requestNeeded, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditFactCheck(
            peer: TLAbsInputPeer,
            msgId: Int,
            text: TLTextWithEntities
    ): TLAbsUpdates = executeMethod(TLRequestMessagesEditFactCheck(peer, msgId, text))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            invertMedia: Boolean,
            id: TLAbsInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, invertMedia, id, message, media, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditMessage(
            noWebpage: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            quickReplyShortcutId: Int?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesEditMessage(noWebpage, invertMedia, peer, id, message, media, replyMarkup, entities, scheduleDate, quickReplyShortcutId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditQuickReplyShortcut(shortcutId: Int, shortcut: String): TLBool = executeMethod(TLRequestMessagesEditQuickReplyShortcut(shortcutId, shortcut))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesExportChatInvite(
            legacyRevokePermanent: Boolean,
            requestNeeded: Boolean,
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?,
            title: String?
    ): TLAbsExportedChatInvite = executeMethod(TLRequestMessagesExportChatInvite(legacyRevokePermanent, requestNeeded, peer, expireDate, usageLimit, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): TLBool = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            dropAuthor: Boolean,
            dropMediaCaptions: Boolean,
            noforwards: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer,
            topMsgId: Int?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, dropAuthor, dropMediaCaptions, noforwards, fromPeer, id, randomId, toPeer, topMsgId, scheduleDate, sendAs, quickReplyShortcut))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAdminsWithInvites(peer: TLAbsInputPeer): TLChatAdminsWithInvites = executeMethod(TLRequestMessagesGetAdminsWithInvites(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllDrafts(): TLAbsUpdates = executeMethod(TLRequestMessagesGetAllDrafts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllStickers(hash: Long): TLAbsAllStickers = executeMethod(TLRequestMessagesGetAllStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetArchivedStickers(
            masks: Boolean,
            emojis: Boolean,
            offsetId: Long,
            limit: Int
    ): TLArchivedStickers = executeMethod(TLRequestMessagesGetArchivedStickers(masks, emojis, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachMenuBot(bot: TLAbsInputUser): TLAttachMenuBotsBot = executeMethod(TLRequestMessagesGetAttachMenuBot(bot))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachMenuBots(hash: Long): TLAbsAttachMenuBots = executeMethod(TLRequestMessagesGetAttachMenuBots(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): TLObjectVector<TLAbsStickerSetCovered> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAvailableEffects(hash: Int): TLAbsAvailableEffects = executeMethod(TLRequestMessagesGetAvailableEffects(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAvailableReactions(hash: Int): TLAbsAvailableReactions = executeMethod(TLRequestMessagesGetAvailableReactions(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetBotApp(app: TLAbsInputBotApp, hash: Long): TLBotApp = executeMethod(TLRequestMessagesGetBotApp(app, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?,
            password: TLAbsInputCheckPasswordSRP?
    ): TLBotCallbackAnswer = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data, password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetChatInviteImporters(
            requested: Boolean,
            subscriptionExpired: Boolean,
            peer: TLAbsInputPeer,
            link: String?,
            q: String?,
            offsetDate: Int,
            offsetUser: TLAbsInputUser,
            limit: Int
    ): TLChatInviteImporters = executeMethod(TLRequestMessagesGetChatInviteImporters(requested, subscriptionExpired, peer, link, q, offsetDate, offsetUser, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetChats(id: TLLongVector): TLAbsChats = executeMethod(TLRequestMessagesGetChats(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Long,
            limit: Int
    ): TLAbsChats = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetCustomEmojiDocuments(documentId: TLLongVector): TLObjectVector<TLAbsDocument> = executeMethod(TLRequestMessagesGetCustomEmojiDocuments(documentId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDefaultHistoryTTL(): TLDefaultHistoryTTL = executeMethod(TLRequestMessagesGetDefaultHistoryTTL())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDefaultTagReactions(hash: Long): TLAbsReactions = executeMethod(TLRequestMessagesGetDefaultTagReactions(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDhConfig(version: Int, randomLength: Int): TLAbsDhConfig = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogFilters(): TLDialogFilters = executeMethod(TLRequestMessagesGetDialogFilters())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogUnreadMarks(): TLObjectVector<TLAbsDialogPeer> = executeMethod(TLRequestMessagesGetDialogUnreadMarks())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogs(
            excludePinned: Boolean,
            folderId: Int?,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): TLAbsDialogs = executeMethod(TLRequestMessagesGetDialogs(excludePinned, folderId, offsetDate, offsetId, offsetPeer, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDiscussionMessage(peer: TLAbsInputPeer, msgId: Int): TLDiscussionMessage = executeMethod(TLRequestMessagesGetDiscussionMessage(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Long,
            mimeType: String
    ): TLAbsDocument = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiGroups(hash: Int): TLAbsEmojiGroups = executeMethod(TLRequestMessagesGetEmojiGroups(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiKeywords(langCode: String): TLEmojiKeywordsDifference = executeMethod(TLRequestMessagesGetEmojiKeywords(langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiKeywordsDifference(langCode: String, fromVersion: Int): TLEmojiKeywordsDifference = executeMethod(TLRequestMessagesGetEmojiKeywordsDifference(langCode, fromVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiKeywordsLanguages(langCodes: TLStringVector): TLObjectVector<TLEmojiLanguage> = executeMethod(TLRequestMessagesGetEmojiKeywordsLanguages(langCodes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiProfilePhotoGroups(hash: Int): TLAbsEmojiGroups = executeMethod(TLRequestMessagesGetEmojiProfilePhotoGroups(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiStatusGroups(hash: Int): TLAbsEmojiGroups = executeMethod(TLRequestMessagesGetEmojiStatusGroups(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiStickerGroups(hash: Int): TLAbsEmojiGroups = executeMethod(TLRequestMessagesGetEmojiStickerGroups(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiStickers(hash: Long): TLAbsAllStickers = executeMethod(TLRequestMessagesGetEmojiStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetEmojiURL(langCode: String): TLEmojiURL = executeMethod(TLRequestMessagesGetEmojiURL(langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetExportedChatInvite(peer: TLAbsInputPeer, link: String): com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite = executeMethod(TLRequestMessagesGetExportedChatInvite(peer, link))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetExportedChatInvites(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            adminId: TLAbsInputUser,
            offsetDate: Int?,
            offsetLink: String?,
            limit: Int
    ): TLExportedChatInvites = executeMethod(TLRequestMessagesGetExportedChatInvites(revoked, peer, adminId, offsetDate, offsetLink, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetExtendedMedia(peer: TLAbsInputPeer, id: TLIntVector): TLAbsUpdates = executeMethod(TLRequestMessagesGetExtendedMedia(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFactCheck(peer: TLAbsInputPeer, msgId: TLIntVector): TLObjectVector<TLFactCheck> = executeMethod(TLRequestMessagesGetFactCheck(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFavedStickers(hash: Long): TLAbsFavedStickers = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFeaturedEmojiStickers(hash: Long): TLAbsFeaturedStickers = executeMethod(TLRequestMessagesGetFeaturedEmojiStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFeaturedStickers(hash: Long): TLAbsFeaturedStickers = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFullChat(chatId: Long): TLChatFull = executeMethod(TLRequestMessagesGetFullChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): TLHighScores = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): TLBotResults = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineGameHighScores(id: TLAbsInputBotInlineMessageID, userId: TLAbsInputUser): TLHighScores = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMaskStickers(hash: Long): TLAbsAllStickers = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): TLMessageEditData = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageReactionsList(
            peer: TLAbsInputPeer,
            id: Int,
            reaction: TLAbsReaction?,
            offset: String?,
            limit: Int
    ): TLMessageReactionsList = executeMethod(TLRequestMessagesGetMessageReactionsList(peer, id, reaction, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageReadParticipants(peer: TLAbsInputPeer, msgId: Int): TLObjectVector<TLReadParticipantDate> = executeMethod(TLRequestMessagesGetMessageReadParticipants(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): TLAbsMessages = executeMethod(TLRequestMessagesGetMessages(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessagesReactions(peer: TLAbsInputPeer, id: TLIntVector): TLAbsUpdates = executeMethod(TLRequestMessagesGetMessagesReactions(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): TLMessageViews = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMyStickers(offsetId: Long, limit: Int): TLMyStickers = executeMethod(TLRequestMessagesGetMyStickers(offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetOldFeaturedStickers(
            offset: Int,
            limit: Int,
            hash: Long
    ): TLAbsFeaturedStickers = executeMethod(TLRequestMessagesGetOldFeaturedStickers(offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetOnlines(peer: TLAbsInputPeer): TLChatOnlines = executeMethod(TLRequestMessagesGetOnlines(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetOutboxReadDate(peer: TLAbsInputPeer, msgId: Int): TLOutboxReadDate = executeMethod(TLRequestMessagesGetOutboxReadDate(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputDialogPeer>): TLPeerDialogs = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): TLPeerSettings = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPinnedDialogs(folderId: Int): TLPeerDialogs = executeMethod(TLRequestMessagesGetPinnedDialogs(folderId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPinnedSavedDialogs(): TLAbsSavedDialogs = executeMethod(TLRequestMessagesGetPinnedSavedDialogs())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPollResults(peer: TLAbsInputPeer, msgId: Int): TLAbsUpdates = executeMethod(TLRequestMessagesGetPollResults(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPollVotes(
            peer: TLAbsInputPeer,
            id: Int,
            option: TLBytes?,
            offset: String?,
            limit: Int
    ): TLVotesList = executeMethod(TLRequestMessagesGetPollVotes(peer, id, option, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetQuickReplies(hash: Long): TLAbsQuickReplies = executeMethod(TLRequestMessagesGetQuickReplies(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetQuickReplyMessages(
            shortcutId: Int,
            id: TLIntVector?,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetQuickReplyMessages(shortcutId, id, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentLocations(
            peer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetRecentLocations(peer, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentReactions(limit: Int, hash: Long): TLAbsReactions = executeMethod(TLRequestMessagesGetRecentReactions(limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentStickers(attached: Boolean, hash: Long): TLAbsRecentStickers = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetReplies(
            peer: TLAbsInputPeer,
            msgId: Int,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetReplies(peer, msgId, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): TLAbsSavedDialogs = executeMethod(TLRequestMessagesGetSavedDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedGifs(hash: Long): TLAbsSavedGifs = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetSavedHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedReactionTags(peer: TLAbsInputPeer?, hash: Long): TLAbsSavedReactionTags = executeMethod(TLRequestMessagesGetSavedReactionTags(peer, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetScheduledHistory(peer: TLAbsInputPeer, hash: Long): TLAbsMessages = executeMethod(TLRequestMessagesGetScheduledHistory(peer, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): TLAbsMessages = executeMethod(TLRequestMessagesGetScheduledMessages(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSearchCounters(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            topMsgId: Int?,
            filters: TLObjectVector<TLAbsMessagesFilter>
    ): TLObjectVector<TLSearchCounter> = executeMethod(TLRequestMessagesGetSearchCounters(peer, savedPeerId, topMsgId, filters))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSearchResultsCalendar(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            filter: TLAbsMessagesFilter,
            offsetId: Int,
            offsetDate: Int
    ): TLSearchResultsCalendar = executeMethod(TLRequestMessagesGetSearchResultsCalendar(peer, savedPeerId, filter, offsetId, offsetDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSearchResultsPositions(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            filter: TLAbsMessagesFilter,
            offsetId: Int,
            limit: Int
    ): TLSearchResultsPositions = executeMethod(TLRequestMessagesGetSearchResultsPositions(peer, savedPeerId, filter, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSplitRanges(): TLObjectVector<TLMessageRange> = executeMethod(TLRequestMessagesGetSplitRanges())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet, hash: Int): TLAbsStickerSet = executeMethod(TLRequestMessagesGetStickerSet(stickerset, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickers(emoticon: String, hash: Long): TLAbsStickers = executeMethod(TLRequestMessagesGetStickers(emoticon, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSuggestedDialogFilters(): TLObjectVector<TLDialogFilterSuggested> = executeMethod(TLRequestMessagesGetSuggestedDialogFilters())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetTopReactions(limit: Int, hash: Long): TLAbsReactions = executeMethod(TLRequestMessagesGetTopReactions(limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetUnreadMentions(peer, topMsgId, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetUnreadReactions(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetUnreadReactions(peer, topMsgId, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPage(url: String, hash: Int): TLWebPage = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): TLAbsMessageMedia = executeMethod(TLRequestMessagesGetWebPagePreview(message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHideAllChatJoinRequests(
            approved: Boolean,
            peer: TLAbsInputPeer,
            link: String?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesHideAllChatJoinRequests(approved, peer, link))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHideChatJoinRequest(
            approved: Boolean,
            peer: TLAbsInputPeer,
            userId: TLAbsInputUser
    ): TLAbsUpdates = executeMethod(TLRequestMessagesHideChatJoinRequest(approved, peer, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHidePeerSettingsBar(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesHidePeerSettingsBar(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesImportChatInvite(hash: String): TLAbsUpdates = executeMethod(TLRequestMessagesImportChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesInitHistoryImport(
            peer: TLAbsInputPeer,
            file: TLAbsInputFile,
            mediaCount: Int
    ): TLHistoryImport = executeMethod(TLRequestMessagesInitHistoryImport(peer, file, mediaCount))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): TLAbsStickerSetInstallResult = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMarkDialogUnread(unread: Boolean, peer: TLAbsInputDialogPeer): TLBool = executeMethod(TLRequestMessagesMarkDialogUnread(unread, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMigrateChat(chatId: Long): TLAbsUpdates = executeMethod(TLRequestMessagesMigrateChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesProlongWebView(
            silent: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            queryId: Long,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ): TLBool = executeMethod(TLRequestMessagesProlongWebView(silent, peer, bot, queryId, replyTo, sendAs))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRateTranscribedAudio(
            peer: TLAbsInputPeer,
            msgId: Int,
            transcriptionId: Long,
            good: Boolean
    ): TLBool = executeMethod(TLRequestMessagesRateTranscribedAudio(peer, msgId, transcriptionId, good))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadDiscussion(
            peer: TLAbsInputPeer,
            msgId: Int,
            readMaxId: Int
    ): TLBool = executeMethod(TLRequestMessagesReadDiscussion(peer, msgId, readMaxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): TLBool = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadFeaturedStickers(id: TLLongVector): TLBool = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): TLAffectedMessages = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMentions(peer: TLAbsInputPeer, topMsgId: Int?): TLAffectedHistory = executeMethod(TLRequestMessagesReadMentions(peer, topMsgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMessageContents(id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesReadMessageContents(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadReactions(peer: TLAbsInputPeer, topMsgId: Int?): TLAffectedHistory = executeMethod(TLRequestMessagesReadReactions(peer, topMsgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedMessages(maxId: Int): TLObjectVector<TLReceivedNotifyMessage> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedQueue(maxQts: Int): TLLongVector = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderPinnedDialogs(
            force: Boolean,
            folderId: Int,
            order: TLObjectVector<TLAbsInputDialogPeer>
    ): TLBool = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, folderId, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderPinnedSavedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputDialogPeer>): TLBool = executeMethod(TLRequestMessagesReorderPinnedSavedDialogs(force, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderQuickReplies(order: TLIntVector): TLBool = executeMethod(TLRequestMessagesReorderQuickReplies(order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderStickerSets(
            masks: Boolean,
            emojis: Boolean,
            order: TLLongVector
    ): TLBool = executeMethod(TLRequestMessagesReorderStickerSets(masks, emojis, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): TLBool = executeMethod(TLRequestMessagesReport(peer, id, reason, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): TLBool = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportReaction(
            peer: TLAbsInputPeer,
            id: Int,
            reactionPeer: TLAbsInputPeer
    ): TLBool = executeMethod(TLRequestMessagesReportReaction(peer, id, reactionPeer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportSpam(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestAppWebView(
            writeAllowed: Boolean,
            compact: Boolean,
            peer: TLAbsInputPeer,
            app: TLAbsInputBotApp,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ): TLWebViewResultUrl = executeMethod(TLRequestMessagesRequestAppWebView(writeAllowed, compact, peer, app, startParam, themeParams, platform))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestMainWebView(
            compact: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ): TLWebViewResultUrl = executeMethod(TLRequestMessagesRequestMainWebView(compact, peer, bot, startParam, themeParams, platform))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestSimpleWebView(
            fromSwitchWebview: Boolean,
            fromSideMenu: Boolean,
            compact: Boolean,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ): TLWebViewResultUrl = executeMethod(TLRequestMessagesRequestSimpleWebView(fromSwitchWebview, fromSideMenu, compact, bot, url, startParam, themeParams, platform))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestUrlAuth(
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): TLAbsUrlAuthResult = executeMethod(TLRequestMessagesRequestUrlAuth(peer, msgId, buttonId, url))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestWebView(
            fromBotMenu: Boolean,
            silent: Boolean,
            compact: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ): TLWebViewResultUrl = executeMethod(TLRequestMessagesRequestWebView(fromBotMenu, silent, compact, peer, bot, url, startParam, themeParams, platform, replyTo, sendAs))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveDefaultSendAs(peer: TLAbsInputPeer, sendAs: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesSaveDefaultSendAs(peer, sendAs))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveDraft(
            noWebpage: Boolean,
            invertMedia: Boolean,
            replyTo: TLAbsInputReplyTo?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            media: TLAbsInputMedia?,
            effect: Long?
    ): TLBool = executeMethod(TLRequestMessagesSaveDraft(noWebpage, invertMedia, replyTo, peer, message, entities, media, effect))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): TLBool = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): TLBool = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearch(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputPeer?,
            savedPeerId: TLAbsInputPeer?,
            savedReaction: TLObjectVector<TLAbsReaction>?,
            topMsgId: Int?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearch(peer, q, fromId, savedPeerId, savedReaction, topMsgId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchCustomEmoji(emoticon: String, hash: Long): TLAbsEmojiList = executeMethod(TLRequestMessagesSearchCustomEmoji(emoticon, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchEmojiStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): TLAbsFoundStickerSets = executeMethod(TLRequestMessagesSearchEmojiStickerSets(excludeFeatured, q, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGlobal(
            broadcastsOnly: Boolean,
            folderId: Int?,
            q: String,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearchGlobal(broadcastsOnly, folderId, q, filter, minDate, maxDate, offsetRate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchSentMedia(
            q: String,
            filter: TLAbsMessagesFilter,
            limit: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearchSentMedia(q, filter, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): TLAbsFoundStickerSets = executeMethod(TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendBotRequestedPeer(
            peer: TLAbsInputPeer,
            msgId: Int,
            buttonId: Int,
            requestedPeers: TLObjectVector<TLAbsInputPeer>
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendBotRequestedPeer(peer, msgId, buttonId, requestedPeers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncrypted(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncrypted(silent, peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedFile(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedFile(silent, peer, randomId, data, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            hideVia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            randomId: Long,
            queryId: Long,
            id: String,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, hideVia, peer, replyTo, randomId, queryId, id, scheduleDate, sendAs, quickReplyShortcut))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            media: TLAbsInputMedia,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?,
            effect: Long?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, peer, replyTo, media, message, randomId, replyMarkup, entities, scheduleDate, sendAs, quickReplyShortcut, effect))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?,
            effect: Long?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, peer, replyTo, message, randomId, replyMarkup, entities, scheduleDate, sendAs, quickReplyShortcut, effect))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?,
            quickReplyShortcut: TLAbsInputQuickReplyShortcut?,
            effect: Long?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMultiMedia(silent, background, clearDraft, noforwards, updateStickersetsOrder, invertMedia, peer, replyTo, multiMedia, scheduleDate, sendAs, quickReplyShortcut, effect))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendQuickReplyMessages(
            peer: TLAbsInputPeer,
            shortcutId: Int,
            id: TLIntVector,
            randomId: TLLongVector
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendQuickReplyMessages(peer, shortcutId, id, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendReaction(
            big: Boolean,
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            reaction: TLObjectVector<TLAbsReaction>?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendReaction(big, addToRecent, peer, msgId, reaction))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): TLAbsUpdates = executeMethod(TLRequestMessagesSendScheduledMessages(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo,
            randomId: Long
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyTo, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendVote(
            peer: TLAbsInputPeer,
            msgId: Int,
            options: TLBytesVector
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendVote(peer, msgId, options))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendWebViewData(
            bot: TLAbsInputUser,
            randomId: Long,
            buttonText: String,
            data: String
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendWebViewData(bot, randomId, buttonText, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendWebViewResultMessage(botQueryId: String, result: TLAbsInputBotInlineResult): TLWebViewMessageSent = executeMethod(TLRequestMessagesSendWebViewResultMessage(botQueryId, result))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): TLBool = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): TLBool = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): TLBool = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetChatAvailableReactions(
            peer: TLAbsInputPeer,
            availableReactions: TLAbsChatReactions,
            reactionsLimit: Int?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSetChatAvailableReactions(peer, availableReactions, reactionsLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetChatTheme(peer: TLAbsInputPeer, emoticon: String): TLAbsUpdates = executeMethod(TLRequestMessagesSetChatTheme(peer, emoticon))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetChatWallPaper(
            forBoth: Boolean,
            revert: Boolean,
            peer: TLAbsInputPeer,
            wallpaper: TLAbsInputWallPaper?,
            settings: TLWallPaperSettings?,
            id: Int?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSetChatWallPaper(forBoth, revert, peer, wallpaper, settings, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetDefaultHistoryTTL(period: Int): TLBool = executeMethod(TLRequestMessagesSetDefaultHistoryTTL(period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetDefaultReaction(reaction: TLAbsReaction): TLBool = executeMethod(TLRequestMessagesSetDefaultReaction(reaction))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): TLBool = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetHistoryTTL(peer: TLAbsInputPeer, period: Int): TLAbsUpdates = executeMethod(TLRequestMessagesSetHistoryTTL(peer, period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?,
            switchWebview: TLInlineBotWebView?
    ): TLBool = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm, switchWebview))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLAbsInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): TLBool = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetTyping(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            action: TLAbsSendMessageAction
    ): TLBool = executeMethod(TLRequestMessagesSetTyping(peer, topMsgId, action))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): TLAbsUpdates = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesStartHistoryImport(peer: TLAbsInputPeer, importId: Long): TLBool = executeMethod(TLRequestMessagesStartHistoryImport(peer, importId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleBotInAttachMenu(
            writeAllowed: Boolean,
            bot: TLAbsInputUser,
            enabled: Boolean
    ): TLBool = executeMethod(TLRequestMessagesToggleBotInAttachMenu(writeAllowed, bot, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleDialogFilterTags(enabled: Boolean): TLBool = executeMethod(TLRequestMessagesToggleDialogFilterTags(enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): TLBool = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleNoForwards(peer: TLAbsInputPeer, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestMessagesToggleNoForwards(peer, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesTogglePeerTranslations(disabled: Boolean, peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesTogglePeerTranslations(disabled, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleSavedDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): TLBool = executeMethod(TLRequestMessagesToggleSavedDialogPin(pinned, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleStickerSets(
            uninstall: Boolean,
            archive: Boolean,
            unarchive: Boolean,
            stickersets: TLObjectVector<TLAbsInputStickerSet>
    ): TLBool = executeMethod(TLRequestMessagesToggleStickerSets(uninstall, archive, unarchive, stickersets))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesTranscribeAudio(peer: TLAbsInputPeer, msgId: Int): TLTranscribedAudio = executeMethod(TLRequestMessagesTranscribeAudio(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesTranslateText(
            peer: TLAbsInputPeer?,
            id: TLIntVector?,
            text: TLObjectVector<TLTextWithEntities>?,
            toLang: String
    ): TLTranslateResult = executeMethod(TLRequestMessagesTranslateText(peer, id, text, toLang))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUnpinAllMessages(peer: TLAbsInputPeer, topMsgId: Int?): TLAffectedHistory = executeMethod(TLRequestMessagesUnpinAllMessages(peer, topMsgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUpdateDialogFilter(id: Int, filter: TLAbsDialogFilter?): TLBool = executeMethod(TLRequestMessagesUpdateDialogFilter(id, filter))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUpdateDialogFiltersOrder(order: TLIntVector): TLBool = executeMethod(TLRequestMessagesUpdateDialogFiltersOrder(order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUpdatePinnedMessage(
            silent: Boolean,
            unpin: Boolean,
            pmOneside: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesUpdatePinnedMessage(silent, unpin, pmOneside, peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUpdateSavedReactionTag(reaction: TLAbsReaction, title: String?): TLBool = executeMethod(TLRequestMessagesUpdateSavedReactionTag(reaction, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadEncryptedFile(peer: TLInputEncryptedChat, file: TLAbsInputEncryptedFile): TLAbsEncryptedFile = executeMethod(TLRequestMessagesUploadEncryptedFile(peer, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadImportedMedia(
            peer: TLAbsInputPeer,
            importId: Long,
            fileName: String,
            media: TLAbsInputMedia
    ): TLAbsMessageMedia = executeMethod(TLRequestMessagesUploadImportedMedia(peer, importId, fileName, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadMedia(
            businessConnectionId: String?,
            peer: TLAbsInputPeer,
            media: TLAbsInputMedia
    ): TLAbsMessageMedia = executeMethod(TLRequestMessagesUploadMedia(businessConnectionId, peer, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsApplyGiftCode(slug: String): TLAbsUpdates = executeMethod(TLRequestPaymentsApplyGiftCode(slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsAssignAppStoreTransaction(receipt: TLBytes, purpose: TLAbsInputStorePaymentPurpose): TLAbsUpdates = executeMethod(TLRequestPaymentsAssignAppStoreTransaction(receipt, purpose))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsAssignPlayMarketTransaction(receipt: TLDataJSON, purpose: TLAbsInputStorePaymentPurpose): TLAbsUpdates = executeMethod(TLRequestPaymentsAssignPlayMarketTransaction(receipt, purpose))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsCanPurchasePremium(purpose: TLAbsInputStorePaymentPurpose): TLBool = executeMethod(TLRequestPaymentsCanPurchasePremium(purpose))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsCheckGiftCode(slug: String): TLCheckedGiftCode = executeMethod(TLRequestPaymentsCheckGiftCode(slug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): TLBool = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsExportInvoice(invoiceMedia: TLAbsInputMedia): TLExportedInvoice = executeMethod(TLRequestPaymentsExportInvoice(invoiceMedia))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetBankCardData(number: String): TLBankCardData = executeMethod(TLRequestPaymentsGetBankCardData(number))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetGiveawayInfo(peer: TLAbsInputPeer, msgId: Int): TLAbsGiveawayInfo = executeMethod(TLRequestPaymentsGetGiveawayInfo(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentForm(invoice: TLAbsInputInvoice, themeParams: TLDataJSON?): TLAbsPaymentForm = executeMethod(TLRequestPaymentsGetPaymentForm(invoice, themeParams))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentReceipt(peer: TLAbsInputPeer, msgId: Int): TLAbsPaymentReceipt = executeMethod(TLRequestPaymentsGetPaymentReceipt(peer, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPremiumGiftCodeOptions(boostPeer: TLAbsInputPeer?): TLObjectVector<TLPremiumGiftCodeOption> = executeMethod(TLRequestPaymentsGetPremiumGiftCodeOptions(boostPeer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetSavedInfo(): TLSavedInfo = executeMethod(TLRequestPaymentsGetSavedInfo())

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsGiftOptions(userId: TLAbsInputUser?): TLObjectVector<TLStarsGiftOption> = executeMethod(TLRequestPaymentsGetStarsGiftOptions(userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsRevenueAdsAccountUrl(peer: TLAbsInputPeer): TLStarsRevenueAdsAccountUrl = executeMethod(TLRequestPaymentsGetStarsRevenueAdsAccountUrl(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsRevenueStats(dark: Boolean, peer: TLAbsInputPeer): TLStarsRevenueStats = executeMethod(TLRequestPaymentsGetStarsRevenueStats(dark, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsRevenueWithdrawalUrl(
            peer: TLAbsInputPeer,
            stars: Long,
            password: TLAbsInputCheckPasswordSRP
    ): TLStarsRevenueWithdrawalUrl = executeMethod(TLRequestPaymentsGetStarsRevenueWithdrawalUrl(peer, stars, password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsStatus(peer: TLAbsInputPeer): TLStarsStatus = executeMethod(TLRequestPaymentsGetStarsStatus(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsTopupOptions(): TLObjectVector<TLStarsTopupOption> = executeMethod(TLRequestPaymentsGetStarsTopupOptions())

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsTransactions(
            inbound: Boolean,
            outbound: Boolean,
            ascending: Boolean,
            peer: TLAbsInputPeer,
            offset: String,
            limit: Int
    ): TLStarsStatus = executeMethod(TLRequestPaymentsGetStarsTransactions(inbound, outbound, ascending, peer, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetStarsTransactionsByID(peer: TLAbsInputPeer, id: TLObjectVector<TLInputStarsTransaction>): TLStarsStatus = executeMethod(TLRequestPaymentsGetStarsTransactionsByID(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsLaunchPrepaidGiveaway(
            peer: TLAbsInputPeer,
            giveawayId: Long,
            purpose: TLAbsInputStorePaymentPurpose
    ): TLAbsUpdates = executeMethod(TLRequestPaymentsLaunchPrepaidGiveaway(peer, giveawayId, purpose))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsRefundStarsCharge(userId: TLAbsInputUser, chargeId: String): TLAbsUpdates = executeMethod(TLRequestPaymentsRefundStarsCharge(userId, chargeId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsSendPaymentForm(
            formId: Long,
            invoice: TLAbsInputInvoice,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ): TLAbsPaymentResult = executeMethod(TLRequestPaymentsSendPaymentForm(formId, invoice, requestedInfoId, shippingOptionId, credentials, tipAmount))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsSendStarsForm(formId: Long, invoice: TLAbsInputInvoice): TLAbsPaymentResult = executeMethod(TLRequestPaymentsSendStarsForm(formId, invoice))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            invoice: TLAbsInputInvoice,
            info: TLPaymentRequestedInfo
    ): TLValidatedRequestedInfo = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, invoice, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneCheckGroupCall(call: TLInputGroupCall, sources: TLIntVector): TLIntVector = executeMethod(TLRequestPhoneCheckGroupCall(call, sources))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneCreateGroupCall(
            rtmpStream: Boolean,
            peer: TLAbsInputPeer,
            randomId: Int,
            title: String?,
            scheduleDate: Int?
    ): TLAbsUpdates = executeMethod(TLRequestPhoneCreateGroupCall(rtmpStream, peer, randomId, title, scheduleDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneDiscardCall(
            video: Boolean,
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): TLAbsUpdates = executeMethod(TLRequestPhoneDiscardCall(video, peer, duration, reason, connectionId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneDiscardGroupCall(call: TLInputGroupCall): TLAbsUpdates = executeMethod(TLRequestPhoneDiscardGroupCall(call))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneEditGroupCallParticipant(
            call: TLInputGroupCall,
            participant: TLAbsInputPeer,
            muted: Boolean?,
            volume: Int?,
            raiseHand: Boolean?,
            videoStopped: Boolean?,
            videoPaused: Boolean?,
            presentationPaused: Boolean?
    ): TLAbsUpdates = executeMethod(TLRequestPhoneEditGroupCallParticipant(call, participant, muted, volume, raiseHand, videoStopped, videoPaused, presentationPaused))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneEditGroupCallTitle(call: TLInputGroupCall, title: String): TLAbsUpdates = executeMethod(TLRequestPhoneEditGroupCallTitle(call, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneExportGroupCallInvite(canSelfUnmute: Boolean, call: TLInputGroupCall): TLExportedGroupCallInvite = executeMethod(TLRequestPhoneExportGroupCallInvite(canSelfUnmute, call))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetCallConfig(): TLDataJSON = executeMethod(TLRequestPhoneGetCallConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetGroupCall(call: TLInputGroupCall, limit: Int): TLGroupCall = executeMethod(TLRequestPhoneGetGroupCall(call, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetGroupCallJoinAs(peer: TLAbsInputPeer): TLJoinAsPeers = executeMethod(TLRequestPhoneGetGroupCallJoinAs(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetGroupCallStreamChannels(call: TLInputGroupCall): TLGroupCallStreamChannels = executeMethod(TLRequestPhoneGetGroupCallStreamChannels(call))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetGroupCallStreamRtmpUrl(peer: TLAbsInputPeer, revoke: Boolean): TLGroupCallStreamRtmpUrl = executeMethod(TLRequestPhoneGetGroupCallStreamRtmpUrl(peer, revoke))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetGroupParticipants(
            call: TLInputGroupCall,
            ids: TLObjectVector<TLAbsInputPeer>,
            sources: TLIntVector,
            offset: String,
            limit: Int
    ): TLGroupParticipants = executeMethod(TLRequestPhoneGetGroupParticipants(call, ids, sources, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneInviteToGroupCall(call: TLInputGroupCall, users: TLObjectVector<TLAbsInputUser>): TLAbsUpdates = executeMethod(TLRequestPhoneInviteToGroupCall(call, users))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneJoinGroupCall(
            muted: Boolean,
            videoStopped: Boolean,
            call: TLInputGroupCall,
            joinAs: TLAbsInputPeer,
            inviteHash: String?,
            params: TLDataJSON
    ): TLAbsUpdates = executeMethod(TLRequestPhoneJoinGroupCall(muted, videoStopped, call, joinAs, inviteHash, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneJoinGroupCallPresentation(call: TLInputGroupCall, params: TLDataJSON): TLAbsUpdates = executeMethod(TLRequestPhoneJoinGroupCallPresentation(call, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneLeaveGroupCall(call: TLInputGroupCall, source: Int): TLAbsUpdates = executeMethod(TLRequestPhoneLeaveGroupCall(call, source))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneLeaveGroupCallPresentation(call: TLInputGroupCall): TLAbsUpdates = executeMethod(TLRequestPhoneLeaveGroupCallPresentation(call))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneReceivedCall(peer: TLInputPhoneCall): TLBool = executeMethod(TLRequestPhoneReceivedCall(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneRequestCall(
            video: Boolean,
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneRequestCall(video, userId, randomId, gAHash, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): TLBool = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveCallLog(peer: TLInputPhoneCall, file: TLAbsInputFile): TLBool = executeMethod(TLRequestPhoneSaveCallLog(peer, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveDefaultGroupCallJoinAs(peer: TLAbsInputPeer, joinAs: TLAbsInputPeer): TLBool = executeMethod(TLRequestPhoneSaveDefaultGroupCallJoinAs(peer, joinAs))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSendSignalingData(peer: TLInputPhoneCall, data: TLBytes): TLBool = executeMethod(TLRequestPhoneSendSignalingData(peer, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSetCallRating(
            userInitiative: Boolean,
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): TLAbsUpdates = executeMethod(TLRequestPhoneSetCallRating(userInitiative, peer, rating, comment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneStartScheduledGroupCall(call: TLInputGroupCall): TLAbsUpdates = executeMethod(TLRequestPhoneStartScheduledGroupCall(call))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneToggleGroupCallRecord(
            start: Boolean,
            video: Boolean,
            call: TLInputGroupCall,
            title: String?,
            videoPortrait: Boolean?
    ): TLAbsUpdates = executeMethod(TLRequestPhoneToggleGroupCallRecord(start, video, call, title, videoPortrait))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneToggleGroupCallSettings(
            resetInviteHash: Boolean,
            call: TLInputGroupCall,
            joinMuted: Boolean?
    ): TLAbsUpdates = executeMethod(TLRequestPhoneToggleGroupCallSettings(resetInviteHash, call, joinMuted))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneToggleGroupCallStartSubscription(call: TLInputGroupCall, subscribed: Boolean): TLAbsUpdates = executeMethod(TLRequestPhoneToggleGroupCallStartSubscription(call, subscribed))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): TLLongVector = executeMethod(TLRequestPhotosDeletePhotos(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): TLAbsPhotos = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUpdateProfilePhoto(
            fallback: Boolean,
            bot: TLAbsInputUser?,
            id: TLAbsInputPhoto
    ): TLPhoto = executeMethod(TLRequestPhotosUpdateProfilePhoto(fallback, bot, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUploadContactProfilePhoto(
            suggest: Boolean,
            save: Boolean,
            userId: TLAbsInputUser,
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?,
            videoEmojiMarkup: TLAbsVideoSize?
    ): TLPhoto = executeMethod(TLRequestPhotosUploadContactProfilePhoto(suggest, save, userId, file, video, videoStartTs, videoEmojiMarkup))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUploadProfilePhoto(
            fallback: Boolean,
            bot: TLAbsInputUser?,
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?,
            videoEmojiMarkup: TLAbsVideoSize?
    ): TLPhoto = executeMethod(TLRequestPhotosUploadProfilePhoto(fallback, bot, file, video, videoStartTs, videoEmojiMarkup))

    @Throws(RpcErrorException::class, IOException::class)
    override fun premiumApplyBoost(slots: TLIntVector?, peer: TLAbsInputPeer): TLMyBoosts = executeMethod(TLRequestPremiumApplyBoost(slots, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun premiumGetBoostsList(
            gifts: Boolean,
            peer: TLAbsInputPeer,
            offset: String,
            limit: Int
    ): TLBoostsList = executeMethod(TLRequestPremiumGetBoostsList(gifts, peer, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun premiumGetBoostsStatus(peer: TLAbsInputPeer): TLBoostsStatus = executeMethod(TLRequestPremiumGetBoostsStatus(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun premiumGetMyBoosts(): TLMyBoosts = executeMethod(TLRequestPremiumGetMyBoosts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun premiumGetUserBoosts(peer: TLAbsInputPeer, userId: TLAbsInputUser): TLBoostsList = executeMethod(TLRequestPremiumGetUserBoosts(peer, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsFinishJob(jobId: String, error: String?): TLBool = executeMethod(TLRequestSmsjobsFinishJob(jobId, error))

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsGetSmsJob(jobId: String): TLSmsJob = executeMethod(TLRequestSmsjobsGetSmsJob(jobId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsGetStatus(): TLStatus = executeMethod(TLRequestSmsjobsGetStatus())

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsIsEligibleToJoin(): TLEligibleToJoin = executeMethod(TLRequestSmsjobsIsEligibleToJoin())

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsJoin(): TLBool = executeMethod(TLRequestSmsjobsJoin())

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsLeave(): TLBool = executeMethod(TLRequestSmsjobsLeave())

    @Throws(RpcErrorException::class, IOException::class)
    override fun smsjobsUpdateSettings(allowInternational: Boolean): TLBool = executeMethod(TLRequestSmsjobsUpdateSettings(allowInternational))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetBroadcastRevenueStats(dark: Boolean, channel: TLAbsInputChannel): TLBroadcastRevenueStats = executeMethod(TLRequestStatsGetBroadcastRevenueStats(dark, channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetBroadcastRevenueTransactions(
            channel: TLAbsInputChannel,
            offset: Int,
            limit: Int
    ): TLBroadcastRevenueTransactions = executeMethod(TLRequestStatsGetBroadcastRevenueTransactions(channel, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetBroadcastRevenueWithdrawalUrl(channel: TLAbsInputChannel, password: TLAbsInputCheckPasswordSRP): TLBroadcastRevenueWithdrawalUrl = executeMethod(TLRequestStatsGetBroadcastRevenueWithdrawalUrl(channel, password))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetBroadcastStats(dark: Boolean, channel: TLAbsInputChannel): TLBroadcastStats = executeMethod(TLRequestStatsGetBroadcastStats(dark, channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetMegagroupStats(dark: Boolean, channel: TLAbsInputChannel): TLMegagroupStats = executeMethod(TLRequestStatsGetMegagroupStats(dark, channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetMessagePublicForwards(
            channel: TLAbsInputChannel,
            msgId: Int,
            offset: String,
            limit: Int
    ): TLPublicForwards = executeMethod(TLRequestStatsGetMessagePublicForwards(channel, msgId, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetMessageStats(
            dark: Boolean,
            channel: TLAbsInputChannel,
            msgId: Int
    ): TLMessageStats = executeMethod(TLRequestStatsGetMessageStats(dark, channel, msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetStoryPublicForwards(
            peer: TLAbsInputPeer,
            id: Int,
            offset: String,
            limit: Int
    ): TLPublicForwards = executeMethod(TLRequestStatsGetStoryPublicForwards(peer, id, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsGetStoryStats(
            dark: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ): TLStoryStats = executeMethod(TLRequestStatsGetStoryStats(dark, peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun statsLoadAsyncGraph(token: String, x: Long?): TLAbsStatsGraph = executeMethod(TLRequestStatsLoadAsyncGraph(token, x))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): TLAbsStickerSet = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersChangeSticker(
            sticker: TLAbsInputDocument,
            emoji: String?,
            maskCoords: TLMaskCoords?,
            keywords: String?
    ): TLAbsStickerSet = executeMethod(TLRequestStickersChangeSticker(sticker, emoji, maskCoords, keywords))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): TLAbsStickerSet = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersCheckShortName(shortName: String): TLBool = executeMethod(TLRequestStickersCheckShortName(shortName))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersCreateStickerSet(
            masks: Boolean,
            emojis: Boolean,
            textColor: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            thumb: TLAbsInputDocument?,
            stickers: TLObjectVector<TLInputStickerSetItem>,
            software: String?
    ): TLAbsStickerSet = executeMethod(TLRequestStickersCreateStickerSet(masks, emojis, textColor, userId, title, shortName, thumb, stickers, software))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersDeleteStickerSet(stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestStickersDeleteStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): TLAbsStickerSet = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersRenameStickerSet(stickerset: TLAbsInputStickerSet, title: String): TLAbsStickerSet = executeMethod(TLRequestStickersRenameStickerSet(stickerset, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersReplaceSticker(sticker: TLAbsInputDocument, newSticker: TLInputStickerSetItem): TLAbsStickerSet = executeMethod(TLRequestStickersReplaceSticker(sticker, newSticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersSetStickerSetThumb(
            stickerset: TLAbsInputStickerSet,
            thumb: TLAbsInputDocument?,
            thumbDocumentId: Long?
    ): TLAbsStickerSet = executeMethod(TLRequestStickersSetStickerSetThumb(stickerset, thumb, thumbDocumentId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersSuggestShortName(title: String): TLSuggestedShortName = executeMethod(TLRequestStickersSuggestShortName(title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesActivateStealthMode(past: Boolean, future: Boolean): TLAbsUpdates = executeMethod(TLRequestStoriesActivateStealthMode(past, future))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesCanSendStory(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestStoriesCanSendStory(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesDeleteStories(peer: TLAbsInputPeer, id: TLIntVector): TLIntVector = executeMethod(TLRequestStoriesDeleteStories(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesEditStory(
            peer: TLAbsInputPeer,
            id: Int,
            media: TLAbsInputMedia?,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>?
    ): TLAbsUpdates = executeMethod(TLRequestStoriesEditStory(peer, id, media, mediaAreas, caption, entities, privacyRules))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesExportStoryLink(peer: TLAbsInputPeer, id: Int): TLExportedStoryLink = executeMethod(TLRequestStoriesExportStoryLink(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetAllReadPeerStories(): TLAbsUpdates = executeMethod(TLRequestStoriesGetAllReadPeerStories())

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetAllStories(
            next: Boolean,
            hidden: Boolean,
            state: String?
    ): TLAbsAllStories = executeMethod(TLRequestStoriesGetAllStories(next, hidden, state))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetChatsToSend(): TLAbsChats = executeMethod(TLRequestStoriesGetChatsToSend())

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetPeerMaxIDs(id: TLObjectVector<TLAbsInputPeer>): TLIntVector = executeMethod(TLRequestStoriesGetPeerMaxIDs(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetPeerStories(peer: TLAbsInputPeer): TLPeerStories = executeMethod(TLRequestStoriesGetPeerStories(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetPinnedStories(
            peer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLStories = executeMethod(TLRequestStoriesGetPinnedStories(peer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetStoriesArchive(
            peer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLStories = executeMethod(TLRequestStoriesGetStoriesArchive(peer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetStoriesByID(peer: TLAbsInputPeer, id: TLIntVector): TLStories = executeMethod(TLRequestStoriesGetStoriesByID(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetStoriesViews(peer: TLAbsInputPeer, id: TLIntVector): TLStoryViews = executeMethod(TLRequestStoriesGetStoriesViews(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetStoryReactionsList(
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            reaction: TLAbsReaction?,
            offset: String?,
            limit: Int
    ): TLStoryReactionsList = executeMethod(TLRequestStoriesGetStoryReactionsList(forwardsFirst, peer, id, reaction, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesGetStoryViewsList(
            justContacts: Boolean,
            reactionsFirst: Boolean,
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            q: String?,
            id: Int,
            offset: String,
            limit: Int
    ): TLStoryViewsList = executeMethod(TLRequestStoriesGetStoryViewsList(justContacts, reactionsFirst, forwardsFirst, peer, q, id, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesIncrementStoryViews(peer: TLAbsInputPeer, id: TLIntVector): TLBool = executeMethod(TLRequestStoriesIncrementStoryViews(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesReadStories(peer: TLAbsInputPeer, maxId: Int): TLIntVector = executeMethod(TLRequestStoriesReadStories(peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): TLBool = executeMethod(TLRequestStoriesReport(peer, id, reason, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesSearchPosts(
            hashtag: String?,
            area: TLAbsMediaArea?,
            offset: String,
            limit: Int
    ): TLFoundStories = executeMethod(TLRequestStoriesSearchPosts(hashtag, area, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesSendReaction(
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            storyId: Int,
            reaction: TLAbsReaction
    ): TLAbsUpdates = executeMethod(TLRequestStoriesSendReaction(addToRecent, peer, storyId, reaction))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesSendStory(
            pinned: Boolean,
            noforwards: Boolean,
            fwdModified: Boolean,
            peer: TLAbsInputPeer,
            media: TLAbsInputMedia,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>,
            randomId: Long,
            period: Int?,
            fwdFromId: TLAbsInputPeer?,
            fwdFromStory: Int?
    ): TLAbsUpdates = executeMethod(TLRequestStoriesSendStory(pinned, noforwards, fwdModified, peer, media, mediaAreas, caption, entities, privacyRules, randomId, period, fwdFromId, fwdFromStory))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesToggleAllStoriesHidden(hidden: Boolean): TLBool = executeMethod(TLRequestStoriesToggleAllStoriesHidden(hidden))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesTogglePeerStoriesHidden(peer: TLAbsInputPeer, hidden: Boolean): TLBool = executeMethod(TLRequestStoriesTogglePeerStoriesHidden(peer, hidden))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesTogglePinned(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            pinned: Boolean
    ): TLIntVector = executeMethod(TLRequestStoriesTogglePinned(peer, id, pinned))

    @Throws(RpcErrorException::class, IOException::class)
    override fun storiesTogglePinnedToTop(peer: TLAbsInputPeer, id: TLIntVector): TLBool = executeMethod(TLRequestStoriesTogglePinnedToTop(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): TLAbsChannelDifference = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetDifference(
            pts: Int,
            ptsLimit: Int?,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int,
            qtsLimit: Int?
    ): TLAbsDifference = executeMethod(TLRequestUpdatesGetDifference(pts, ptsLimit, ptsTotalLimit, date, qts, qtsLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetState(): TLState = executeMethod(TLRequestUpdatesGetState())

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Long,
            limit: Int
    ): TLAbsCdnFile = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Long): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFile(
            precise: Boolean,
            cdnSupported: Boolean,
            location: TLAbsInputFileLocation,
            offset: Long,
            limit: Int
    ): TLAbsFile = executeMethod(TLRequestUploadGetFile(precise, cdnSupported, location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Long): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadGetFileHashes(location, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetWebFile(
            location: TLAbsInputWebFileLocation,
            offset: Int,
            limit: Int
    ): TLWebFile = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetFullUser(id: TLAbsInputUser): TLUserFull = executeMethod(TLRequestUsersGetFullUser(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetIsPremiumRequiredToContact(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLBool> = executeMethod(TLRequestUsersGetIsPremiumRequiredToContact(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLAbsUser> = executeMethod(TLRequestUsersGetUsers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersSetSecureValueErrors(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>): TLBool = executeMethod(TLRequestUsersSetSecureValueErrors(id, errors))
}

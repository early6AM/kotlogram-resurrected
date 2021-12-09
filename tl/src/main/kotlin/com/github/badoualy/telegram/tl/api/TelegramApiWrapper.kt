package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQueryExecutor
import com.github.badoualy.telegram.tl.api.account.TLAbsChatThemes
import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult
import com.github.badoualy.telegram.tl.api.account.TLAbsThemes
import com.github.badoualy.telegram.tl.api.account.TLAbsWallPapers
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations
import com.github.badoualy.telegram.tl.api.account.TLContentSettings
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode
import com.github.badoualy.telegram.tl.api.account.TLTakeout
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword
import com.github.badoualy.telegram.tl.api.account.TLWebAuthorizations
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLAbsLoginToken
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.api.contacts.TLFound
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsPassportConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsPromoData
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.help.TLSupportName
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers
import com.github.badoualy.telegram.tl.api.messages.TLAffectedFoundMessages
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.api.messages.TLChatAdminsWithInvites
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters
import com.github.badoualy.telegram.tl.api.messages.TLCheckedHistoryImportPeer
import com.github.badoualy.telegram.tl.api.messages.TLDiscussionMessage
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites
import com.github.badoualy.telegram.tl.api.messages.TLHighScores
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImport
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImportParsed
import com.github.badoualy.telegram.tl.api.messages.TLInactiveChats
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData
import com.github.badoualy.telegram.tl.api.messages.TLMessageViews
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter
import com.github.badoualy.telegram.tl.api.messages.TLSponsoredMessages
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.api.messages.TLVotesList
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.api.payments.TLBankCardData
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.api.payments.TLPaymentReceipt
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants
import com.github.badoualy.telegram.tl.api.phone.TLJoinAsPeers
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountAcceptAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCancelPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangePhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCreateTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeclinePasswordReset
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAccount
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountFinishTakeoutSession
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAllSecureValues
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizationForm
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAutoDownloadSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetChatThemes
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContactSignUpNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetContentSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetGlobalPrivacySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetMultiWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifyExceptions
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPrivacy
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
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountRegisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportPeer
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResendPasswordEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveAutoDownloadSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveWallPaper
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendChangePhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendConfirmPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyEmailCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContactSignUpNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetContentSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetGlobalPrivacySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetPrivacy
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUnregisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateDeviceLocked
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateProfile
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateUsername
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
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthLogOut
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRecoverPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestPasswordRecovery
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignIn
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignUp
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsGetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsResetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSendCustomRequest
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSetBotCommands
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsConvertToGigagroup
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteUserHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditBanned
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditCreator
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditLocation
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsExportMessageLink
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminLog
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminedPublicChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetFullChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetGroupsForDiscussion
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetInactiveChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetLeftChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipant
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetSponsoredMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsInviteToChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsJoinChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsLeaveChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetDiscussionGroup
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsTogglePreHistoryHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSignatures
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSlowMode
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsViewSponsoredMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAcceptContact
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsAddContact
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlock
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlockFromReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteByPhones
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBlocked
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContactIDs
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetLocated
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetTopPeerRating
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolveUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsToggleTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsUnblock
import com.github.badoualy.telegram.tl.api.request.TLRequestFoldersDeleteFolder
import com.github.badoualy.telegram.tl.api.request.TLRequestFoldersEditPeerFolders
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpAcceptTermsOfService
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpDismissSuggestion
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpEditUserInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppChangelog
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCdnConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCountriesList
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetDeepLinkInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetInviteText
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPassportConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetPromoData
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetRecentMeUrls
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupport
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupportName
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetUserInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpHidePromoData
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSaveAppLog
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSetBotUpdatesStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsg
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsgs
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
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearAllDrafts
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCreateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChatUser
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeletePhoneCallHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteRevokedExportedChatInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDiscardEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAbout
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatDefaultBannedRights
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditInlineBotMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesExportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesFaveSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesForwardMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAdminsWithInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllDrafts
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetArchivedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChatInviteImporters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCommonChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDhConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogFilters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogUnreadMarks
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDiscussionMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDocumentByHash
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywords
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiKeywordsLanguages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetEmojiURL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetExportedChatInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFavedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFullChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMaskStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageEditData
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageReadParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesViews
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOldFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetOnlines
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPollVotes
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentLocations
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetReplies
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedGifs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSearchCounters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSplitRanges
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSuggestedDialogFilters
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPagePreview
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHidePeerSettingsBar
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesImportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInitHistoryImport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMarkDialogUnread
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMigrateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadDiscussion
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadEncryptedHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedQueue
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportEncryptedSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestUrlAuth
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDraft
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveGif
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveRecentSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchGlobal
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncrypted
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedService
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendInlineBotResult
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMultiMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScheduledMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScreenshotNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendVote
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotShippingResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetChatTheme
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetEncryptedTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetHistoryTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartBot
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartHistoryImport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogPin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUninstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUnpinAllMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFilter
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdateDialogFiltersOrder
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUpdatePinnedMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadImportedMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsClearSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetBankCardData
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentReceipt
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendPaymentForm
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
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetGroupParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneInviteToGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneJoinGroupCallPresentation
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneLeaveGroupCallPresentation
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneReceivedCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneRequestCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallDebug
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
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetBroadcastStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMegagroupStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessagePublicForwards
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsGetMessageStats
import com.github.badoualy.telegram.tl.api.request.TLRequestStatsLoadAsyncGraph
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersAddStickerToSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeStickerPosition
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCheckShortName
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCreateStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRemoveStickerFromSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSetStickerSetThumb
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersSuggestShortName
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
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetUsers
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersSetSecureValueErrors
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastStats
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats
import com.github.badoualy.telegram.tl.api.stickers.TLSuggestedShortName
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import io.reactivex.Single

abstract class TelegramApiWrapper : TelegramApi, RpcQueryExecutor {
    override fun accountAcceptAuthorization(
            botId: Long,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): Single<TLBool> = executeMethod(TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials))

    override fun accountCancelPasswordEmail(): Single<TLBool> = executeMethod(TLRequestAccountCancelPasswordEmail())

    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun accountCheckUsername(username: String): Single<TLBool> = executeMethod(TLRequestAccountCheckUsername(username))

    override fun accountConfirmPasswordEmail(code: String): Single<TLBool> = executeMethod(TLRequestAccountConfirmPasswordEmail(code))

    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool> = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    override fun accountCreateTheme(
            slug: String,
            title: String,
            document: TLAbsInputDocument?,
            settings: TLInputThemeSettings?
    ): Single<TLTheme> = executeMethod(TLRequestAccountCreateTheme(slug, title, document, settings))

    override fun accountDeclinePasswordReset(): Single<TLBool> = executeMethod(TLRequestAccountDeclinePasswordReset())

    override fun accountDeleteAccount(reason: String): Single<TLBool> = executeMethod(TLRequestAccountDeleteAccount(reason))

    override fun accountDeleteSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLBool> = executeMethod(TLRequestAccountDeleteSecureValue(types))

    override fun accountFinishTakeoutSession(success: Boolean): Single<TLBool> = executeMethod(TLRequestAccountFinishTakeoutSession(success))

    override fun accountGetAccountTTL(): Single<TLAccountDaysTTL> = executeMethod(TLRequestAccountGetAccountTTL())

    override fun accountGetAllSecureValues(): Single<TLObjectVector<TLSecureValue>> = executeMethod(TLRequestAccountGetAllSecureValues())

    override fun accountGetAuthorizationForm(
            botId: Long,
            scope: String,
            publicKey: String
    ): Single<TLAuthorizationForm> = executeMethod(TLRequestAccountGetAuthorizationForm(botId, scope, publicKey))

    override fun accountGetAuthorizations(): Single<TLAuthorizations> = executeMethod(TLRequestAccountGetAuthorizations())

    override fun accountGetAutoDownloadSettings(): Single<com.github.badoualy.telegram.tl.api.account.TLAutoDownloadSettings> = executeMethod(TLRequestAccountGetAutoDownloadSettings())

    override fun accountGetChatThemes(hash: Int): Single<TLAbsChatThemes> = executeMethod(TLRequestAccountGetChatThemes(hash))

    override fun accountGetContactSignUpNotification(): Single<TLBool> = executeMethod(TLRequestAccountGetContactSignUpNotification())

    override fun accountGetContentSettings(): Single<TLContentSettings> = executeMethod(TLRequestAccountGetContentSettings())

    override fun accountGetGlobalPrivacySettings(): Single<TLGlobalPrivacySettings> = executeMethod(TLRequestAccountGetGlobalPrivacySettings())

    override fun accountGetMultiWallPapers(wallpapers: TLObjectVector<TLAbsInputWallPaper>): Single<TLObjectVector<TLAbsWallPaper>> = executeMethod(TLRequestAccountGetMultiWallPapers(wallpapers))

    override fun accountGetNotifyExceptions(compareSound: Boolean, peer: TLAbsInputNotifyPeer?): Single<TLAbsUpdates> = executeMethod(TLRequestAccountGetNotifyExceptions(compareSound, peer))

    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLPeerNotifySettings> = executeMethod(TLRequestAccountGetNotifySettings(peer))

    override fun accountGetPassword(): Single<TLPassword> = executeMethod(TLRequestAccountGetPassword())

    override fun accountGetPasswordSettings(password: TLAbsInputCheckPasswordSRP): Single<TLPasswordSettings> = executeMethod(TLRequestAccountGetPasswordSettings(password))

    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules> = executeMethod(TLRequestAccountGetPrivacy(key))

    override fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLObjectVector<TLSecureValue>> = executeMethod(TLRequestAccountGetSecureValue(types))

    override fun accountGetTheme(
            format: String,
            theme: TLAbsInputTheme,
            documentId: Long
    ): Single<TLTheme> = executeMethod(TLRequestAccountGetTheme(format, theme, documentId))

    override fun accountGetThemes(format: String, hash: Long): Single<TLAbsThemes> = executeMethod(TLRequestAccountGetThemes(format, hash))

    override fun accountGetTmpPassword(password: TLAbsInputCheckPasswordSRP, period: Int): Single<TLTmpPassword> = executeMethod(TLRequestAccountGetTmpPassword(password, period))

    override fun accountGetWallPaper(wallpaper: TLAbsInputWallPaper): Single<TLAbsWallPaper> = executeMethod(TLRequestAccountGetWallPaper(wallpaper))

    override fun accountGetWallPapers(hash: Long): Single<TLAbsWallPapers> = executeMethod(TLRequestAccountGetWallPapers(hash))

    override fun accountGetWebAuthorizations(): Single<TLWebAuthorizations> = executeMethod(TLRequestAccountGetWebAuthorizations())

    override fun accountInitTakeoutSession(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Int?
    ): Single<TLTakeout> = executeMethod(TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize))

    override fun accountInstallTheme(
            dark: Boolean,
            format: String?,
            theme: TLAbsInputTheme?
    ): Single<TLBool> = executeMethod(TLRequestAccountInstallTheme(dark, format, theme))

    override fun accountInstallWallPaper(wallpaper: TLAbsInputWallPaper, settings: TLWallPaperSettings): Single<TLBool> = executeMethod(TLRequestAccountInstallWallPaper(wallpaper, settings))

    override fun accountRegisterDevice(
            noMuted: Boolean,
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLLongVector
    ): Single<TLBool> = executeMethod(TLRequestAccountRegisterDevice(noMuted, tokenType, token, appSandbox, secret, otherUids))

    override fun accountReportPeer(
            peer: TLAbsInputPeer,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool> = executeMethod(TLRequestAccountReportPeer(peer, reason, message))

    override fun accountReportProfilePhoto(
            peer: TLAbsInputPeer,
            photoId: TLAbsInputPhoto,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool> = executeMethod(TLRequestAccountReportProfilePhoto(peer, photoId, reason, message))

    override fun accountResendPasswordEmail(): Single<TLBool> = executeMethod(TLRequestAccountResendPasswordEmail())

    override fun accountResetAuthorization(hash: Long): Single<TLBool> = executeMethod(TLRequestAccountResetAuthorization(hash))

    override fun accountResetNotifySettings(): Single<TLBool> = executeMethod(TLRequestAccountResetNotifySettings())

    override fun accountResetPassword(): Single<TLAbsResetPasswordResult> = executeMethod(TLRequestAccountResetPassword())

    override fun accountResetWallPapers(): Single<TLBool> = executeMethod(TLRequestAccountResetWallPapers())

    override fun accountResetWebAuthorization(hash: Long): Single<TLBool> = executeMethod(TLRequestAccountResetWebAuthorization(hash))

    override fun accountResetWebAuthorizations(): Single<TLBool> = executeMethod(TLRequestAccountResetWebAuthorizations())

    override fun accountSaveAutoDownloadSettings(
            low: Boolean,
            high: Boolean,
            settings: TLAutoDownloadSettings
    ): Single<TLBool> = executeMethod(TLRequestAccountSaveAutoDownloadSettings(low, high, settings))

    override fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): Single<TLSecureValue> = executeMethod(TLRequestAccountSaveSecureValue(value, secureSecretId))

    override fun accountSaveTheme(theme: TLAbsInputTheme, unsave: Boolean): Single<TLBool> = executeMethod(TLRequestAccountSaveTheme(theme, unsave))

    override fun accountSaveWallPaper(
            wallpaper: TLAbsInputWallPaper,
            unsave: Boolean,
            settings: TLWallPaperSettings
    ): Single<TLBool> = executeMethod(TLRequestAccountSaveWallPaper(wallpaper, unsave, settings))

    override fun accountSendChangePhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLSentCode> = executeMethod(TLRequestAccountSendChangePhoneCode(phoneNumber, settings))

    override fun accountSendConfirmPhoneCode(hash: String, settings: TLCodeSettings): Single<TLSentCode> = executeMethod(TLRequestAccountSendConfirmPhoneCode(hash, settings))

    override fun accountSendVerifyEmailCode(email: String): Single<TLSentEmailCode> = executeMethod(TLRequestAccountSendVerifyEmailCode(email))

    override fun accountSendVerifyPhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLSentCode> = executeMethod(TLRequestAccountSendVerifyPhoneCode(phoneNumber, settings))

    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool> = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    override fun accountSetContactSignUpNotification(silent: Boolean): Single<TLBool> = executeMethod(TLRequestAccountSetContactSignUpNotification(silent))

    override fun accountSetContentSettings(sensitiveEnabled: Boolean): Single<TLBool> = executeMethod(TLRequestAccountSetContentSettings(sensitiveEnabled))

    override fun accountSetGlobalPrivacySettings(settings: TLGlobalPrivacySettings): Single<TLGlobalPrivacySettings> = executeMethod(TLRequestAccountSetGlobalPrivacySettings(settings))

    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules> = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    override fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLLongVector
    ): Single<TLBool> = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token, otherUids))

    override fun accountUpdateDeviceLocked(period: Int): Single<TLBool> = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool> = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    override fun accountUpdatePasswordSettings(password: TLAbsInputCheckPasswordSRP, newSettings: TLPasswordInputSettings): Single<TLBool> = executeMethod(TLRequestAccountUpdatePasswordSettings(password, newSettings))

    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    override fun accountUpdateStatus(offline: Boolean): Single<TLBool> = executeMethod(TLRequestAccountUpdateStatus(offline))

    override fun accountUpdateTheme(
            format: String,
            theme: TLAbsInputTheme,
            slug: String?,
            title: String?,
            document: TLAbsInputDocument?,
            settings: TLInputThemeSettings?
    ): Single<TLTheme> = executeMethod(TLRequestAccountUpdateTheme(format, theme, slug, title, document, settings))

    override fun accountUpdateUsername(username: String): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateUsername(username))

    override fun accountUploadTheme(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            fileName: String,
            mimeType: String
    ): Single<TLAbsDocument> = executeMethod(TLRequestAccountUploadTheme(file, thumb, fileName, mimeType))

    override fun accountUploadWallPaper(
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ): Single<TLAbsWallPaper> = executeMethod(TLRequestAccountUploadWallPaper(file, mimeType, settings))

    override fun accountVerifyEmail(email: String, code: String): Single<TLBool> = executeMethod(TLRequestAccountVerifyEmail(email, code))

    override fun accountVerifyPhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLBool> = executeMethod(TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun authAcceptLoginToken(token: TLBytes): Single<TLAuthorization> = executeMethod(TLRequestAuthAcceptLoginToken(token))

    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool> = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    override fun authCheckPassword(password: TLAbsInputCheckPasswordSRP): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthCheckPassword(password))

    override fun authCheckRecoveryPassword(code: String): Single<TLBool> = executeMethod(TLRequestAuthCheckRecoveryPassword(code))

    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool> = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    override fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization> = executeMethod(TLRequestAuthExportAuthorization(dcId))

    override fun authExportLoginToken(
            apiId: Int,
            apiHash: String,
            exceptIds: TLLongVector
    ): Single<TLAbsLoginToken> = executeMethod(TLRequestAuthExportLoginToken(apiId, apiHash, exceptIds))

    override fun authImportAuthorization(id: Long, bytes: TLBytes): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    override fun authImportLoginToken(token: TLBytes): Single<TLAbsLoginToken> = executeMethod(TLRequestAuthImportLoginToken(token))

    override fun authLogOut(): Single<TLBool> = executeMethod(TLRequestAuthLogOut())

    override fun authRecoverPassword(code: String, newSettings: TLPasswordInputSettings?): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthRecoverPassword(code, newSettings))

    override fun authRequestPasswordRecovery(): Single<TLPasswordRecovery> = executeMethod(TLRequestAuthRequestPasswordRecovery())

    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode> = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    override fun authResetAuthorizations(): Single<TLBool> = executeMethod(TLRequestAuthResetAuthorizations())

    override fun authSendCode(
            phoneNumber: String,
            apiId: Int,
            apiHash: String,
            settings: TLCodeSettings
    ): Single<TLSentCode> = executeMethod(TLRequestAuthSendCode(phoneNumber, apiId, apiHash, settings))

    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            firstName: String,
            lastName: String
    ): Single<TLAbsAuthorization> = executeMethod(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, firstName, lastName))

    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool> = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    override fun botsGetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLObjectVector<TLBotCommand>> = executeMethod(TLRequestBotsGetBotCommands(scope, langCode))

    override fun botsResetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLBool> = executeMethod(TLRequestBotsResetBotCommands(scope, langCode))

    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON> = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    override fun botsSetBotCommands(
            scope: TLAbsBotCommandScope,
            langCode: String,
            commands: TLObjectVector<TLBotCommand>
    ): Single<TLBool> = executeMethod(TLRequestBotsSetBotCommands(scope, langCode, commands))

    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    override fun channelsConvertToGigagroup(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsConvertToGigagroup(channel))

    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, forImport, title, about, geoPoint, address))

    override fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsDeleteChannel(channel))

    override fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeMethod(TLRequestChannelsDeleteHistory(channel, maxId))

    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory> = executeMethod(TLRequestChannelsDeleteUserHistory(channel, userId))

    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChatAdminRights,
            rank: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights, rank))

    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            bannedRights: TLChatBannedRights
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditBanned(channel, participant, bannedRights))

    override fun channelsEditCreator(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            password: TLAbsInputCheckPasswordSRP
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditCreator(channel, userId, password))

    override fun channelsEditLocation(
            channel: TLAbsInputChannel,
            geoPoint: TLAbsInputGeoPoint,
            address: String
    ): Single<TLBool> = executeMethod(TLRequestChannelsEditLocation(channel, geoPoint, address))

    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditTitle(channel, title))

    override fun channelsExportMessageLink(
            grouped: Boolean,
            thread: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLExportedMessageLink> = executeMethod(TLRequestChannelsExportMessageLink(grouped, thread, channel, id))

    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults> = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    override fun channelsGetAdminedPublicChannels(byLocation: Boolean, checkLimit: Boolean): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetAdminedPublicChannels(byLocation, checkLimit))

    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetChannels(id))

    override fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull> = executeMethod(TLRequestChannelsGetFullChannel(channel))

    override fun channelsGetGroupsForDiscussion(): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetGroupsForDiscussion())

    override fun channelsGetInactiveChannels(): Single<TLInactiveChats> = executeMethod(TLRequestChannelsGetInactiveChannels())

    override fun channelsGetLeftChannels(offset: Int): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetLeftChannels(offset))

    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages> = executeMethod(TLRequestChannelsGetMessages(channel, id))

    override fun channelsGetParticipant(channel: TLAbsInputChannel, participant: TLAbsInputPeer): Single<TLChannelParticipant> = executeMethod(TLRequestChannelsGetParticipant(channel, participant))

    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsChannelParticipants> = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    override fun channelsGetSponsoredMessages(channel: TLAbsInputChannel): Single<TLSponsoredMessages> = executeMethod(TLRequestChannelsGetSponsoredMessages(channel))

    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    override fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsJoinChannel(channel))

    override fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsLeaveChannel(channel))

    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool> = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool> = executeMethod(TLRequestChannelsReportSpam(channel, userId, id))

    override fun channelsSetDiscussionGroup(broadcast: TLAbsInputChannel, group: TLAbsInputChannel): Single<TLBool> = executeMethod(TLRequestChannelsSetDiscussionGroup(broadcast, group))

    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    override fun channelsToggleSlowMode(channel: TLAbsInputChannel, seconds: Int): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleSlowMode(channel, seconds))

    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    override fun channelsViewSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): Single<TLBool> = executeMethod(TLRequestChannelsViewSponsoredMessage(channel, randomId))

    override fun contactsAcceptContact(id: TLAbsInputUser): Single<TLAbsUpdates> = executeMethod(TLRequestContactsAcceptContact(id))

    override fun contactsAddContact(
            addPhonePrivacyException: Boolean,
            id: TLAbsInputUser,
            firstName: String,
            lastName: String,
            phone: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestContactsAddContact(addPhonePrivacyException, id, firstName, lastName, phone))

    override fun contactsBlock(id: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestContactsBlock(id))

    override fun contactsBlockFromReplies(
            deleteMessage: Boolean,
            deleteHistory: Boolean,
            reportSpam: Boolean,
            msgId: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestContactsBlockFromReplies(deleteMessage, deleteHistory, reportSpam, msgId))

    override fun contactsDeleteByPhones(phones: TLStringVector): Single<TLBool> = executeMethod(TLRequestContactsDeleteByPhones(phones))

    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeMethod(TLRequestContactsDeleteContacts(id))

    override fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked> = executeMethod(TLRequestContactsGetBlocked(offset, limit))

    override fun contactsGetContactIDs(hash: Long): Single<TLIntVector> = executeMethod(TLRequestContactsGetContactIDs(hash))

    override fun contactsGetContacts(hash: Long): Single<TLAbsContacts> = executeMethod(TLRequestContactsGetContacts(hash))

    override fun contactsGetLocated(
            background: Boolean,
            geoPoint: TLAbsInputGeoPoint,
            selfExpires: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestContactsGetLocated(background, geoPoint, selfExpires))

    override fun contactsGetSaved(): Single<TLObjectVector<TLSavedPhoneContact>> = executeMethod(TLRequestContactsGetSaved())

    override fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>> = executeMethod(TLRequestContactsGetStatuses())

    override fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            forwardUsers: Boolean,
            forwardChats: Boolean,
            groups: Boolean,
            channels: Boolean,
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsTopPeers> = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, forwardUsers, forwardChats, groups, channels, offset, limit, hash))

    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts> = executeMethod(TLRequestContactsImportContacts(contacts))

    override fun contactsResetSaved(): Single<TLBool> = executeMethod(TLRequestContactsResetSaved())

    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    override fun contactsResolveUsername(username: String): Single<TLResolvedPeer> = executeMethod(TLRequestContactsResolveUsername(username))

    override fun contactsSearch(q: String, limit: Int): Single<TLFound> = executeMethod(TLRequestContactsSearch(q, limit))

    override fun contactsToggleTopPeers(enabled: Boolean): Single<TLBool> = executeMethod(TLRequestContactsToggleTopPeers(enabled))

    override fun contactsUnblock(id: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestContactsUnblock(id))

    override fun foldersDeleteFolder(folderId: Int): Single<TLAbsUpdates> = executeMethod(TLRequestFoldersDeleteFolder(folderId))

    override fun foldersEditPeerFolders(folderPeers: TLObjectVector<TLInputFolderPeer>): Single<TLAbsUpdates> = executeMethod(TLRequestFoldersEditPeerFolders(folderPeers))

    override fun helpAcceptTermsOfService(id: TLDataJSON): Single<TLBool> = executeMethod(TLRequestHelpAcceptTermsOfService(id))

    override fun helpDismissSuggestion(peer: TLAbsInputPeer, suggestion: String): Single<TLBool> = executeMethod(TLRequestHelpDismissSuggestion(peer, suggestion))

    override fun helpEditUserInfo(
            userId: TLAbsInputUser,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>
    ): Single<TLAbsUserInfo> = executeMethod(TLRequestHelpEditUserInfo(userId, message, entities))

    override fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates> = executeMethod(TLRequestHelpGetAppChangelog(prevAppVersion))

    override fun helpGetAppConfig(): Single<TLAbsJSONValue> = executeMethod(TLRequestHelpGetAppConfig())

    override fun helpGetAppUpdate(source: String): Single<TLAbsAppUpdate> = executeMethod(TLRequestHelpGetAppUpdate(source))

    override fun helpGetCdnConfig(): Single<TLCdnConfig> = executeMethod(TLRequestHelpGetCdnConfig())

    override fun helpGetConfig(): Single<TLConfig> = executeMethod(TLRequestHelpGetConfig())

    override fun helpGetCountriesList(langCode: String, hash: Int): Single<TLAbsCountriesList> = executeMethod(TLRequestHelpGetCountriesList(langCode, hash))

    override fun helpGetDeepLinkInfo(path: String): Single<TLAbsDeepLinkInfo> = executeMethod(TLRequestHelpGetDeepLinkInfo(path))

    override fun helpGetInviteText(): Single<TLInviteText> = executeMethod(TLRequestHelpGetInviteText())

    override fun helpGetNearestDc(): Single<TLNearestDc> = executeMethod(TLRequestHelpGetNearestDc())

    override fun helpGetPassportConfig(hash: Int): Single<TLAbsPassportConfig> = executeMethod(TLRequestHelpGetPassportConfig(hash))

    override fun helpGetPromoData(): Single<TLAbsPromoData> = executeMethod(TLRequestHelpGetPromoData())

    override fun helpGetRecentMeUrls(referer: String): Single<TLRecentMeUrls> = executeMethod(TLRequestHelpGetRecentMeUrls(referer))

    override fun helpGetSupport(): Single<TLSupport> = executeMethod(TLRequestHelpGetSupport())

    override fun helpGetSupportName(): Single<TLSupportName> = executeMethod(TLRequestHelpGetSupportName())

    override fun helpGetTermsOfServiceUpdate(): Single<TLAbsTermsOfServiceUpdate> = executeMethod(TLRequestHelpGetTermsOfServiceUpdate())

    override fun helpGetUserInfo(userId: TLAbsInputUser): Single<TLAbsUserInfo> = executeMethod(TLRequestHelpGetUserInfo(userId))

    override fun helpHidePromoData(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestHelpHidePromoData(peer))

    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool> = executeMethod(TLRequestHelpSaveAppLog(events))

    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool> = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

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
    ): Single<T> = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, params, query))

    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithLayer(layer, query))

    override fun <T : TLObject> invokeWithMessagesRange(range: TLMessageRange, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithMessagesRange(range, query))

    override fun <T : TLObject> invokeWithTakeout(takeoutId: Long, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithTakeout(takeoutId, query))

    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithoutUpdates(query))

    override fun langpackGetDifference(
            langPack: String,
            langCode: String,
            fromVersion: Int
    ): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetDifference(langPack, langCode, fromVersion))

    override fun langpackGetLangPack(langPack: String, langCode: String): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetLangPack(langPack, langCode))

    override fun langpackGetLanguage(langPack: String, langCode: String): Single<TLLangPackLanguage> = executeMethod(TLRequestLangpackGetLanguage(langPack, langCode))

    override fun langpackGetLanguages(langPack: String): Single<TLObjectVector<TLLangPackLanguage>> = executeMethod(TLRequestLangpackGetLanguages(langPack))

    override fun langpackGetStrings(
            langPack: String,
            langCode: String,
            keys: TLStringVector
    ): Single<TLObjectVector<TLAbsLangPackString>> = executeMethod(TLRequestLangpackGetStrings(langPack, langCode, keys))

    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    override fun messagesAcceptUrlAuth(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): Single<TLAbsUrlAuthResult> = executeMethod(TLRequestMessagesAcceptUrlAuth(writeAllowed, peer, msgId, buttonId, url))

    override fun messagesAddChatUser(
            chatId: Long,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    override fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite> = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    override fun messagesCheckHistoryImport(importHead: String): Single<TLHistoryImportParsed> = executeMethod(TLRequestMessagesCheckHistoryImport(importHead))

    override fun messagesCheckHistoryImportPeer(peer: TLAbsInputPeer): Single<TLCheckedHistoryImportPeer> = executeMethod(TLRequestMessagesCheckHistoryImportPeer(peer))

    override fun messagesClearAllDrafts(): Single<TLBool> = executeMethod(TLRequestMessagesClearAllDrafts())

    override fun messagesClearRecentStickers(attached: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesCreateChat(users, title))

    override fun messagesDeleteChat(chatId: Long): Single<TLBool> = executeMethod(TLRequestMessagesDeleteChat(chatId))

    override fun messagesDeleteChatUser(
            revokeHistory: Boolean,
            chatId: Long,
            userId: TLAbsInputUser
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesDeleteChatUser(revokeHistory, chatId, userId))

    override fun messagesDeleteExportedChatInvite(peer: TLAbsInputPeer, link: String): Single<TLBool> = executeMethod(TLRequestMessagesDeleteExportedChatInvite(peer, link))

    override fun messagesDeleteHistory(
            justClear: Boolean,
            revoke: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesDeleteHistory(justClear, revoke, peer, maxId))

    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    override fun messagesDeletePhoneCallHistory(revoke: Boolean): Single<TLAffectedFoundMessages> = executeMethod(TLRequestMessagesDeletePhoneCallHistory(revoke))

    override fun messagesDeleteRevokedExportedChatInvites(peer: TLAbsInputPeer, adminId: TLAbsInputUser): Single<TLBool> = executeMethod(TLRequestMessagesDeleteRevokedExportedChatInvites(peer, adminId))

    override fun messagesDeleteScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesDeleteScheduledMessages(peer, id))

    override fun messagesDiscardEncryption(deleteHistory: Boolean, chatId: Int): Single<TLBool> = executeMethod(TLRequestMessagesDiscardEncryption(deleteHistory, chatId))

    override fun messagesEditChatAbout(peer: TLAbsInputPeer, about: String): Single<TLBool> = executeMethod(TLRequestMessagesEditChatAbout(peer, about))

    override fun messagesEditChatAdmin(
            chatId: Long,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    override fun messagesEditChatDefaultBannedRights(peer: TLAbsInputPeer, bannedRights: TLChatBannedRights): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatDefaultBannedRights(peer, bannedRights))

    override fun messagesEditChatPhoto(chatId: Long, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    override fun messagesEditChatTitle(chatId: Long, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    override fun messagesEditExportedChatInvite(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            link: String,
            expireDate: Int?,
            usageLimit: Int?
    ): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestMessagesEditExportedChatInvite(revoked, peer, link, expireDate, usageLimit))

    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLAbsInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, media, replyMarkup, entities))

    override fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditMessage(noWebpage, peer, id, message, media, replyMarkup, entities, scheduleDate))

    override fun messagesExportChatInvite(
            legacyRevokePermanent: Boolean,
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?
    ): Single<TLChatInviteExported> = executeMethod(TLRequestMessagesExportChatInvite(legacyRevokePermanent, peer, expireDate, usageLimit))

    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            dropAuthor: Boolean,
            dropMediaCaptions: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, dropAuthor, dropMediaCaptions, fromPeer, id, randomId, toPeer, scheduleDate))

    override fun messagesGetAdminsWithInvites(peer: TLAbsInputPeer): Single<TLChatAdminsWithInvites> = executeMethod(TLRequestMessagesGetAdminsWithInvites(peer))

    override fun messagesGetAllChats(exceptIds: TLLongVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetAllChats(exceptIds))

    override fun messagesGetAllDrafts(): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesGetAllDrafts())

    override fun messagesGetAllStickers(hash: Long): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetAllStickers(hash))

    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers> = executeMethod(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?,
            password: TLAbsInputCheckPasswordSRP?
    ): Single<TLBotCallbackAnswer> = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data, password))

    override fun messagesGetChatInviteImporters(
            peer: TLAbsInputPeer,
            link: String,
            offsetDate: Int,
            offsetUser: TLAbsInputUser,
            limit: Int
    ): Single<TLChatInviteImporters> = executeMethod(TLRequestMessagesGetChatInviteImporters(peer, link, offsetDate, offsetUser, limit))

    override fun messagesGetChats(id: TLLongVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetChats(id))

    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Long,
            limit: Int
    ): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    override fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig> = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    override fun messagesGetDialogFilters(): Single<TLObjectVector<TLDialogFilter>> = executeMethod(TLRequestMessagesGetDialogFilters())

    override fun messagesGetDialogUnreadMarks(): Single<TLObjectVector<TLAbsDialogPeer>> = executeMethod(TLRequestMessagesGetDialogUnreadMarks())

    override fun messagesGetDialogs(
            excludePinned: Boolean,
            folderId: Int?,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): Single<TLAbsDialogs> = executeMethod(TLRequestMessagesGetDialogs(excludePinned, folderId, offsetDate, offsetId, offsetPeer, limit, hash))

    override fun messagesGetDiscussionMessage(peer: TLAbsInputPeer, msgId: Int): Single<TLDiscussionMessage> = executeMethod(TLRequestMessagesGetDiscussionMessage(peer, msgId))

    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument> = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    override fun messagesGetEmojiKeywords(langCode: String): Single<TLEmojiKeywordsDifference> = executeMethod(TLRequestMessagesGetEmojiKeywords(langCode))

    override fun messagesGetEmojiKeywordsDifference(langCode: String, fromVersion: Int): Single<TLEmojiKeywordsDifference> = executeMethod(TLRequestMessagesGetEmojiKeywordsDifference(langCode, fromVersion))

    override fun messagesGetEmojiKeywordsLanguages(langCodes: TLStringVector): Single<TLObjectVector<TLEmojiLanguage>> = executeMethod(TLRequestMessagesGetEmojiKeywordsLanguages(langCodes))

    override fun messagesGetEmojiURL(langCode: String): Single<TLEmojiURL> = executeMethod(TLRequestMessagesGetEmojiURL(langCode))

    override fun messagesGetExportedChatInvite(peer: TLAbsInputPeer, link: String): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestMessagesGetExportedChatInvite(peer, link))

    override fun messagesGetExportedChatInvites(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            adminId: TLAbsInputUser,
            offsetDate: Int?,
            offsetLink: String?,
            limit: Int
    ): Single<TLExportedChatInvites> = executeMethod(TLRequestMessagesGetExportedChatInvites(revoked, peer, adminId, offsetDate, offsetLink, limit))

    override fun messagesGetFavedStickers(hash: Long): Single<TLAbsFavedStickers> = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    override fun messagesGetFeaturedStickers(hash: Long): Single<TLAbsFeaturedStickers> = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    override fun messagesGetFullChat(chatId: Long): Single<TLChatFull> = executeMethod(TLRequestMessagesGetFullChat(chatId))

    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores> = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults> = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    override fun messagesGetInlineGameHighScores(id: TLAbsInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores> = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    override fun messagesGetMaskStickers(hash: Long): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData> = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    override fun messagesGetMessageReadParticipants(peer: TLAbsInputPeer, msgId: Int): Single<TLLongVector> = executeMethod(TLRequestMessagesGetMessageReadParticipants(peer, msgId))

    override fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetMessages(id))

    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLMessageViews> = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    override fun messagesGetOldFeaturedStickers(
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsFeaturedStickers> = executeMethod(TLRequestMessagesGetOldFeaturedStickers(offset, limit, hash))

    override fun messagesGetOnlines(peer: TLAbsInputPeer): Single<TLChatOnlines> = executeMethod(TLRequestMessagesGetOnlines(peer))

    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputDialogPeer>): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings> = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    override fun messagesGetPinnedDialogs(folderId: Int): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPinnedDialogs(folderId))

    override fun messagesGetPollResults(peer: TLAbsInputPeer, msgId: Int): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesGetPollResults(peer, msgId))

    override fun messagesGetPollVotes(
            peer: TLAbsInputPeer,
            id: Int,
            option: TLBytes?,
            offset: String?,
            limit: Int
    ): Single<TLVotesList> = executeMethod(TLRequestMessagesGetPollVotes(peer, id, option, offset, limit))

    override fun messagesGetRecentLocations(
            peer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetRecentLocations(peer, limit, hash))

    override fun messagesGetRecentStickers(attached: Boolean, hash: Long): Single<TLAbsRecentStickers> = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

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
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetReplies(peer, msgId, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    override fun messagesGetSavedGifs(hash: Long): Single<TLAbsSavedGifs> = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    override fun messagesGetScheduledHistory(peer: TLAbsInputPeer, hash: Long): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetScheduledHistory(peer, hash))

    override fun messagesGetScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetScheduledMessages(peer, id))

    override fun messagesGetSearchCounters(peer: TLAbsInputPeer, filters: TLObjectVector<TLAbsMessagesFilter>): Single<TLObjectVector<TLSearchCounter>> = executeMethod(TLRequestMessagesGetSearchCounters(peer, filters))

    override fun messagesGetSplitRanges(): Single<TLObjectVector<TLMessageRange>> = executeMethod(TLRequestMessagesGetSplitRanges())

    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet> = executeMethod(TLRequestMessagesGetStickerSet(stickerset))

    override fun messagesGetStickers(emoticon: String, hash: Long): Single<TLAbsStickers> = executeMethod(TLRequestMessagesGetStickers(emoticon, hash))

    override fun messagesGetSuggestedDialogFilters(): Single<TLObjectVector<TLDialogFilterSuggested>> = executeMethod(TLRequestMessagesGetSuggestedDialogFilters())

    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    override fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage> = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    override fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesGetWebPagePreview(message, entities))

    override fun messagesHidePeerSettingsBar(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesHidePeerSettingsBar(peer))

    override fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesImportChatInvite(hash))

    override fun messagesInitHistoryImport(
            peer: TLAbsInputPeer,
            file: TLAbsInputFile,
            mediaCount: Int
    ): Single<TLHistoryImport> = executeMethod(TLRequestMessagesInitHistoryImport(peer, file, mediaCount))

    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult> = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    override fun messagesMarkDialogUnread(unread: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool> = executeMethod(TLRequestMessagesMarkDialogUnread(unread, peer))

    override fun messagesMigrateChat(chatId: Long): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesMigrateChat(chatId))

    override fun messagesReadDiscussion(
            peer: TLAbsInputPeer,
            msgId: Int,
            readMaxId: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesReadDiscussion(peer, msgId, readMaxId))

    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool> = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    override fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    override fun messagesReadMentions(peer: TLAbsInputPeer): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesReadMentions(peer))

    override fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadMessageContents(id))

    override fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    override fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector> = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    override fun messagesReorderPinnedDialogs(
            force: Boolean,
            folderId: Int,
            order: TLObjectVector<TLAbsInputDialogPeer>
    ): Single<TLBool> = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, folderId, order))

    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReorderStickerSets(masks, order))

    override fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool> = executeMethod(TLRequestMessagesReport(peer, id, reason, message))

    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool> = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    override fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesReportSpam(peer))

    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    override fun messagesRequestUrlAuth(
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): Single<TLAbsUrlAuthResult> = executeMethod(TLRequestMessagesRequestUrlAuth(peer, msgId, buttonId, url))

    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

    override fun messagesSearch(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputPeer?,
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
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearch(peer, q, fromId, topMsgId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash))

    override fun messagesSearchGlobal(
            folderId: Int?,
            q: String,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearchGlobal(folderId, q, filter, minDate, maxDate, offsetRate, offsetPeer, offsetId, limit))

    override fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): Single<TLAbsFoundStickerSets> = executeMethod(TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash))

    override fun messagesSendEncrypted(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncrypted(silent, peer, randomId, data))

    override fun messagesSendEncryptedFile(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedFile(silent, peer, randomId, data, file))

    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            hideVia: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, hideVia, peer, replyToMsgId, randomId, queryId, id, scheduleDate))

    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, message, randomId, replyMarkup, entities, scheduleDate))

    override fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities, scheduleDate))

    override fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMultiMedia(silent, background, clearDraft, peer, replyToMsgId, multiMedia, scheduleDate))

    override fun messagesSendScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendScheduledMessages(peer, id))

    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    override fun messagesSendVote(
            peer: TLAbsInputPeer,
            msgId: Int,
            options: TLBytesVector
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendVote(peer, msgId, options))

    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    override fun messagesSetChatTheme(peer: TLAbsInputPeer, emoticon: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSetChatTheme(peer, emoticon))

    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    override fun messagesSetHistoryTTL(peer: TLAbsInputPeer, period: Int): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSetHistoryTTL(peer, period))

    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLAbsInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    override fun messagesSetTyping(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            action: TLAbsSendMessageAction
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetTyping(peer, topMsgId, action))

    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    override fun messagesStartHistoryImport(peer: TLAbsInputPeer, importId: Long): Single<TLBool> = executeMethod(TLRequestMessagesStartHistoryImport(peer, importId))

    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool> = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    override fun messagesToggleStickerSets(
            uninstall: Boolean,
            archive: Boolean,
            unarchive: Boolean,
            stickersets: TLObjectVector<TLAbsInputStickerSet>
    ): Single<TLBool> = executeMethod(TLRequestMessagesToggleStickerSets(uninstall, archive, unarchive, stickersets))

    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    override fun messagesUnpinAllMessages(peer: TLAbsInputPeer): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesUnpinAllMessages(peer))

    override fun messagesUpdateDialogFilter(id: Int, filter: TLDialogFilter?): Single<TLBool> = executeMethod(TLRequestMessagesUpdateDialogFilter(id, filter))

    override fun messagesUpdateDialogFiltersOrder(order: TLIntVector): Single<TLBool> = executeMethod(TLRequestMessagesUpdateDialogFiltersOrder(order))

    override fun messagesUpdatePinnedMessage(
            silent: Boolean,
            unpin: Boolean,
            pmOneside: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesUpdatePinnedMessage(silent, unpin, pmOneside, peer, id))

    override fun messagesUploadEncryptedFile(peer: TLInputEncryptedChat, file: TLAbsInputEncryptedFile): Single<TLAbsEncryptedFile> = executeMethod(TLRequestMessagesUploadEncryptedFile(peer, file))

    override fun messagesUploadImportedMedia(
            peer: TLAbsInputPeer,
            importId: Long,
            fileName: String,
            media: TLAbsInputMedia
    ): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesUploadImportedMedia(peer, importId, fileName, media))

    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesUploadMedia(peer, media))

    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool> = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    override fun paymentsGetBankCardData(number: String): Single<TLBankCardData> = executeMethod(TLRequestPaymentsGetBankCardData(number))

    override fun paymentsGetPaymentForm(
            peer: TLAbsInputPeer,
            msgId: Int,
            themeParams: TLDataJSON?
    ): Single<TLPaymentForm> = executeMethod(TLRequestPaymentsGetPaymentForm(peer, msgId, themeParams))

    override fun paymentsGetPaymentReceipt(peer: TLAbsInputPeer, msgId: Int): Single<TLPaymentReceipt> = executeMethod(TLRequestPaymentsGetPaymentReceipt(peer, msgId))

    override fun paymentsGetSavedInfo(): Single<TLSavedInfo> = executeMethod(TLRequestPaymentsGetSavedInfo())

    override fun paymentsSendPaymentForm(
            formId: Long,
            peer: TLAbsInputPeer,
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ): Single<TLAbsPaymentResult> = executeMethod(TLRequestPaymentsSendPaymentForm(formId, peer, msgId, requestedInfoId, shippingOptionId, credentials, tipAmount))

    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo> = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, peer, msgId, info))

    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    override fun phoneCheckGroupCall(call: TLInputGroupCall, sources: TLIntVector): Single<TLIntVector> = executeMethod(TLRequestPhoneCheckGroupCall(call, sources))

    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    override fun phoneCreateGroupCall(
            peer: TLAbsInputPeer,
            randomId: Int,
            title: String?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneCreateGroupCall(peer, randomId, title, scheduleDate))

    override fun phoneDiscardCall(
            video: Boolean,
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneDiscardCall(video, peer, duration, reason, connectionId))

    override fun phoneDiscardGroupCall(call: TLInputGroupCall): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneDiscardGroupCall(call))

    override fun phoneEditGroupCallParticipant(
            call: TLInputGroupCall,
            participant: TLAbsInputPeer,
            muted: Boolean?,
            volume: Int?,
            raiseHand: Boolean?,
            videoStopped: Boolean?,
            videoPaused: Boolean?,
            presentationPaused: Boolean?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneEditGroupCallParticipant(call, participant, muted, volume, raiseHand, videoStopped, videoPaused, presentationPaused))

    override fun phoneEditGroupCallTitle(call: TLInputGroupCall, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneEditGroupCallTitle(call, title))

    override fun phoneExportGroupCallInvite(canSelfUnmute: Boolean, call: TLInputGroupCall): Single<TLExportedGroupCallInvite> = executeMethod(TLRequestPhoneExportGroupCallInvite(canSelfUnmute, call))

    override fun phoneGetCallConfig(): Single<TLDataJSON> = executeMethod(TLRequestPhoneGetCallConfig())

    override fun phoneGetGroupCall(call: TLInputGroupCall, limit: Int): Single<TLGroupCall> = executeMethod(TLRequestPhoneGetGroupCall(call, limit))

    override fun phoneGetGroupCallJoinAs(peer: TLAbsInputPeer): Single<TLJoinAsPeers> = executeMethod(TLRequestPhoneGetGroupCallJoinAs(peer))

    override fun phoneGetGroupParticipants(
            call: TLInputGroupCall,
            ids: TLObjectVector<TLAbsInputPeer>,
            sources: TLIntVector,
            offset: String,
            limit: Int
    ): Single<TLGroupParticipants> = executeMethod(TLRequestPhoneGetGroupParticipants(call, ids, sources, offset, limit))

    override fun phoneInviteToGroupCall(call: TLInputGroupCall, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneInviteToGroupCall(call, users))

    override fun phoneJoinGroupCall(
            muted: Boolean,
            videoStopped: Boolean,
            call: TLInputGroupCall,
            joinAs: TLAbsInputPeer,
            inviteHash: String?,
            params: TLDataJSON
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneJoinGroupCall(muted, videoStopped, call, joinAs, inviteHash, params))

    override fun phoneJoinGroupCallPresentation(call: TLInputGroupCall, params: TLDataJSON): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneJoinGroupCallPresentation(call, params))

    override fun phoneLeaveGroupCall(call: TLInputGroupCall, source: Int): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneLeaveGroupCall(call, source))

    override fun phoneLeaveGroupCallPresentation(call: TLInputGroupCall): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneLeaveGroupCallPresentation(call))

    override fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool> = executeMethod(TLRequestPhoneReceivedCall(peer))

    override fun phoneRequestCall(
            video: Boolean,
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneRequestCall(video, userId, randomId, gAHash, protocol))

    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool> = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    override fun phoneSaveDefaultGroupCallJoinAs(peer: TLAbsInputPeer, joinAs: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestPhoneSaveDefaultGroupCallJoinAs(peer, joinAs))

    override fun phoneSendSignalingData(peer: TLInputPhoneCall, data: TLBytes): Single<TLBool> = executeMethod(TLRequestPhoneSendSignalingData(peer, data))

    override fun phoneSetCallRating(
            userInitiative: Boolean,
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneSetCallRating(userInitiative, peer, rating, comment))

    override fun phoneStartScheduledGroupCall(call: TLInputGroupCall): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneStartScheduledGroupCall(call))

    override fun phoneToggleGroupCallRecord(
            start: Boolean,
            video: Boolean,
            call: TLInputGroupCall,
            title: String?,
            videoPortrait: Boolean?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneToggleGroupCallRecord(start, video, call, title, videoPortrait))

    override fun phoneToggleGroupCallSettings(
            resetInviteHash: Boolean,
            call: TLInputGroupCall,
            joinMuted: Boolean?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneToggleGroupCallSettings(resetInviteHash, call, joinMuted))

    override fun phoneToggleGroupCallStartSubscription(call: TLInputGroupCall, subscribed: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneToggleGroupCallStartSubscription(call, subscribed))

    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector> = executeMethod(TLRequestPhotosDeletePhotos(id))

    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos> = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLPhoto> = executeMethod(TLRequestPhotosUpdateProfilePhoto(id))

    override fun photosUploadProfilePhoto(
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?
    ): Single<TLPhoto> = executeMethod(TLRequestPhotosUploadProfilePhoto(file, video, videoStartTs))

    override fun statsGetBroadcastStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLBroadcastStats> = executeMethod(TLRequestStatsGetBroadcastStats(dark, channel))

    override fun statsGetMegagroupStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLMegagroupStats> = executeMethod(TLRequestStatsGetMegagroupStats(dark, channel))

    override fun statsGetMessagePublicForwards(
            channel: TLAbsInputChannel,
            msgId: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestStatsGetMessagePublicForwards(channel, msgId, offsetRate, offsetPeer, offsetId, limit))

    override fun statsGetMessageStats(
            dark: Boolean,
            channel: TLAbsInputChannel,
            msgId: Int
    ): Single<TLMessageStats> = executeMethod(TLRequestStatsGetMessageStats(dark, channel, msgId))

    override fun statsLoadAsyncGraph(token: String, x: Long?): Single<TLAbsStatsGraph> = executeMethod(TLRequestStatsLoadAsyncGraph(token, x))

    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet> = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet> = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    override fun stickersCheckShortName(shortName: String): Single<TLBool> = executeMethod(TLRequestStickersCheckShortName(shortName))

    override fun stickersCreateStickerSet(
            masks: Boolean,
            animated: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            thumb: TLAbsInputDocument?,
            stickers: TLObjectVector<TLInputStickerSetItem>,
            software: String?
    ): Single<TLStickerSet> = executeMethod(TLRequestStickersCreateStickerSet(masks, animated, userId, title, shortName, thumb, stickers, software))

    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet> = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    override fun stickersSetStickerSetThumb(stickerset: TLAbsInputStickerSet, thumb: TLAbsInputDocument): Single<TLStickerSet> = executeMethod(TLRequestStickersSetStickerSetThumb(stickerset, thumb))

    override fun stickersSuggestShortName(title: String): Single<TLSuggestedShortName> = executeMethod(TLRequestStickersSuggestShortName(title))

    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference> = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference> = executeMethod(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    override fun updatesGetState(): Single<TLState> = executeMethod(TLRequestUpdatesGetState())

    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile> = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    override fun uploadGetFile(
            precise: Boolean,
            cdnSupported: Boolean,
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile> = executeMethod(TLRequestUploadGetFile(precise, cdnSupported, location, offset, limit))

    override fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Int): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadGetFileHashes(location, offset))

    override fun uploadGetWebFile(
            location: TLAbsInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile> = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    override fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull> = executeMethod(TLRequestUsersGetFullUser(id))

    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>> = executeMethod(TLRequestUsersGetUsers(id))

    override fun usersSetSecureValueErrors(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>): Single<TLBool> = executeMethod(TLRequestUsersSetSecureValueErrors(id, errors))
}

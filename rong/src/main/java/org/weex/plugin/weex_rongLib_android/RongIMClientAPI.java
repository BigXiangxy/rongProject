package org.weex.plugin.weex_rongLib_android;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import io.rong.imlib.AnnotationNotFoundException;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.TypingMessage.TypingStatus;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.ChatRoomInfo;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.UserData;

/**
 * Created by QYG_XXY on 0022 2018/2/22.
 */

public final class RongIMClientAPI {
    /**
     * 根据 discussionId 添加一名或者一组用户加入讨论组。
     *
     * @param discussionId
     * @param userIdList
     * @param callback
     */
    public static void addMemberToDiscussion(String discussionId, List<String> userIdList, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().addMemberToDiscussion(discussionId, userIdList, callback);
    }

    /**
     * 添加位置共享监听。
     *
     * @param conversationType
     * @param targetId
     * @param listener
     */
    public static void addRealTimeLocationListener(Conversation.ConversationType conversationType, String targetId, RongIMClient.RealTimeLocationListener listener) {
        RongIMClient.getInstance().addRealTimeLocationListener(conversationType, targetId, listener);
    }

    /**
     * 将某个用户加到黑名单中。
     *
     * @param userId
     * @param callback
     */
    public static void addToBlacklist(String userId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().addToBlacklist(userId, callback);
    }

    /**
     * 取消多媒体消息下载。
     *
     * @param message
     * @param callback
     */
    public static void cancelDownloadMediaMessage(Message message, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().cancelDownloadMediaMessage(message, callback);
    }

    /**
     * 取消发送多媒体文件。
     *
     * @param message
     * @param callback
     */
    public static void cancelSendMediaMessage(Message message, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().cancelSendMediaMessage(message, callback);
    }

    /**
     * 此方法从服务器端清除历史消息，但是必须先开通历史消息云存储功能。
     *
     * @param conversationType
     * @param targetId
     * @param recordTime
     * @param callback
     */
    public static void cleanRemoteHistoryMessages(Conversation.ConversationType conversationType, String targetId, long recordTime, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().cleanRemoteHistoryMessages(conversationType, targetId, recordTime, callback);
    }

    /**
     * 已过时。
     * 该方法已废弃，请使用 clearConversations(ResultCallback, Conversation.ConversationType...)
     *
     * @param conversationTypes
     * @return
     */
    @Deprecated
    public static boolean clearConversations(Conversation.ConversationType... conversationTypes) {
        return RongIMClient.getInstance().clearConversations(conversationTypes);
    }

    /**
     * 清空会话类型列表中的所有会话及会话信息，回调方式通知是否清空成功。
     *
     * @param callback
     * @param conversationTypes
     */
    public static void clearConversations(RongIMClient.ResultCallback callback, Conversation.ConversationType... conversationTypes) {
        RongIMClient.getInstance().clearConversations(callback, conversationTypes);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 { #clearMessages(Conversation.ConversationType, String, ResultCallback)} 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static boolean clearMessages(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().clearMessages(conversationType, targetId);
    }

    /**
     * 清空指定类型，targetId 的某一会话所有聊天消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void clearMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().clearMessages(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 clearMessagesUnreadStatus(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static boolean clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().clearMessagesUnreadStatus(conversationType, targetId);
    }

    /**
     * 根据时间戳清除指定类型，目标Id 的某一会话消息未读状态。
     *
     * @param conversationType
     * @param targetId
     * @param timestamp
     * @param callback
     */
    public static void clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId, long timestamp, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().clearMessagesUnreadStatus(conversationType, targetId, timestamp, callback);
    }

    /**
     * 清除指定类型，targetId 的某一会话消息未读状态。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().clearMessagesUnreadStatus(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     * 该方法已废弃，请使用 RongPushClient.clearAllNotifications(Context)
     */
    @Deprecated
    public static void clearNotifications() {
        RongIMClient.getInstance().clearNotifications();
    }

    /**
     * 已过时。
     * 已废弃，建议使用 clearTextMessageDraft(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static boolean clearTextMessageDraft(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().clearTextMessageDraft(conversationType, targetId);
    }

    /**
     * 根据消息类型，targetId 清除某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void clearTextMessageDraft(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().clearTextMessageDraft(conversationType, targetId, callback);
    }

    /**
     * 创建讨论组。
     *
     * @param name
     * @param userIdList
     * @param callback
     */
    public static void createDiscussion(String name, List<String> userIdList, RongIMClient.CreateDiscussionCallback callback) {
        RongIMClient.getInstance().createDiscussion(name, userIdList, callback);
    }

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @param messages
     * @param callback
     */
    @Deprecated
    public static void deleteMessages(Conversation.ConversationType conversationType, String targetId, Message[] messages, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().deleteMessages(conversationType, targetId, messages, callback);
    }

    /**
     * 清除指定会话的消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void deleteMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().deleteMessages(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 { #deleteMessages(int[], ResultCallback)} 异步方法。
     *
     * @param messageIds
     * @return
     */
    @Deprecated
    public static boolean deleteMessages(int[] messageIds) {
        return RongIMClient.getInstance().deleteMessages(messageIds);
    }

    /**
     * 根据 messageId，删除指定的一条或者一组消息。
     *
     * @param messageIds
     * @param callback
     */
    public static void deleteMessages(int[] messageIds, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().deleteMessages(messageIds, callback);
    }

    /**
     * 断开与融云服务器的连接。
     */
    public static void disconnect() {
        RongIMClient.getInstance().disconnect();
    }

    /**
     * 已过时。
     * 该方法已废弃，请使用 disconnect() 或者 logout()
     *
     * @param isReceivePush
     */
    @Deprecated
    public static void disconnect(boolean isReceivePush) {
        RongIMClient.getInstance().disconnect(isReceivePush);
    }

    /**
     * 下载多媒体文件。
     *
     * @param conversationType
     * @param targetId
     * @param mediaType
     * @param imageUrl
     * @param callback
     */
    public static void downloadMedia(Conversation.ConversationType conversationType, String targetId, RongIMClient.MediaType mediaType, String imageUrl, RongIMClient.DownloadMediaCallback callback) {
        RongIMClient.getInstance().downloadMedia(conversationType, targetId, mediaType, imageUrl, callback);
    }

    /**
     * 下载文件。
     *
     * @param message
     * @param callback
     */
    public static void downloadMediaMessage(Message message, IRongCallback.IDownloadMediaMessageCallback callback) {
        RongIMClient.getInstance().downloadMediaMessage(message, callback);
    }

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_SEPARATELY, 即人工机器人分开评价时,调用此方法对机器人客服进行评价
     *
     * @param kefuId
     * @param isRobotResolved
     * @param knowledgeId
     */
    public static void evaluateCustomService(String kefuId, boolean isRobotResolved, String knowledgeId) {
        RongIMClient.getInstance().evaluateCustomService(kefuId, isRobotResolved, knowledgeId);
    }

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_UNIFIED, 即人工机器人统一评价时,调用此方法进行评价。
     *
     * @param kefuId
     * @param source
     * @param solveStatus
     * @param suggest
     * @param dialogId
     */
    public static void evaluateCustomService(String kefuId, int source, CustomServiceConfig.CSEvaSolveStatus solveStatus, String suggest, String dialogId) {
        RongIMClient.getInstance().evaluateCustomService(kefuId, source, solveStatus, suggest, dialogId);
    }

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_SEPARATELY, 即人工机器人分开评价时,调用此方法对人工客服进行评价
     *
     * @param kefuId
     * @param source
     * @param resolvestatus
     * @param tagText
     * @param suggest
     * @param dialogId
     * @param extra
     */
    public static void evaluateCustomService(String kefuId, int source, CustomServiceConfig.CSEvaSolveStatus resolvestatus, String tagText, String suggest, String dialogId, String extra) {
        RongIMClient.getInstance().evaluateCustomService(kefuId, source, resolvestatus, tagText, suggest, dialogId, extra);
    }

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_SEPARATELY, 即人工机器人分开评价时,调用此方法对人工客服进行评价
     *
     * @param kefuId
     * @param source
     * @param suggest
     * @param dialogId
     */
    public static void evaluateCustomService(String kefuId, int source, String suggest, String dialogId) {
        RongIMClient.getInstance().evaluateCustomService(kefuId, source, suggest, dialogId);
    }

    /**
     * 获取当前用户设置的黑名单列表。
     *
     * @param callback
     */
    public static void getBlacklist(RongIMClient.GetBlacklistCallback callback) {
        RongIMClient.getInstance().getBlacklist(callback);
    }

    /**
     * 获取某用户是否在黑名单中。
     *
     * @param userId
     * @param callback
     */
    public static void getBlacklistStatus(String userId, RongIMClient.ResultCallback<RongIMClient.BlacklistStatus> callback) {
        RongIMClient.getInstance().getBlacklistStatus(userId, callback);
    }

    /**
     * 获取所有设置了消息免打扰的会话列表。
     *
     * @param callback
     * @param conversationTypes
     */
    public static void getBlockedConversationList(RongIMClient.ResultCallback<List<Conversation>> callback, Conversation.ConversationType... conversationTypes) {
        RongIMClient.getInstance().getBlockedConversationList(callback, conversationTypes);
    }

    /**
     * 获取聊天室历史消息记录。
     *
     * @param targetId
     * @param recordTime
     * @param count
     * @param order
     * @param callback
     */
    public static void getChatroomHistoryMessages(String targetId, long recordTime, int count, RongIMClient.TimestampOrder order, IRongCallback.IChatRoomHistoryMessageCallback callback) {
        RongIMClient.getInstance().getChatroomHistoryMessages(targetId, recordTime, count, order, callback);
    }

    /**
     * 查询聊天室信息。
     *
     * @param chatRoomId
     * @param defMemberCount
     * @param order
     * @param callback
     */
    public static void getChatRoomInfo(String chatRoomId, int defMemberCount, ChatRoomInfo.ChatRoomMemberOrder order, RongIMClient.ResultCallback<ChatRoomInfo> callback) {
        RongIMClient.getInstance().getChatRoomInfo(chatRoomId, defMemberCount, order, callback);
    }

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static Conversation getConversation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getConversation(conversationType, targetId);
    }

    /**
     * 根据不同会话类型的目标 Id，回调方式获取某一会话信息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void getConversation(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Conversation> callback) {
        RongIMClient.getInstance().getConversation(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     * 该方法废弃
     * 请使用getConversationList(ResultCallback)
     * 或getConversationList(ResultCallback, Conversation.ConversationType...)
     *
     * @return
     */
    @Deprecated
    public static List<Conversation> getConversationList() {
        return RongIMClient.getInstance().getConversationList();
    }

    /**
     * 已过时。
     * 该方法废弃
     * 请使用getConversationList(ResultCallback)
     * <p>
     * 或getConversationList(ResultCallback, Conversation.ConversationType...)
     *
     * @param types
     * @return
     */
    @Deprecated
    public static List<Conversation> getConversationList(Conversation.ConversationType... types) {
        return RongIMClient.getInstance().getConversationList(types);
    }

    /**
     * 获取当前用户本地会话列表的默认方法，该方法返回的是以下类型的会话列表：私聊，群组，讨论组，系统会话。
     *
     * @param callback
     */
    public static void getConversationList(RongIMClient.ResultCallback<List<Conversation>> callback) {
        RongIMClient.getInstance().getConversationList(callback);
    }

    /**
     * 根据会话类型，获取当前用户的本地会话列表。
     *
     * @param callback
     * @param conversationTypes
     */
    public static void getConversationList(RongIMClient.ResultCallback<List<Conversation>> callback, Conversation.ConversationType... conversationTypes) {
        RongIMClient.getInstance().getConversationList(callback, conversationTypes);
    }

    /**
     * 分页获取会话列表 注意：当更换设备或者清除缓存后，能拉取到暂存在融云服务器中该账号当天收发过消息的会话。
     *
     * @param callback
     * @param timeStamp
     * @param count
     * @param conversationTypes
     */
    public static void getConversationListByPage(RongIMClient.ResultCallback<List<Conversation>> callback, long timeStamp, int count, Conversation.ConversationType... conversationTypes) {
        RongIMClient.getInstance().getConversationListByPage(callback, timeStamp, count, conversationTypes);
    }

    /**
     * 获取会话消息提醒状态。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void getConversationNotificationStatus(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> callback) {
        RongIMClient.getInstance().getConversationNotificationStatus(conversationType, targetId, callback);
    }

    /**
     * 获取当前服务器连接状态。
     *
     * @return
     */
    public static RongIMClient.ConnectionStatusListener.ConnectionStatus getCurrentConnectionStatus() {
        return RongIMClient.getInstance().getCurrentConnectionStatus();
    }

    /**
     * 获取当前连接用户的信息。
     *
     * @return
     */
    public static String getCurrentUserId() {
        return RongIMClient.getInstance().getCurrentUserId();
    }

    /**
     * 获取本地时间与服务器时间的差值。
     *
     * @return
     */
    public static long getDeltaTime() {
        return RongIMClient.getInstance().getDeltaTime();
    }

    /**
     * 根据消息类型，targetId 获取讨论组信息和设置。
     *
     * @param discussionId
     * @param callback
     */
    public static void getDiscussion(String discussionId, RongIMClient.ResultCallback<Discussion> callback) {
        RongIMClient.getInstance().getDiscussion(discussionId, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 getHistoryMessages(Conversation.ConversationType, String, int, int, ResultCallback) 或 getHistoryMessages(Conversation.ConversationType, String, String, int, int, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param oldestMessageId
     * @param count
     * @return
     */
    @Deprecated
    public static List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String targetId, int oldestMessageId, int count) {
        return RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, oldestMessageId, count);
    }

    /**
     * 获取指定类型，targetId 的N条历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param oldestMessageId
     * @param count
     * @param callback
     */
    public static void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, int oldestMessageId, int count, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, oldestMessageId, count, callback);
    }

//    /**
//     * 根据会话类型的目标 Id，回调方式获取某些消息类型的某条消息之前或之后的N条历史消息记录。
//     *
//     * @param conversationType
//     * @param targetId
//     * @param objectNames
//     * @param timestamp
//     * @param count
//     * @param direction
//     * @param org.weex.plugin.callback
//     */
//    public static void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, List<String> objectNames, long timestamp, int count, RongCommonDefine.GetMessageDirection direction, RongIMClient.ResultCallback<List<Message>> org.weex.plugin.callback) {
//        RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, objectNames, timestamp, count, direction, org.weex.plugin.callback);
//    }

    /**
     * 在会话中搜索指定消息的前 before 数量和 after 数量的消息。
     *
     * @param conversationType
     * @param targetId
     * @param sentTime
     * @param before
     * @param after
     * @param resultCallback
     */
    public static void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, long sentTime, int before, int after, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, sentTime, before, after, resultCallback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 getHistoryMessages(Conversation.ConversationType, String, int, int, ResultCallback) 或 getHistoryMessages(Conversation.ConversationType, String, String, int, int, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param objectName
     * @param oldestMessageId
     * @param count
     * @return
     */
    @Deprecated
    public static List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int oldestMessageId, int count) {
        return RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, objectName, oldestMessageId, count);
    }

    /**
     * 根据会话类型的目标 Id，回调方式获取某消息类型的某条消息之前或之后的N条历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param objectName
     * @param baseMessageId
     * @param count
     * @param direction
     * @param callback
     */
    public static void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int baseMessageId, int count, io.rong.imlib.RongCommonDefine.GetMessageDirection direction, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, objectName, baseMessageId, count, direction, callback);
    }

    /**
     * 获取本地数据库中保存，特定类型，targetId 的N条历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param objectName
     * @param oldestMessageId
     * @param count
     * @param callback
     */
    public static void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int oldestMessageId, int count, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, targetId, objectName, oldestMessageId, count, callback);
    }


    /**
     * 已过时。
     * 已废弃，建议使用 getLatestMessages(Conversation.ConversationType, String, int, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param count
     * @return
     */
    @Deprecated
    public static List<Message> getLatestMessages(Conversation.ConversationType conversationType, String targetId, int count) {
        return RongIMClient.getInstance().getLatestMessages(conversationType, targetId, count);
    }

    /**
     * 获取指定类型，targetId 的最新消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param count
     * @param callback
     */
    public static void getLatestMessages(Conversation.ConversationType conversationType, String targetId, int count, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getLatestMessages(conversationType, targetId, count, callback);
    }

    /**
     * 根据 message id 获取消息体。
     *
     * @param messageId
     * @param callback
     */
    public static void getMessage(int messageId, RongIMClient.ResultCallback<Message> callback) {
        RongIMClient.getInstance().getMessage(messageId, callback);
    }

    /**
     * 根据 uid 获取 message 对象
     *
     * @param uid
     * @param callback
     */
    public static void getMessageByUid(String uid, RongIMClient.ResultCallback callback) {
        RongIMClient.getInstance().getMessageByUid(uid, callback);
    }

    /**
     * 获取消息通知免打扰时间。
     *
     * @param callback
     */
    public static void getNotificationQuietHours(RongIMClient.GetNotificationQuietHoursCallback callback) {
        RongIMClient.getInstance().getNotificationQuietHours(callback);
    }

    /**
     * 获取当前用户离线消息的存储时间，取值范围为int值1~7天
     *
     * @param callback
     */
    public static void getOfflineMessageDuration(RongIMClient.ResultCallback<String> callback) {
        RongIMClient.getInstance().getOfflineMessageDuration(callback);
    }

    /**
     * 获取己关注公共账号列表。
     *
     * @param callback
     */
    public static void getPublicServiceList(RongIMClient.ResultCallback<PublicServiceProfileList> callback) {
        RongIMClient.getInstance().getPublicServiceList(callback);
    }

    /**
     * 获取某公共服务信息。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    public static void getPublicServiceProfile(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.ResultCallback<PublicServiceProfile> callback) {
        RongIMClient.getInstance().getPublicServiceProfile(publicServiceType, publicServiceId, callback);
    }

    /**
     * 获取是否显示 Push 内容详情的设置
     *
     * @param callback
     */
    public static void getPushContentShowStatus(RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().getPushContentShowStatus(callback);
    }

    /**
     * 获取 RealTimeLocation 实例，每发起一次位置共享业务，就要获取一个实例。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode getRealTimeLocation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getRealTimeLocation(conversationType, targetId);
    }

    /**
     * 获取位置共享状态。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationStatus getRealTimeLocationCurrentState(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getRealTimeLocationCurrentState(conversationType, targetId);
    }

    /**
     * 获取参与该位置共享的所有成员。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static List<String> getRealTimeLocationParticipants(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getRealTimeLocationParticipants(conversationType, targetId);
    }

    /**
     * 获取融云服务器中暂存，特定类型，targetId 的N条（一次不超过40条）历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param dateTime
     * @param count
     * @param callback
     */
    public static void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String targetId, long dateTime, int count, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getRemoteHistoryMessages(conversationType, targetId, dateTime, count, callback);
    }

    /**
     * 根据 messageId 获取消息发送时间 Message.sentTime
     *
     * @param messageId
     * @return
     */
    public static long getSendTimeByMessageId(int messageId) {
        return RongIMClient.getInstance().getSendTimeByMessageId(messageId);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 getTextMessageDraft(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static String getTextMessageDraft(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getTextMessageDraft(conversationType, targetId);
    }

    /**
     * 根据消息类型，targetId 获取某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void getTextMessageDraft(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<String> callback) {
        RongIMClient.getInstance().getTextMessageDraft(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     *
     * @return
     */
    @Deprecated
    public static int getTotalUnreadCount() {
        return RongIMClient.getInstance().getTotalUnreadCount();
    }

    /**
     * 通过回调方式，获取所有未读消息数。
     *
     * @param callback
     */
    public static void getTotalUnreadCount(RongIMClient.ResultCallback<Integer> callback) {
        RongIMClient.getInstance().getTotalUnreadCount(callback);
    }

    /**
     * 通过回调方式，获取所有指定会话的未读消息数（聊天室除外）。
     *
     * @param callback
     * @param conversations
     */
    public static void getTotalUnreadCount(RongIMClient.ResultCallback<Integer> callback, Conversation... conversations) {
        RongIMClient.getInstance().getTotalUnreadCount(callback, conversations);
    }

    /**
     * 根据conversationType和targetId获取当前会话正在输入的用户列表
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static Collection<TypingStatus> getTypingUserListFromConversation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getTypingUserListFromConversation(conversationType, targetId);
    }

    /**
     * 已过时。
     *
     * @param conversationTypes
     * @return
     */
    @Deprecated
    public static int getUnreadCount(Conversation.ConversationType... conversationTypes) {
        return RongIMClient.getInstance().getUnreadCount(conversationTypes);
    }

    /**
     * 根据会话类型数组，回调方式获取某会话类型的未读消息数。
     *
     * @param conversationTypes
     * @param callback
     */
    public static void getUnreadCount(Conversation.ConversationType[] conversationTypes, RongIMClient.ResultCallback<Integer> callback) {
        RongIMClient.getInstance().getUnreadCount(conversationTypes, callback);
    }

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static int getUnreadCount(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().getUnreadCount(conversationType, targetId);
    }

    /**
     * 根据会话类型的目标 Id，回调方式获取来自某用户（某会话）的未读消息数。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void getUnreadCount(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Integer> callback) {
        RongIMClient.getInstance().getUnreadCount(conversationType, targetId, callback);
    }

    /**
     * 回调方式获取某会话类型的未读消息数。
     *
     * @param callback
     * @param conversationTypes
     */
    public static void getUnreadCount(RongIMClient.ResultCallback<Integer> callback, Conversation.ConversationType... conversationTypes) {
        RongIMClient.getInstance().getUnreadCount(callback, conversationTypes);
    }

    /**
     * 获取某会话里未读的@消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void getUnreadMentionedMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<List<Message>> callback) {
        RongIMClient.getInstance().getUnreadMentionedMessages(conversationType, targetId, callback);
    }

    /**
     * 已过时。
     *
     * @param userId
     * @param callback
     */
    @Deprecated
    public static void getUserOnlineStatus(String userId, IRongCallback.IGetUserOnlineStatusCallback callback) {
        RongIMClient.getInstance().getUserOnlineStatus(userId, callback);
    }

    /**
     * 获取登录者身份认证信息。
     *
     * @param resultCallback
     */
    public static void getVendorToken(RongIMClient.ResultCallback<String> resultCallback) {
        RongIMClient.getInstance().getVendorToken(resultCallback);
    }

    /**
     * 向本地会话中插入一条消息，方向为接收。
     *
     * @param type
     * @param targetId
     * @param senderUserId
     * @param receivedStatus
     * @param content
     * @param sentTime
     * @param resultCallback
     */
    public static void insertIncomingMessage(Conversation.ConversationType type, String targetId, String senderUserId, Message.ReceivedStatus receivedStatus, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertIncomingMessage(type, targetId, senderUserId, receivedStatus, content, sentTime, resultCallback);
    }

    /**
     * 向本地会话中插入一条消息，方向为接收。
     *
     * @param type
     * @param targetId
     * @param senderUserId
     * @param receivedStatus
     * @param content
     * @param resultCallback
     */
    public static void insertIncomingMessage(Conversation.ConversationType type, String targetId, String senderUserId, Message.ReceivedStatus receivedStatus, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertIncomingMessage(type, targetId, senderUserId, receivedStatus, content, resultCallback);
    }

    /**
     * 已过时。
     * 该方法废弃, 请使用 insertMessage(Conversation.ConversationType, String, String, MessageContent, ResultCallback)
     *
     * @param type
     * @param targetId
     * @param senderUserId
     * @param content
     * @return
     */
    @Deprecated
    public static Message insertMessage(Conversation.ConversationType type, String targetId, String senderUserId, MessageContent content) {
        return RongIMClient.getInstance().insertMessage(type, targetId, senderUserId, content);
    }

    /**
     * 已过时。
     * 此方法废弃，请使用以下两个方法： insertIncomingMessage(Conversation.ConversationType, String, String, Message.ReceivedStatus, MessageContent, long, ResultCallback) insertOutgoingMessage(Conversation.ConversationType, String, Message.SentStatus, MessageContent, long, ResultCallback)
     *
     * @param type
     * @param targetId
     * @param senderUserId
     * @param content
     * @param sentTime
     * @param resultCallback
     */
    @Deprecated
    public static void insertMessage(Conversation.ConversationType type, String targetId, String senderUserId, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertMessage(type, targetId, senderUserId, content, sentTime, resultCallback);
    }

    /**
     * 已过时。
     * 此方法废弃，请使用以下两个方法： insertIncomingMessage(Conversation.ConversationType, String, String, Message.ReceivedStatus, MessageContent, ResultCallback) insertOutgoingMessage(Conversation.ConversationType, String, Message.SentStatus, MessageContent, ResultCallback)
     *
     * @param conversationType
     * @param targetId
     * @param senderUserId
     * @param content
     * @param resultCallback
     */
    @Deprecated
    public static void insertMessage(Conversation.ConversationType conversationType, String targetId, String senderUserId, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertMessage(conversationType, targetId, senderUserId, content, resultCallback);
    }

    /**
     * 向本地会话中插入一条消息，方向为发送。
     *
     * @param type
     * @param targetId
     * @param sentStatus
     * @param content
     * @param sentTime
     * @param resultCallback
     */
    public static void insertOutgoingMessage(Conversation.ConversationType type, String targetId, Message.SentStatus sentStatus, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertOutgoingMessage(type, targetId, sentStatus, content, sentTime, resultCallback);
    }

    /**
     * 向本地会话中插入一条消息。
     *
     * @param type
     * @param targetId
     * @param sentStatus
     * @param content
     * @param resultCallback
     */
    public static void insertOutgoingMessage(Conversation.ConversationType type, String targetId, Message.SentStatus sentStatus, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().insertOutgoingMessage(type, targetId, sentStatus, content, resultCallback);
    }

    /**
     * 加入聊天室。
     *
     * @param chatRoomId
     * @param defMessageCount
     * @param callback
     */
    public static void joinChatRoom(String chatRoomId, int defMessageCount, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().joinChatRoom(chatRoomId, defMessageCount, callback);
    }

    /**
     * 加入已存在的聊天室。
     *
     * @param chatRoomId
     * @param defMessageCount
     * @param callback
     */
    public static void joinExistChatRoom(String chatRoomId, int defMessageCount, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().joinExistChatRoom(chatRoomId, defMessageCount, callback);
    }

    /**
     * 已过时。
     * 已废弃。请参考群组 http://www.rongcloud.cn/docs/android.html#3、群组 和 href="http://support.rongcloud.cn/kb/MzY5" 使用说明。
     *
     * @param groupId
     * @param groupName
     * @param callback
     */
    @Deprecated
    public static void joinGroup(String groupId, String groupName, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().joinGroup(groupId, groupName, callback);
    }

    /**
     * 加入位置共享。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode joinRealTimeLocation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().joinRealTimeLocation(conversationType, targetId);
    }

    /**
     * 发送留言消息给客服。
     *
     * @param kefuId
     * @param contentMap
     * @param operationCallback
     */
    public static void leaveMessageCustomService(String kefuId, Map<String, String> contentMap, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().leaveMessageCustomService(kefuId, contentMap, operationCallback);
    }

    /**
     * 断开与融云服务器的连接，并且不再接收 Push 消息。
     */
    public static void logout() {
        RongIMClient.getInstance().logout();
    }

    /**
     * 退出聊天室。
     *
     * @param chatRoomId
     * @param callback
     */
    public static void quitChatRoom(String chatRoomId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().quitChatRoom(chatRoomId, callback);
    }

    /**
     * 根据discussionId 退出当前用户所在的某讨论组。
     *
     * @param discussionId
     * @param callback
     */
    public static void quitDiscussion(String discussionId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().quitDiscussion(discussionId, callback);
    }

    /**
     * 已过时。
     * 已废弃，请参考群组 href="http://www.rongcloud.cn/docs/android.html#3、群组 和 href="http://support.rongcloud.cn/kb/MzY5" 使用说明。
     *
     * @param groupId
     * @param callback
     */
    @Deprecated
    public static void quitGroup(String groupId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().quitGroup(groupId, callback);
    }

    /**
     * 退出位置共享。
     *
     * @param conversationType
     * @param targetId
     */
    public static void quitRealTimeLocation(Conversation.ConversationType conversationType, String targetId) {
        RongIMClient.getInstance().quitRealTimeLocation(conversationType, targetId);
    }

    /**
     * 撤回消息
     *
     * @param message
     * @param pushContent
     * @param callback
     */
    public static void recallMessage(Message message, String pushContent, RongIMClient.ResultCallback<io.rong.message.RecallNotificationMessage> callback) {
        RongIMClient.getInstance().recallMessage(message, pushContent, callback);
    }

    /**
     * 已过时。
     * 请使用 connect(String, ConnectCallback) 方法
     *
     * @param callback
     */
    @Deprecated
    public static void reconnect(RongIMClient.ConnectCallback callback) {
        RongIMClient.getInstance().reconnect(callback);
    }

    /**
     * 已过时。
     * 该方法已废弃，请使用 RongPushClient.recordNotificationEvent(String)
     *
     * @return
     */
    @Deprecated
    public static void recordNotificationEvent(String pushId) {
        RongIMClient.getInstance().recordNotificationEvent(pushId);
    }

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    @Deprecated
    public static boolean removeConversation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().removeConversation(conversationType, targetId);
    }

    /**
     * 从会话列表中移除某一会话，但是不删除会话内的消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    public static void removeConversation(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().removeConversation(conversationType, targetId, callback);
    }

    /**
     * 将个某用户从黑名单中移出。
     *
     * @param userId
     * @param callback
     */
    public static void removeFromBlacklist(String userId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().removeFromBlacklist(userId, callback);
    }

    /**
     * 供创建者将某用户移出讨论组。
     *
     * @param discussionId
     * @param userId
     * @param callback
     */
    public static void removeMemberFromDiscussion(String discussionId, String userId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().removeMemberFromDiscussion(discussionId, userId, callback);
    }

    /**
     * 移除消息通知免打扰时间。
     *
     * @param callback
     */
    public static void removeNotificationQuietHours(RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().removeNotificationQuietHours(callback);
    }

    /**
     * @param conversationType
     * @param targetId
     */
    public static void removeRealTimeLocationObserver(Conversation.ConversationType conversationType, String targetId) {
        RongIMClient.getInstance().removeRealTimeLocationObserver(conversationType, targetId);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 saveTextMessageDraft(Conversation.ConversationType, String, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param content
     * @return
     */
    @Deprecated
    public static boolean saveTextMessageDraft(Conversation.ConversationType conversationType, String targetId, String content) {
        return RongIMClient.getInstance().saveTextMessageDraft(conversationType, targetId, content);
    }

    /**
     * 根据消息类型，targetId 保存某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param content
     * @param callback
     */
    public static void saveTextMessageDraft(Conversation.ConversationType conversationType, String targetId, String content, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().saveTextMessageDraft(conversationType, targetId, content, callback);
    }

    /**
     * 搜索本地历史消息。
     *
     * @param keyword
     * @param conversationTypes
     * @param objectNames
     * @param resultCallback
     */
    public static void searchConversations(String keyword, Conversation.ConversationType[] conversationTypes, String[] objectNames, RongIMClient.ResultCallback<List<SearchConversationResult>> resultCallback) {
        RongIMClient.getInstance().searchConversations(keyword, conversationTypes, objectNames, resultCallback);
    }

    /**
     * 根据会话,搜索本地历史消息。
     *
     * @param conversationType
     * @param targetId
     * @param keyword
     * @param count
     * @param beginTime
     * @param resultCallback
     */
    public static void searchMessages(Conversation.ConversationType conversationType, String targetId, String keyword, int count, long beginTime, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().searchMessages(conversationType, targetId, keyword, count, beginTime, resultCallback);
    }

    /**
     * 搜索公众服务。
     *
     * @param searchType
     * @param keywords
     * @param callback
     */
    public static void searchPublicService(RongIMClient.SearchType searchType, String keywords, RongIMClient.ResultCallback<PublicServiceProfileList> callback) {
        RongIMClient.getInstance().searchPublicService(searchType, keywords, callback);
    }

    /**
     * 按公众服务类型搜索公众服务。
     *
     * @param publicServiceType
     * @param searchType
     * @param keywords
     * @param callback
     */
    public static void searchPublicServiceByType(Conversation.PublicServiceType publicServiceType, RongIMClient.SearchType searchType, String keywords, RongIMClient.ResultCallback<PublicServiceProfileList> callback) {
        RongIMClient.getInstance().searchPublicServiceByType(publicServiceType, searchType, keywords, callback);
    }

    /**
     * 根据客服ID和分组ID转换人工模式
     *
     * @param kefuId
     * @param groupId
     */
    public static void selectCustomServiceGroup(String kefuId, String groupId) {
        RongIMClient.getInstance().selectCustomServiceGroup(kefuId, groupId);
    }

    /**
     * 此方法用于在群组和讨论组中发送消息给其中的部分用户，其它用户不会收到这条消息。
     *
     * @param type
     * @param targetId
     * @param content
     * @param userIds
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendDirectionalMessage(Conversation.ConversationType type, String targetId, MessageContent content, String[] userIds, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback) {
        RongIMClient.getInstance().sendDirectionalMessage(type, targetId, content, userIds, pushContent, pushData, callback);
    }

    /**
     * 根据会话类型，发送图片消息。
     *
     * @param type
     * @param targetId
     * @param content
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendImageMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendImageMessageCallback callback) {
        RongIMClient.getInstance().sendImageMessage(type, targetId, content, pushContent, pushData, callback);
    }

    /**
     * 发送图片消息
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageCallback callback) {
        RongIMClient.getInstance().sendImageMessage(message, pushContent, pushData, callback);
    }

    /**
     * 发送图片消息，可以使用该方法将图片上传到自己的服务器发送，同时更新图片状态。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageWithUploadListenerCallback callback) {
        RongIMClient.getInstance().sendImageMessage(message, pushContent, pushData, callback);
    }

    /**
     * 发送地理位置消息。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param sendMessageCallback
     */
    public static void sendLocationMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMessageCallback sendMessageCallback) {
        RongIMClient.getInstance().sendLocationMessage(message, pushContent, pushData, sendMessageCallback);
    }

    /**
     * 发送多媒体消息 发送前构造 Message 消息实体
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallback callback) {
        RongIMClient.getInstance().sendMediaMessage(message, pushContent, pushData, callback);
    }

    /**
     * 发送多媒体消息，可以使用该方法将多媒体文件上传到自己的服务器。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallbackWithUploader callback) {
        RongIMClient.getInstance().sendMediaMessage(message, pushContent, pushData, callback);
    }

    /**
     * 根据会话类型，发送消息。
     *
     * @param type
     * @param targetId
     * @param content
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback) {
        RongIMClient.getInstance().sendMessage(type, targetId, content, pushContent, pushData, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 sendMessage(Conversation.ConversationType, String, MessageContent, String, String, IRongCallback.WeexISendMessageCallback) 异步方法
     *
     * @param type
     * @param targetId
     * @param content
     * @param pushContent
     * @param pushData
     * @param callback
     * @return
     */
    @Deprecated
    public static Message sendMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendMessageCallback callback) {
        return RongIMClient.getInstance().sendMessage(type, targetId, content, pushContent, pushData, callback);
    }

    /**
     * 已过时。
     * 已废弃，请使用 sendMessage(Conversation.ConversationType, String, MessageContent, String, String, IRongCallback.WeexISendMessageCallback)
     *
     * @param conversationType
     * @param targetId
     * @param content
     * @param pushContent
     * @param pushData
     * @param callback
     * @param resultCallback
     */
    @Deprecated
    public static void sendMessage(Conversation.ConversationType conversationType, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendMessageCallback callback, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().sendMessage(conversationType, targetId, content, pushContent, pushData, callback, resultCallback);
    }

    /**
     * 发送消息。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    public static void sendMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback) {
        RongIMClient.getInstance().sendMessage(message, pushContent, pushData, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 sendMessage(Message, String, String, IRongCallback.WeexISendMessageCallback) 异步方法。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     * @return
     */
    @Deprecated
    public static Message sendMessage(Message message, String pushContent, String pushData, RongIMClient.SendMessageCallback callback) {
        return RongIMClient.getInstance().sendMessage(message, pushContent, pushData, callback);
    }

    /**
     * 已过时。
     * 已废弃，请使用 sendMessage(Message, String, String, IRongCallback.WeexISendMessageCallback)
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     * @param resultCallback
     */
    @Deprecated
    public static void sendMessage(Message message, String pushContent, String pushData, RongIMClient.SendMessageCallback callback, RongIMClient.ResultCallback<Message> resultCallback) {
        RongIMClient.getInstance().sendMessage(message, pushContent, pushData, callback, resultCallback);
    }

    /**
     * 发送某个会话中的消息阅读回执
     *
     * @param conversationType
     * @param targetId
     * @param timestamp
     */
    public static void sendReadReceiptMessage(Conversation.ConversationType conversationType, String targetId, long timestamp) {
        RongIMClient.getInstance().sendReadReceiptMessage(conversationType, targetId, timestamp);
    }

    /**
     * 发起群组消息回执请求。
     *
     * @param message
     * @param callback
     */
    public static void sendReadReceiptRequest(Message message, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().sendReadReceiptRequest(message, callback);
    }

    /**
     * 发送群消息已读回执
     *
     * @param type
     * @param targetId
     * @param messageList
     * @param callback
     */
    public static void sendReadReceiptResponse(Conversation.ConversationType type, String targetId, List<Message> messageList, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().sendReadReceiptResponse(type, targetId, messageList, callback);
    }

    /**
     * 向会话中发送正在输入的状态
     *
     * @param conversationType
     * @param targetId
     * @param typingContentType
     */
    public static void sendTypingStatus(Conversation.ConversationType conversationType, String targetId, String typingContentType) {
        RongIMClient.getInstance().sendTypingStatus(conversationType, targetId, typingContentType);
    }

//    /**
//     * 设置集成 sdk 的用户 App 版本信息。
//     *
//     * @param appVer
//     */
//    public static void setAppVer(String appVer) {
//        RongIMClient.getInstance().setAppVer( appVer);
//    }

    /**
     * 设置会话消息提醒状态。
     *
     * @param conversationType
     * @param targetId
     * @param notificationStatus
     * @param callback
     */
    public static void setConversationNotificationStatus(Conversation.ConversationType conversationType, String targetId, Conversation.ConversationNotificationStatus notificationStatus, RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> callback) {
        RongIMClient.getInstance().setConversationNotificationStatus(conversationType, targetId, notificationStatus, callback);
    }

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @param isTop
     * @return
     */
    @Deprecated
    public static boolean setConversationToTop(Conversation.ConversationType conversationType, String targetId, boolean isTop) {
        return RongIMClient.getInstance().setConversationToTop(conversationType, targetId, isTop);
    }

    /**
     * 设置某一会话为置顶或者取消置顶，回调方式获取设置是否成功。
     *
     * @param conversationType
     * @param id
     * @param isTop
     * @param callback
     */
    public static void setConversationToTop(Conversation.ConversationType conversationType, String id, boolean isTop, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().setConversationToTop(conversationType, id, isTop, callback);
    }

    /**
     * 设置人工评价监听 当人工评价有标签等配置时，在回调中返回配置
     *
     * @param listener
     */
    public static void setCustomServiceHumanEvaluateListener(io.rong.imlib.cs.CustomServiceManager.OnHumanEvaluateListener listener) {
        RongIMClient.getInstance().setCustomServiceHumanEvaluateListener(listener);
    }

    /**
     * 设置讨论组成员邀请权限。
     *
     * @param discussionId
     * @param status
     * @param callback
     */
    public static void setDiscussionInviteStatus(String discussionId, RongIMClient.DiscussionInviteStatus status, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().setDiscussionInviteStatus(discussionId, status, callback);
    }

    /**
     * 根据 discussionId 设置讨论组名称。
     *
     * @param discussionId
     * @param name
     * @param callback
     */
    public static void setDiscussionName(String discussionId, String name, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().setDiscussionName(discussionId, name, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageExtra(int, String, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param value
     * @return
     */
    @Deprecated
    public static boolean setMessageExtra(int messageId, String value) {
        return RongIMClient.getInstance().setMessageExtra(messageId, value);
    }

    /**
     * 根据 messageId 设置本地消息的附加信息，用于扩展消息的使用场景。
     *
     * @param messageId
     * @param value
     * @param callback
     */
    public static void setMessageExtra(int messageId, String value, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().setMessageExtra(messageId, value, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageReceivedStatus(int, Message.ReceivedStatus, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param receivedStatus
     * @return
     */
    @Deprecated
    public static boolean setMessageReceivedStatus(int messageId, Message.ReceivedStatus receivedStatus) {
        return RongIMClient.getInstance().setMessageReceivedStatus(messageId, receivedStatus);
    }

    /**
     * 根据 messageId 设置接收到的消息状态。
     *
     * @param messageId
     * @param receivedStatus
     * @param callback
     */
    public static void setMessageReceivedStatus(int messageId, Message.ReceivedStatus receivedStatus, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().setMessageReceivedStatus(messageId, receivedStatus, callback);
    }

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageSentStatus(int, Message.SentStatus, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param sentStatus
     * @return
     */
    @Deprecated
    public static boolean setMessageSentStatus(int messageId, Message.SentStatus sentStatus) {
        return RongIMClient.getInstance().setMessageSentStatus(messageId, sentStatus);
    }

    /**
     * 根据 messageId 设置消息的发送状态。
     *
     * @param messageId
     * @param sentStatus
     * @param callback
     */
    public static void setMessageSentStatus(int messageId, Message.SentStatus sentStatus, RongIMClient.ResultCallback<Boolean> callback) {
        RongIMClient.getInstance().setMessageSentStatus(messageId, sentStatus, callback);
    }

    /**
     * 设置消息通知免打扰时间。
     *
     * @param startTime
     * @param spanMinutes
     * @param callback
     */
    public static void setNotificationQuietHours(String startTime, int spanMinutes, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().setNotificationQuietHours(startTime, spanMinutes, callback);
    }

    /**
     * 设置当前用户离线消息存储时间
     *
     * @param duration
     * @param callback
     */
    public static void setOfflineMessageDuration(int duration, RongIMClient.ResultCallback<Long> callback) {
        RongIMClient.getInstance().setOfflineMessageDuration(duration, callback);
    }


    /**
     * 设置是否显示 Push 内容详情
     *
     * @param showStatus
     * @param callback
     */
    public static void setPushContentShowStatus(boolean showStatus, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().setPushContentShowStatus(showStatus, callback);
    }


    /**
     * 已过时。
     *
     * @param callback
     */
    @Deprecated
    public static void setSubscribeStatusListener(IRongCallback.ISetSubscribeStatusCallback callback) {
        RongIMClient.getInstance().setSubscribeStatusListener(callback);
    }

    /**
     * 设置多端同步会话阅读数监听
     *
     * @param listener
     */
    public static void setSyncConversationReadStatusListener(RongIMClient.SyncConversationReadStatusListener listener) {
        RongIMClient.getInstance().setSyncConversationReadStatusListener(listener);
    }

    /**
     * 已过时。
     *
     * @param status
     * @param callback
     */
    @Deprecated
    public static void setUserOnlineStatus(int status, IRongCallback.ISetUserOnlineStatusCallback callback) {
        RongIMClient.getInstance().setUserOnlineStatus(status, callback);
    }


    /**
     * 启动客服服务
     *
     * @param kefuId
     * @param listener
     * @param customServiceInfo
     */
    public static void startCustomService(String kefuId, io.rong.imlib.ICustomServiceListener listener, CSCustomServiceInfo customServiceInfo) {
        RongIMClient.getInstance().startCustomService(kefuId, listener, customServiceInfo);
    }

    /**
     * 发起位置共享。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    public static io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode startRealTimeLocation(Conversation.ConversationType conversationType, String targetId) {
        return RongIMClient.getInstance().startRealTimeLocation(conversationType, targetId);
    }

    /**
     * 结束客服.
     *
     * @param kefuId
     */
    public static void stopCustomService(String kefuId) {
        RongIMClient.getInstance().stopCustomService(kefuId);
    }

    /**
     * 订阅公众号。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    public static void subscribePublicService(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().subscribePublicService(publicServiceType, publicServiceId, callback);
    }

    /**
     * 已过时。
     *
     * @param userIdList
     */
    @Deprecated
    public static void subscribeUserOnlineStatus(List<String> userIdList) {
        RongIMClient.getInstance().subscribeUserOnlineStatus(userIdList);
    }

    /**
     * 切换 appKey.
     *
     * @param appKey
     */
    public static void switchAppKey(String appKey) {
        RongIMClient.getInstance().switchAppKey(appKey);
    }

    /**
     * 切换到人工客服模式,切换的结果需要在 ICustomServiceListener.onModeChanged(CustomServiceMode) 方法回调中处理 如果客服没有分组, 则直接切人工模式 {   RongIMClient.getInstance().}如果客服有分组,那么需要在回调ICustomServiceListener.onSelectGroup(List) 中去弹出分组选择窗口并选择分组,之后在这个回调中调用 @seeselectCustomServiceGroup(String, String) 根据客服 Id 和 分组 Id 去切换到人工模式 客服模式 分为无服务,机器人模式,人工模式,机器人优先模式,人工优先模式
     *
     * @param kefuId
     */
    public static void switchToHumanMode(String kefuId) {
        RongIMClient.getInstance().switchToHumanMode(kefuId);
    }

    /**
     * 多端登录时，通知其它终端清除某个会话的未读消息数
     *
     * @param type
     * @param targetId
     * @param timestamp
     * @param callback
     */
    public static void syncConversationReadStatus(Conversation.ConversationType type, String targetId, long timestamp, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().syncConversationReadStatus(type, targetId, timestamp, callback);
    }

    /**
     * 已过时。
     * 已废弃。请参考 http://www.rongcloud.cn/docs/android.html#3、群组， http://support.rongcloud.cn/kb/MzY5 文档中的使用说明。
     *
     * @param groups
     * @param callback
     */
    @Deprecated
    public static void syncGroup(List<Group> groups, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().syncGroup(groups, callback);
    }

    /**
     * 已过时。
     *
     * @param userData
     * @param callback
     */
    @Deprecated
    public static void syncUserData(UserData userData, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().syncUserData(userData, callback);
    }

    /**
     * 取消订阅公众号。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    public static void unsubscribePublicService(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.OperationCallback callback) {
        RongIMClient.getInstance().unsubscribePublicService(publicServiceType, publicServiceId, callback);
    }

    /**
     * 更新会话信息。
     *
     * @param conversationType
     * @param targetId
     * @param title
     * @param portrait
     * @param callback
     */
    public static void updateConversationInfo(Conversation.ConversationType conversationType, String targetId, String title, String portrait, RongIMClient.ResultCallback callback) {
        RongIMClient.getInstance().updateConversationInfo(conversationType, targetId, title, portrait, callback);
    }

    /**
     * 使用者调用此方法更新坐标位置。
     *
     * @param conversationType
     * @param targetId
     * @param latitude
     * @param longitude
     */
    public static void updateRealTimeLocationStatus(Conversation.ConversationType conversationType, String targetId, double latitude, double longitude) {
        RongIMClient.getInstance().updateRealTimeLocationStatus(conversationType, targetId, latitude, longitude);
    }

    /**
     * 已过时。
     *
     * @param msg
     */
    @Deprecated
    public static void writeDebugFile(String msg) {
        RongIMClient.getInstance().writeDebugFile(msg);
    }

    /**
     * 已过时。
     *
     * @param msg
     */
    @Deprecated
    public static void writeLogFile(String msg) {
        RongIMClient.getInstance().writeLogFile(msg);
    }

    /**
     * 连接服务器，在整个应用程序全局，只需要调用一次，需在 init(Context) 之后调用。
     *
     * @param token
     * @param callback
     * @return
     */
    public static RongIMClient connect(String token, RongIMClient.ConnectCallback callback) {
        return RongIMClient.connect(token, callback);
    }


    /**
     * 获取 IMLib 接口类实例，需在执行 init 方法初始化 SDK 后获取, 否则返回值为 NULL。
     *
     * @return
     */
    public static RongIMClient getInstance() {
        return RongIMClient.getInstance();
    }

    /**
     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在 Application 继承类中调用。
     *
     * @param application
     * @param appKey
     */
    public static void init(android.app.Application application, String appKey) {
        RongIMClient.init(application, appKey);
    }

    /**
     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在Application继承类中调用。
     *
     * @param context
     */
    public static void init(android.content.Context context) {
        RongIMClient.init(context);
    }

    /**
     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在 Application 继承类中调用。
     *
     * @param context
     * @param appKey
     */
    public static void init(android.content.Context context, String appKey) {
        RongIMClient.init(context, appKey);
    }

    /**
     * 用于自定义消息的注册, 注册后方能正确识别自定义消息, 建议在init后及时注册，保证自定义消息到达时能正确解析。
     *
     * @param messageContentClass
     */
    public static void registerMessageType(Class<? extends MessageContent> messageContentClass) throws AnnotationNotFoundException {
        RongIMClient.registerMessageType(messageContentClass);
    }

    /**
     * 开发者可以通过设置监听，获取加入聊天室的状态回调 开发者调用 join 接口后，由于网络异常，加入失败后，sdk 会做重新加入，重新加入后回调此监听的方法通知结果 注意：回调时的线程并不是 UI 线程，请不要在回调中直接操作 UI
     *
     * @param listener
     */
    public static void setChatRoomActionListener(RongIMClient.ChatRoomActionListener listener) {
        RongIMClient.setChatRoomActionListener(listener);
    }

    /**
     * 设置连接状态变化的监听器。
     *
     * @param listener
     */
    public static void setConnectionStatusListener(RongIMClient.ConnectionStatusListener listener) {
        RongIMClient.setConnectionStatusListener(listener);
    }

    /**
     * 开启多 cmp 链接策略，开启后会启用新策略优化链接流程。
     *
     * @param enable
     */
    public static void setUserPolicy(boolean enable) {
        RongIMClient.setUserPolicy(enable);
    }

    /**
     * 设置输入状态监听器，当输入状态发生变化时，会回调RongIMClient.TypingStatusListener.onTypingStatusChanged(Conversation.ConversationType, String, Collection) 对于单聊而言，当对方正在输入时，监听会触发一次；当对方不处于输入状态时，该监听还会触发一次，但是回调里上来的输入用户列表为空
     *
     * @param listener
     */
    public static void setTypingStatusListener(RongIMClient.TypingStatusListener listener) {
        RongIMClient.setTypingStatusListener(listener);
    }

    /**
     * 设置撤回消息监听器
     *
     * @param listener
     */
    public static void setOnRecallMessageListener(RongIMClient.OnRecallMessageListener listener) {
        RongIMClient.setOnRecallMessageListener(listener);
    }

    /**
     * 设置接收消息事件的监听器。
     *
     * @param listener
     */
    public static void setOnReceiveMessageListener(RongIMClient.OnReceiveMessageListener listener) {
        RongIMClient.setOnReceiveMessageListener(listener);
    }

    /**
     * 设置连接服务器阶段的 Log 输出监听。
     *
     * @param listener
     */
    public static void setRCLogInfoListener(RongIMClient.RCLogInfoListener listener) {
        RongIMClient.setRCLogInfoListener(listener);
    }

    /**
     * 设置消息回执监听器，当收到消息回执时会回调其中的RongIMClient.ReadReceiptListener.onReadReceiptReceived(io.rong.imlib.model.Message)
     *
     * @param listener
     */
    public static void setReadReceiptListener(RongIMClient.ReadReceiptListener listener) {
        RongIMClient.setReadReceiptListener(listener);
    }

    /**
     * 已过时。
     *
     * @param listener
     */
    @Deprecated
    public static void setRecallMessageListener(RongIMClient.RecallMessageListener listener) {
        RongIMClient.setRecallMessageListener(listener);
    }

    /**
     * 设置私有部署的导航服务器和媒体服务器地址。
     *
     * @param naviServer
     * @param fileServer
     */
    public static void setServerInfo(String naviServer, String fileServer) {
        RongIMClient.setServerInfo(naviServer, fileServer);
    }

    /**
     * 配置数据上传地址 (非必须) 通过配置该地址，SDK 会在初始化时把设备相关信息上传到私有云节点。
     *
     * @param domain
     */
    public static void setStatisticDomain(String domain) {
        RongIMClient.setStatisticDomain(domain);
    }
}

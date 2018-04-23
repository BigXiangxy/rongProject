package org.weex.plugin.weex_rongLib_android;

import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.ChatRoomInfo;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.UserData;

/**
 * Created by QYG_XXY on 0022 2018/2/22.
 * 融云API 备份，不用于其他
 */

public interface __RongIMAPI__ {
    /**
     * 根据 discussionId 添加一名或者一组用户加入讨论组。
     *
     * @param discussionId
     * @param userIdList
     * @param callback
     */
    void addMemberToDiscussion(String discussionId, java.util.List<String> userIdList, RongIMClient.OperationCallback callback);

    /**
     * 添加位置共享监听。
     *
     * @param conversationType
     * @param targetId
     * @param listener
     */
    void addRealTimeLocationListener(Conversation.ConversationType conversationType, String targetId, RongIMClient.RealTimeLocationListener listener);

    /**
     * 将某个用户加到黑名单中。
     *
     * @param userId
     * @param callback
     */
    void addToBlacklist(String userId, RongIMClient.OperationCallback callback);

    /**
     * 取消多媒体消息下载。
     *
     * @param message
     * @param callback
     */
    void cancelDownloadMediaMessage(Message message, RongIMClient.OperationCallback callback);

    /**
     * 取消发送多媒体文件。
     *
     * @param message
     * @param callback
     */
    void cancelSendMediaMessage(Message message, RongIMClient.OperationCallback callback);

    /**
     * 此方法从服务器端清除历史消息，但是必须先开通历史消息云存储功能。
     *
     * @param conversationType
     * @param targetId
     * @param recordTime
     * @param callback
     */
    void cleanRemoteHistoryMessages(Conversation.ConversationType conversationType, String targetId, long recordTime, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     * 该方法已废弃，请使用 clearConversations(ResultCallback, Conversation.ConversationType...)
     *
     * @param conversationTypes
     * @return
     */
    boolean clearConversations(Conversation.ConversationType... conversationTypes);

    /**
     * 清空会话类型列表中的所有会话及会话信息，回调方式通知是否清空成功。
     *
     * @param callback
     * @param conversationTypes
     */
    void clearConversations(RongIMClient.ResultCallback callback, Conversation.ConversationType... conversationTypes);

    /**
     * 已过时。
     * 已废弃，建议使用 { #clearMessages(Conversation.ConversationType, String, ResultCallback)} 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    boolean clearMessages(Conversation.ConversationType conversationType, String targetId);

    /**
     * 清空指定类型，targetId 的某一会话所有聊天消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void clearMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 已过时。
     * 已废弃，建议使用 clearMessagesUnreadStatus(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    boolean clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId);

    /**
     * 根据时间戳清除指定类型，目标Id 的某一会话消息未读状态。
     *
     * @param conversationType
     * @param targetId
     * @param timestamp
     * @param callback
     */
    void clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId, long timestamp, RongIMClient.OperationCallback callback);

    /**
     * 清除指定类型，targetId 的某一会话消息未读状态。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 已过时。
     * 该方法已废弃，请使用 RongPushClient.clearAllNotifications(Context)
     */
    void clearNotifications();

    /**
     * 已过时。
     * 已废弃，建议使用 clearTextMessageDraft(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    boolean clearTextMessageDraft(Conversation.ConversationType conversationType, String targetId);

    /**
     * 根据消息类型，targetId 清除某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void clearTextMessageDraft(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 创建讨论组。
     *
     * @param name
     * @param userIdList
     * @param callback
     */
    void createDiscussion(String name, java.util.List<String> userIdList, RongIMClient.CreateDiscussionCallback callback);

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @param messages
     * @param callback
     */
    void deleteMessages(Conversation.ConversationType conversationType, String targetId, Message[] messages, RongIMClient.OperationCallback callback);

    /**
     * 清除指定会话的消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void deleteMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 已过时。
     * 已废弃，建议使用 { #deleteMessages(int[], ResultCallback)} 异步方法。
     *
     * @param messageIds
     * @return
     */
    boolean deleteMessages(int[] messageIds);

    /**
     * 根据 messageId，删除指定的一条或者一组消息。
     *
     * @param messageIds
     * @param callback
     */
    void deleteMessages(int[] messageIds, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 断开与融云服务器的连接。
     */
    void disconnect();

    /**
     * 已过时。
     * 该方法已废弃，请使用 disconnect() 或者 logout()
     *
     * @param isReceivePush
     */
    void disconnect(boolean isReceivePush);

    /**
     * 下载多媒体文件。
     *
     * @param conversationType
     * @param targetId
     * @param mediaType
     * @param imageUrl
     * @param callback
     */
    void downloadMedia(Conversation.ConversationType conversationType, String targetId, RongIMClient.MediaType mediaType, String imageUrl, RongIMClient.DownloadMediaCallback callback);

    /**
     * 下载文件。
     *
     * @param message
     * @param callback
     */
    void downloadMediaMessage(Message message, IRongCallback.IDownloadMediaMessageCallback callback);

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_SEPARATELY, 即人工机器人分开评价时,调用此方法对机器人客服进行评价
     *
     * @param kefuId
     * @param isRobotResolved
     * @param knowledgeId
     */
    void evaluateCustomService(String kefuId, boolean isRobotResolved, String knowledgeId);

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_UNIFIED, 即人工机器人统一评价时,调用此方法进行评价。
     *
     * @param kefuId
     * @param source
     * @param solveStatus
     * @param suggest
     * @param dialogId
     */
    void evaluateCustomService(String kefuId, int source, CustomServiceConfig.CSEvaSolveStatus solveStatus, String suggest, String dialogId);

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
    void evaluateCustomService(String kefuId, int source, CustomServiceConfig.CSEvaSolveStatus resolvestatus, String tagText, String suggest, String dialogId, String extra);

    /**
     * 当建立客服连接时,返回的 CustomServiceConfig.CSEvaType 为 CSEvaType.EVA_SEPARATELY, 即人工机器人分开评价时,调用此方法对人工客服进行评价
     *
     * @param kefuId
     * @param source
     * @param suggest
     * @param dialogId
     */
    void evaluateCustomService(String kefuId, int source, String suggest, String dialogId);

    /**
     * 获取当前用户设置的黑名单列表。
     *
     * @param callback
     */
    void getBlacklist(RongIMClient.GetBlacklistCallback callback);

    /**
     * 获取某用户是否在黑名单中。
     *
     * @param userId
     * @param callback
     */
    void getBlacklistStatus(String userId, RongIMClient.ResultCallback<RongIMClient.BlacklistStatus> callback);

    /**
     * 获取所有设置了消息免打扰的会话列表。
     *
     * @param callback
     * @param conversationTypes
     */
    void getBlockedConversationList(RongIMClient.ResultCallback<java.util.List<Conversation>> callback, Conversation.ConversationType... conversationTypes);

    /**
     * 获取聊天室历史消息记录。
     *
     * @param targetId
     * @param recordTime
     * @param count
     * @param order
     * @param callback
     */
    void getChatroomHistoryMessages(String targetId, long recordTime, int count, RongIMClient.TimestampOrder order, IRongCallback.IChatRoomHistoryMessageCallback callback);

    /**
     * 查询聊天室信息。
     *
     * @param chatRoomId
     * @param defMemberCount
     * @param order
     * @param callback
     */
    void getChatRoomInfo(String chatRoomId, int defMemberCount, ChatRoomInfo.ChatRoomMemberOrder order, RongIMClient.ResultCallback<ChatRoomInfo> callback);

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    Conversation getConversation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 根据不同会话类型的目标 Id，回调方式获取某一会话信息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void getConversation(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Conversation> callback);

    /**
     * 已过时。
     * 该方法废弃
     * 请使用getConversationList(ResultCallback)
     * 或getConversationList(ResultCallback, Conversation.ConversationType...)
     *
     * @return
     */
    java.util.List<Conversation> getConversationList();

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
    java.util.List<Conversation> getConversationList(Conversation.ConversationType... types);

    /**
     * 获取当前用户本地会话列表的默认方法，该方法返回的是以下类型的会话列表：私聊，群组，讨论组，系统会话。
     *
     * @param callback
     */
    void getConversationList(RongIMClient.ResultCallback<java.util.List<Conversation>> callback);

    /**
     * 根据会话类型，获取当前用户的本地会话列表。
     *
     * @param callback
     * @param conversationTypes
     */
    void getConversationList(RongIMClient.ResultCallback<java.util.List<Conversation>> callback, Conversation.ConversationType... conversationTypes);

    /**
     * 分页获取会话列表 注意：当更换设备或者清除缓存后，能拉取到暂存在融云服务器中该账号当天收发过消息的会话。
     *
     * @param callback
     * @param timeStamp
     * @param count
     * @param conversationTypes
     */
    void getConversationListByPage(RongIMClient.ResultCallback<java.util.List<Conversation>> callback, long timeStamp, int count, Conversation.ConversationType... conversationTypes);

    /**
     * 获取会话消息提醒状态。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void getConversationNotificationStatus(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> callback);

    /**
     * 获取当前服务器连接状态。
     *
     * @return
     */
    RongIMClient.ConnectionStatusListener.ConnectionStatus getCurrentConnectionStatus();

    /**
     * 获取当前连接用户的信息。
     *
     * @return
     */
    String getCurrentUserId();

    /**
     * 获取本地时间与服务器时间的差值。
     *
     * @return
     */
    long getDeltaTime();

    /**
     * 根据消息类型，targetId 获取讨论组信息和设置。
     *
     * @param discussionId
     * @param callback
     */
    void getDiscussion(String discussionId, RongIMClient.ResultCallback<Discussion> callback);

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
    java.util.List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String targetId, int oldestMessageId, int count);

    /**
     * 获取指定类型，targetId 的N条历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param oldestMessageId
     * @param count
     * @param callback
     */
    void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, int oldestMessageId, int count, RongIMClient.ResultCallback<java.util.List<Message>> callback);

    /**
     * 根据会话类型的目标 Id，回调方式获取某些消息类型的某条消息之前或之后的N条历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param objectNames
     * @param timestamp
     * @param count
     * @param direction
     * @param callback
     */
    void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, java.util.List<String> objectNames, long timestamp, int count, io.rong.imlib.RongCommonDefine.GetMessageDirection direction, RongIMClient.ResultCallback<java.util.List<Message>> callback);

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
    void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, long sentTime, int before, int after, RongIMClient.ResultCallback<java.util.List<Message>> resultCallback);

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
    java.util.List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int oldestMessageId, int count);

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
    void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int baseMessageId, int count, io.rong.imlib.RongCommonDefine.GetMessageDirection direction, RongIMClient.ResultCallback<java.util.List<Message>> callback);

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
    void getHistoryMessages(Conversation.ConversationType conversationType, String targetId, String objectName, int oldestMessageId, int count, RongIMClient.ResultCallback<java.util.List<Message>> callback);


    /**
     * 已过时。
     * 已废弃，建议使用 getLatestMessages(Conversation.ConversationType, String, int, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param count
     * @return
     */
    java.util.List<Message> getLatestMessages(Conversation.ConversationType conversationType, String targetId, int count);

    /**
     * 获取指定类型，targetId 的最新消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param count
     * @param callback
     */
    void getLatestMessages(Conversation.ConversationType conversationType, String targetId, int count, RongIMClient.ResultCallback<java.util.List<Message>> callback);

    /**
     * 根据 message id 获取消息体。
     *
     * @param messageId
     * @param callback
     */
    void getMessage(int messageId, RongIMClient.ResultCallback<Message> callback);

    /**
     * 根据 uid 获取 message 对象
     *
     * @param uid
     * @param callback
     */
    void getMessageByUid(String uid, RongIMClient.ResultCallback callback);

    /**
     * 获取消息通知免打扰时间。
     *
     * @param callback
     */
    void getNotificationQuietHours(RongIMClient.GetNotificationQuietHoursCallback callback);

    /**
     * 获取当前用户离线消息的存储时间，取值范围为int值1~7天
     *
     * @param callback
     */
    void getOfflineMessageDuration(RongIMClient.ResultCallback<String> callback);

    /**
     * 获取己关注公共账号列表。
     *
     * @param callback
     */
    void getPublicServiceList(RongIMClient.ResultCallback<PublicServiceProfileList> callback);

    /**
     * 获取某公共服务信息。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    void getPublicServiceProfile(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.ResultCallback<PublicServiceProfile> callback);

    /**
     * 获取是否显示 Push 内容详情的设置
     *
     * @param callback
     */
    void getPushContentShowStatus(RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 获取 RealTimeLocation 实例，每发起一次位置共享业务，就要获取一个实例。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode getRealTimeLocation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 获取位置共享状态。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationStatus getRealTimeLocationCurrentState(Conversation.ConversationType conversationType, String targetId);

    /**
     * 获取参与该位置共享的所有成员。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    java.util.List<String> getRealTimeLocationParticipants(Conversation.ConversationType conversationType, String targetId);

    /**
     * 获取融云服务器中暂存，特定类型，targetId 的N条（一次不超过40条）历史消息记录。
     *
     * @param conversationType
     * @param targetId
     * @param dateTime
     * @param count
     * @param callback
     */
    void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String targetId, long dateTime, int count, RongIMClient.ResultCallback<java.util.List<Message>> callback);

    /**
     * 根据 messageId 获取消息发送时间 Message.sentTime
     *
     * @param messageId
     * @return
     */
    long getSendTimeByMessageId(int messageId);

    /**
     * 已过时。
     * 已废弃，建议使用 getTextMessageDraft(Conversation.ConversationType, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    String getTextMessageDraft(Conversation.ConversationType conversationType, String targetId);

    /**
     * 根据消息类型，targetId 获取某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void getTextMessageDraft(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<String> callback);

    /**
     * 已过时。
     *
     * @return
     */
    int getTotalUnreadCount();

    /**
     * 通过回调方式，获取所有未读消息数。
     *
     * @param callback
     */
    void getTotalUnreadCount(RongIMClient.ResultCallback<Integer> callback);

    /**
     * 通过回调方式，获取所有指定会话的未读消息数（聊天室除外）。
     *
     * @param callback
     * @param conversations
     */
    void getTotalUnreadCount(RongIMClient.ResultCallback<Integer> callback, Conversation... conversations);

    /**
     * 根据conversationType和targetId获取当前会话正在输入的用户列表
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    java.util.Collection<io.rong.imlib.TypingMessage.TypingStatus> getTypingUserListFromConversation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 已过时。
     *
     * @param conversationTypes
     * @return
     */
    int getUnreadCount(Conversation.ConversationType... conversationTypes);

    /**
     * 根据会话类型数组，回调方式获取某会话类型的未读消息数。
     *
     * @param conversationTypes
     * @param callback
     */
    void getUnreadCount(Conversation.ConversationType[] conversationTypes, RongIMClient.ResultCallback<Integer> callback);

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    int getUnreadCount(Conversation.ConversationType conversationType, String targetId);

    /**
     * 根据会话类型的目标 Id，回调方式获取来自某用户（某会话）的未读消息数。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void getUnreadCount(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Integer> callback);

    /**
     * 回调方式获取某会话类型的未读消息数。
     *
     * @param callback
     * @param conversationTypes
     */
    void getUnreadCount(RongIMClient.ResultCallback<Integer> callback, Conversation.ConversationType... conversationTypes);

    /**
     * 获取某会话里未读的@消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void getUnreadMentionedMessages(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<java.util.List<Message>> callback);

    /**
     * 已过时。
     *
     * @param userId
     * @param callback
     */
    void getUserOnlineStatus(String userId, IRongCallback.IGetUserOnlineStatusCallback callback);

    /**
     * 获取登录者身份认证信息。
     *
     * @param resultCallback
     */
    void getVendorToken(RongIMClient.ResultCallback<String> resultCallback);

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
    void insertIncomingMessage(Conversation.ConversationType type, String targetId, String senderUserId, Message.ReceivedStatus receivedStatus, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback);

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
    void insertIncomingMessage(Conversation.ConversationType type, String targetId, String senderUserId, Message.ReceivedStatus receivedStatus, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback);

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
    Message insertMessage(Conversation.ConversationType type, String targetId, String senderUserId, MessageContent content);

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
    void insertMessage(Conversation.ConversationType type, String targetId, String senderUserId, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback);

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
    void insertMessage(Conversation.ConversationType conversationType, String targetId, String senderUserId, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback);

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
    void insertOutgoingMessage(Conversation.ConversationType type, String targetId, Message.SentStatus sentStatus, MessageContent content, long sentTime, RongIMClient.ResultCallback<Message> resultCallback);

    /**
     * 向本地会话中插入一条消息。
     *
     * @param type
     * @param targetId
     * @param sentStatus
     * @param content
     * @param resultCallback
     */
    void insertOutgoingMessage(Conversation.ConversationType type, String targetId, Message.SentStatus sentStatus, MessageContent content, RongIMClient.ResultCallback<Message> resultCallback);

    /**
     * 加入聊天室。
     *
     * @param chatRoomId
     * @param defMessageCount
     * @param callback
     */
    void joinChatRoom(String chatRoomId, int defMessageCount, RongIMClient.OperationCallback callback);

    /**
     * 加入已存在的聊天室。
     *
     * @param chatRoomId
     * @param defMessageCount
     * @param callback
     */
    void joinExistChatRoom(String chatRoomId, int defMessageCount, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     * 已废弃。请参考群组 http://www.rongcloud.cn/docs/android.html#3、群组 和 href="http://support.rongcloud.cn/kb/MzY5" 使用说明。
     *
     * @param groupId
     * @param groupName
     * @param callback
     */
    void joinGroup(String groupId, String groupName, RongIMClient.OperationCallback callback);

    /**
     * 加入位置共享。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode joinRealTimeLocation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 发送留言消息给客服。
     *
     * @param kefuId
     * @param contentMap
     * @param operationCallback
     */
    void leaveMessageCustomService(String kefuId, java.util.Map<String, String> contentMap, RongIMClient.OperationCallback operationCallback);

    /**
     * 断开与融云服务器的连接，并且不再接收 Push 消息。
     */
    void logout();

    /**
     * 退出聊天室。
     *
     * @param chatRoomId
     * @param callback
     */
    void quitChatRoom(String chatRoomId, RongIMClient.OperationCallback callback);

    /**
     * 根据discussionId 退出当前用户所在的某讨论组。
     *
     * @param discussionId
     * @param callback
     */
    void quitDiscussion(String discussionId, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     * 已废弃，请参考群组 href="http://www.rongcloud.cn/docs/android.html#3、群组 和 href="http://support.rongcloud.cn/kb/MzY5" 使用说明。
     *
     * @param groupId
     * @param callback
     */
    void quitGroup(String groupId, RongIMClient.OperationCallback callback);

    /**
     * 退出位置共享。
     *
     * @param conversationType
     * @param targetId
     */
    void quitRealTimeLocation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 撤回消息
     *
     * @param message
     * @param pushContent
     * @param callback
     */
    void recallMessage(Message message, String pushContent, RongIMClient.ResultCallback<io.rong.message.RecallNotificationMessage> callback);

    /**
     * 已过时。
     * 请使用 connect(String, ConnectCallback) 方法
     *
     * @param callback
     */
    void reconnect(RongIMClient.ConnectCallback callback);

    /**
     * 已过时。
     * 该方法已废弃，请使用 RongPushClient.recordNotificationEvent(String)
     *
     * @return
     */
    void recordNotificationEvent(String pushId);

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    boolean removeConversation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 从会话列表中移除某一会话，但是不删除会话内的消息。
     *
     * @param conversationType
     * @param targetId
     * @param callback
     */
    void removeConversation(Conversation.ConversationType conversationType, String targetId, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 将个某用户从黑名单中移出。
     *
     * @param userId
     * @param callback
     */
    void removeFromBlacklist(String userId, RongIMClient.OperationCallback callback);

    /**
     * 供创建者将某用户移出讨论组。
     *
     * @param discussionId
     * @param userId
     * @param callback
     */
    void removeMemberFromDiscussion(String discussionId, String userId, RongIMClient.OperationCallback callback);

    /**
     * 移除消息通知免打扰时间。
     *
     * @param callback
     */
    void removeNotificationQuietHours(RongIMClient.OperationCallback callback);

    /**
     * @param conversationType
     * @param targetId
     */
    void removeRealTimeLocationObserver(Conversation.ConversationType conversationType, String targetId);

    /**
     * 已过时。
     * 已废弃，建议使用 saveTextMessageDraft(Conversation.ConversationType, String, String, ResultCallback) 异步方法。
     *
     * @param conversationType
     * @param targetId
     * @param content
     * @return
     */
    boolean saveTextMessageDraft(Conversation.ConversationType conversationType, String targetId, String content);

    /**
     * 根据消息类型，targetId 保存某一会话的文字消息草稿。
     *
     * @param conversationType
     * @param targetId
     * @param content
     * @param callback
     */
    void saveTextMessageDraft(Conversation.ConversationType conversationType, String targetId, String content, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 搜索本地历史消息。
     *
     * @param keyword
     * @param conversationTypes
     * @param objectNames
     * @param resultCallback
     */
    void searchConversations(String keyword, Conversation.ConversationType[] conversationTypes, String[] objectNames, RongIMClient.ResultCallback<java.util.List<io.rong.imlib.model.SearchConversationResult>> resultCallback);

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
    void searchMessages(Conversation.ConversationType conversationType, String targetId, String keyword, int count, long beginTime, RongIMClient.ResultCallback<java.util.List<Message>> resultCallback);

    /**
     * 搜索公众服务。
     *
     * @param searchType
     * @param keywords
     * @param callback
     */
    void searchPublicService(RongIMClient.SearchType searchType, String keywords, RongIMClient.ResultCallback<PublicServiceProfileList> callback);

    /**
     * 按公众服务类型搜索公众服务。
     *
     * @param publicServiceType
     * @param searchType
     * @param keywords
     * @param callback
     */
    void searchPublicServiceByType(Conversation.PublicServiceType publicServiceType, RongIMClient.SearchType searchType, String keywords, RongIMClient.ResultCallback<PublicServiceProfileList> callback);

    /**
     * 根据客服ID和分组ID转换人工模式
     *
     * @param kefuId
     * @param groupId
     */
    void selectCustomServiceGroup(String kefuId, String groupId);

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
    void sendDirectionalMessage(Conversation.ConversationType type, String targetId, MessageContent content, String[] userIds, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback);

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
    void sendImageMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendImageMessageCallback callback);

    /**
     * 发送图片消息
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageCallback callback);

    /**
     * 发送图片消息，可以使用该方法将图片上传到自己的服务器发送，同时更新图片状态。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageWithUploadListenerCallback callback);

    /**
     * 发送地理位置消息。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param sendMessageCallback
     */
    void sendLocationMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMessageCallback sendMessageCallback);

    /**
     * 发送多媒体消息 发送前构造 Message 消息实体
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallback callback);

    /**
     * 发送多媒体消息，可以使用该方法将多媒体文件上传到自己的服务器。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallbackWithUploader callback);

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
    void sendMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback);

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
    Message sendMessage(Conversation.ConversationType type, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendMessageCallback callback);

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
    void sendMessage(Conversation.ConversationType conversationType, String targetId, MessageContent content, String pushContent, String pushData, RongIMClient.SendMessageCallback callback, RongIMClient.ResultCallback<Message> resultCallback);

    /**
     * 发送消息。
     *
     * @param message
     * @param pushContent
     * @param pushData
     * @param callback
     */
    void sendMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMessageCallback callback);

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
    Message sendMessage(Message message, String pushContent, String pushData, RongIMClient.SendMessageCallback callback);

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
    void sendMessage(Message message, String pushContent, String pushData, RongIMClient.SendMessageCallback callback, RongIMClient.ResultCallback<Message> resultCallback);

    /**
     * 发送某个会话中的消息阅读回执
     *
     * @param conversationType
     * @param targetId
     * @param timestamp
     */
    void sendReadReceiptMessage(Conversation.ConversationType conversationType, String targetId, long timestamp);

    /**
     * 发起群组消息回执请求。
     *
     * @param message
     * @param callback
     */
    void sendReadReceiptRequest(Message message, RongIMClient.OperationCallback callback);

    /**
     * 发送群消息已读回执
     *
     * @param type
     * @param targetId
     * @param messageList
     * @param callback
     */
    void sendReadReceiptResponse(Conversation.ConversationType type, String targetId, java.util.List<Message> messageList, RongIMClient.OperationCallback callback);

    /**
     * 向会话中发送正在输入的状态
     *
     * @param conversationType
     * @param targetId
     * @param typingContentType
     */
    void sendTypingStatus(Conversation.ConversationType conversationType, String targetId, String typingContentType);

    /**
     * 设置集成 sdk 的用户 App 版本信息。
     *
     * @param appVer
     */
    void setAppVer(String appVer);

    /**
     * 设置会话消息提醒状态。
     *
     * @param conversationType
     * @param targetId
     * @param notificationStatus
     * @param callback
     */
    void setConversationNotificationStatus(Conversation.ConversationType conversationType, String targetId, Conversation.ConversationNotificationStatus notificationStatus, RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> callback);

    /**
     * 已过时。
     *
     * @param conversationType
     * @param targetId
     * @param isTop
     * @return
     */
    boolean setConversationToTop(Conversation.ConversationType conversationType, String targetId, boolean isTop);

    /**
     * 设置某一会话为置顶或者取消置顶，回调方式获取设置是否成功。
     *
     * @param conversationType
     * @param id
     * @param isTop
     * @param callback
     */
    void setConversationToTop(Conversation.ConversationType conversationType, String id, boolean isTop, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 设置人工评价监听 当人工评价有标签等配置时，在回调中返回配置
     *
     * @param listener
     */
    void setCustomServiceHumanEvaluateListener(io.rong.imlib.cs.CustomServiceManager.OnHumanEvaluateListener listener);

    /**
     * 设置讨论组成员邀请权限。
     *
     * @param discussionId
     * @param status
     * @param callback
     */
    void setDiscussionInviteStatus(String discussionId, RongIMClient.DiscussionInviteStatus status, RongIMClient.OperationCallback callback);

    /**
     * 根据 discussionId 设置讨论组名称。
     *
     * @param discussionId
     * @param name
     * @param callback
     */
    void setDiscussionName(String discussionId, String name, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageExtra(int, String, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param value
     * @return
     */
    boolean setMessageExtra(int messageId, String value);

    /**
     * 根据 messageId 设置本地消息的附加信息，用于扩展消息的使用场景。
     *
     * @param messageId
     * @param value
     * @param callback
     */
    void setMessageExtra(int messageId, String value, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageReceivedStatus(int, Message.ReceivedStatus, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param receivedStatus
     * @return
     */
    boolean setMessageReceivedStatus(int messageId, Message.ReceivedStatus receivedStatus);

    /**
     * 根据 messageId 设置接收到的消息状态。
     *
     * @param messageId
     * @param receivedStatus
     * @param callback
     */
    void setMessageReceivedStatus(int messageId, Message.ReceivedStatus receivedStatus, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 已过时。
     * 已废弃，建议使用 setMessageSentStatus(int, Message.SentStatus, ResultCallback) 异步方法。
     *
     * @param messageId
     * @param sentStatus
     * @return
     */
    boolean setMessageSentStatus(int messageId, Message.SentStatus sentStatus);

    /**
     * 根据 messageId 设置消息的发送状态。
     *
     * @param messageId
     * @param sentStatus
     * @param callback
     */
    void setMessageSentStatus(int messageId, Message.SentStatus sentStatus, RongIMClient.ResultCallback<Boolean> callback);

    /**
     * 设置消息通知免打扰时间。
     *
     * @param startTime
     * @param spanMinutes
     * @param callback
     */
    void setNotificationQuietHours(String startTime, int spanMinutes, RongIMClient.OperationCallback callback);

    /**
     * 设置当前用户离线消息存储时间
     *
     * @param duration
     * @param callback
     */
    void setOfflineMessageDuration(int duration, RongIMClient.ResultCallback<Long> callback);


    /**
     * 设置是否显示 Push 内容详情
     *
     * @param showStatus
     * @param callback
     */
    void setPushContentShowStatus(boolean showStatus, RongIMClient.OperationCallback callback);


    /**
     * 已过时。
     *
     * @param callback
     */
    void setSubscribeStatusListener(IRongCallback.ISetSubscribeStatusCallback callback);

    /**
     * 设置多端同步会话阅读数监听
     *
     * @param listener
     */
    void setSyncConversationReadStatusListener(RongIMClient.SyncConversationReadStatusListener listener);

    /**
     * 已过时。
     *
     * @param status
     * @param callback
     */
    void setUserOnlineStatus(int status, IRongCallback.ISetUserOnlineStatusCallback callback);


    /**
     * 启动客服服务
     *
     * @param kefuId
     * @param listener
     * @param customServiceInfo
     */
    void startCustomService(String kefuId, io.rong.imlib.ICustomServiceListener listener, CSCustomServiceInfo customServiceInfo);

    /**
     * 发起位置共享。
     *
     * @param conversationType
     * @param targetId
     * @return
     */
    io.rong.imlib.location.RealTimeLocationConstant.RealTimeLocationErrorCode startRealTimeLocation(Conversation.ConversationType conversationType, String targetId);

    /**
     * 结束客服.
     *
     * @param kefuId
     */
    void stopCustomService(String kefuId);

    /**
     * 订阅公众号。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    void subscribePublicService(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     *
     * @param userIdList
     */
    void subscribeUserOnlineStatus(java.util.List<String> userIdList);

    /**
     * 切换 appKey.
     *
     * @param appKey
     */
    void switchAppKey(String appKey);

    /**
     * 切换到人工客服模式,切换的结果需要在 ICustomServiceListener.onModeChanged(CustomServiceMode) 方法回调中处理 如果客服没有分组, 则直接切人工模式;如果客服有分组,那么需要在回调ICustomServiceListener.onSelectGroup(List) 中去弹出分组选择窗口并选择分组,之后在这个回调中调用 @seeselectCustomServiceGroup(String, String) 根据客服 Id 和 分组 Id 去切换到人工模式 客服模式 分为无服务,机器人模式,人工模式,机器人优先模式,人工优先模式
     *
     * @param kefuId
     */
    void switchToHumanMode(String kefuId);

    /**
     * 多端登录时，通知其它终端清除某个会话的未读消息数
     *
     * @param type
     * @param targetId
     * @param timestamp
     * @param callback
     */
    void syncConversationReadStatus(Conversation.ConversationType type, String targetId, long timestamp, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     * 已废弃。请参考 http://www.rongcloud.cn/docs/android.html#3、群组， http://support.rongcloud.cn/kb/MzY5 文档中的使用说明。
     *
     * @param groups
     * @param callback
     */
    void syncGroup(java.util.List<Group> groups, RongIMClient.OperationCallback callback);

    /**
     * 已过时。
     *
     * @param userData
     * @param callback
     */
    void syncUserData(UserData userData, RongIMClient.OperationCallback callback);

    /**
     * 取消订阅公众号。
     *
     * @param publicServiceType
     * @param publicServiceId
     * @param callback
     */
    void unsubscribePublicService(Conversation.PublicServiceType publicServiceType, String publicServiceId, RongIMClient.OperationCallback callback);

    /**
     * 更新会话信息。
     *
     * @param conversationType
     * @param targetId
     * @param title
     * @param portrait
     * @param callback
     */
    void updateConversationInfo(Conversation.ConversationType conversationType, String targetId, String title, String portrait, RongIMClient.ResultCallback callback);

    /**
     * 使用者调用此方法更新坐标位置。
     *
     * @param conversationType
     * @param targetId
     * @param latitude
     * @param longitude
     */
    void updateRealTimeLocationStatus(Conversation.ConversationType conversationType, String targetId, double latitude, double longitude);

    /**
     * 已过时。
     *
     * @param msg
     */
    void writeDebugFile(String msg);

    /**
     * 已过时。
     *
     * @param msg
     */
    void writeLogFile(String msg);

//    /**
//     * 连接服务器，在整个应用程序全局，只需要调用一次，需在 init(Context) 之后调用。
//     *
//     * @param token
//     * @param org.weex.plugin.callback
//     * @return
//     */
//    static RongIMClient connect(String token, RongIMClient.ConnectCallback org.weex.plugin.callback);
//
//
//    /**
//     * 获取 IMLib 接口类实例，需在执行 init 方法初始化 SDK 后获取, 否则返回值为 NULL。
//     *
//     * @return
//     */
//    static RongIMClient getInstance()
//
//    /**
//     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在 Application 继承类中调用。
//     *
//     * @param application
//     * @param appKey
//     */
//    static void init(android.app.Application application, String appKey);
//
//    /**
//     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在Application继承类中调用。
//     *
//     * @param context
//     */
//    static void init(android.content.Context context)
//
//    /**
//     * 初始化 SDK，在整个应用程序全局只需要调用一次, 建议在 Application 继承类中调用。
//     *
//     * @param context
//     * @param appKey
//     */
//    static void init(android.content.Context context, String appKey);
//
//    /**
//     * 用于自定义消息的注册, 注册后方能正确识别自定义消息, 建议在init后及时注册，保证自定义消息到达时能正确解析。
//     *
//     * @param messageContentClass
//     */
//    static void registerMessageType(Class<? extends MessageContent> messageContentClass);
//
//    /**
//     * 开发者可以通过设置监听，获取加入聊天室的状态回调 开发者调用 join 接口后，由于网络异常，加入失败后，sdk 会做重新加入，重新加入后回调此监听的方法通知结果 注意：回调时的线程并不是 UI 线程，请不要在回调中直接操作 UI
//     *
//     * @param listener
//     */
//    static void setChatRoomActionListener(RongIMClient.ChatRoomActionListener listener);
//
//    /**
//     * 设置连接状态变化的监听器。
//     *
//     * @param listener
//     */
//    static void setConnectionStatusListener(RongIMClient.ConnectionStatusListener listener);
//
//    /**
//     * 开启多 cmp 链接策略，开启后会启用新策略优化链接流程。
//     *
//     * @param enable
//     */
//    static void setUserPolicy(boolean enable);
//
//    /**
//     * 设置输入状态监听器，当输入状态发生变化时，会回调RongIMClient.TypingStatusListener.onTypingStatusChanged(Conversation.ConversationType, String, Collection) 对于单聊而言，当对方正在输入时，监听会触发一次；当对方不处于输入状态时，该监听还会触发一次，但是回调里上来的输入用户列表为空
//     *
//     * @param listener
//     */
//    static void setTypingStatusListener(RongIMClient.TypingStatusListener listener);
//
//    /**
//     * 设置撤回消息监听器
//     *
//     * @param listener
//     */
//    static void setOnRecallMessageListener(RongIMClient.OnRecallMessageListener listener);
//
//    /**
//     * 设置接收消息事件的监听器。
//     *
//     * @param listener
//     */
//    static void setOnReceiveMessageListener(RongIMClient.OnReceiveMessageListener listener);
//
//    /**
//     * 设置连接服务器阶段的 Log 输出监听。
//     *
//     * @param listener
//     */
//    static void setRCLogInfoListener(RongIMClient.RCLogInfoListener listener);
//
//    /**
//     * 设置消息回执监听器，当收到消息回执时会回调其中的RongIMClient.ReadReceiptListener.onReadReceiptReceived(io.rong.imlib.model.Message)
//     *
//     * @param listener
//     */
//    static void setReadReceiptListener(RongIMClient.ReadReceiptListener listener);
//
//    /**
//     * 已过时。
//     *
//     * @param listener
//     */
//    static void setRecallMessageListener(RongIMClient.RecallMessageListener listener);
//
//    /**
//     * 设置私有部署的导航服务器和媒体服务器地址。
//     *
//     * @param naviServer
//     * @param fileServer
//     */
//    static void setServerInfo(String naviServer, String fileServer);
//
//    /**
//     * 配置数据上传地址 (非必须) 通过配置该地址，SDK 会在初始化时把设备相关信息上传到私有云节点。
//     *
//     * @param domain
//     */
//    static void setStatisticDomain(String domain);
}

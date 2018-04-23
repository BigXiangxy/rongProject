package org.weex.plugin.weex_rongLib_android;

import android.content.Context;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import org.weex.plugin.weex_rongLib_android.callback.WeexConnectCallback;
import org.weex.plugin.weex_rongLib_android.callback.WeexResultCallback;

import java.util.List;

import io.rong.imlib.model.Message;

/**
 * Module 扩展的方法可以使用 int, double, float, String, Map, List 类型的参数
 */
@WeexModule(name = "rongLib")
public class RongLibModule extends WXModule {
    /**
     * 融云初始化（尽早调用，最好在Application中初始化）。注意：已经由原生调用，js不需要调用
     */
    @JSMethod(uiThread = true)
    public void init() {
        Context context = mWXSDKInstance.getContext();
        if (context == null) return;
        if (context.getApplicationInfo().packageName.equals(RongUtils.getCurProcessName(context)) ||
                "io.rong.push".equals(RongUtils.getCurProcessName(context))) {
            WeexRongIMClient.init(context);
        }
    }

    /**
     * 根据 discussionId 添加一名或者一组用户加入讨论组。
     *
     * @param discussionId 讨论组ID
     * @param userIdList   一组用户的ID
     * @param callback     回调
     */
    @JSMethod
    public void addMemberToDiscussion(String discussionId, List<String> userIdList, JSCallback callback) {
        WeexRongIMClient.addMemberToDiscussion(discussionId, userIdList, callback);
    }

    /**
     * 将某个用户加到黑名单中。
     *
     * @param userId
     * @param callback
     */
    @JSMethod
    public void addToBlacklist(String userId, JSCallback callback) {
        WeexRongIMClient.addToBlacklist(userId, callback);
    }


    /**
     * 此方法从服务器端清除历史消息，但是必须先开通历史消息云存储功能。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param recordTime       时间
     * @param callback
     */
    @JSMethod
    public void cleanRemoteHistoryMessages(int conversationType, String targetId, long recordTime, JSCallback callback) {
        WeexRongIMClient.cleanRemoteHistoryMessages(conversationType, targetId, recordTime, callback);
    }


    /**
     * 清空会话类型列表中的所有会话及会话信息，回调方式通知是否清空成功。
     *
     * @param conversationType 会话类型
     * @param callback
     */
    @JSMethod
    public void clearConversations(int conversationType, JSCallback callback) {
        WeexRongIMClient.clearConversations(callback, conversationType);
    }

    /**
     * 清空指定类型，targetId 的某一会话所有聊天消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param jsCallback
     */
    @JSMethod
    public void clearMessages(int conversationType, String targetId, JSCallback jsCallback) {
        WeexRongIMClient.clearMessages(conversationType, targetId, jsCallback);
    }

    /**
     * 根据时间戳清除指定类型，目标Id 的某一会话消息未读状态。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param timestamp        时间戳
     * @param callback
     */
    @JSMethod
    public void clearMessagesUnreadStatus(int conversationType, String targetId, long timestamp, JSCallback callback) {
        WeexRongIMClient.clearMessagesUnreadStatus(conversationType, targetId, timestamp, callback);
    }

    /**
     * 清除指定类型，targetId 的某一会话消息未读状态。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void clearMessagesUnreadStatus(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.clearMessagesUnreadStatus(conversationType, targetId, callback);
    }

    /**
     * 根据消息类型，targetId 清除某一会话的文字消息草稿。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void clearTextMessageDraft(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.clearTextMessageDraft(conversationType, targetId, callback);
    }

    /**
     * 创建讨论组。
     *
     * @param name       名称
     * @param userIdList 用户列表
     * @param callback
     */
    @JSMethod
    public void createDiscussion(String name, List<String> userIdList, JSCallback callback) {
        WeexRongIMClient.createDiscussion(name, userIdList, callback);
    }


    /**
     * 清除指定会话的消息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void deleteMessages(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.deleteMessages(conversationType, targetId, callback);
    }

    /**
     * 根据 messageId，删除指定的一条或者一组消息。
     *
     * @param messageIds 消息ID列表
     * @param callback
     */
    @JSMethod
    public void deleteMessages(int[] messageIds, JSCallback callback) {
        WeexRongIMClient.deleteMessages(messageIds, callback);
    }

    /**
     * 断开与融云服务器的连接。
     */
    @JSMethod
    public void disconnect() {
        WeexRongIMClient.disconnect();
    }

    /**
     * 获取当前用户设置的黑名单列表。
     *
     * @param callback
     */
    @JSMethod
    public void getBlacklist(JSCallback callback) {
        WeexRongIMClient.getBlacklist(callback);
    }

    /**
     * 获取某用户是否在黑名单中。
     *
     * @param userId   用户ID
     * @param callback
     */
    @JSMethod
    public void getBlacklistStatus(String userId, JSCallback callback) {
        WeexRongIMClient.getBlacklistStatus(userId, callback);
    }

//    /**
//     * 获取所有设置了消息免打扰的会话列表。
//     *
//     * @param org.weex.plugin.callback
//     * @param conversationTypes
//     */
//    @JSMethod
//    public void getBlockedConversationList(RongIMClient.ResultCallback<List<Conversation>> org.weex.plugin.callback, Conversation.ConversationType... conversationTypes) {
//        WeexRongIMClient.getBlockedConversationList(org.weex.plugin.callback, conversationTypes);
//    }

    /**
     * 根据不同会话类型的目标 Id，回调方式获取某一会话信息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void getConversation(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.getConversation(conversationType, targetId, callback);
    }

    /**
     * 获取当前用户本地会话列表的默认方法，该方法返回的是以下类型的会话列表：私聊，群组，讨论组，系统会话。
     *
     * @param callback
     */
    @JSMethod
    public void getConversationList(JSCallback callback) {
        WeexRongIMClient.getConversationList(callback);
    }

    /**
     * 根据会话类型，获取当前用户的本地会话列表。
     *
     * @param conversationTypes 会话类型
     * @param callback
     */
    @JSMethod
    public void getConversationList(int[] conversationTypes, JSCallback callback) {
        WeexRongIMClient.getConversationList(callback, conversationTypes);
    }

    /**
     * 分页获取会话列表 注意：当更换设备或者清除缓存后，能拉取到暂存在融云服务器中该账号当天收发过消息的会话。
     *
     * @param timeStamp         时间戳
     * @param count             ？？？？
     * @param conversationTypes 会话类型列表
     * @param callback
     */
    @JSMethod
    public void getConversationListByPage(long timeStamp, int count, int[] conversationTypes, JSCallback callback) {
        WeexRongIMClient.getConversationListByPage(callback, timeStamp, count, conversationTypes);
    }

    /**
     * 获取会话消息提醒状态。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param callback
     */
    @JSMethod
    public void getConversationNotificationStatus(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.getConversationNotificationStatus(conversationType, targetId, callback);
    }

    /**
     * 获取当前服务器连接状态。
     * 参考融云 ：RongIMClient.ConnectionStatusListener.ConnectionStatus
     *
     * @return
     */
    @JSMethod(uiThread = false)
    public BaseCallBackBean<Integer> getCurrentConnectionStatus(JSCallback callback) {
        BaseCallBackBean<Integer> callBackBean = new BaseCallBackBean<>();
        int status = WeexRongIMClient.getCurrentConnectionStatus().getValue();
        callBackBean.setData(status);
        callback.invokeAndKeepAlive(callBackBean);
        return callBackBean;
    }

    /**
     * 获取当前连接用户的信息。
     *
     * @return
     */
    @JSMethod(uiThread = false)
    public BaseCallBackBean<String> getCurrentUserId(JSCallback callback) {
        BaseCallBackBean<String> callBackBean = new BaseCallBackBean<>();
        String userId = WeexRongIMClient.getCurrentUserId();
        callBackBean.setData(userId);
        callback.invokeAndKeepAlive(callBackBean);
        return callBackBean;
    }

    /**
     * 获取本地时间与服务器时间的差值。
     *
     * @return
     */
    @JSMethod(uiThread = false)
    public BaseCallBackBean<Long> getDeltaTime(JSCallback callback) {
        BaseCallBackBean<Long> callBackBean = new BaseCallBackBean<>();
        Long time = WeexRongIMClient.getDeltaTime();
        callBackBean.setData(time);
        callback.invokeAndKeepAlive(callBackBean);
        return callBackBean;
    }

    /**
     * 获取指定类型，targetId 的N条历史消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param oldestMessageId  最老一条消息ID
     * @param count            获取条数
     * @param callback
     */
    @JSMethod
    public void getHistoryMessages(int conversationType, String targetId, int oldestMessageId, int count, JSCallback callback) {
        WeexRongIMClient.getHistoryMessages(conversationType, targetId, oldestMessageId, count, callback);
    }

    /**
     * 在会话中搜索指定消息的前 before 数量和 after 数量的消息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param sentTime         发送时间（指定消息的发送时间）
     * @param before           前面N条
     * @param after            后面N条
     * @param callback
     */
    @JSMethod
    public void getHistoryMessages(int conversationType, String targetId, long sentTime, int before, int after, JSCallback callback) {
        WeexRongIMClient.getHistoryMessages(conversationType, targetId, sentTime, before, after, callback);
    }

    /**
     * 根据会话类型的目标 Id，回调方式获取某消息类型的某条消息之前或之后的N条历史消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param objectName       消息类型唯一标识
     * @param baseMessageId    消息ID
     * @param count            条数
     * @param direction        参考RongCommonDefine.GetMessageDirection
     * @param callback
     */
    @JSMethod
    public void getHistoryMessages(int conversationType, String targetId, String objectName, int baseMessageId, int count, int direction, JSCallback callback) {
        WeexRongIMClient.getHistoryMessages(conversationType, targetId, objectName, baseMessageId, count, direction, callback);
    }

    /**
     * 获取本地数据库中保存，特定类型，targetId 的N条历史消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param objectName       消息类型唯一标识
     * @param oldestMessageId  最老一条消息的ID
     * @param count            条数
     * @param callback
     */
    @JSMethod
    public void getHistoryMessages(int conversationType, String targetId, String objectName, int oldestMessageId, int count, JSCallback callback) {
        WeexRongIMClient.getHistoryMessages(conversationType, targetId, objectName, oldestMessageId, count, callback);
    }

    /**
     * 获取指定类型，targetId 的最新消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param count            条数
     * @param callback
     */
    @JSMethod
    public void getLatestMessages(int conversationType, String targetId, int count, JSCallback callback) {
        WeexRongIMClient.getLatestMessages(conversationType, targetId, count, callback);
    }

    /**
     * 根据 message id 获取消息体。
     *
     * @param messageId 消息ID
     * @param callback
     */
    @JSMethod
    public void getMessage(int messageId, JSCallback callback) {
        WeexRongIMClient.getMessage(messageId, callback);
    }

    /**
     * 根据 uid 获取 message 对象
     *
     * @param uid      uid
     * @param callback
     */
    @JSMethod
    public void getMessageByUid(String uid, JSCallback callback) {
        WeexRongIMClient.getMessageByUid(uid, callback);
    }

    /**
     * 获取消息通知免打扰时间。
     *
     * @param callback
     */
    @JSMethod
    public void getNotificationQuietHours(JSCallback callback) {
        WeexRongIMClient.getNotificationQuietHours(callback);
    }

    /**
     * 获取当前用户离线消息的存储时间，取值范围为int值1~7天
     *
     * @param callback
     */
    @JSMethod
    public void getOfflineMessageDuration(JSCallback callback) {
        WeexRongIMClient.getOfflineMessageDuration(callback);
    }

    /**
     * 获取己关注公共账号列表。
     *
     * @param callback
     */
    @JSMethod
    public void getPublicServiceList(JSCallback callback) {
        WeexRongIMClient.getPublicServiceList(callback);
    }

    /**
     * 获取某公共服务信息。
     *
     * @param publicServiceType 服务类型 参考Conversation.PublicServiceType
     * @param publicServiceId   服务ID
     * @param callback
     */
    @JSMethod
    public void getPublicServiceProfile(int publicServiceType, String publicServiceId, JSCallback callback) {
        WeexRongIMClient.getPublicServiceProfile(publicServiceType, publicServiceId, callback);
    }

    /**
     * 获取是否显示 Push 内容详情的设置
     *
     * @param callback
     */
    @JSMethod
    public void getPushContentShowStatus(JSCallback callback) {
        WeexRongIMClient.getPushContentShowStatus(callback);
    }

    /**
     * 获取融云服务器中暂存，特定类型，targetId 的N条（一次不超过40条）历史消息记录。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param dateTime         时间戳
     * @param count            条数
     * @param callback
     */
    @JSMethod
    public void getRemoteHistoryMessages(int conversationType, String targetId, long dateTime, int count, JSCallback callback) {
        WeexRongIMClient.getRemoteHistoryMessages(conversationType, targetId, dateTime, count, callback);
    }

    /**
     * 根据 messageId 获取消息发送时间 Message.sentTime
     *
     * @param messageId 消息ID
     * @return
     */
    @JSMethod
    public BaseCallBackBean<Long> getSendTimeByMessageId(int messageId, JSCallback callback) {
        BaseCallBackBean<Long> callBackBean = new BaseCallBackBean<>();
        Long time = WeexRongIMClient.getSendTimeByMessageId(messageId);
        callBackBean.setData(time);
        callback.invokeAndKeepAlive(callBackBean);
        return callBackBean;
    }

    /**
     * 根据消息类型，targetId 获取某一会话的文字消息草稿。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void getTextMessageDraft(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.getTextMessageDraft(conversationType, targetId, callback);
    }

    /**
     * 通过回调方式，获取所有未读消息数。
     *
     * @param callback
     */
    @JSMethod
    public void getTotalUnreadCount(JSCallback callback) {
        WeexRongIMClient.getTotalUnreadCount(new WeexResultCallback<Integer>(callback));
    }

    /**
     * 根据会话类型数组，回调方式获取某会话类型的未读消息数。
     *
     * @param conversationTypes 会话类型列表
     * @param callback
     */
    @JSMethod
    public void getUnreadCount(int[] conversationTypes, JSCallback callback) {
        WeexRongIMClient.getUnreadCount(conversationTypes, callback);
    }

    /**
     * 根据会话类型的目标 Id，回调方式获取来自某用户（某会话）的未读消息数。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void getUnreadCount(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.getUnreadCount(conversationType, targetId, callback);
    }

    /**
     * 获取某会话里未读的@消息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void getUnreadMentionedMessages(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.getUnreadMentionedMessages(conversationType, targetId, callback);
    }

    /**
     * 获取登录者身份认证信息。
     *
     * @param callback
     */
    @JSMethod
    public void getVendorToken(JSCallback callback) {
        WeexRongIMClient.getVendorToken(callback);
    }

    /**
     * 断开与融云服务器的连接，并且不再接收 Push 消息。
     */
    @JSMethod
    public void logout() {
        WeexRongIMClient.logout();
    }

    /**
     * 从会话列表中移除某一会话，但是不删除会话内的消息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param callback
     */
    @JSMethod
    public void removeConversation(int conversationType, String targetId, JSCallback callback) {
        WeexRongIMClient.removeConversation(conversationType, targetId, callback);
    }

    /**
     * 将个某用户从黑名单中移出。
     *
     * @param userId   用户ID
     * @param callback
     */
    @JSMethod
    public void removeFromBlacklist(String userId, JSCallback callback) {
        WeexRongIMClient.removeFromBlacklist(userId, callback);
    }

    /**
     * 移除消息通知免打扰时间。
     *
     * @param callback
     */
    @JSMethod
    public void removeNotificationQuietHours(JSCallback callback) {
        WeexRongIMClient.removeNotificationQuietHours(callback);
    }

    /**
     * 根据消息类型，targetId 保存某一会话的文字消息草稿。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param content          文字内容
     * @param callback
     */
    @JSMethod
    public void saveTextMessageDraft(int conversationType, String targetId, String content, JSCallback callback) {
        WeexRongIMClient.saveTextMessageDraft(conversationType, targetId, content, callback);
    }

    /**
     * 搜索本地历史消息。
     *
     * @param keyword           关键字
     * @param conversationTypes 会话类型列表
     * @param objectNames       消息唯一标识列表
     * @param callback
     */
    @JSMethod
    public void searchConversations(String keyword, int[] conversationTypes, String[] objectNames, JSCallback callback) {
        WeexRongIMClient.searchConversations(keyword, conversationTypes, objectNames, callback);
    }

    /**
     * 根据会话,搜索本地历史消息。
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param keyword          关键字
     * @param count            条数
     * @param beginTime        开始时间戳
     * @param callback
     */
    @JSMethod
    public void searchMessages(int conversationType, String targetId, String keyword, int count, long beginTime, JSCallback callback) {
        WeexRongIMClient.searchMessages(conversationType, targetId, keyword, count, beginTime, callback);
    }

    /**
     * 发送某个会话中的消息阅读回执
     *
     * @param conversationType 会话类型
     * @param targetId         聊天ID
     * @param timestamp        时间戳
     */
    @JSMethod
    public void sendReadReceiptMessage(int conversationType, String targetId, long timestamp) {
        WeexRongIMClient.sendReadReceiptMessage(conversationType, targetId, timestamp);
    }

    /**
     * 向会话中发送正在输入的状态
     *
     * @param conversationType  会话类型
     * @param targetId          聊天ID
     * @param typingContentType ？？？？
     */
    @JSMethod
    public void sendTypingStatus(int conversationType, String targetId, String typingContentType) {
        WeexRongIMClient.sendTypingStatus(conversationType, targetId, typingContentType);
    }

    /**
     * 设置某一会话为置顶或者取消置顶，回调方式获取设置是否成功。
     *
     * @param conversationType 会话类型
     * @param id               会话ID
     * @param isTop            是否置顶
     * @param callback
     */
    @JSMethod
    public void setConversationToTop(int conversationType, String id, boolean isTop, JSCallback callback) {
        WeexRongIMClient.setConversationToTop(conversationType, id, isTop, callback);
    }

    /**
     * 根据 messageId 设置本地消息的附加信息，用于扩展消息的使用场景。
     *
     * @param messageId 消息ID
     * @param value     附加信息
     * @param callback
     */
    @JSMethod
    public void setMessageExtra(int messageId, String value, JSCallback callback) {
        WeexRongIMClient.setMessageExtra(messageId, value, callback);
    }

    /**
     * 根据 messageId 设置接收到的消息状态。
     *
     * @param messageId      消息ID
     * @param receivedStatus 消息接收状态 参考 Message.ReceivedStatus
     * @param callback
     */
    @JSMethod
    public void setMessageReceivedStatus(int messageId, int receivedStatus, JSCallback callback) {
        WeexRongIMClient.setMessageReceivedStatus(messageId, receivedStatus, callback);
    }

    /**
     * 根据 messageId 设置消息的发送状态。
     *
     * @param messageId  消息ID
     * @param sentStatus 发送状态 参考Message.SentStatus
     * @param callback
     */
    @JSMethod
    public void setMessageSentStatus(int messageId, int sentStatus, JSCallback callback) {
        WeexRongIMClient.setMessageSentStatus(messageId, sentStatus, callback);
    }

    /**
     * 设置消息通知免打扰时间。
     *
     * @param startTime   开始时间
     * @param spanMinutes ？？？？
     * @param callback
     */
    @JSMethod
    public void setNotificationQuietHours(String startTime, int spanMinutes, JSCallback callback) {
        WeexRongIMClient.setNotificationQuietHours(startTime, spanMinutes, callback);
    }

    /**
     * 设置当前用户离线消息存储时间
     *
     * @param duration
     * @param callback
     */
    @JSMethod
    public void setOfflineMessageDuration(int duration, JSCallback callback) {
        WeexRongIMClient.setOfflineMessageDuration(duration, callback);
    }


    /**
     * 设置是否显示 Push 内容详情
     *
     * @param showStatus 是否显示
     * @param callback
     */
    @JSMethod
    public void setPushContentShowStatus(boolean showStatus, JSCallback callback) {
        WeexRongIMClient.setPushContentShowStatus(showStatus, callback);
    }

    /**
     * 切换 appKey.
     *
     * @param appKey appKey
     */
    @JSMethod
    public void switchAppKey(String appKey) {
        WeexRongIMClient.switchAppKey(appKey);
    }

    /**
     * 更新会话信息。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param title            标题
     * @param portrait         ？？？
     * @param callback
     */
    @JSMethod
    public void updateConversationInfo(int conversationType, String targetId, String title, String portrait, JSCallback callback) {
        WeexRongIMClient.updateConversationInfo(conversationType, targetId, title, portrait, callback);
    }
        /*------------------------------------消息收发-------------------------------*/

    /**
     * 向本地会话中插入一条消息，方向为接收。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param senderUserId     发送方ID
     * @param receivedStatus   接收状态
     * @param objectName       消息唯一标识
     * @param content          消息内容json
     * @param sentTime         发送时间
     * @param callback
     */
    @JSMethod
    public void insertIncomingMessage(int conversationType, String targetId, String senderUserId, int receivedStatus, String objectName, String content, long sentTime, JSCallback callback) {
        WeexRongIMClient.insertIncomingMessage(conversationType, targetId, senderUserId, new Message.ReceivedStatus(receivedStatus), MessageUtils.buildMessage(objectName, content), sentTime, callback);
    }

    /**
     * 向本地会话中插入一条消息，方向为接收。
     *
     * @param conversationType 消息类型
     * @param targetId         会话ID
     * @param senderUserId     发送方ID
     * @param receivedStatus   接收状态
     * @param objectName       消息唯一标识
     * @param content          消息内容JSON
     * @param callback
     */
    @JSMethod
    public void insertIncomingMessage(int conversationType, String targetId, String senderUserId, int receivedStatus, String objectName, String content, JSCallback callback) {
        WeexRongIMClient.insertIncomingMessage(conversationType, targetId, senderUserId, new Message.ReceivedStatus(receivedStatus), MessageUtils.buildMessage(objectName, content), callback);
    }

    /**
     * 向本地会话中插入一条消息，方向为发送。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param sentStatus       发送状态
     * @param objectName       消息唯一标识
     * @param content          消息内容JSON
     * @param sentTime         发送时间
     * @param callback
     */
    @JSMethod
    public void insertOutgoingMessage(int conversationType, String targetId, int sentStatus, String objectName, String content, long sentTime, JSCallback callback) {
        WeexRongIMClient.insertOutgoingMessage(conversationType, targetId, Message.SentStatus.setValue(sentStatus), MessageUtils.buildMessage(objectName, content), sentTime, callback);
    }

    /**
     * 向本地会话中插入一条消息。
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param sentStatus       发送状态
     * @param objectName       消息唯一标识
     * @param content          消息内容json
     * @param callback
     */
    @JSMethod
    public void insertOutgoingMessage(int conversationType, String targetId, int sentStatus, String objectName, String content, JSCallback callback) {
        WeexRongIMClient.insertOutgoingMessage(conversationType, targetId, Message.SentStatus.setValue(sentStatus), MessageUtils.buildMessage(objectName, content), callback);
    }

    /**
     * 根据会话类型，发送图片消息。
     *
     * @param conversationType 会话类型
     * @param targetId         会话id
     * @param content          图片本地url
     * @param pushContent      推送字段
     * @param pushData         推送时间
     * @param callback
     */
    @JSMethod
    public void sendImageMessage(int conversationType, String targetId, String content, String pushContent, String pushData, JSCallback callback) {
        WeexRongIMClient.sendImageMessage(conversationType, targetId, content, pushContent, pushData, callback);
    }

//    /**
//     * 发送图片消息
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendImageMessage(message, pushContent, pushData, org.weex.plugin.callback);
//    }

//    /**
//     * 发送图片消息，可以使用该方法将图片上传到自己的服务器发送，同时更新图片状态。
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendImageMessage(Message message, String pushContent, String pushData, RongIMClient.SendImageMessageWithUploadListenerCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendImageMessage(message, pushContent, pushData, org.weex.plugin.callback);
//    }

//    /**
//     * 发送地理位置消息。
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param sendMessageCallback
//     */
//    @JSMethod
//    public void sendLocationMessage(Message message, String pushContent, String pushData, IRongCallback.WeexISendMessageCallback sendMessageCallback) {
//        WeexRongIMClient.sendLocationMessage(message, pushContent, pushData, sendMessageCallback);
//    }

//    /**
//     * 发送多媒体消息 发送前构造 Message 消息实体
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendMediaMessage(message, pushContent, pushData, org.weex.plugin.callback);
//    }

//    /**
//     * 发送多媒体消息，可以使用该方法将多媒体文件上传到自己的服务器。
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendMediaMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMediaMessageCallbackWithUploader org.weex.plugin.callback) {
//        WeexRongIMClient.sendMediaMessage(message, pushContent, pushData, org.weex.plugin.callback);
//    }

    /**
     * 根据会话类型，发送消息。(图片消息使用sendImageMessage方法否则会出现路径问题)
     *
     * @param conversationType 会话类型
     * @param targetId         会话ID
     * @param objectName       消息唯一标识
     * @param content          消息内容json
     * @param pushContent      推送内容
     * @param pushData         推送时间
     * @param callback
     */
    @JSMethod
    public void sendMessage(int conversationType, String targetId, String objectName, String content, String pushContent, String pushData, JSCallback callback) {
        WeexRongIMClient.sendMessage(conversationType, targetId, MessageUtils.buildMessage(objectName, content), pushContent, pushData, callback);
    }

//    /**
//     * 发送消息。
//     *
//     * @param message
//     * @param pushContent
//     * @param pushData
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendMessage(Message message, String pushContent, String pushData, IRongCallback.ISendMessageCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendMessage(message, pushContent, pushData, org.weex.plugin.callback);
//    }

//    /**
//     * 发起群组消息回执请求。
//     *
//     * @param message
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendReadReceiptRequest(Message message, RongIMClient.OperationCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendReadReceiptRequest(message, org.weex.plugin.callback);
//    }

//    /**
//     * 发送群消息已读回执
//     *
//     * @param conversationType
//     * @param targetId
//     * @param messageList
//     * @param org.weex.plugin.callback
//     */
//    @JSMethod
//    public void sendReadReceiptResponse(int conversationType, String targetId, List<Message> messageList, JSCallback org.weex.plugin.callback) {
//        WeexRongIMClient.sendReadReceiptResponse(conversationType, targetId, messageList, org.weex.plugin.callback);
//    }

    /**
     * 设置会话消息提醒状态。
     *
     * @param conversationType   会话类型
     * @param targetId           会话ID
     * @param notificationStatus 提醒状态 参考Conversation.ConversationNotificationStatus
     * @param callback
     */
    @JSMethod
    public void setConversationNotificationStatus(int conversationType, String targetId, int notificationStatus, JSCallback callback) {
        WeexRongIMClient.setConversationNotificationStatus(conversationType, targetId, notificationStatus, callback);
    }

/*--------------------------------------融云静态方法---------------------------------*/

    /**
     * 连接服务器，在整个应用程序全局，只需要调用一次，需在 init(Context) 之后调用。注意：原生调用，js无需调用
     *
     * @param token    token
     * @param callback
     * @return
     */
    @JSMethod
    public void connect(String token, JSCallback callback) {
        WeexRongIMClient.connect(token, new WeexConnectCallback(callback));
    }

    /**
     * 设置私有部署的导航服务器和媒体服务器地址。
     *
     * @param naviServer 导航服务器地址
     * @param fileServer 媒体服务器地址
     */
    @JSMethod
    public void setServerInfo(String naviServer, String fileServer) {
        WeexRongIMClient.setServerInfo(naviServer, fileServer);
    }

    /**
     * 配置数据上传地址 (非必须) 通过配置该地址，SDK 会在初始化时把设备相关信息上传到私有云节点。
     *
     * @param domain 数据上传地址
     */
    @JSMethod
    public void setStatisticDomain(String domain) {
        WeexRongIMClient.setStatisticDomain(domain);
    }
}
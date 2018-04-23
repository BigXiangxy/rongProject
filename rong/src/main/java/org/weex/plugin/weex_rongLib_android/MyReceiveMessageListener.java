package org.weex.plugin.weex_rongLib_android;


import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import com.base.library.LogX;
import com.google.gson.Gson;
import com.taobao.weex.WXSDKInstance;

import java.util.HashMap;
import java.util.Map;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;


/**
 * 接收消息监听器的实现，所有接收到的消息、通知、状态都经由此处设置的监听器处理。包括私聊消息、讨论组消息、群组消息、聊天室消息以及各种状态。
 */
public class MyReceiveMessageListener implements RongIMClient.OnReceiveMessageListener {
    public static int NotificationID = 123278;
    private Context context;
    private NotificationManager mNotificationManager;

    public MyReceiveMessageListener(Context context) {
        this.context = context;
    }

    /**
     * 收到消息的处理。
     *
     * @param message 收到的消息实体。
     * @param left    剩余未拉取消息数目。
     * @return
     */
    @Override
    public boolean onReceived(final Message message, int left) {//开发者根据自己需求自行处理
        LogX.e("MessageListener", "->" + new Gson().toJson(message));
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        params.put("left", left);
        Map<String, WXSDKInstance> wxsdkInstances = RongWeexManager.getInstance().getWXSDKInstances();
        for (Map.Entry<String, WXSDKInstance> entry : wxsdkInstances.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            WXSDKInstance instance = entry.getValue();
            if (instance != null) {
                instance.fireGlobalEventCallback(RongWeexManager.GEN_New_Message, params);
            }
        }
        return false;
    }

//    private void showNotification(final Conversation.ConversationType conversationType, final String targentId, final String title, final String content, final String ticker) {
//        if (targentId.equals(Constant.USER_ID_TYPE.TASK_HALL)) return;
//        showNotification(conversationType, targentId, title, content, ticker, null);
//    }
//
//    private void showNotification(final Conversation.ConversationType conversationType, final String targentId, final String title, final String content, final String ticker, final String msgType) {
//        if (AppUtils.isAppIsInBackground(context)) {//在后台
//            RongApi.getConversationNotificationStatus(conversationType, targentId, new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() {
//                @Override
//                public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
//                    switch (conversationNotificationStatus) {
//                        case DO_NOT_DISTURB:
//                            LogUtils.e("ReceiveMessageListener", "消息免打扰，不提示!");
//                            break;
//                        case NOTIFY:
//                            LogUtils.e("YUY", "conversationType = " + conversationType + " targentId = " + targentId);
//                            buildNotification(conversationType, targentId, title, content, ticker, msgType);
//                            break;
//                    }
//                }
//
//                @Override
//                public void onError(RongIMClient.ErrorCode errorCode) {
//                    LogUtils.e("ReceiveMessageListener", "获取消息免打扰状态失败，不提示!");
//                }
//            });
//        }
//    }
//
//    private void buildNotification(Conversation.ConversationType conversationType, String targentId, String title, String content, String ticker, String msgType) {
//        if (mNotificationManager == null)
//            mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
//
//        Intent intent = new Intent(context, RongMsgType.RC_CONTACTNTF_MSG.equals(msgType) ? NewFriendActivity.class : RongChatActivity.class);
//        switch (conversationType) {
//            case GROUP:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.GROUP);
//                break;
//            case PRIVATE:
//                if (targentId.equals("4")) {
//                    intent = new Intent(context, BusinessHallActivity.class);
//                }
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.PRIVATE);
//                break;
//            case APP_PUBLIC_SERVICE:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.APP_PUBLIC_SERVICE);
//                break;
//            case CHATROOM:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.CHATROOM);
//                break;
//            case CUSTOMER_SERVICE:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.CUSTOMER_SERVICE);
//                break;
//            case DISCUSSION:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.DISCUSSION);
//                break;
//            case NONE:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.NONE);
//                break;
//            case PUBLIC_SERVICE:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.PUBLIC_SERVICE);
//                break;
//            case PUSH_SERVICE:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.PUSH_SERVICE);
//                break;
//            case SYSTEM:
//                intent.putExtra(RongChatMsgFragment.KEY_TYPE, Conversation.ConversationType.SYSTEM);
//                break;
//        }
//        intent.putExtra(RongChatMsgFragment.KEY_TARGET, targentId);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        mBuilder.setContentTitle(title)//设置通知栏标题
//                .setContentText(content) //设置通知栏显示内容
//                .setContentIntent(pendingIntent) //设置通知栏点击意图
//                //  .setNumber(number) //设置通知集合的数量
//                .setTicker(ticker) //通知首次出现在通知栏，带上升动画效果的
//                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
//                .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
//                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
//                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
//                .setDefaults(Notification.DEFAULT_ALL)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
//                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
//                .setSmallIcon(R.drawable.ic_luncher);//设置通知小ICON
//        mNotificationManager.notify(NotificationID, mBuilder.build());
//    }
//
//    public void MessageType(Message message) throws Exception {
//        CDDQuanMsg cddQuanMsg = (CDDQuanMsg) message.getContent();
//        if (!TextUtils.isEmpty(cddQuanMsg.getServiceType()) && Integer.parseInt(cddQuanMsg.getServiceType()) == 1) {//1朋友圈 2 图文  3 活动
//            if (Integer.parseInt(cddQuanMsg.getOperateType()) == 0) {
//                SharedPreferencesUtil.setOtherCacheData("Quanhead" + UserBean.getInstall(context).getId(), cddQuanMsg.getHeadImage());
//                EventBus.getDefault().post(new Refresh());
//            } else {
//                String NumQuan = SharedPreferencesUtil.getOtherCacheData("Quan" + UserBean.getInstall(context).getId());
//                SharedPreferencesUtil.setOtherCacheData("Quan" + UserBean.getInstall(context).getId(), TextUtils.isEmpty(NumQuan) ? String.valueOf(1) : String.valueOf((Integer.parseInt(NumQuan) + 1)));
//                SharedPreferencesUtil.setOtherCacheData("QuanImg" + UserBean.getInstall(context).getId(), cddQuanMsg.getHeadImage());
//                EventBus.getDefault().post(new Refresh());
//            }
//        } else if (!TextUtils.isEmpty(cddQuanMsg.getServiceType()) && Integer.parseInt(cddQuanMsg.getServiceType()) == 3) {
//            String Numhuodong = SharedPreferencesUtil.getOtherCacheData("huodong" + UserBean.getInstall(context).getId());
//            SharedPreferencesUtil.setOtherCacheData("huodong" + UserBean.getInstall(context).getId(), TextUtils.isEmpty(Numhuodong) ? String.valueOf(1) : String.valueOf((Integer.parseInt(Numhuodong) + 1)));
//            SharedPreferencesUtil.setOtherCacheData("huodongImg" + UserBean.getInstall(context).getId(), cddQuanMsg.getHeadImage());
//            EventBus.getDefault().post(new Refresh());
//        } else {
//            String NumTuwen = SharedPreferencesUtil.getOtherCacheData("tuwen" + UserBean.getInstall(context).getId());
//            SharedPreferencesUtil.setOtherCacheData("tuwen" + UserBean.getInstall(context).getId(), TextUtils.isEmpty(NumTuwen) ? String.valueOf(1) : String.valueOf((Integer.parseInt(NumTuwen) + 1)));
//            SharedPreferencesUtil.setOtherCacheData("tuwenImg" + UserBean.getInstall(context).getId(), cddQuanMsg.getHeadImage());
//            EventBus.getDefault().post(new Refresh());
//        }
//    }
}




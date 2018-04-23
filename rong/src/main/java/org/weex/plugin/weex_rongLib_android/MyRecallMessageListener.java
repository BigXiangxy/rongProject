package org.weex.plugin.weex_rongLib_android;


import android.util.Log;

import com.google.gson.Gson;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.RecallNotificationMessage;

/**
 * 撤回消息监听器
 * Created by xxy on 2016/9/10 0010.
 */
public class MyRecallMessageListener implements RongIMClient.OnRecallMessageListener {
//    @Override
//    public void onMessageRecalled(int msgId, RecallNotificationMessage recallNotificationMessage) {
////        EventBus.getDefault().post(new RecallMsgBean(msgId,recallNotificationMessage));
//    }

    @Override
    public boolean onMessageRecalled(Message message, RecallNotificationMessage recallNotificationMessage) {
        Log.e("MyRecallMessageListener", "->" + new Gson().toJson(message) + " \nRecallNotificationMessage" + new Gson().toJson(recallNotificationMessage));
        return false;
    }
}

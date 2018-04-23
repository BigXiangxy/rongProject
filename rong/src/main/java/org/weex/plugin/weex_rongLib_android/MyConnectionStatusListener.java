//package org.weex.plugin.weex_rongLib_android;
//
//import android.util.Log;
//
//import com.taobao.weex.WXSDKInstance;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import io.rong.imlib.RongIMClient;
//
///**
// * Created by Administrator on 2016/9/27 0027.
// */
//public class MyConnectionStatusListener implements RongIMClient.ConnectionStatusListener {
//
//    @Override
//    public void onChanged(ConnectionStatus connectionStatus) {
//        //EventBus.getDefault().post(new RongConnectionStatus(connectionStatus));
//        Map<String, Object> params = new HashMap<>();
//        params.put("connectionStatus", connectionStatus.getValue());
//        params.put("connectionMsg", connectionStatus.getMessage());
//        Map<String, WXSDKInstance> wxsdkInstances = RongWeexManager.getInstance().getWXSDKInstances();
//        for (Map.Entry<String, WXSDKInstance> entry : wxsdkInstances.entrySet()) {
//            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            WXSDKInstance instance = entry.getValue();
//            if (instance != null) {
//                instance.fireGlobalEventCallback(RongWeexManager.GEN_Connection_Status, params);
//            }
//        }
//        switch (connectionStatus) {
//            case NETWORK_UNAVAILABLE://网络不可用。
//                Log.e("------", "网络不可用");
//                break;
//            case CONNECTED://连接成功。
//                Log.e("------", "连接成功");
//                break;
//            case CONNECTING://连接中。
//                Log.e("------", "连接中...");
//                break;
//            case DISCONNECTED://断开连接。
//                Log.e("------", "断开连接");
//                break;
//            case KICKED_OFFLINE_BY_OTHER_CLIENT://用户账户在其他设备登录，本机会被踢掉线。
//                Log.e("------", "用户账户在其他设备登录，本机被踢掉线。");
//                break;
//            case TOKEN_INCORRECT://Token 不正确。
//                Log.e("------", "Token不正确");
//                break;
//            case SERVER_INVALID://服务器异常或无法连接。
//                Log.e("------", "服务器异常或无法连接");
//                break;
//        }
//    }
//}

//package org.weex.plugin.weex_rongLib_android.callback;
//
//import com.taobao.weex.bridge.JSCallback;
//
//
//import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;
//
//import io.rong.imlib.IRongCallback;
//import io.rong.imlib.RongIMClient;
//import io.rong.imlib.model.Message;
//
///**
// * Created by QYG_XXY on 0023 2018/2/23.
// */
//
//public class WeexISendMessageCallback implements IRongCallback.ISendMessageCallback {
//    private JSCallback jsCallback;
//
//    public WeexISendMessageCallback(JSCallback jsCallback) {
//        this.jsCallback = jsCallback;
//    }
//
//    @Override
//    public void onAttached(Message message) {
//
//    }
//
//    @Override
//    public void onError(Message message, RongIMClient.ErrorCode errorCode) {
//        if (jsCallback != null)
//            jsCallback.invoke(new BaseCallBackBean<Message>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()).setData(message));
//    }
//
//    @Override
//    public void onSuccess(Message message) {
//        if (jsCallback != null)
//            jsCallback.invoke(new BaseCallBackBean<Message>().setData(message));
//
//    }
//}

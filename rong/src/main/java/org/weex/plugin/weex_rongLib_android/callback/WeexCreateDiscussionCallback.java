//package org.weex.plugin.weex_rongLib_android.callback;
//
//import com.taobao.weex.bridge.JSCallback;
//
//import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;
//
//import io.rong.imlib.RongIMClient;
//
///**
// * Created by QYG_XXY on 0023 2018/2/23.
// */
//
//public class WeexCreateDiscussionCallback extends RongIMClient.CreateDiscussionCallback {
//
//    private JSCallback jsCallback;
//
//    public WeexCreateDiscussionCallback(JSCallback jsCallback) {
//        this.jsCallback = jsCallback;
//    }
//
//    @Override
//    public void onSuccess(String s) {
//        if (jsCallback != null)
//            jsCallback.invoke(new BaseCallBackBean<String>().setData(s));
//    }
//
//    @Override
//    public void onError(RongIMClient.ErrorCode errorCode) {
//        if (jsCallback != null)
//            jsCallback.invoke(new BaseCallBackBean<String>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()));
//    }
//}

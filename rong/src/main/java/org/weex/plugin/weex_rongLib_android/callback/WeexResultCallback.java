//package org.weex.plugin.weex_rongLib_android.callback;
//
//import com.taobao.weex.bridge.JSCallback;
//
//
//import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;
//
//import io.rong.imlib.RongIMClient;
//
///**
// * Created by QYG_XXY on 0022 2018/2/22.
// */
//
//public class WeexResultCallback<T> extends RongIMClient.ResultCallback<T> {
//    private JSCallback jsCallback;
//
//    public WeexResultCallback(JSCallback jsCallback) {
//        this.jsCallback = jsCallback;
//    }
//
//
//    @Override
//    public void onSuccess(T o) {
//        if (jsCallback!= null)
//            jsCallback.invoke(new BaseCallBackBean<T>().setData(o));
//    }
//
//    @Override
//    public void onError(RongIMClient.ErrorCode errorCode) {
//        if (jsCallback != null)
//            jsCallback.invoke(new BaseCallBackBean<String>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()));
//    }
//}

package org.weex.plugin.weex_rongLib_android.callback;

import com.taobao.weex.bridge.JSCallback;


import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;

import io.rong.imlib.RongIMClient;

/**
 * Created by QYG_XXY on 0022 2018/2/22.
 */

public class WeexOperationCallback extends RongIMClient.OperationCallback {
    private JSCallback jsCallback;

    public WeexOperationCallback(JSCallback jsCallback) {
        this.jsCallback = jsCallback;
    }

    @Override
    public void onSuccess() {
        if (jsCallback != null)
            jsCallback.invoke(new BaseCallBackBean<String>());
    }

    @Override
    public void onError(RongIMClient.ErrorCode errorCode) {
        if (jsCallback != null)
            jsCallback.invoke(new BaseCallBackBean<String>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()));
    }
}

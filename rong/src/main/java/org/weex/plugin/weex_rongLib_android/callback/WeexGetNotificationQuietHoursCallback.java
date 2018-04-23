package org.weex.plugin.weex_rongLib_android.callback;

import com.taobao.weex.bridge.JSCallback;


import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;

import io.rong.imlib.RongIMClient;

/**
 * Created by QYG_XXY on 0023 2018/2/23.
 */

public class WeexGetNotificationQuietHoursCallback extends RongIMClient.GetNotificationQuietHoursCallback {
    private JSCallback jsCallback;

    public WeexGetNotificationQuietHoursCallback(JSCallback jsCallback) {
        this.jsCallback = jsCallback;
    }


    @Override
    public void onSuccess(String s, int i) {
        QuietHour quietHour = new QuietHour();
        quietHour.s = s;
        quietHour.i = i;
        if (jsCallback != null) {
            jsCallback.invoke(new BaseCallBackBean<QuietHour>().setData(quietHour));
        }
    }

    @Override
    public void onError(RongIMClient.ErrorCode errorCode) {
        if (jsCallback != null) {
            jsCallback.invoke(new BaseCallBackBean<QuietHour>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()));
        }
    }

    static class QuietHour {
        String s;
        int i;
    }
}

package org.weex.plugin.weex_rongLib_android.callback;

import com.taobao.weex.bridge.JSCallback;

import org.weex.plugin.weex_rongLib_android.BaseCallBackBean;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

/**
 * Created by QYG_XXY on 0023 2018/2/23.
 */

public class WeexSendImageMessageCallback extends RongIMClient.SendImageMessageCallback {
    private JSCallback jsCallback;

    public WeexSendImageMessageCallback(JSCallback jsCallback) {
        this.jsCallback = jsCallback;
    }

    /**
     * 存入本地数据库成功
     *
     * @param message
     */
    @Override
    public void onAttached(Message message) {

    }

    /**
     * 发送失败
     *
     * @param message
     * @param errorCode
     */
    @Override
    public void onError(Message message, RongIMClient.ErrorCode errorCode) {
        if (jsCallback != null)
            jsCallback.invoke(new BaseCallBackBean<Message>().setCode(errorCode.getValue()).setMessage(errorCode.getMessage()).setData(message));
    }

    /**
     * 成功
     *
     * @param message
     */
    @Override
    public void onSuccess(Message message) {
        if (jsCallback != null)
            jsCallback.invoke(new BaseCallBackBean<Message>().setData(message));

    }

    /**
     * 进度
     *
     * @param message
     * @param i
     */
    @Override
    public void onProgress(Message message, int i) {

    }
}

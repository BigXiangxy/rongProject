package org.weex.plugin.weex_rongLib_android;

import android.content.Context;
import android.text.TextUtils;

import com.base.library.BeanUtil;
import com.taobao.weex.WXSDKInstance;

import java.util.HashMap;
import java.util.Map;

import io.rong.imlib.AnnotationNotFoundException;
import io.rong.imlib.RongIMClient;

/**
 * Created by QYG_XXY on 0012 2018/2/12.
 */

public final class RongWeexManager {
    /**
     * 全局融云连接状态监听器EventName
     */
    public static final String GEN_Connection_Status = "connectionStatus";
    /**
     * 全局融云消息监听器EVENTName
     */
    public static final String GEN_New_Message = "newMessage";
    /**
     * 全局返回键EVENTName
     */
    public static final String GEN_Back = "aBack";

    private Map<String, WXSDKInstance> mWXSDKInstances;
    private static RongWeexManager rongWeexManager;

    public WXSDKInstance getWXSDKInstance(String instanceHash) {
        if (TextUtils.isEmpty(instanceHash)) return null;
        for (Map.Entry<String, WXSDKInstance> entry : mWXSDKInstances.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (instanceHash.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Map<String, WXSDKInstance> getWXSDKInstances() {
        return mWXSDKInstances;
    }

    /**
     * 默认取obj.toString()作为Key
     *
     * @param mWXSDKInstance
     */
    public void putWXSDKInstance(WXSDKInstance mWXSDKInstance) {
        if (mWXSDKInstance == null) return;
        mWXSDKInstances.put(BeanUtil.getBeanHash(mWXSDKInstance), mWXSDKInstance);
    }

    public void removeWXSDKInstance(String instanceHash) {
        mWXSDKInstances.remove(instanceHash);
    }

    public void removeWXSDKInstance(WXSDKInstance instance) {
        if (instance == null) return;
        mWXSDKInstances.remove(BeanUtil.getBeanHash(instance));
    }

    public void removeAllWXSDKInstance() {
        this.mWXSDKInstances.clear();
    }


    private RongWeexManager() {
        mWXSDKInstances = new HashMap<>();
    }

    public static RongWeexManager getInstance() {
        if (rongWeexManager == null) {
            synchronized (RongWeexManager.class) {
                if (rongWeexManager == null) {
                    rongWeexManager = new RongWeexManager();
                }
            }
        }
        return rongWeexManager;
    }


    public static void initRong(Context context) {
        /*
         * OnCreate 会被多个进程重入，这段保护代码，确保只有您需要使用 RongIMClient 的进程和 Push 进程执行了 init。
         * io.rong.push 为融云 push 进程名称，不可修改。
         */
        if (context == null) return;
        if (context.getApplicationInfo().packageName.equals(RongUtils.getCurProcessName(context)) ||
                "io.rong.push".equals(RongUtils.getCurProcessName(context))) {
            RongIMClient.init(context);
        }
        try {
            RongIMClient.registerMessageType(MHPMessage.class);
        } catch (AnnotationNotFoundException e) {
            e.printStackTrace();
        }
        RongIMClient.setOnReceiveMessageListener(new MyReceiveMessageListener(context));
        RongIMClient.setOnRecallMessageListener(new MyRecallMessageListener());
        RongIMClient.setConnectionStatusListener(new MyConnectionStatusListener());
    }

    public static void connect(String token, final RongConnectCallback callback) {
        RongIMClient.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                callback.onTokenIncorrect();
            }

            @Override
            public void onSuccess(String s) {
                callback.onSuccess(s);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                callback.error(errorCode.getValue(), errorCode.getMessage());
            }
        });
    }

    public interface RongConnectCallback {
        void onTokenIncorrect();

        void onSuccess(String s);

        void error(int code, String msg);
    }
}

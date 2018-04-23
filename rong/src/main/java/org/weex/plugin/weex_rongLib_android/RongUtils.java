package org.weex.plugin.weex_rongLib_android;

import android.app.ActivityManager;
import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by QYG_XXY on 0012 2018/2/12.
 */

public final class RongUtils {

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) return null;
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid)
                return appProcess.processName;
        }
        return null;
    }

    /**
     * BeanToJson
     *
     * @param obj
     * @return
     */
    public static String BeanToJSON(Object obj) {
        return new Gson().toJson(obj);
    }


}

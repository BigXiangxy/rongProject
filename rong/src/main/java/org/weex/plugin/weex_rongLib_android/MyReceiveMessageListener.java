package org.weex.plugin.weex_rongLib_android;


import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.base.library.MyWeexManager;
import com.base.library.SharedPreferencesHelper;
import com.google.gson.Gson;
import com.taobao.weex.WXSDKInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.TextMessage;


/**
 * 接收消息监听器的实现，所有接收到的消息、通知、状态都经由此处设置的监听器处理。包括私聊消息、讨论组消息、群组消息、聊天室消息以及各种状态。
 */
public class MyReceiveMessageListener implements RongIMClient.OnReceiveMessageListener {
    public static int NotificationID = 123278;
    public static final String channelID = "rong_nt";
    public static final String SHOWWW = "SHOWWW";
    public static final String SHOWVV = "SHOVVV";
    public static final String SHOWII = "SHOWII";//应用前台是否显示
    public static final String SHOWGG = "SHOWGG";//聊天界面是否显示
    public static Boolean SHOWKK = false;//是否在聊天界面
    public static final String shareP = "PUSH_SP";
    private Context context;
    private NotificationManager mNotificationManager;
    public static final String RONG_INTENT_KEY = "rong_s_key";
    private static final String TAG = "ReceiveMessage";

    public MyReceiveMessageListener(Context context) {
        this.context = context;
    }

    /**
     * 收到消息的处理。
     *
     * @param message 收到的消息实体。
     * @param left    剩余未拉取消息数目。
     * @return
     */
    @Override
    public boolean onReceived(final Message message, int left) {//开发者根据自己需求自行处理
        Log.i(TAG, "rong--" + new Gson().toJson(message));
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        params.put("left", left);
        Map<String, WXSDKInstance> wxsdkInstances = MyWeexManager.getInstance().getWXSDKInstances();
        for (Map.Entry<String, WXSDKInstance> entry : wxsdkInstances.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            WXSDKInstance instance = entry.getValue();
            if (instance != null) {
                instance.fireGlobalEventCallback(MyWeexManager.GEN_New_Message, params);
            }
        }
        showNotification(message);
        return false;
    }

    private void showNotification(Message message) {
        String con = null;
        if ("QYC:Template".equals(message.getObjectName())) {
            con = "收到一条业务消息，请注意查看！";
        } else if ("RC:TxtMsg".equals(message.getObjectName())) {
            TextMessage textMessage = (TextMessage) message.getContent();
            con = textMessage.getContent();
        } else if ("RC:VcMsg".equals(message.getObjectName())) {
            con = "[语音]";
        } else if ("RC:ImgMsg".equals(message.getObjectName())) {
            con = "[图片]";
        }

        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, shareP);
        Boolean ii = (Boolean) sharedPreferencesHelper.getSharedPreference(SHOWII, Boolean.TRUE);
        Boolean gg = (Boolean) sharedPreferencesHelper.getSharedPreference(SHOWGG, Boolean.TRUE);
        if (message != null && (ii || isAppIsInBackground(context)) && (gg || SHOWKK)) {
            UserInfo userInfo = message.getContent().getUserInfo();
            if (TextUtils.isEmpty(con) || userInfo == null || TextUtils.isEmpty(userInfo.getName()))
                return;
            buildNotification(userInfo.getName(), con, message);
        }
    }


    private void buildNotification(String title, String content, Message message) {
        if (mNotificationManager == null)
            mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelID);

        Intent intent = new Intent(context.getApplicationInfo().packageName + ".main");
        intent.putExtra(RONG_INTENT_KEY, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, shareP);
        Boolean sound = (Boolean) sharedPreferencesHelper.getSharedPreference(SHOWWW, Boolean.FALSE);
        Boolean vibrate = (Boolean) sharedPreferencesHelper.getSharedPreference(SHOWVV, Boolean.FALSE);
        int defaults = Notification.DEFAULT_LIGHTS;
        if (sound) defaults |= Notification.DEFAULT_SOUND;
        if (vibrate) defaults |= Notification.DEFAULT_VIBRATE;
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentTitle(title)//设置通知栏标题
                .setContentText(content) //设置通知栏显示内容
                .setContentIntent(pendingIntent) //设置通知栏点击意图
                //.setNumber(number) //设置通知集合的数量
                //.setTicker(ticker) //通知首次出现在通知栏，带上升动画效果的
                //.setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                //.setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(defaults)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(context.getApplicationInfo().icon);//设置通知小ICON
        mNotificationManager.notify(NotificationID, mBuilder.build());
    }


//    private void startActivity(Context context, String pkgName, PushNotificationMessage message) {
//        if (TextUtils.isEmpty(pkgName)) return;
//        //判断app进程是否存活
//        if (isAppAlive(context, pkgName)) {
//            //如果存活的话，就直接启动DetailActivity，但要考虑一种情况，就是app的进程虽然仍然在
//            //但Task栈已经空了，比如用户点击Back键退出应用，但进程还没有被系统回收，如果直接启动
//            //DetailActivity,再按Back键就不会返回MainActivity了。所以在启动
//            //DetailActivity前，要先启动MainActivity。
//            Intent mainIntent = new Intent(pkgName + ".main");
//            //将MainAtivity的launchMode设置成SingleTask, 或者在下面flag中加上Intent.FLAG_CLEAR_TOP,
//            //如果Task栈中有MainActivity的实例，就会把它移到栈顶，把在它之上的Activity都清理出栈，
//            //如果Task栈不存在MainActivity实例，则在栈顶创建
//            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            Intent detailIntent = new Intent(context, DetailActivity.class);
////            detailIntent.putExtra("name", "电饭锅");
////            detailIntent.putExtra("price", "58元");
////            detailIntent.putExtra("detail", "这是一个好锅, 这是app进程存在，直接启动Activity的");
////            Intent[] intents = {mainIntent, detailIntent};
////            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            mainIntent.putExtra(PUSH_RONG_INTENT_KEY, message);
//            context.startActivity(mainIntent);
//        } else {
//            //如果app进程已经被杀死，先重新启动app，将DetailActivity的启动参数传入Intent中，参数经过
//            //SplashActivity传入MainActivity，此时app的初始化已经完成，在MainActivity中就可以根据传入             //参数跳转到DetailActivity中去了
//            Log.i(TAG, "the app process is dead");
//            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(pkgName);
//            launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//            launchIntent.putExtra(PUSH_RONG_INTENT_KEY, message);
//            context.startActivity(launchIntent);
//        }
//    }

//    private void startActivity(Context context, String id, Conversation.ConversationType conversationType) {
//        //判断app进程是否存活
////        if(isAppAlive(context, "com.chewuwuyou.app")){
////            //如果存活的话，就直接启动DetailActivity，但要考虑一种情况，就是app的进程虽然仍然在
////            //但Task栈已经空了，比如用户点击Back键退出应用，但进程还没有被系统回收，如果直接启动
////            //DetailActivity,再按Back键就不会返回MainActivity了。所以在启动
////            //DetailActivity前，要先启动MainActivity。
////            Intent mainIntent = new Intent(context, MainActivity.class);
////            //将MainAtivity的launchMode设置成SingleTask, 或者在下面flag中加上Intent.FLAG_CLEAR_TOP,
////            //如果Task栈中有MainActivity的实例，就会把它移到栈顶，把在它之上的Activity都清理出栈，
////            //如果Task栈不存在MainActivity实例，则在栈顶创建
////            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            Intent detailIntent = new Intent(context, DetailActivity.class);
////            detailIntent.putExtra("name", "电饭锅");
////            detailIntent.putExtra("price", "58元");
////            detailIntent.putExtra("detail", "这是一个好锅, 这是app进程存在，直接启动Activity的");
////            Intent[] intents = {mainIntent, detailIntent};
////            context.startActivities(intents);
////        }else {
//        //如果app进程已经被杀死，先重新启动app，将DetailActivity的启动参数传入Intent中，参数经过
//        //SplashActivity传入MainActivity，此时app的初始化已经完成，在MainActivity中就可以根据传入             //参数跳转到DetailActivity中去了
//        Log.i("NotificationReceiver", "the app process is dead");
//        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.chewuwuyou.app");
//        launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//        Bundle args = new Bundle();
//        args.putString(RongChatMsgFragment.KEY_TARGET, id);
//        args.putSerializable(RongChatMsgFragment.KEY_TYPE, conversationType);
//        launchIntent.putExtra(RE_TAG, args);
//        context.startActivity(launchIntent);
////        }
//    }


    public static boolean isAppAlive(Context context, String packageName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfos = activityManager.getRunningAppProcesses();
        for (int i = 0; i < processInfos.size(); i++) {
            if (processInfos.get(i).processName.equals(packageName)) {
                Log.i("NotificationR",
                        String.format("the %s is running, isAppAlive return true", packageName));
                return true;
            }
        }
        Log.i("NotificationR",
                String.format("the %s is not running, isAppAlive return false", packageName));
        return false;
    }

    /**
     * 判断程序是否在前台运行,返回true表示在后台
     *
     * @param context
     * @return
     */
    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {//前台程序
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {//说明在前台
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {//说明在前台
                isInBackground = false;
            }
        }
        return isInBackground;
    }
}




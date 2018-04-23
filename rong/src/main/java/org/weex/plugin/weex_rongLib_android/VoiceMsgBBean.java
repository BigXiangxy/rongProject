package org.weex.plugin.weex_rongLib_android;

/**
 * Created by QYG_XXY on 0027 2018/3/27.
 */

public class VoiceMsgBBean {

    /**
     * duration : 时长？？？
     * mLocalPath : 本地路径
     * extra : 拓展字段可缺省
     */
    private int duration;
    private String mLocalPath;
    private String extra;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMLocalPath() {
        return mLocalPath;
    }

    public void setMLocalPath(String mLocalPath) {
        this.mLocalPath = mLocalPath;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}

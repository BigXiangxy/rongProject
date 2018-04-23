package org.weex.plugin.weex_rongLib_android;

/**
 * Created by QYG_XXY on 0027 2018/3/27.
 */

public class ImgMsgBBean {

    /**
     * mThumUri : 缩略图路径发送时直接使用mLocalPath
     * mLocalPath : 本地路径
     * extra : 拓展字段可缺省
     */

    private String mThumUri;
    private String mLocalPath;
    private String extra;

    public String getMThumUri() {
        return mThumUri;
    }

    public void setMThumUri(String mThumUri) {
        this.mThumUri = mThumUri;
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

package org.weex.plugin.weex_rongLib_android;

import android.net.Uri;
import android.text.TextUtils;

import com.google.gson.Gson;

import io.rong.imlib.model.MessageContent;
import io.rong.message.ImageMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;

/**
 * Created by QYG_XXY on 0023 2018/2/23.
 */

public class MessageUtils {
    public static final String TEXT_MSG_NAME = "RC:TxtMsg";//文字消息

    public static final String IMAGE_MSG_NAME = "RC:ImgMsg";//图片消息

    public static final String MHP_MSG_NAME = "QYC:Template";//病历/处方消息

    public static final String VOICE_MSG_NAME = "RC:VcMsg";//语音消息

    /**
     * "RC:TxtMsg";//文字消息    {"content":"内容","extra":"拓展字段可缺省"}
     * "RC:ImgMsg";//图片消息    {"mThumUri":"缩略图路径发送时直接使用mLocalPath","mLocalPath":"本地路径","extra":"拓展字段可缺省"}
     * "QYC:Template";//病历/处方消息 {"id1":123,"id2":34,"img1":"","img2":"","status":"","content":"","content1":"","content2":"","content3":"","content4":"","msgUuid":"","extra":"",}
     * "RC:VcMsg";//语音消息 {"duration":"时长？？？","mLocalPath":"本地路径","extra":"拓展字段可缺省"}
     *
     * @param objectName
     * @param content
     * @return
     */
    public static MessageContent buildMessage(String objectName, String content) {
        try {
            switch (objectName) {
                case TEXT_MSG_NAME:
                    TextMessage textMessage = new Gson().fromJson(content, TextMessage.class);
                    return textMessage;
                case IMAGE_MSG_NAME:
                    ImgMsgBBean bean = new Gson().fromJson(content, ImgMsgBBean.class);
                    ImageMessage imageMessage = ImageMessage.obtain();
                    if (!TextUtils.isEmpty(bean.getMLocalPath())) {
                        imageMessage.setLocalPath(Uri.parse("file://" + bean.getMLocalPath()));
                    }
                    if (!TextUtils.isEmpty(bean.getMThumUri())) {
                        imageMessage.setThumUri(Uri.parse("file://" + bean.getMThumUri()));
                    }
                    if (!TextUtils.isEmpty(bean.getExtra())) {
                        imageMessage.setExtra(bean.getExtra());
                    }
                    return imageMessage;
                case MHP_MSG_NAME:
                    MHPMessage mhpMessage = new Gson().fromJson(content, MHPMessage.class);
                    return mhpMessage;
                case VOICE_MSG_NAME:
                    VoiceMsgBBean voiceMsgBBean = new Gson().fromJson(content, VoiceMsgBBean.class);
                    VoiceMessage voiceMessage = VoiceMessage.obtain(Uri.parse("file://" + voiceMsgBBean.getMLocalPath()), voiceMsgBBean.getDuration());
                    if (!TextUtils.isEmpty(voiceMsgBBean.getExtra())) {
                        voiceMessage.setExtra(voiceMsgBBean.getExtra());
                    }
                    return voiceMessage;
            }
            return TextMessage.obtain(content);
        } catch (Exception e) {
            e.printStackTrace();
            return TextMessage.obtain(content);
        }
    }
}

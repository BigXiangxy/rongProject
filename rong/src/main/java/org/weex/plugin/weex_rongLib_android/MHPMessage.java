package org.weex.plugin.weex_rongLib_android;

import android.os.Parcel;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;

/**
 * Created by QYG_XXY on 0027 2018/3/27.
 */
@MessageTag(
        value = "QYC:Template",
        flag = 3
)
public class MHPMessage extends MessageContent {
    private static final String TAG = "MHPMessage";
    private Long id1;
    private Long id2;
    private String img1;
    private String img2;
    private String status;
    private String content;
    private String content1;
    private String content2;
    private String content3;
    private String content4;
    private String msgUuid;
    protected String extra;
    public static final Creator<MHPMessage> CREATOR = new Creator<MHPMessage>() {
        public MHPMessage createFromParcel(Parcel source) {
            return new MHPMessage(source);
        }

        public MHPMessage[] newArray(int size) {
            return new MHPMessage[size];
        }
    };

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public byte[] encode() {
        JSONObject jsonObj = new JSONObject();
        try {
            if (this.getId1() != null) {
                jsonObj.put("id1", this.getId1());
            }
            if (this.getId2() != null) {
                jsonObj.put("id2", this.getId2());
            }
            if (!TextUtils.isEmpty(getImg1())) {
                jsonObj.put("img1", this.getImg1());
            }
            if (!TextUtils.isEmpty(getImg2())) {
                jsonObj.put("img2", this.getImg2());
            }
            if (!TextUtils.isEmpty(getStatus())) {
                jsonObj.put("status", this.getStatus());
            }
            if (!TextUtils.isEmpty(getContent())) {
                jsonObj.put("content", this.getContent());
            }
            if (!TextUtils.isEmpty(getContent1())) {
                jsonObj.put("content1", this.getContent1());
            }
            if (!TextUtils.isEmpty(getContent2())) {
                jsonObj.put("content2", this.getContent2());
            }
            if (!TextUtils.isEmpty(getContent3())) {
                jsonObj.put("content3", this.getContent3());
            }
            if (!TextUtils.isEmpty(getContent4())) {
                jsonObj.put("content4", this.getContent4());
            }
            if (!TextUtils.isEmpty(this.getMsgUuid())) {
                jsonObj.put("msgUuid", this.getMsgUuid());
            }
            if (!TextUtils.isEmpty(this.getExtra())) {
                jsonObj.put("extra", this.getExtra());
            }

            if (this.getJSONUserInfo() != null) {
                jsonObj.putOpt("user", this.getJSONUserInfo());
            }

            if (this.getJsonMentionInfo() != null) {
                jsonObj.putOpt("mentionedInfo", this.getJsonMentionInfo());
            }
        } catch (JSONException var4) {
            RLog.e("MHPMessage", "JSONException " + var4.getMessage());
        }

        try {
            return jsonObj.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            return null;
        }
    }

//    private String getEmotion(String content) {
//        Pattern pattern = Pattern.compile("\\[/u([0-9A-Fa-f]+)\\]");
//        Matcher matcher = pattern.matcher(content);
//        StringBuffer sb = new StringBuffer();
//
//        while (matcher.find()) {
//            int inthex = Integer.parseInt(matcher.group(1), 16);
//            matcher.appendReplacement(sb, String.valueOf(Character.toChars(inthex)));
//        }
//
//        matcher.appendTail(sb);
//        return sb.toString();
//    }

    protected MHPMessage() {
    }


    public static MHPMessage obtain(Long id1,
                                    Long id2,
                                    String img1,
                                    String img2,
                                    String status,
                                    String content,
                                    String content1,
                                    String content2,
                                    String content3,
                                    String content4,
                                    String msgUuid) {
        MHPMessage model = new MHPMessage();
        model.setId1(id1);
        model.setId2(id2);
        model.setImg1(img1);
        model.setImg2(img2);
        model.setStatus(status);
        model.setContent(content);
        model.setContent1(content1);
        model.setContent2(content2);
        model.setContent3(content3);
        model.setContent4(content4);
        model.setMsgUuid(msgUuid);
        return model;
    }

    public MHPMessage(byte[] data) {
        String jsonStr = null;

        try {
            jsonStr = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException var5) {
            var5.printStackTrace();
        }

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            if (jsonObj.has("id1")) {
                this.setId1(jsonObj.optLong("id1"));
            }
            if (jsonObj.has("id2")) {
                this.setId2(jsonObj.optLong("id2"));
            }
            if (jsonObj.has("img1")) {
                this.setImg1(jsonObj.optString("img1"));
            }
            if (jsonObj.has("img2")) {
                this.setImg2(jsonObj.optString("img2"));
            }
            if (jsonObj.has("status")) {
                this.setStatus(jsonObj.optString("status"));
            }
            if (jsonObj.has("content")) {
                this.setContent(jsonObj.optString("content"));
            }
            if (jsonObj.has("content1")) {
                this.setContent1(jsonObj.optString("content1"));
            }
            if (jsonObj.has("content2")) {
                this.setContent2(jsonObj.optString("content2"));
            }
            if (jsonObj.has("content3")) {
                this.setContent3(jsonObj.optString("content3"));
            }
            if (jsonObj.has("content4")) {
                this.setContent4(jsonObj.optString("content4"));
            }
            if (jsonObj.has("msgUuid")) {
                this.setMsgUuid(jsonObj.optString("msgUuid"));
            }

            if (jsonObj.has("extra")) {
                this.setExtra(jsonObj.optString("extra"));
            }

            if (jsonObj.has("user")) {
                this.setUserInfo(this.parseJsonToUserInfo(jsonObj.getJSONObject("user")));
            }

            if (jsonObj.has("mentionedInfo")) {
                this.setMentionedInfo(this.parseJsonToMentionInfo(jsonObj.getJSONObject("mentionedInfo")));
            }
        } catch (JSONException var4) {
            RLog.e("MHPMessage", "JSONException " + var4.getMessage());
        }

    }

    public void setContent(String content) {
        this.content = content;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, this.id1);
        ParcelUtils.writeToParcel(dest, this.id2);
        ParcelUtils.writeToParcel(dest, this.img1);
        ParcelUtils.writeToParcel(dest, this.img2);
        ParcelUtils.writeToParcel(dest, this.status);
        ParcelUtils.writeToParcel(dest, this.content);
        ParcelUtils.writeToParcel(dest, this.content1);
        ParcelUtils.writeToParcel(dest, this.content2);
        ParcelUtils.writeToParcel(dest, this.content3);
        ParcelUtils.writeToParcel(dest, this.content4);
        ParcelUtils.writeToParcel(dest, this.msgUuid);
        ParcelUtils.writeToParcel(dest, this.getExtra());
        ParcelUtils.writeToParcel(dest, this.getUserInfo());
        ParcelUtils.writeToParcel(dest, this.getMentionedInfo());
    }

    public MHPMessage(Parcel in) {
        this.setId1(ParcelUtils.readLongFromParcel(in));
        this.setId2(ParcelUtils.readLongFromParcel(in));
        this.setImg1(ParcelUtils.readFromParcel(in));
        this.setImg2(ParcelUtils.readFromParcel(in));
        this.setStatus(ParcelUtils.readFromParcel(in));
        this.setContent(ParcelUtils.readFromParcel(in));
        this.setContent1(ParcelUtils.readFromParcel(in));
        this.setContent2(ParcelUtils.readFromParcel(in));
        this.setContent3(ParcelUtils.readFromParcel(in));
        this.setContent4(ParcelUtils.readFromParcel(in));
        this.setMsgUuid(ParcelUtils.readFromParcel(in));
        this.setExtra(ParcelUtils.readFromParcel(in));
        this.setUserInfo((UserInfo) ParcelUtils.readFromParcel(in, UserInfo.class));
        this.setMentionedInfo((MentionedInfo) ParcelUtils.readFromParcel(in, MentionedInfo.class));
    }

    public MHPMessage(Long id1,
                      Long id2,
                      String img1,
                      String img2,
                      String status,
                      String content,
                      String content1,
                      String content2,
                      String content3,
                      String content4,
                      String msgUuid) {
        this.setId1(id1);
        this.setId2(id2);
        this.setImg1(img1);
        this.setImg2(img2);
        this.setStatus(status);
        this.setContent(content);
        this.setContent1(content1);
        this.setContent2(content2);
        this.setContent3(content3);
        this.setContent4(content4);
        this.setMsgUuid(msgUuid);
    }

    public String getContent() {
        return this.content;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getMsgUuid() {
        return msgUuid;
    }

    public void setMsgUuid(String msgUuid) {
        this.msgUuid = msgUuid;
    }
}


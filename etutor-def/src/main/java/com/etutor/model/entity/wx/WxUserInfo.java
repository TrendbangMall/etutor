package com.etutor.model.entity.wx;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：Lion
 * @date ：2020/4/1 4:54 下午
 * @description ：
 */
@Data
public class WxUserInfo implements Serializable {
    private static final long serialVersionUID = 6719822331555402137L;

    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;

    public static WxUserInfo fromJson(String json) {
//        return WxGsonBuilder.create().fromJson(json, WxUserInfo.class);
        return null;
    }

    @Data
    public static class Watermark {
        private String timestamp;
        private String appid;
    }
}

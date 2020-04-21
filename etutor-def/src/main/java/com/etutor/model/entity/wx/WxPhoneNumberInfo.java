package com.etutor.model.entity.wx;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：Lion
 * @date ：2020/4/1 5:10 下午
 * @description ：
 */
@Data
public class WxPhoneNumberInfo implements Serializable {
    private static final long serialVersionUID = 6719822331555402137L;

    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    private Watermark watermark;

    public static WxPhoneNumberInfo fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxPhoneNumberInfo.class);
    }

    @Data
    public static class Watermark {
        private String timestamp;
        private String appid;
    }
}

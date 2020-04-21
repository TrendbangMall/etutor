package com.etutor.model.entity.wx;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author ：Lion
 * @date ：2020/3/31 4:42 下午
 * @description ：
 */
@Data
public class WxSessionResult {
    private static final long serialVersionUID = -1060216618475607933L;

    @SerializedName("session_key")
    private String sessionKey;

    @SerializedName("openid")
    private String openid;

    @SerializedName("unionid")
    private String unionid;

    public static WxSessionResult fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxSessionResult.class);
    }
}

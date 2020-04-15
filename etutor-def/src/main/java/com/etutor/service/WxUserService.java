package com.etutor.service;

import com.alibaba.fastjson.JSONObject;
import com.etutor.model.entity.wx.*;

/**
 * @author Winter
 */
public interface WxUserService {

    /**
     * 授权, 返回token.
     *
     * @param jsCode 登录时获取的 code
     */
    WeixinUserDO impower(String jsCode);

    /**
     * 获取登录后的 openid, unionid, session信息.
     *
     * @param jsCode 登录时获取的 code
     */
    WxSessionResult jsCode2Session(String jsCode);

    /**
     * 获取微信用户信息
     * @param jsonObject json
     */
    WxUserInfo getUserInfo(JSONObject jsonObject);

    /**
     * 获取手机信息
     * @param jsonObject json
     */
    WxPhoneNumberInfo getPhone(JSONObject jsonObject);

    WeixinUserDO getWeixinUser(String openId);

    WeixinUserDO getWeixinUserBySession(String sessionKey);

    boolean checkSessionKey(String sessionKey);

    boolean updateUserInfo(WeixinUserDTO weixinUserDTO);


    /**
     * 通过userId获取微信用户
     *
     * @param userId
     * @return
     */
    WeixinUserDO getWeixinUserByUserId(long userId);
}

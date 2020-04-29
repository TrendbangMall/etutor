package com.etutor.wx.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.etutor.common.CommonConstant;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.model.entity.wx.*;
import com.etutor.service.UserInfoService;
import com.etutor.service.WxUserService;
import com.etutor.utils.WxUtils;
import com.etutor.wx.dao.WeixinUserDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WxUserServiceImpl implements WxUserService {

    /**
     * wx.appid=wx2b83354dcd945f86
     * wx.secret: f554555a6cbc562cc00f3567b3540a21
     * wx.code2sessionUrl: http
     */
    private String appid = "wx2b83354dcd945f86";

    private String secret = "f554555a6cbc562cc00f3567b3540a21";

    private String code2sessionUrl = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private UserInfoService userService;

    @Autowired
    private WeixinUserDAO weixinUserDAO;

    @Override
    public WeixinUserDO impower(String jsCode) {
        WxSessionResult sessionResult = jsCode2Session(jsCode);
        // 校验数据库是否保存了该用户
        WeixinUserDO checkDo = weixinUserDAO.getUserByOpenId(sessionResult.getOpenid());
        // 未注册过
        if (checkDo == null) {
            // 只有在创建团队的时候才创建User; 这里只创建WeixinUser
            WeixinUserDO weixinUserDO = new WeixinUserDO();
            setWeixinUser(weixinUserDO, sessionResult);
            weixinUserDAO.addUser(weixinUserDO);
            String sessionKey = sessionResult.getSessionKey();
            if (checkSessionkey(sessionKey)) {
                String token = userService.createToken(-1L, -1L, sessionKey, CommonConstant.TOKEN_WECHAT);
                weixinUserDO.setToken(token);
                return weixinUserDO;
            }
            return null;
        } else {
            String sessionKey = sessionResult.getSessionKey();
            // 已经登录过, 查询sessionKey
            if (checkSessionkey(sessionKey)) {
                // 获取User, 来获取默认团队
                Long teamId = -1L;
                UserInfoDO userDo = userService.getUserById(checkDo.getUserId());
                String token = userService.createToken(teamId, checkDo.getUserId(), sessionKey, CommonConstant.TOKEN_WECHAT);
                checkDo.setToken(token);
                // 更新最新的session信息到库里
                setWeixinUser(checkDo, sessionResult);
                weixinUserDAO.updateUser(checkDo);
                return checkDo;
            }
            return null;
        }
    }

    @Override
    public WxSessionResult jsCode2Session(String jsCode) {

        Map<String, Object> params = new HashMap<>(8);
        params.put("appid", appid);
        params.put("secret", secret);
        params.put("js_code", jsCode);
        params.put("grant_type", "authorization_code");
        String result = HttpUtil.get(code2sessionUrl, params);
        /*WxSessionResult wxSessionResult = new WxSessionResult();
        wxSessionResult.setUnionid(null);
        wxSessionResult.setOpenid("BeO1Ol7u6");
        wxSessionResult.setSessionKey("0230YVx61RlBeO1Ol7u61SWTx610YVxX");
        return wxSessionResult;*/
        return WxSessionResult.fromJson(result);
    }

    @Override
    public WxUserInfo getUserInfo(JSONObject jsonObject) {

        String sessionKey = jsonObject.getString("sessionKey");
        String encryptedData = jsonObject.getString("encryptedData");
        String iv = jsonObject.getString("iv");
        WeixinUserDO checkDo = weixinUserDAO.getUserBySessionKey(sessionKey);
        WxUserInfo wxUserInfo = WxUserInfo.fromJson(WxUtils.decrypt(sessionKey, encryptedData, iv));
        setWeixinUser(checkDo, wxUserInfo);
        weixinUserDAO.updateUser(checkDo);
        return wxUserInfo;
    }

    @Override
    public WxPhoneNumberInfo getPhone(JSONObject jsonObject) {
        String sessionKey = jsonObject.getString("sessionKey");
        String encryptedData = jsonObject.getString("encryptedData");
        String iv = jsonObject.getString("iv");
        WeixinUserDO checkDo = weixinUserDAO.getUserBySessionKey(sessionKey);
        WxPhoneNumberInfo wxPhoneNumberInfo = WxPhoneNumberInfo.fromJson(WxUtils.decrypt(sessionKey, encryptedData, iv));
        setWeixinUser(checkDo, wxPhoneNumberInfo);
        weixinUserDAO.updateUser(checkDo);
        return wxPhoneNumberInfo;
    }

    @Override
    public WeixinUserDO getWeixinUser(String openId) {
        return weixinUserDAO.getUserByOpenId(openId);
    }

    @Override
    public WeixinUserDO getWeixinUserBySession(String sessionKey) {
        return weixinUserDAO.getUserBySessionKey(sessionKey);
    }

    @Override
    public boolean checkSessionKey(String sessionKey) {

        WeixinUserDO checkDo = weixinUserDAO.getUserBySessionKey(sessionKey);
        return checkDo != null;
    }

    @Override
    public boolean updateUserInfo(WeixinUserDTO weixinUserDTO) {

        WeixinUserDO weixinUserDO = new WeixinUserDO();
        weixinUserDO.setSubscribe(weixinUserDTO.getSubscribe());
        weixinUserDO.setSubscribeTime(weixinUserDTO.getSubscribeTime());
        weixinUserDO.setUserId(weixinUserDTO.getUserId());
        return weixinUserDAO.updateUser(weixinUserDO) > 0;
    }

    @Override
    public WeixinUserDO getWeixinUserByUserId(long userId) {
        return weixinUserDAO.getUserByUserId(userId);
    }

    private boolean setWeixinUser(WeixinUserDO weixinUserDO, WxSessionResult sessionResult) {
        return setWeixinUser(weixinUserDO,sessionResult,null,null);
    }

    private boolean setWeixinUser(WeixinUserDO weixinUserDO, WxPhoneNumberInfo phoneInfo) {
        return setWeixinUser(weixinUserDO,null,phoneInfo,null);
    }

    private boolean setWeixinUser(WeixinUserDO weixinUserDO, WxUserInfo wxUserInfo) {
        return setWeixinUser(weixinUserDO,null,null,wxUserInfo);
    }

    private boolean setWeixinUser(WeixinUserDO weixinUserDO, WxSessionResult sessionResult, WxPhoneNumberInfo phoneInfo, WxUserInfo wxUserInfo) {
        // 将微信UserInfo信息封装
        if (wxUserInfo != null) {
            weixinUserDO.setOpenId(wxUserInfo.getOpenId());
            weixinUserDO.setNickName(wxUserInfo.getNickName());
            weixinUserDO.setGender(Integer.parseInt(wxUserInfo.getGender()));
            weixinUserDO.setLanguage(wxUserInfo.getLanguage());
            weixinUserDO.setCity(wxUserInfo.getCity());
            weixinUserDO.setProvince(wxUserInfo.getProvince());
            weixinUserDO.setCountry(wxUserInfo.getCountry());
            weixinUserDO.setAvatarUrl(wxUserInfo.getAvatarUrl());
            weixinUserDO.setUnionId(wxUserInfo.getUnionId() == null ? "" : wxUserInfo.getUnionId());
        }
        // 将手机信息封装
        if (phoneInfo != null) {
            weixinUserDO.setMobile(phoneInfo.getPhoneNumber());
        }
        // 将小程序sessionKey封装
        if (sessionResult != null) {
            weixinUserDO.setSessionKey(sessionResult.getSessionKey() == null ? "" : sessionResult.getSessionKey());
            // 这里也可能要更新openId 和 unionId
            weixinUserDO.setOpenId(sessionResult.getOpenid() == null ? "" : sessionResult.getOpenid());
            weixinUserDO.setUnionId(sessionResult.getUnionid() == null ? "" : sessionResult.getUnionid());
        }
        // TODO 还剩 subscribe, weixinGhId, userId
        return true;
    }

    private boolean checkSessionkey(String sessionKey) {
        return StringUtils.isNoneEmpty(sessionKey);
    }
}

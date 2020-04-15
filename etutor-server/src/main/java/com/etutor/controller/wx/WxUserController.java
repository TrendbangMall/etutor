package com.etutor.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.etutor.annotation.LoginCheck;
import com.etutor.constant.LoginConstant;
import com.etutor.model.entity.wx.WeixinUserDO;
import com.etutor.model.entity.wx.WxPhoneNumberInfo;
import com.etutor.model.entity.wx.WxSessionResult;
import com.etutor.model.entity.wx.WxUserInfo;
import com.etutor.response.Result;
import com.etutor.service.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：Winter
 * @date ：2020/4/1 11:24 上午
 * @description ：
 */
@Slf4j
@RestController
@RequestMapping("/wxapi/user")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    /**
     * 小程序授权 (相当于登录或者注册)
     */
    @LoginCheck(LoginConstant.UN_CHECK)
    @RequestMapping("/impower.json")
    public Result<WeixinUserDO> impower(@RequestBody JSONObject json) {
        WeixinUserDO token =  wxUserService.impower(json.getString("jsCode"));
        return Result.success(token);
    }

    /**
     * 获取sessionKey,openid,unionid
     * jsCode
     */
    @LoginCheck(LoginConstant.UN_CHECK)
    @RequestMapping("/jsCode2Session.json")
    public Result<WxSessionResult> jsCode2Session(@RequestBody JSONObject json) {
        WxSessionResult sessionResult =  wxUserService.jsCode2Session(json.getString("jsCode"));
        return Result.success(sessionResult);
    }

    /**
     * 获取微信用户信息
     * sessionKey 会话密钥; encryptedData 消息密文; iv 加密算法的初始向量
     */
    @LoginCheck(LoginConstant.UN_CHECK)
    @RequestMapping("/getUserInfo.json")
    public Result<WxUserInfo> getUserInfo(@RequestBody JSONObject json) {
        WxUserInfo userInfo =  wxUserService.getUserInfo(json);
        return Result.success(userInfo);
    }

    /**
     * 获取手机信息
     * sessionKey 会话密钥; encryptedData 消息密文; iv 加密算法的初始向量
     */
    @LoginCheck(LoginConstant.UN_CHECK)
    @RequestMapping("/getPhone.json")
    public Result<WxPhoneNumberInfo> getPhone(@RequestBody JSONObject json) {
        WxPhoneNumberInfo phone =  wxUserService.getPhone(json);
        return Result.success(phone);
    }

}

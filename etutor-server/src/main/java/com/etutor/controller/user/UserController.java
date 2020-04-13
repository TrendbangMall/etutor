package com.etutor.controller.user;

import com.etutor.dto.UserDTO;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.response.ResultCode;
import com.etutor.service.UserInfoService;
import com.etutor.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author winter
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 插入用户
     *
     * @param userInfoDO
     * @return
     */
    @RequestMapping("/register")
    public Result insertUserService(@RequestBody UserInfoDO userInfoDO) {
        long id = userInfoService.insertUser(userInfoDO);
        if (id > 0) {
            return Result.success("保存成功" );
        } else {
            return Result.failed("保存失败");
        }
    }


    /**
     * 手机登录
     */
    @PostMapping("/loginByCode.json")
    public Result<Object> loginByCode(@RequestBody UserDTO userDTO, HttpServletRequest request) {
//        if (!geeTestValid.validGeeTestCaptcha(userDTO.getChallenge(), userDTO.getValidate(), userDTO.getSeccode(),
//                IPUtils.getIpAddr(request))) {
//            return Result.failed(ResultCode.FAIL.getCode(), "非法请求", null);
//        }
        String result = userInfoService.loginByPhone(userDTO);
        Map<String, String> map = new HashMap<>();
        map.put("token", result);
        return Result.success(map);
    }

    /**
     * 手机注册
     */
    @PostMapping("/registerByCode.json")
    public Result<Object> registerByCode(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        // 校验极验
//        if (!geeTestValid.validGeeTestCaptcha(userDTO.getChallenge(), userDTO.getValidate(), userDTO.getSeccode(),
//                IPUtils.getIpAddr(request))) {
//            return Result.failed(ResultCode.FAIL.getCode(), "非法请求", null);
//        }
        Map<String, String> map = new HashMap<>();
        String result = userInfoService.registerByPhone(userDTO);
        map.put("token", result);
        return Result.success(map);
    }

}

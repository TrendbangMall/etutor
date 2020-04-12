package com.etutor.controller.user;

import com.etutor.model.UserInfoDO;
import com.etutor.model.service.UserInfoService;
import com.etutor.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/getUser")
    public Result getUserInfo(@RequestParam long id) {
        UserInfoDO userInfoDO = userInfoService.getUserInfoById(id);
        return Result.success(userInfoDO);
    }
}

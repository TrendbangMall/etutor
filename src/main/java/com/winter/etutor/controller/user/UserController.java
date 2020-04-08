package com.winter.etutor.controller.user;

import com.winter.etutor.bean.BaseResult;
import com.winter.etutor.bean.UserInfoDO;
import com.winter.etutor.service.user.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public BaseResult insertUserService(@RequestBody UserInfoDO userInfoDO) {
        long rowCount = userInfoService.insertUser(userInfoDO);
        if (rowCount > 0) {
            return BaseResult.createSuccess("保存成功" );
        } else {
            return BaseResult.createFailure("保存失败");
        }
    }
}

package com.winter.etutor.user;

import com.winter.etutor.EtutorApplication;
import com.winter.etutor.bean.UserInfoDO;
import com.winter.etutor.service.user.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends EtutorApplication {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void insertUser() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setName("宋东东" );
        userInfoDO.setAge(25);
        userInfoDO.setIcon("icon" );
        userInfoDO.setNickname("北极星" );
        userInfoDO.setSex(1);
        userInfoDO.setBreakingValue(0);
        long id = userInfoService.insertUser(userInfoDO);
        System.out.println(id);
    }
}

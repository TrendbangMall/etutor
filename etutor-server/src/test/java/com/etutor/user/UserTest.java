package com.etutor.user;

import com.etutor.EtutorServerApplicationTests;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends EtutorServerApplicationTests {

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

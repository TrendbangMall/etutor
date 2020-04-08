package com.winter.etutor.user;

import com.alibaba.fastjson.JSON;
import com.winter.etutor.bean.UserInfoDO;
import org.junit.Test;

public class JavaCodeTest {

    @Test
    public void getJson() {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setName("宋东东" );
        userInfoDO.setAge(25);
        userInfoDO.setIcon("icon" );
        userInfoDO.setNickname("北极星" );
        userInfoDO.setSex(1);
        userInfoDO.setBreakingValue(0);

        String s = JSON.toJSONString(userInfoDO);
        System.out.println(s);
    }
}

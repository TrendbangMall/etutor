package com.etutor.user;

import com.etutor.EtutorServerApplicationTests;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.service.UserInfoService;
import com.etutor.utils.RedisUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends EtutorServerApplicationTests {

    @Autowired
    private RedisUtil redis;

    @Test
    public void redis() {
    	redis.get("hhha");
        System.out.println("");
    }
}

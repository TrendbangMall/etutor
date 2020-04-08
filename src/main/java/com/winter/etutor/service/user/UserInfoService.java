package com.winter.etutor.service.user;

import com.winter.etutor.bean.UserInfoDO;

/**
 * @author winter
 */
public interface UserInfoService {

    /**
     * 插入用户
     *
     * @param userInfoDO
     * @return
     */
    long insertUser(UserInfoDO userInfoDO);
}

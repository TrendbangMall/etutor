package com.etutor.model.service;

import com.etutor.model.UserInfoDO;

/**
 * @author winter
 */
public interface UserInfoService {

    /**
     * 插入用户
     * @param userInfoDO
     * @return
     */
    long insertUser(UserInfoDO userInfoDO);
}

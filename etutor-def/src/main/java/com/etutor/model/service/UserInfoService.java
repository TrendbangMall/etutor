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

    /**
     * 通过Id获取用户
     * @param id
     * @return
     */
    UserInfoDO getUserInfoById(long id);
}

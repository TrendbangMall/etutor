package com.etutor.service;

import com.etutor.dto.UserInfoDTO;
import com.etutor.model.entity.UserInfoDO;

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

    /**
     * 手机注册
     * @param userInfoDTO 用户信息
     */
    void registerByPhone(UserInfoDTO userInfoDTO);

    /**
     * 手机登录
     * @param userInfoDTO 用户信息
     */
    void loginByPhone(UserInfoDTO userInfoDTO);
}

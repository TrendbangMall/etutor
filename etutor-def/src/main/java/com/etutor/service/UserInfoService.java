package com.etutor.service;

import com.etutor.dto.UserDTO;
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
     * 手机注册
     * @return 结果
     */
    String registerByPhone(UserDTO userDTO);

    /**
     * 手机登录
     */
    String loginByPhone(UserDTO userDTO);

    /**
     * 创建团队的时候, 创建token
     * @return 结果
     */
    String createToken(long userId);
}

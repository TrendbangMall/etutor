package com.etutor.service;

import com.etutor.model.dto.UserDTO;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.model.vo.UserInfoVO;

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

    /**
     * 手机注册
     *
     * @return 结果
     */
    String registerByPhone(UserDTO userDTO);

    /**
     * 手机登录
     */
    String loginByPhone(UserDTO userDTO);


    /**
     * 通过token获取USER信息
     *
     * @param token
     * @return
     */
    UserInfoVO getUserInfoByToken(String token);


    /**
     * 创建token
     *
     * @return 结果
     */
    String createToken(long userId);

    /**
     * 其他平台, 创建token
     * @return 结果
     */
    String createToken(Long teamId, Long userId, String systemCode, Integer tokenType);

    UserInfoDO getUserById(long userId);

    UserInfoVO getUserInfoBySessionKey(String sessionKey);
}

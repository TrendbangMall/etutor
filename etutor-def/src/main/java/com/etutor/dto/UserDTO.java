package com.etutor.dto;

import lombok.Data;

/**
 * @author winter
 */
@Data
public class UserDTO{

    /**
     * 手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 团队id
     */
    private Long teamId;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 验证码
     */
    private String code;


}
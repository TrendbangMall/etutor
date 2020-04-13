package com.etutor.model.dto;

import lombok.Data;


/**
 * 用户
 * @author Winter
 */
@Data
public class UserInfoDTO {

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
     * 用户Id
     */
    private Long userId;
    /**
     * 验证码
     */
    private String code;


}
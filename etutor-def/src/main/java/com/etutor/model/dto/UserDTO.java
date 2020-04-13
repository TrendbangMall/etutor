package com.etutor.model.dto;

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
     * 用户Id
     */
    private Long userId;
    /**
     * 验证码
     */
    private String code;


}
package com.etutor.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Winter
 */
@Data
public class UserInfoVO {

    /**
     * 主键
     */
    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 1 男, 2女
     */
    private int sex;

    /**
     * 年龄
     */
    private int age;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 爆料值
     */
    private int breakingValue;

    /**
     * 手机号
     */
    private String phone;

    private String token;
}

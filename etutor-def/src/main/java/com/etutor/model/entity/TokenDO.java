package com.etutor.model.entity;

import lombok.Data;

import java.util.Date;


/**
 * 用户
 * @author huangyuan
 * @since 1.0 2019-12-24
 */
@Data
public class TokenDO {

    /**
     * 自增id
     */
    private Long id;
    /**
     * token
     */
    private String token;
    /**
     * userId
     */
    private Long userId;
    /**
     * 过期时间
     */
    private Date exprTime;
    /**
     * 增添时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态
     */
    private int status;

}
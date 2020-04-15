package com.etutor.model.entity.wx;

import lombok.Data;

import java.util.Date;

/**
 * @author ：Lion
 * @date ：2020/4/1 4:54 下午
 * @description ：
 */
@Data
public class WeixinUserDO {

    private Long id;
    private Long userId = -1L;
    private String subscribe = "0";
    private Long subscribeTime = 0L;
    private Date addTime = new Date();
    private Date updateTime = new Date();

    private String mobile = "";
    private String sessionKey = "";
    private String weixinGhId = "";


    //  ======  小程序userInfo字段 ======
    private String openId = "";
    private String nickName = "";
    private Integer gender = 0;
    private String language = "";
    private String city = "";
    private String province = "";
    private String country = "";
    private String avatarUrl = "";
    private String unionId = "";

    private String token;

}

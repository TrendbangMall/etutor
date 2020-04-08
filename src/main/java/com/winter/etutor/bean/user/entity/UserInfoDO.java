package com.winter.etutor.bean.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表
 *
 * @author winter
 * @since 1.0 2020-04-08
 */
@Data
public class UserInfoDO {

	
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
	private int phone;
}
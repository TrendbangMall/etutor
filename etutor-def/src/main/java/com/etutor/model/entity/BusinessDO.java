package com.etutor.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class BusinessDO {

		/**
	* 商家_id
 	*/
	private int id;
		/**
	* 商家名称
 	*/
	private String name;
		/**
	* 商家电话
 	*/
	private long phone;
		/**
	* 省
 	*/
	private String province;
		/**
	* 市
 	*/
	private String city;
		/**
	* 区
 	*/
	private String region;
		/**
	* 详细地址
 	*/
	private String addressFull;
		/**
	* 商家是否认证
 	*/
	private int isAuth;
		/**
	* 商家评分
 	*/
	private BigDecimal businessScore;
		/**
	* 经度
 	*/
	private BigDecimal lon;
		/**
	* 纬度
 	*/
	private BigDecimal lat;
		/**
	* 商家logo
 	*/
	private String businessLogo;
		/**
	* 
 	*/
	private Date addTime;
		/**
	* 
 	*/
	private Date updateTime;
	
}
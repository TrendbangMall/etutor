package com.etutor.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class CourseDO {

		/**
	* 课程_id
 	*/
	private long id;
		/**
	* 课程大类名称
 	*/
	private long type;
		/**
	* 课程标题
 	*/
	private String name;
		/**
	* 课程人数
 	*/
	private long number;
		/**
	* 原价
 	*/
	private long price;
		/**
	* 简介
 	*/
	private String briefInfo;
		/**
	* 视频时长(秒)
 	*/
	private long videoDuration;
		/**
	* 课程主图_id
 	*/
	private long mainPictureId;
		/**
	* 开始日期
 	*/
	private Date startDate;
		/**
	* 结束日期
 	*/
	private Date endDate;
		/**
	* 课程节数
 	*/
	private long courseNumber;
		/**
	* 上课地址
 	*/
	private String courseAddress;
		/**
	* 商家_id
 	*/
	private long businessId;
		/**
	* 添加时间
 	*/
	private Date addTime;
		/**
	* 最后更新时间
 	*/
	private Date updateTime;
	
}
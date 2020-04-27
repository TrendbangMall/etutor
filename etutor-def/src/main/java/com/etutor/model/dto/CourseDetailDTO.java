package com.etutor.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class CourseDetailDTO {

		/**
	* 课程明细id
 	*/
	private long id;
		/**
	* 课程_id
 	*/
	private long courseId;
		/**
	* 开始时间（日期+时间）
 	*/
	private Date startTime;
		/**
	* 结束时间（同上）
 	*/
	private Date endTime;
		/**
	* 老师名称
 	*/
	private String teacher;
		/**
	* 上课地址
 	*/
	private String courseAddress;
		/**
	* 课程价格
 	*/
	private BigDecimal price;
		/**
	* 拼团价格
 	*/
	private String assemblePrice;
		/**
	* 添加时间
 	*/
	private Date addTime;
		/**
	* 最后更新时间
 	*/
	private Date updateTime;
	
}
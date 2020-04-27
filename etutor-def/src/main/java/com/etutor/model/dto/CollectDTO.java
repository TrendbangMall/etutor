package com.etutor.model.dto;

import lombok.Data;

import java.util.Date;


/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class CollectDTO {

		/**
	* 主键
 	*/
	private long id;
		/**
	* 
 	*/
	private int type;
		/**
	* 
 	*/
	private long userId;
		/**
	* 
 	*/
	private long relationId;
		/**
	* 开始时间
 	*/
	private Date addTime;
		/**
	* 结束时间
 	*/
	private Date updateTime;
	
}
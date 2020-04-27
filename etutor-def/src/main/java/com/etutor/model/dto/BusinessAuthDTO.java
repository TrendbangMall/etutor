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
public class BusinessAuthDTO {

		/**
	* 主键
 	*/
	private long id;
		/**
	* 
 	*/
	private long businessId;
		/**
	* 
 	*/
	private String authFile;
		/**
	* 
 	*/
	private Date authFileUploadTime;
		/**
	* 
 	*/
	private String checkName;
		/**
	* 
 	*/
	private String checkOpinion;
		/**
	* 
 	*/
	private Date checkTime;
		/**
	* 
 	*/
	private int isApprove;
		/**
	* 开始时间
 	*/
	private Date addTime;
		/**
	* 结束时间
 	*/
	private Date updateTime;
	
}
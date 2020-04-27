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
public class CommentDTO {

		/**
	* 
 	*/
	private long id;
		/**
	* 专业技能分
 	*/
	private int scoreSkills;
		/**
	* 服务态度分
 	*/
	private int scoreService;
		/**
	* 有耐心分
 	*/
	private int scorePatience;
		/**
	* 价格实惠分
 	*/
	private int scorePrice;
		/**
	* 评论内容
 	*/
	private String content;
		/**
	* 课程明细id
 	*/
	private long courseDetailId;
		/**
	* 评论人
 	*/
	private long courseCommentUserId;
		/**
	* 评论时间
 	*/
	private Date courseCommentTime;
		/**
	* 图片
 	*/
	private String file;
		/**
	* 添加时间
 	*/
	private Date addTime;
		/**
	* 更新时间
 	*/
	private Date updateTime;
	
}
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
public class OrderDO {

		/**
	* 订单_id
 	*/
	private int id;
		/**
	* 拼团_id
 	*/
	private int assembleId;
		/**
	* 课程id
 	*/
	private int courseId;
		/**
	* 订单价格
 	*/
	private BigDecimal orderPrice;
		/**
	* 下单时间
 	*/
	private Date orderTime;
		/**
	* 订单编号
 	*/
	private long orderNumber;
		/**
	* 订单状态
 	*/
	private int orderState;
		/**
	* 取消原因
 	*/
	private String cancelReason;
		/**
	* 取消时间
 	*/
	private Date cancelTime;
		/**
	* 团购券编码
 	*/
	private String groupPurchaseCode;
		/**
	* 
 	*/
	private Date addTime;
		/**
	* 
 	*/
	private Date updateTime;
	
}
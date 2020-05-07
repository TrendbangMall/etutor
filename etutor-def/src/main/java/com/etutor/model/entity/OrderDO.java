package com.etutor.model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDO {
	
	private Long id;
	
    /**
     * 增添时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    private Date cancleTime;
    /**
     * 状态
     */
    private int status;

}

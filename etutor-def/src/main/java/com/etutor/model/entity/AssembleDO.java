package com.etutor.model.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class AssembleDO {

    /**
     * 拼团信息_id
     */
    private int id;
    /**
     * 拼团类型(课程,活动)
     */
    private int type;
    /**
     * 关系ID
     */
    private int relationId;
    /**
     * 开始时间（日期+时间）
     */
    private Date startTime;
    /**
     * 结束时间（同上）
     */
    private Date endTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 拼团人数
     */
    private int number;
    /**
     * 发起人
     */
    private int ownerId;
    /**
     * 是否取消(-1取消, 0, 正在进行, 1拼团成功)
     */
    private int status;
    /**
     * 取消时间
     */
    private Date cancelTime;
    /**
     *
     */
    private Date addTime;
    /**
     *
     */
    private Date updateTime;

}
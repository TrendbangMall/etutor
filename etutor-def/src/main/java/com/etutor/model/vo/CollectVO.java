package com.etutor.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author winter
 * @since 1.0 2020-04-28
 */
@Data
public class CollectVO implements Serializable {

    private static final long serialVersionUID = 104850269338354272L;


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
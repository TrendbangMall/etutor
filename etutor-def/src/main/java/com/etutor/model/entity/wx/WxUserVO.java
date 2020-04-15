package com.etutor.model.entity.wx;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: pangshaonning
 * @date: 2020/4/1
 */
@Data
public class WxUserVO implements Serializable {

    private static final long serialVersionUID = -4573304547097556217L;

    /**
     * 员工id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职位
     */
    private String position;
    /**
     * 部门名称
     */
    private String className;
    /**
     * 是否超级管理员
     */
    private boolean isSuperMana;
    /**
     * 管理员
     */
    private boolean isMana;
    /**
     * 待审核数量
     */
    private Integer approvalCount;
    /**
     * 是否多团队
     */
    private Boolean hasMoreTeam;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 是否需要审核
     */
    private Boolean isAudited;
}

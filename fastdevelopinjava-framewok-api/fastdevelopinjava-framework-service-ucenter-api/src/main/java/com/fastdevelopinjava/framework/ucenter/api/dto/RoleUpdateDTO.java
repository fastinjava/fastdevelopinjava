package com.fastdevelopinjava.framework.ucenter.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleUpdateDTO
        implements Serializable {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 是否删除
     */
    private String deleteFlag;

    private Date creatTime;

    private Date updateTime;


}

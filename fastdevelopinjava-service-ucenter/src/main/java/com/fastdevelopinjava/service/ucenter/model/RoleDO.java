package com.fastdevelopinjava.service.ucenter.model;

import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

public class RoleDO implements Serializable {
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


    public RoleDO() {
    }

    public RoleDO(Integer id, String roleName, String roleCode, String roleDesc , String deleteFlag) {
        this.id = id;
        this.roleName = roleName;
        this.roleCode = roleCode;
        this.roleDesc = roleDesc;
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
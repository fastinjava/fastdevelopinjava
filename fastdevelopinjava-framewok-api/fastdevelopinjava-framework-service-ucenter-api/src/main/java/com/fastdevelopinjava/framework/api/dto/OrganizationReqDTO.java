package com.fastdevelopinjava.framework.api.dto;

import java.util.Date;

public class OrganizationReqDTO {

    //默认分页，第一页
    private Integer pageNum = 0;
    //默认分页大小 10
    private Integer pageSize = 10;
    //默认分页
    private Boolean pageable = true;

    /**
    * 组织id
    */
    private Integer orgId;

    /**
    * 组织父id
    */
    private Integer orgPid;

    /**
    * 组织名称
    */
    private String orgName;

    /**
    * 组织编码
    */
    private String orgCode;

    /**
    * 组织描述
    */
    private String orgDesc;

    /**
    * 是否删除
    */
    private String deleteFlag;

    private Date creatTime;

    private Date updateTime;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getPageable() {
        return pageable;
    }

    public void setPageable(Boolean pageable) {
        this.pageable = pageable;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(Integer orgPid) {
        this.orgPid = orgPid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
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
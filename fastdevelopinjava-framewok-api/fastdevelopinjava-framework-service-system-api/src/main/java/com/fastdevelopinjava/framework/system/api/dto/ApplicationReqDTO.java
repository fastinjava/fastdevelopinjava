package com.fastdevelopinjava.framework.system.api.dto;

import java.io.Serializable;
import java.util.Date;

public class ApplicationReqDTO implements Serializable {


    //默认分页，第一页
    private Integer pageNum = 0;
    //默认分页大小 10
    private Integer pageSize = 10;
    //默认分页
    private Boolean pageable = true;

    /**
     * app id
     */
    private Integer appId;

    /**
     * app名称
     */
    private String appName;

    /**
     * app编码
     */
    private String appCode;

    /**
     * app描述
     */
    private String appDesc;

    /**
     * app类型,1=application 2=service
     */
    private String appType;

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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
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
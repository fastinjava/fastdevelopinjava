package com.fastdevelopinjava.framework.system.api.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class ApplicationDeleteDTO {
    /**
     * app id
     */


    @NotBlank(message = "删除应用appId缺失")
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


    public ApplicationDeleteDTO() {
    }

    public ApplicationDeleteDTO(Integer appId, String appName, String appCode, String appDesc, String appType, String deleteFlag, Date creatTime, Date updateTime) {
        this.appId = appId;
        this.appName = appName;
        this.appCode = appCode;
        this.appDesc = appDesc;
        this.appType = appType;
        this.deleteFlag = deleteFlag;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
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
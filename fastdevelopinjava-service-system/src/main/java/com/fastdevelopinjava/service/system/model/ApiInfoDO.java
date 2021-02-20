package com.fastdevelopinjava.service.system.model;

import java.util.Date;

public class ApiInfoDO {
    /**
     * api id
     */
    private Integer apiId;

    /**
     * 接口编码
     */
    private String apiCode;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口描述
     */
    private String apiDesc;

    /**
     * 应用id
     */
    private Integer appId;

    /**
     * 是否需要授权才能访问
     */
    private String needAuth;

    /**
     * 是否删除
     */
    private String deleteFlag;

    private Date creatTime;

    private Date updateTime;

    /**
     * url
     */
    private String apiUrl;


    public ApiInfoDO() {
    }

    public ApiInfoDO(Integer apiId, String apiCode, String apiName, String apiDesc, Integer appId, String needAuth, String deleteFlag, Date creatTime, Date updateTime, String apiUrl) {
        this.apiId = apiId;
        this.apiCode = apiCode;
        this.apiName = apiName;
        this.apiDesc = apiDesc;
        this.appId = appId;
        this.needAuth = needAuth;
        this.deleteFlag = deleteFlag;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
        this.apiUrl = apiUrl;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiDesc() {
        return apiDesc;
    }

    public void setApiDesc(String apiDesc) {
        this.apiDesc = apiDesc;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getNeedAuth() {
        return needAuth;
    }

    public void setNeedAuth(String needAuth) {
        this.needAuth = needAuth;
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

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
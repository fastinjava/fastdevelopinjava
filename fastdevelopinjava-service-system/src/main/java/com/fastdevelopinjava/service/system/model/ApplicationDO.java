package com.fastdevelopinjava.service.system.model;

import java.util.Date;

public class ApplicationDO {
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

    /**
     * 是否支持https，0不支持1支持，默认为0不支持
     */
    private Integer appHttps;

    /**
     * ip或者主机名
     */
    private String appHost;

    /**
     * 资源前缀
     */
    private String appContext;

    /**
     * 端口号
     */
    private Integer appPort;

    private Date creatTime;

    private Date updateTime;

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

    public Integer getAppHttps() {
        return appHttps;
    }

    public void setAppHttps(Integer appHttps) {
        this.appHttps = appHttps;
    }

    public String getAppHost() {
        return appHost;
    }

    public void setAppHost(String appHost) {
        this.appHost = appHost;
    }

    public String getAppContext() {
        return appContext;
    }

    public void setAppContext(String appContext) {
        this.appContext = appContext;
    }

    public Integer getAppPort() {
        return appPort;
    }

    public void setAppPort(Integer appPort) {
        this.appPort = appPort;
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
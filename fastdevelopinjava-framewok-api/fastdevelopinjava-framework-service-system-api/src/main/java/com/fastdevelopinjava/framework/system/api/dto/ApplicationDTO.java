package com.fastdevelopinjava.framework.system.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ApplicationDTO implements Serializable {
    private Integer appId;
    private String appName;
    private String appCode;
    private String appDesc;
    private String appType;
    private String deleteFlag;
    private Integer appHttps;
    private String appHost;
    private String appContext;
    private Integer appPort;
    private Date creatTime;
    private Date updateTime;

    public ApplicationDTO() {
    }

    public ApplicationDTO(Integer appId, String appName, String appCode, String appDesc, String appType, String deleteFlag, Date creatTime, Date updateTime) {
        this.appId = appId;
        this.appName = appName;
        this.appCode = appCode;
        this.appDesc = appDesc;
        this.appType = appType;
        this.deleteFlag = deleteFlag;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }


}
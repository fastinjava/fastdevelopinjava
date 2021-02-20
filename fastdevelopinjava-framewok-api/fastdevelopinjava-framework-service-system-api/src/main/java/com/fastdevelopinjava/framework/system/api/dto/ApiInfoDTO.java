package com.fastdevelopinjava.framework.system.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ApiInfoDTO implements Serializable {
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

    private String appName;


    public ApiInfoDTO() {
    }

    public ApiInfoDTO(Integer apiId, String apiCode, String apiName, String apiDesc, Integer appId, String needAuth, String deleteFlag, Date creatTime, Date updateTime, String apiUrl, String appName) {
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
        this.appName = appName;
    }
}
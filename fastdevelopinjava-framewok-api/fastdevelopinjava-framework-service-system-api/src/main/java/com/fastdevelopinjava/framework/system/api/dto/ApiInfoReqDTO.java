package com.fastdevelopinjava.framework.system.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class ApiInfoReqDTO implements Serializable {


    //默认分页，第一页
    private Integer pageNum = 0;
    //默认分页大小 10
    private Integer pageSize = 10;
    //默认分页
    private Boolean pageable = true;


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

}

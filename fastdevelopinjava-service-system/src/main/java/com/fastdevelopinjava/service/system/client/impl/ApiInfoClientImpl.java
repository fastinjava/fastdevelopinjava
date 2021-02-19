package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.ApiInfoClient;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "应用接口管理", tags = {"应用接口管理api"})
@Slf4j
@RestController
@RequestMapping("/apiinfo")
public class ApiInfoClientImpl implements ApiInfoClient {
    @Override
    public ResultDTO<PageDTO<ApiInfoDTO>> getList(ApiInfoReqDTO apiInfoReqDTO) {
        return null;
    }
}

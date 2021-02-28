package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.ApiInfoClient;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.framework.ucenter.utils.exception.ThrowableUtil;
import com.fastdevelopinjava.service.system.service.ApiInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "应用接口管理", tags = {"应用接口管理api"})
@Slf4j
@RestController
@RequestMapping("/apiinfo")
public class ApiInfoClientImpl implements ApiInfoClient {

    @Resource
    private ApiInfoService apiInfoService;

    @Override
    @ApiOperation(value = "应用接口列表查询")
    @PostMapping(value = "/getList",name = "获取接口信息列表")
    public ResultDTO<PageDTO<ApiInfoDTO>> getList(@RequestBody ApiInfoReqDTO apiInfoReqDTO) {
        try {
            PageDTO<ApiInfoDTO> pageDTO = apiInfoService.getList(apiInfoReqDTO);
            return success(pageDTO);
        } catch (Exception e) {
            String errorMsg = ThrowableUtil.getStackTrace(e);
            log.error(errorMsg);
            return failure(errorMsg);
        }
    }

    @PostMapping(value = "/getOne",name = "获取接口信息详情")
    @Override
    public ResultDTO<ApiInfoDTO> getOne(@RequestBody ApiInfoReqDTO apiInfoReqDTO) {
        try {
            return success(apiInfoService.getOne(apiInfoReqDTO));
        } catch (Exception e) {
            String errorMsg = ThrowableUtil.getStackTrace(e);
            log.error(errorMsg);
            return failure(errorMsg);
        }
    }

    @PostMapping(value = "/delete",name = "删除接口信息")
    @Override
    public ResultDTO<Boolean> delete(@RequestBody ApiInfoDeleteDTO apiInfoDeleteDTO) {
        try {
            return success(apiInfoService.delete(apiInfoDeleteDTO));
        } catch (Exception e) {
            String errorMsg = ThrowableUtil.getStackTrace(e);
            log.error(errorMsg);
            return failure(errorMsg);
        }
    }

    @Override
    @PostMapping(value = "/insert",name = "增加接口信息")
    public ResultDTO<Boolean> insert(@RequestBody ApiInfoInsertDTO apiInfoInsertDTO) {
        try {
            return success(apiInfoService.insert(apiInfoInsertDTO));
        } catch (Exception e) {
            String errorMsg = ThrowableUtil.getStackTrace(e);
            log.error(errorMsg);
            return failure(errorMsg);
        }
    }


}

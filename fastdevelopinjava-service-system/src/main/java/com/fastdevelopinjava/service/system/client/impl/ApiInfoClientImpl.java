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
    @PostMapping("/getList")
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

    @PostMapping("/getOne")
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

    @PostMapping("/delete")
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
    @PostMapping("/insert")
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

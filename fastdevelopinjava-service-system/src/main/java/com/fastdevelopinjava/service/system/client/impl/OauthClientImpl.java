package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.OauthClient;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.framework.ucenter.utils.exception.ThrowableUtil;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "客户端接口管理", tags = {"客户端接口管理api"})
@Slf4j
@RestController
@RequestMapping("/auth")
public class OauthClientImpl implements OauthClient {

    @Resource
    private OauthClientService oauthClientService;

    @Override
    @ApiOperation("获取客户端详情")
    @PostMapping("/getOne")
    public ResultDTO<OauthDetailsDTO> getOne(@RequestBody OauthDetailReqDTO oauthDetailReqDTO) {
        try {
            OauthDetailsDTO oauthDetailsDTO = oauthClientService.getOne(oauthDetailReqDTO);
            return ResultDTO.success(oauthDetailsDTO);
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("errorMessage = {} ", errorMessage);
            return ResultDTO.failure(errorMessage);
        }
    }

    @Override
    @ApiOperation("获取客户端列表")
    @PostMapping("/getList")
    public ResultDTO<PageDTO<OauthDetailsDTO>> getList(@RequestBody OauthDetailReqDTO oauthDetailReqDTO) {
        try {
            return ResultDTO.success(oauthClientService.getList(oauthDetailReqDTO));
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("errorMessage = {} ", errorMessage);
            return ResultDTO.failure(errorMessage);
        }
    }

    @Override
    @ApiOperation("更新客户端信息")
    @PostMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody OauthDetailsUpdateDTO oauthDetailsUpdateDTO) {
        try {
            return ResultDTO.success(oauthClientService.update(oauthDetailsUpdateDTO));
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("errorMessage = {} ", errorMessage);
            return ResultDTO.failure(errorMessage);
        }
    }
}

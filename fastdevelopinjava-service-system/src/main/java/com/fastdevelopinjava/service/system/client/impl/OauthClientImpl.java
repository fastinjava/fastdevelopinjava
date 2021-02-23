package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.OauthClient;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.framework.ucenter.utils.exception.ThrowableUtil;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import io.swagger.annotations.Api;
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
}

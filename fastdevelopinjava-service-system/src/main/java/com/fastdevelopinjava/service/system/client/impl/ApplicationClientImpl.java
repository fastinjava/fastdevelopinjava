package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.ApplicationClient;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.service.system.service.ApplicationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "应用管理", tags = {"应用管理api"})
@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationClientImpl implements ApplicationClient {


    @Resource
    private ApplicationService applicationService;

    @PostMapping("/getOne")
    @Override
    public ResultDTO<ApplicationDTO> getOne(@RequestBody ApplicationReqDTO applicationReqDTO) {
        return success(applicationService.getOne(applicationReqDTO));
    }


    @PostMapping("/getList")
    @Override
    public ResultDTO<PageDTO<ApplicationDTO>> getList(@RequestBody ApplicationReqDTO applicationReqDTO) {
        return success(applicationService.getList(applicationReqDTO));
    }


    @PostMapping("/delete")
    @Override
    public ResultDTO<Boolean> delete(ApplicationDeleteDTO applicationDeleteDTO) {
        return success(applicationService.delete(applicationDeleteDTO));
    }
}

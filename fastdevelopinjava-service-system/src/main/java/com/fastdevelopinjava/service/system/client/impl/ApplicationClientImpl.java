package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.ApplicationClient;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationInsertDTO;
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

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "应用管理", tags = {"应用管理api"})
@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationClientImpl implements ApplicationClient {


    @Resource
    private ApplicationService applicationService;

    @Override
    @PostMapping(value = "/getOne", name = "获取应用详情")
    public ResultDTO<ApplicationDTO> getOne(@RequestBody ApplicationReqDTO applicationReqDTO) {
        try {
            return success(applicationService.getOne(applicationReqDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return failure(e.getMessage());
        }
    }


    @PostMapping(value = "/getList", name = "获取应用列表")
    @Override
    public ResultDTO<PageDTO<ApplicationDTO>> getList(@RequestBody ApplicationReqDTO applicationReqDTO) {
        try {
            return success(applicationService.getList(applicationReqDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return failure(e.getMessage());
        }
    }


    @PostMapping(value = "/delete", name = "删除应用")
    @Override
    public ResultDTO<Boolean> delete(@RequestBody ApplicationDeleteDTO applicationDeleteDTO) {
        try {
            return success(applicationService.delete(applicationDeleteDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return failure(e.getMessage());
        }
    }

    @PostMapping(value = "/insert", name = "新增应用")
    @Override
    public ResultDTO<Boolean> insert(@RequestBody ApplicationInsertDTO applicationInsertDTO) {
        try {
            return success(applicationService.insert(applicationInsertDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return failure(e.getMessage());
        }
    }
}

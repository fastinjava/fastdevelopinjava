package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.ApplicationClient;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.service.system.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationClientImpl implements ApplicationClient {


    @Resource
    private ApplicationService applicationService;

    @Override
    public ResultDTO<ApplicationDTO> getOne(ApplicationReqDTO applicationReqDTO) {
        try {
            ApplicationDTO applicationDTO = applicationService.getOne(applicationReqDTO);
            return success(applicationDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.system.client.impl.ApplicationClientImpl#getOne error , message = {} , applicationReqDTO = {}", e.getMessage(), applicationReqDTO);
            return failure(e.getMessage());
        }

    }

    @Override
    public ResultDTO<PageDTO<ApplicationDTO>> getList(ApplicationReqDTO applicationReqDTO) {
        return null;
    }
}

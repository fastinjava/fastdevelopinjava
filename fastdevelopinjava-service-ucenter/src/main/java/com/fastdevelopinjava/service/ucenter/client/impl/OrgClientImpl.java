package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.ucenter.api.client.OrgClient;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.OrgService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "组织管理", tags = {"组织管理api"})
@Slf4j
@RestController
@RequestMapping("/org")
public class OrgClientImpl implements OrgClient {

    @Resource
    private OrgService orgService;

    @PostMapping("/getList")
    @Override
    public ResultDTO<PageDTO<OrganizationDTO>> getList(@RequestBody OrganizationReqDTO organizationReqDTO) {
        try {
            return success(orgService.getList(organizationReqDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.getList error = {} , organizationReqDTO = {} ", e.getMessage(), organizationReqDTO);
            return failure(e.getMessage());
        }
    }

    @PostMapping("/getOne")
    @Override
    public ResultDTO<OrganizationDTO> getOne(@RequestBody OrganizationReqDTO organizationReqDTO) {
        try {
            return success(orgService.getOne(organizationReqDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.getOne error = {} , organizationReqDTO = {} ", e.getMessage(), organizationReqDTO);
            return failure(e.getMessage());
        }
    }


    @PostMapping("/insert")
    @Override
    public ResultDTO<Boolean> insert(@RequestBody OrganizationCreateDTO organizationCreateDTO) {
        try {
            return success(orgService.insert(organizationCreateDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.insert error = {} , organizationCreateDTO = {} ", e.getMessage(), organizationCreateDTO);
            return failure(e.getMessage());
        }
    }

    @PostMapping("/update")
    @Override
    public ResultDTO<Boolean> update(@RequestBody OrganizationUpdateDTO organizationUpdateDTO) {
        try {
            return success(orgService.update(organizationUpdateDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.update error = {} , organizationUpdateDTO = {} ", e.getMessage(), organizationUpdateDTO);
            return failure(e.getMessage());
        }
    }
}

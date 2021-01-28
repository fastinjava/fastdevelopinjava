package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.api.client.OrgClient;
import com.fastdevelopinjava.framework.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.OrgService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fastdevelopinjava.framework.common.res.ResultDTO.*;
import javax.annotation.Resource;

@Api(value = "组织管理", tags = {"组织管理api"})
@Slf4j
@RestController
@RequestMapping("/role")
public class OrgClientImpl implements OrgClient {

    @Resource
    private OrgService orgService;

    @Override
    public ResultDTO<PageDTO<OrganizationDTO>> getList(OrganizationReqDTO organizationReqDTO) {
        try {
            return success(orgService.getList(organizationReqDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.getList error = {} , organizationReqDTO = {} ", e.getMessage(), organizationReqDTO);
            return failure(e.getMessage());
        }
    }

    @Override
    public ResultDTO<OrganizationDTO> getOne(OrganizationReqDTO organizationReqDTO) {
        try {
            return success(orgService.getOne(organizationReqDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.getOne error = {} , organizationReqDTO = {} ", e.getMessage(), organizationReqDTO);
            return failure(e.getMessage());
        }
    }

    @Override
    public ResultDTO<Boolean> insert(OrganizationCreateDTO organizationCreateDTO) {
        try {
            return success(orgService.insert(organizationCreateDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.insert error = {} , organizationCreateDTO = {} ", e.getMessage(), organizationCreateDTO);
            return failure(e.getMessage());
        }
    }

    @Override
    public ResultDTO<Boolean> update(OrganizationUpdateDTO organizationUpdateDTO) {
        try {
            return success(orgService.update(organizationUpdateDTO));
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.OrgClientImpl.update error = {} , organizationUpdateDTO = {} ", e.getMessage(), organizationUpdateDTO);
            return failure(e.getMessage());
        }
    }
}

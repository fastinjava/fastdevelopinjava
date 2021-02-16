package com.fastdevelopinjava.service.ucenter.client.impl;

import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.ucenter.api.client.OrgClient;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.NodeDTO;
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
import java.util.List;

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
        return success(orgService.getList(organizationReqDTO));
    }

    @PostMapping("/getOne")
    @Override
    public ResultDTO<OrganizationDTO> getOne(@RequestBody OrganizationReqDTO organizationReqDTO) {
        return success(orgService.getOne(organizationReqDTO));
    }


    @PostMapping("/insert")
    @Override
    public ResultDTO<Boolean> insert(@RequestBody OrganizationCreateDTO organizationCreateDTO) {
        return success(orgService.insert(organizationCreateDTO));

    }

    @PostMapping("/update")
    @Override
    public ResultDTO<Boolean> update(@RequestBody OrganizationUpdateDTO organizationUpdateDTO) {
        return success(orgService.update(organizationUpdateDTO));
    }

    @PostMapping("/listTree")
    @Override
    public ResultDTO<List<NodeDTO>> listTree(@RequestBody OrganizationReqDTO organizationReqDTO) {
        return success(orgService.listTree(organizationReqDTO));
    }
}

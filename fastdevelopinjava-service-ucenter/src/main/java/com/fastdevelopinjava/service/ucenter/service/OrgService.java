package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.NodeDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

import java.util.List;

public interface OrgService {
    OrganizationDTO getOne(OrganizationReqDTO organizationReqDTO);

    PageDTO<OrganizationDTO> getList(OrganizationReqDTO organizationReqDTO);

    Boolean insert(OrganizationCreateDTO organizationCreateDTO);

    Boolean update(OrganizationUpdateDTO organizationUpdateDTO);

    List<NodeDTO> listTree(OrganizationReqDTO organizationReqDTO);
}

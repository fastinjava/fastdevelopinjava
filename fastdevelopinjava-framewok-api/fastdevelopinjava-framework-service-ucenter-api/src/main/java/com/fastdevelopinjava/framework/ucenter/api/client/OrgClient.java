package com.fastdevelopinjava.framework.ucenter.api.client;

import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface OrgClient {

    /**
     * 分页条件查询组织信息
     *
     * @param organizationReqDTO
     * @return
     */
    ResultDTO<PageDTO<OrganizationDTO>> getList(OrganizationReqDTO organizationReqDTO);

    /**
     * 组织详情
     *
     * @param organizationReqDTO
     * @return
     */
    ResultDTO<OrganizationDTO> getOne(OrganizationReqDTO organizationReqDTO);

    ResultDTO<Boolean> insert(OrganizationCreateDTO organizationCreateDTO);

    ResultDTO<Boolean> update(OrganizationUpdateDTO organizationUpdateDTO);

}

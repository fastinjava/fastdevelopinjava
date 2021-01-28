package com.fastdevelopinjava.framework.api.client;

import com.fastdevelopinjava.framework.api.dto.*;
import com.fastdevelopinjava.framework.common.res.PageDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;

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

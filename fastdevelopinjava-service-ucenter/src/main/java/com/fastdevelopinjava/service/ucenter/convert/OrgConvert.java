package com.fastdevelopinjava.service.ucenter.convert;

import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;

public interface OrgConvert {

    OrganizationDTO organizationDO2OrganizationDTO(OrganizationDO organizationDO);

    OrganizationDO organizationCreateDTO2OrganizationDO(OrganizationCreateDTO organizationCreateDTO);

    OrganizationDO organizationUpdateDTO2OrganizationDO(OrganizationUpdateDTO organizationUpdateDTO);
}

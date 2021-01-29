package com.fastdevelopinjava.service.ucenter.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.service.ucenter.convert.OrgConvert;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrgConvertImpl implements OrgConvert {

    /**
     * OrganizationDO =======> OrganizationDTO
     *
     * @param organizationDO
     * @return
     */
    @Override
    public OrganizationDTO organizationDO2OrganizationDTO(OrganizationDO organizationDO) {
        if (ObjectUtil.isEmpty(organizationDO)) return null;
        OrganizationDTO organizationDTO = new OrganizationDTO();
        BeanUtil.copyProperties(organizationDO, organizationDTO);
        Date creatTime = organizationDO.getCreatTime();
        Date updateTime = organizationDO.getUpdateTime();
        if (ObjectUtil.isNotEmpty(creatTime)) {
            organizationDTO.setCreatTimeStr(DateUtil.formatDateTime(creatTime));
        }
        if (ObjectUtil.isNotEmpty(updateTime)) {
            organizationDTO.setUpdateTimeStr(DateUtil.formatDateTime(updateTime));
        }
        return organizationDTO;
    }


    @Override
    public OrganizationDO organizationCreateDTO2OrganizationDO(OrganizationCreateDTO organizationUpdateDTO) {
        if (ObjectUtil.isEmpty(organizationUpdateDTO)) return null;
        return new OrganizationDO(organizationUpdateDTO.getOrgId(), organizationUpdateDTO.getOrgPid(), organizationUpdateDTO.getOrgName(), organizationUpdateDTO.getOrgCode(), organizationUpdateDTO.getOrgDesc(), organizationUpdateDTO.getDeleteFlag());
    }

    @Override
    public OrganizationDO organizationUpdateDTO2OrganizationDO(OrganizationUpdateDTO organizationUpdateDTO) {
        if (ObjectUtil.isEmpty(organizationUpdateDTO)) return null;
        return new OrganizationDO(organizationUpdateDTO.getOrgId(), organizationUpdateDTO.getOrgPid(), organizationUpdateDTO.getOrgName(), organizationUpdateDTO.getOrgCode(), organizationUpdateDTO.getDeleteFlag(), organizationUpdateDTO.getDeleteFlag());
    }
}

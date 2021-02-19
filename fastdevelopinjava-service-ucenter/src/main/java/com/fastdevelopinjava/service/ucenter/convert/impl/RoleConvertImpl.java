package com.fastdevelopinjava.service.ucenter.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.convert.RoleConvert;
import com.fastdevelopinjava.service.ucenter.mapper.OrganizationDOMapper;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * role 实体转换类
 */
@Slf4j
@Component
public class RoleConvertImpl implements RoleConvert {

    @Resource
    private OrganizationDOMapper organizationDOMapper;

    @Override
    public RoleDTO roleDO2RoleDTO(RoleDO roleDO) {
        if (null == roleDO) return null;

        RoleDTO roleDTO = new RoleDTO();

        if (ObjectUtil.isNotEmpty(roleDO.getId())) {
            roleDTO.setId(roleDO.getId());
        }
        if (ObjectUtil.isNotEmpty(roleDO.getOrgId())) {
            Integer orgId = roleDO.getOrgId();

            roleDTO.setOrgId(orgId);

            OrganizationDO organizationDO = organizationDOMapper.selectByPrimaryKey(orgId);

            if (ObjectUtil.isNotEmpty(organizationDO)) {
                roleDTO.setOrgName(organizationDO.getOrgName());
            }

        }
        if (StringUtils.isNotEmpty(roleDO.getRoleCode())) {
            roleDTO.setRoleCode(roleDO.getRoleCode());
        }
        if (StringUtils.isNotEmpty(roleDO.getRoleName())) {
            roleDTO.setRoleName(roleDO.getRoleName());
        }
        if (StringUtils.isNotEmpty(roleDO.getRoleDesc())) {
            roleDTO.setRoleDesc(roleDO.getRoleDesc());
        }
        if (StringUtils.isNotEmpty(roleDO.getDeleteFlag())) {
            roleDTO.setDeleteFlag(roleDO.getDeleteFlag());
        }
        return roleDTO;
    }

    @Override
    public RoleDO roleReqDTO2RoleDO(RoleReqDTO roleReqDTO) {
        if (null == roleReqDTO) return null;
        return new RoleDO(roleReqDTO.getId(), roleReqDTO.getRoleName(), roleReqDTO.getRoleCode(),roleReqDTO.getRoleDesc(),roleReqDTO.getDeleteFlag());
    }

    @Override
    public RoleDO roleUpdateDTO2RoleDO(RoleUpdateDTO roleUpdateDTO) {
        if (null == roleUpdateDTO) return null;
        return new RoleDO(roleUpdateDTO.getId(), roleUpdateDTO.getRoleName(), roleUpdateDTO.getRoleCode(),roleUpdateDTO.getRoleDesc(),roleUpdateDTO.getDeleteFlag());
    }

    @Override
    public RoleDO roleCreateDTO2RoleDO(RoleCreateDTO roleCreateDTO) {
        if (null == roleCreateDTO) return null;
        RoleDO roleDO = new RoleDO(roleCreateDTO.getId(), roleCreateDTO.getRoleName(), roleCreateDTO.getRoleCode(), roleCreateDTO.getRoleDesc(), roleCreateDTO.getDeleteFlag());
        roleDO.setOrgId(roleCreateDTO.getOrgId());
        return roleDO;
    }

}

package com.fastdevelopinjava.service.ucenter.service.impl;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.convert.impl.RoleConvert;
import com.fastdevelopinjava.service.ucenter.mapper.RoleDOMapper;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleConvert roleConvert;

    @Resource
    RoleDOMapper roleMapper;

    @Override
    public Boolean insert(RoleCreateDTO roleCreateDTO) {
        RoleDO roleDO = roleConvert.roleCreateDTO2RoleDO(roleCreateDTO);
        return roleMapper.insertSelective(roleDO) > 0;
    }

    @Override
    public Boolean update(RoleUpdateDTO roleUpdateDTO) {
        RoleDO roleDO = roleConvert.roleUpdateDTO2RoleDO(roleUpdateDTO);
        return roleMapper.updateByPrimaryKeySelective(roleDO) > 0;
    }


}

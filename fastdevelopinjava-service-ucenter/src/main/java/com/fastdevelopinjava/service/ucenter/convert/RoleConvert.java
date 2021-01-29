package com.fastdevelopinjava.service.ucenter.convert;

import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;

public interface RoleConvert {
    RoleDO roleCreateDTO2RoleDO(RoleCreateDTO roleCreateDTO);
    RoleDO roleUpdateDTO2RoleDO(RoleUpdateDTO roleUpdateDTO);
    RoleDO roleReqDTO2RoleDO(RoleReqDTO roleReqDTO);
    RoleDTO roleDO2RoleDTO(RoleDO roleDO);
}

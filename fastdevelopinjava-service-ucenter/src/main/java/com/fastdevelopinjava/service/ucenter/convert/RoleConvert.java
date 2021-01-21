package com.fastdevelopinjava.service.ucenter.convert;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;

public interface RoleConvert {
    RoleDO roleCreateDTO2RoleDO(RoleCreateDTO roleCreateDTO);
    RoleDO roleUpdateDTO2RoleDO(RoleUpdateDTO roleUpdateDTO);
    RoleDO roleReqDTO2RoleDO(RoleReqDTO roleReqDTO);
    RoleDTO roleDO2RoleDTO(RoleDO roleDO);
}

package com.fastdevelopinjava.service.ucenter.convert.impl;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;

public interface RoleConvert {
    RoleDO roleCreateDTO2RoleDO(RoleCreateDTO roleCreateDTO);
    RoleDO roleUpdateDTO2RoleDO(RoleUpdateDTO roleUpdateDTO);
}

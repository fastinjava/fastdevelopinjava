package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;

public interface RoleService {

    Boolean insert(RoleCreateDTO roleCreateDTO);
    Boolean update(RoleUpdateDTO roleUpdateDTO);

}

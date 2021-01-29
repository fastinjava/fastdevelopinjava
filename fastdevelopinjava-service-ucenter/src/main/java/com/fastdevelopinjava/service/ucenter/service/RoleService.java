package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface RoleService {

    Boolean insert(RoleCreateDTO roleCreateDTO);
    Boolean update(RoleUpdateDTO roleUpdateDTO);
    RoleDTO getOne(RoleReqDTO roleReqDTO);
    PageDTO<RoleDTO> getList(RoleReqDTO roleReqDTO);
}

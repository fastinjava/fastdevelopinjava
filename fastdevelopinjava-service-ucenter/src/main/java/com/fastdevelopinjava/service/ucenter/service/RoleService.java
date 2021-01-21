package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;

public interface RoleService {

    Boolean insert(RoleCreateDTO roleCreateDTO);
    Boolean update(RoleUpdateDTO roleUpdateDTO);
    RoleDTO getOne(RoleReqDTO roleReqDTO);
    PageResultDTO<RoleDTO> getList(RoleReqDTO roleReqDTO);
}

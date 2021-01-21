package com.fastdevelopinjava.framework.api.client;

import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;

public interface RoleClient {

    ResultDTO<RoleDTO> getOne(RoleReqDTO roleReqDTO);
    ResultDTO<PageResultDTO<RoleDTO>> getList(RoleReqDTO roleReqDTO);
    ResultDTO<Boolean> insert(RoleCreateDTO roleCreateDTO);
    ResultDTO<Boolean> update(RoleUpdateDTO roleUpdateDTO);

}

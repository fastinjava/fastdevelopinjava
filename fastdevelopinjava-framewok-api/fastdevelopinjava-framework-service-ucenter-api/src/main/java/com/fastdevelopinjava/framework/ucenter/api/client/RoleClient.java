package com.fastdevelopinjava.framework.ucenter.api.client;

import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface RoleClient {

    ResultDTO<RoleDTO> getOne(RoleReqDTO roleReqDTO);
    ResultDTO<PageDTO<RoleDTO>> getList(RoleReqDTO roleReqDTO);
    ResultDTO<Boolean> insert(RoleCreateDTO roleCreateDTO);
    ResultDTO<Boolean> update(RoleUpdateDTO roleUpdateDTO);

}

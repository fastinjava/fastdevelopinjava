package com.fastdevelopinjava.framework.api.system.manage.client;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;

public interface UserClient {
    public ResResultDTO<UserDTO> getOne(UserReqDTO userReqDTO);
}

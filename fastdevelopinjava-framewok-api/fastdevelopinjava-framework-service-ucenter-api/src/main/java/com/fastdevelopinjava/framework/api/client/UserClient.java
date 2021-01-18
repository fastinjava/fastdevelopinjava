package com.fastdevelopinjava.framework.api.client;

import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.Result;

public interface UserClient {
    Result<UserDTO> getOne(UserReqDTO userReqDTO);
}

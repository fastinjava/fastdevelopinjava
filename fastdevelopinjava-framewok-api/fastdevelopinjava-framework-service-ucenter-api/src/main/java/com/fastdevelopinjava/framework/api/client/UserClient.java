package com.fastdevelopinjava.framework.api.client;

import com.fastdevelopinjava.framework.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;

public interface UserClient {
    ResultDTO<UserDTO> selectOne(UserReqDTO userReqDTO);
    ResultDTO<PageDTO<UserDTO>> selectList(UserReqDTO userReqDTO);
    ResultDTO<Boolean> insert(UserCreateDTO userCreateDTO);
    ResultDTO<Boolean> update(UserUpdateDTO userUpdateDTO);
}

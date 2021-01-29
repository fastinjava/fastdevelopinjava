package com.fastdevelopinjava.framework.ucenter.api.client;

import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface UserClient {
    ResultDTO<UserDTO> selectOne(UserReqDTO userReqDTO);
    ResultDTO<PageDTO<UserDTO>> selectList(UserReqDTO userReqDTO);
    ResultDTO<Boolean> insert(UserCreateDTO userCreateDTO);
    ResultDTO<Boolean> update(UserUpdateDTO userUpdateDTO);
}

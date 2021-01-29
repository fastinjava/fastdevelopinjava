package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface UserService {
    UserDTO getOne(UserReqDTO userReqDTO);

    PageDTO<UserDTO> getList(UserReqDTO userReqDTO);

    Boolean insert(UserCreateDTO userCreateDTO);

    Boolean update(UserUpdateDTO userUpdateDTO);

}

package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageDTO;

public interface UserService {
    UserDTO getOne(UserReqDTO userReqDTO);

    PageDTO<UserDTO> getList(UserReqDTO userReqDTO);

    Boolean insert(UserCreateDTO userCreateDTO);

    Boolean update(UserUpdateDTO userUpdateDTO);

}

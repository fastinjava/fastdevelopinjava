package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;

public interface UserService {
    UserDTO getOne(UserReqDTO userReqDTO);
}

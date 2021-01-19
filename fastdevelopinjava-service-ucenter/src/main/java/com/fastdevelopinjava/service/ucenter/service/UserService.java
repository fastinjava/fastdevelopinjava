package com.fastdevelopinjava.service.ucenter.service;

import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;

public interface UserService {
    UserDTO getOne(UserReqDTO userReqDTO);

    PageResultDTO<UserDTO> getList(UserReqDTO userReqDTO);
}

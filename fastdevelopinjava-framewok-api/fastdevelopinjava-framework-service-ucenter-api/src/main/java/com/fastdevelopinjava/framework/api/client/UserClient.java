package com.fastdevelopinjava.framework.api.client;

import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;

public interface UserClient {
    ResultDTO<UserDTO> getOne(UserReqDTO userReqDTO);
    ResultDTO<PageResultDTO<UserDTO>> getList(UserReqDTO userReqDTO);
}

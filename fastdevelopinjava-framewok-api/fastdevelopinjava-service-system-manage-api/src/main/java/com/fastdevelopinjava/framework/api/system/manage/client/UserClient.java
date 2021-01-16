package com.fastdevelopinjava.framework.api.system.manage.client;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;

public interface UserClient {
    ResResultDTO<UserDTO> selectOneByAll(UserReqDTO userReqDTO);
    ResResultDTO<Boolean> insertSelective(UserCreateDTO userCreateDTO);
    ResResultDTO<Boolean> updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO);
}

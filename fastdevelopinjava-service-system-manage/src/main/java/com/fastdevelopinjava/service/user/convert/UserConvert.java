package com.fastdevelopinjava.service.user.convert;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.service.user.entity.UserDO;

public interface UserConvert extends Convert{
    UserDO userReqDTO2UserDO(UserReqDTO userReqDTO);
    UserDO userCreateDTO2UserDO(UserCreateDTO userCreateDTO);
    UserDTO user2UserDTO(UserDO userDO);
}

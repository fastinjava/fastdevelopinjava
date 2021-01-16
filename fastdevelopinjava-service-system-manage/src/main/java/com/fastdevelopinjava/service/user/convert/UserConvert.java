package com.fastdevelopinjava.service.user.convert;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.service.user.entity.UserDO;

public interface UserConvert {
    UserDO userReqDTO2UserDO(UserReqDTO userReqDTO);
    UserDTO user2UserDTO(UserDO userDO);
}

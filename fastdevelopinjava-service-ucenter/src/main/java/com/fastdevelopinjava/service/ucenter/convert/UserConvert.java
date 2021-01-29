package com.fastdevelopinjava.service.ucenter.convert;

import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.service.ucenter.model.UserDO;

public interface UserConvert {
    UserDO userReqDTO2UserDO(UserReqDTO userReqDTO);
    UserDTO userDO2UserDTO(UserDO userDO);
    UserDO userCreateDTO2UserDO(UserCreateDTO userCreateDTO);
    UserDO userUpdateDTO2UserDO(UserUpdateDTO userUpdateDTO);
}

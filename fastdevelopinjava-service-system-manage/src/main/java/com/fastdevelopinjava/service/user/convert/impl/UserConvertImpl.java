package com.fastdevelopinjava.service.user.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.service.user.convert.UserConvert;
import com.fastdevelopinjava.service.user.entity.UserDO;
import org.springframework.stereotype.Component;

@Component
public class UserConvertImpl  implements UserConvert {
    @Override
    public UserDO userReqDTO2UserDO(UserReqDTO userReqDTO) {
        if (null == userReqDTO) return null;
        UserDO userDO = new UserDO();
        copyProperties(userReqDTO,userDO);
        return userDO;
    }

    @Override
    public UserDO userCreateDTO2UserDO(UserCreateDTO userCreateDTO) {
        if (ObjectUtil.isEmpty(userCreateDTO)) return null;
        UserDO userDO = new UserDO();
        copyProperties(userCreateDTO,userDO);
        return userDO;
    }

    @Override
    public UserDTO user2UserDTO(UserDO userDO) {
        if (ObjectUtil.isEmpty(userDO)) return null;
        UserDTO userDTO = new UserDTO();
        copyProperties(userDO,userDTO);
        return userDTO;

    }
}

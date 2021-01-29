package com.fastdevelopinjava.service.ucenter.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * user转换实现类
 */
@Component
public class UserConvertImpl implements UserConvert {

    @Override
    public UserDTO userDO2UserDTO(UserDO userDO) {
        if (ObjectUtil.isEmpty(userDO)) return null;
        UserDTO userDTO = new UserDTO();
        if (ObjectUtil.isNotEmpty(userDO.getUserId())) {
            userDTO.setUserId(userDO.getUserId());
        }
        if (StringUtils.isNotEmpty(userDO.getUserName())) {
            userDTO.setUserName(userDO.getUserName());
        }
        if (StringUtils.isNotEmpty(userDO.getUserNickName())) {
            userDTO.setUserNickName(userDO.getUserNickName());
        }
        if (ObjectUtil.isNotEmpty(userDO.getDeleteFlag())) {
            userDTO.setDeleteFlag(userDO.getDeleteFlag());
        }
        if (StringUtils.isNotEmpty(userDO.getUserEmail())) {
            userDTO.setUserEmail(userDO.getUserEmail());
        }
        return userDTO;
    }

    @Override
    public UserDO userCreateDTO2UserDO(UserCreateDTO userCreateDTO) {

        if (null == userCreateDTO) return null;

        UserDO userDO = new UserDO();

        if (ObjectUtil.isNotEmpty(userCreateDTO.getUserId())) {
            userDO.setUserId(userCreateDTO.getUserId());
        }

        if (StringUtils.isNotEmpty(userCreateDTO.getUserName())) {
            userDO.setUserName(userCreateDTO.getUserName());
        }

        if (StringUtils.isNotEmpty(userCreateDTO.getUserNickName())) {
            userDO.setUserNickName(userCreateDTO.getUserNickName());
        }

        if (ObjectUtil.isNotEmpty(userCreateDTO.getDeleteFlag())) {
            userDO.setDeleteFlag(userCreateDTO.getDeleteFlag());
        }

        if (StringUtils.isNotEmpty(userCreateDTO.getUserEmail())) {
            userDO.setUserEmail(userCreateDTO.getUserEmail());
        }

        return userDO;
    }

    @Override
    public UserDO userUpdateDTO2UserDO(UserUpdateDTO userUpdateDTO) {
        if (null == userUpdateDTO) return null;
        UserDO userDO = new UserDO();
        if (ObjectUtil.isNotEmpty(userUpdateDTO.getUserId())) {
            userDO.setUserId(userUpdateDTO.getUserId());
        }
        if (StringUtils.isNotEmpty(userUpdateDTO.getUserName())) {
            userDO.setUserName(userUpdateDTO.getUserName());
        }
        if (StringUtils.isNotEmpty(userUpdateDTO.getUserNickName())) {
            userDO.setUserNickName(userUpdateDTO.getUserNickName());
        }
        if (ObjectUtil.isNotEmpty(userUpdateDTO.getDeleteFlag())) {
            userDO.setDeleteFlag(userUpdateDTO.getDeleteFlag());
        }
        return userDO;
    }

    @Override
    public UserDO userReqDTO2UserDO(UserReqDTO userReqDTO) {
        if (ObjectUtil.isEmpty(userReqDTO)) {
            return null;
        } else {
            UserDO userDO = new UserDO();
            if (ObjectUtil.isNotEmpty(userReqDTO.getUserId())) {
                userDO.setUserId(userReqDTO.getUserId());
            }
            if (StringUtils.isNotEmpty(userReqDTO.getUserName())) {
                userDO.setUserName(userReqDTO.getUserName());
            }
            if (StringUtils.isNotEmpty(userReqDTO.getUserNickName())) {
                userDO.setUserNickName(userReqDTO.getUserNickName());
            }
            if (ObjectUtil.isNotEmpty(userReqDTO.getDeleteFlag())) {
                userDO.setDeleteFlag(userReqDTO.getDeleteFlag());
            }
            return userDO;
        }
    }
}

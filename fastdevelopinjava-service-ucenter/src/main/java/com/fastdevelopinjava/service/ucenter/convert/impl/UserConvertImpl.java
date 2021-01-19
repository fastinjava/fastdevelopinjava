package com.fastdevelopinjava.service.ucenter.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.mapper.UserDOMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.annotation.Resource;

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
        return userDTO;
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

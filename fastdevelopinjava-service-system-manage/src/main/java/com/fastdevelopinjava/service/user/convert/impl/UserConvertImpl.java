package com.fastdevelopinjava.service.user.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.service.user.convert.UserConvert;
import com.fastdevelopinjava.service.user.entity.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConvertImpl  implements UserConvert {
    @Override
    public UserDO userReqDTO2UserDO(UserReqDTO userReqDTO) {
        if (null == userReqDTO) return null;
        UserDO userDO = new UserDO();
        if (null != userReqDTO.getUserId()) userDO.setUserId(userReqDTO.getUserId());
        if (StringUtils.isNotEmpty(userReqDTO.getUserName()))     userDO.setUserName(userReqDTO.getUserName());
        if (StringUtils.isNotEmpty(userReqDTO.getUserNickName())) userDO.setUserNickName(userReqDTO.getUserNickName());
        if (StringUtils.isNotEmpty(userReqDTO.getUserEmail()))    userDO.setUserEmail(userReqDTO.getUserEmail());
        if (ObjectUtil.isNotEmpty(userReqDTO.getDeleteFlag()))    userDO.setDeleteFlag(userReqDTO.getDeleteFlag());
        if (ObjectUtil.isNotEmpty(userReqDTO.getUpdatedTime()))   userDO.setUpdatedTime(userReqDTO.getUpdatedTime());
        if (ObjectUtil.isNotEmpty(userReqDTO.getCreatedTime()))   userDO.setCreatedTime(userReqDTO.getCreatedTime());
        if (ObjectUtil.isNotEmpty(userReqDTO.getCreatedUserId())) userDO.setCreatedUserId(userReqDTO.getCreatedUserId());
        if (ObjectUtil.isNotEmpty(userReqDTO.getUpdatedUserId())) userDO.setUpdatedUserId(userReqDTO.getUpdatedUserId());
        return userDO;
    }

    @Override
    public UserDTO user2UserDTO(UserDO userDO) {
        if (ObjectUtil.isEmpty(userDO)) return null;
        UserDTO userDTO = new UserDTO();
//
//        if (null != userDO.getUserId()) userDTO.setUserId(userDO.getUserId());
//        if (StringUtils.isNotEmpty(userDO.getUserName()))     userDTO.setUserName(userDO.getUserName());
//        if (StringUtils.isNotEmpty(userDO.getUserNickName())) userDTO.setUserNickName(userDO.getUserNickName());
//        if (StringUtils.isNotEmpty(userDO.getUserEmail()))    userDTO.setUserEmail(userDO.getUserEmail());
//        if (ObjectUtil.isNotEmpty(userDO.getDeleteFlag()))    userDTO.setDeleteFlag(userDO.getDeleteFlag());
//        if (ObjectUtil.isNotEmpty(userDO.getUpdatedTime()))   userDTO.setUpdatedTime(userDO.getUpdatedTime());
//        if (ObjectUtil.isNotEmpty(userDO.getCreatedTime()))   userDTO.setCreatedTime(userDO.getCreatedTime());
//        if (ObjectUtil.isNotEmpty(userDO.getCreatedUserId())) userDTO.setCreatedUserId(userDO.getCreatedUserId());
//        if (ObjectUtil.isNotEmpty(userDO.getUpdatedUserId())) userDTO.setUpdatedUserId(userDO.getUpdatedUserId());
        convert(userDO,userDTO);
        return userDTO;

    }
}

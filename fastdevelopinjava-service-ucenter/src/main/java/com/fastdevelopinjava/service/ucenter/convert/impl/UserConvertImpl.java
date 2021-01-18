package com.fastdevelopinjava.service.ucenter.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.mapper.UserDOMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConvertImpl  implements UserConvert {




    @Override
    public UserDO userReqDTO2UserDO(UserReqDTO userReqDTO) {
        if (ObjectUtil.isEmpty(userReqDTO))
        {
            return null;
        }
        else {
            UserDO userDO = new UserDO();
            if (ObjectUtil.isNotEmpty(userReqDTO.getUserId())){
                userDO.setUserId(userReqDTO.getUserId());
            }
            return userDO;
        }
    }
}

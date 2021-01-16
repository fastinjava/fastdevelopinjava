package com.fastdevelopinjava.service.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fastdevelopinjava.framework.api.system.manage.client.UserClient;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;
import com.fastdevelopinjava.service.user.convert.UserConvert;
import com.fastdevelopinjava.service.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserClientImpl  implements UserClient {

    @Resource
    private UserConvert userConvert;

    @Resource
    private UserMapper userMapper;

    @Override
    public ResResultDTO<UserDTO> selectOneByAll(UserReqDTO userReqDTO) {
        ResResultDTO<UserDTO> resultDTO = ResResultDTO.<UserDTO>builder().build();
        try {
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            log.error(" com.fastdevelopinjava.service.user.service.UserClientImpl#getOne error , userReqDTO = {} " , userReqDTO);
            resultDTO.setSuccess(false);
            resultDTO.setErrorMessage(e.getMessage());
        }
        return resultDTO;
    }

    @Override
    public ResResultDTO<Boolean> insertSelective(UserCreateDTO userCreateDTO) {
        ResResultDTO<Boolean> resultDTO = ResResultDTO.<Boolean>builder().build();
        try {
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            log.error(" com.fastdevelopinjava.service.user.service.UserClientImpl#insertSelective error , userCreateDTO = {} " , userCreateDTO);
            resultDTO.setSuccess(false);
            resultDTO.setErrorMessage(e.getMessage());
        }
        return resultDTO;
    }

    @Override
    public ResResultDTO<Boolean> updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO) {
        ResResultDTO<Boolean> resultDTO = ResResultDTO.<Boolean>builder().build();
        try {
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            log.error(" com.fastdevelopinjava.service.user.service.UserClientImpl#updateByPrimaryKeySelective error , userCreateDTO = {} " , userUpdateDTO);
            resultDTO.setSuccess(false);
            resultDTO.setErrorMessage(e.getMessage());
        }
        return resultDTO;
    }
}

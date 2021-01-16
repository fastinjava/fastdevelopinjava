package com.fastdevelopinjava.service.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fastdevelopinjava.framework.api.system.manage.client.UserClient;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
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
    public ResResultDTO<UserDTO> getOne(UserReqDTO userReqDTO) {
        ResResultDTO<UserDTO> resultDTO = ResResultDTO.<UserDTO>builder().build();
        try {
            resultDTO.setSuccess(true);
            resultDTO.setData(userConvert.user2UserDTO(userMapper.selectOne(new QueryWrapper<>(userConvert.userReqDTO2UserDO(userReqDTO)))));
        } catch (Exception e) {
            log.error(" com.fastdevelopinjava.service.user.service.UserClientImpl#getOne error , userReqDTO = {} " , userReqDTO);
            resultDTO.setSuccess(false);
            resultDTO.setErrorMessage(e.getMessage());
        }
        return resultDTO;
    }
}

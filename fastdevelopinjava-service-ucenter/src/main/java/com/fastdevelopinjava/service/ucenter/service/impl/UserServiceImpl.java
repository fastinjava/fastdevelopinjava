package com.fastdevelopinjava.service.ucenter.service.impl;

import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.mapper.UserMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserConvert userConvert;

    @Resource
    UserMapper userMapper;

    @Override
    public UserDTO getOne(UserReqDTO userReqDTO) {
        UserDO userDO = userConvert.userReqDTO2UserDO(userReqDTO);
        return null;
    }

    @Override
    public PageResultDTO<UserDTO> getList(UserReqDTO userReqDTO) {
        UserDO userDO = userConvert.userReqDTO2UserDO(userReqDTO);
        return null;
    }
}

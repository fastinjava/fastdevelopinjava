package com.fastdevelopinjava.service.user.service;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;

public interface UserService {
    UserDTO selectByPrimaryKey(Integer userId);
    Boolean deleteByPrimaryKey(Integer userId);
    Boolean updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO);
    Boolean insertSelective(UserCreateDTO userCreateDTO);
    PageResultDTO<UserDTO> selectList(UserReqDTO userReqDTO);
}

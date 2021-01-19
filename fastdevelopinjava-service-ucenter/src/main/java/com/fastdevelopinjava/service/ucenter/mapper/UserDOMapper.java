package com.fastdevelopinjava.service.ucenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;

public interface UserDOMapper extends BaseMapper<UserDO> {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}
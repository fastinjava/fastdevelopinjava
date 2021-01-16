package com.fastdevelopinjava.framework.api.system.manage.client;

import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;

public interface UserClient {
    ResResultDTO<PageResultDTO<UserDTO>> selectList(UserReqDTO userReqDTO);
    ResResultDTO<UserDTO> selectByPrimaryKey(Integer userId);
    ResResultDTO<Boolean> deleteByPrimaryKey(Integer userId);
    ResResultDTO<Boolean> insert();
    ResResultDTO<Boolean> insertOrUpdate();
    ResResultDTO<Boolean> insertOrUpdateSelective();
    ResResultDTO<Boolean> insertSelective(UserCreateDTO userCreateDTO);
    ResResultDTO<Boolean> updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO);
    ResResultDTO<Boolean> updateByPrimaryKey();
    ResResultDTO<Boolean> updateBatch();
    ResResultDTO<Boolean> updateBatchSelective();
    ResResultDTO<Boolean> batchInsert();
}

package com.fastdevelopinjava.service.ucenter.mapper;

import com.fastdevelopinjava.service.ucenter.model.UserDO;
import com.fastdevelopinjava.service.ucenter.model.UserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserDO record);

    int insertOrUpdate(UserDO record);

    int insertOrUpdateSelective(UserDO record);

    int insertSelective(UserDO record);

    List<UserDO> selectByExample(UserDOExample example);

    UserDO selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    int updateBatch(List<UserDO> list);

    int batchInsert(@Param("list") List<UserDO> list);

    int updateBatchSelective(List<UserDO> list);
}
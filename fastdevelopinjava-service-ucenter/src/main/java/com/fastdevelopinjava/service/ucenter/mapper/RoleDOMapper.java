package com.fastdevelopinjava.service.ucenter.mapper;

import com.fastdevelopinjava.service.ucenter.model.RoleDO;
import com.fastdevelopinjava.service.ucenter.model.RoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDOMapper {
    long countByExample(RoleDOExample example);

    int deleteByExample(RoleDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleDO record);

    int insertOrUpdate(RoleDO record);

    int insertOrUpdateSelective(RoleDO record);

    int insertSelective(RoleDO record);

    List<RoleDO> selectByExample(RoleDOExample example);

    RoleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    int updateBatch(List<RoleDO> list);

    int batchInsert(@Param("list") List<RoleDO> list);
}
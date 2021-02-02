package com.fastdevelopinjava.service.system.mapper;

import com.fastdevelopinjava.service.system.model.ApplicationDO;
import com.fastdevelopinjava.service.system.model.ApplicationDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationDOMapper {
    long countByExample(ApplicationDOExample example);

    int deleteByExample(ApplicationDOExample example);

    int deleteByPrimaryKey(Integer appId);

    int insert(ApplicationDO record);

    int insertOrUpdate(ApplicationDO record);

    int insertOrUpdateSelective(ApplicationDO record);

    int insertSelective(ApplicationDO record);

    List<ApplicationDO> selectByExample(ApplicationDOExample example);

    ApplicationDO selectByPrimaryKey(Integer appId);

    int updateByExampleSelective(@Param("record") ApplicationDO record, @Param("example") ApplicationDOExample example);

    int updateByExample(@Param("record") ApplicationDO record, @Param("example") ApplicationDOExample example);

    int updateByPrimaryKeySelective(ApplicationDO record);

    int updateByPrimaryKey(ApplicationDO record);

    int updateBatch(List<ApplicationDO> list);

    int batchInsert(@Param("list") List<ApplicationDO> list);
}
package com.fastdevelopinjava.service.system.mapper;

import com.fastdevelopinjava.service.system.model.ApiInfoDO;
import com.fastdevelopinjava.service.system.model.ApiInfoDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiInfoDOMapper {
    long countByExample(ApiInfoDOExample example);

    int deleteByExample(ApiInfoDOExample example);

    int deleteByPrimaryKey(Integer apiId);

    int insert(ApiInfoDO record);

    int insertOrUpdate(ApiInfoDO record);

    int insertOrUpdateSelective(ApiInfoDO record);

    int insertSelective(ApiInfoDO record);

    List<ApiInfoDO> selectByExample(ApiInfoDOExample example);

    ApiInfoDO selectByPrimaryKey(Integer apiId);

    int updateByExampleSelective(@Param("record") ApiInfoDO record, @Param("example") ApiInfoDOExample example);

    int updateByExample(@Param("record") ApiInfoDO record, @Param("example") ApiInfoDOExample example);

    int updateByPrimaryKeySelective(ApiInfoDO record);

    int updateByPrimaryKey(ApiInfoDO record);

    int updateBatch(List<ApiInfoDO> list);

    int batchInsert(@Param("list") List<ApiInfoDO> list);
}
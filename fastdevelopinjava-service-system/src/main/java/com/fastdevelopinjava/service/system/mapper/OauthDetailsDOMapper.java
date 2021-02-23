package com.fastdevelopinjava.service.system.mapper;

import com.fastdevelopinjava.service.system.model.OauthDetailsDO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthDetailsDOMapper {
    long countByExample(OauthDetailsDOExample example);

    int deleteByExample(OauthDetailsDOExample example);

    int insert(OauthDetailsDO record);

    int insertOrUpdate(OauthDetailsDO record);

    int insertOrUpdateSelective(OauthDetailsDO record);

    int insertSelective(OauthDetailsDO record);

    List<OauthDetailsDO> selectByExample(OauthDetailsDOExample example);

    int updateByExampleSelective(@Param("record") OauthDetailsDO record, @Param("example") OauthDetailsDOExample example);

    int updateByExample(@Param("record") OauthDetailsDO record, @Param("example") OauthDetailsDOExample example);

    int batchInsert(@Param("list") List<OauthDetailsDO> list);
}
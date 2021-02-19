package com.fastdevelopinjava.service.ucenter.mapper;

import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.NodeDTO;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationDOMapper {
    long countByExample(OrganizationDOExample example);

    int deleteByExample(OrganizationDOExample example);

    int deleteByPrimaryKey(Integer orgId);

    int insert(OrganizationDO record);

    int insertOrUpdate(OrganizationDO record);

    int insertOrUpdateSelective(OrganizationDO record);

    int insertSelective(OrganizationDO record);

    List<OrganizationDO> selectByExample(OrganizationDOExample example);

    OrganizationDO selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") OrganizationDO record, @Param("example") OrganizationDOExample example);

    int updateByExample(@Param("record") OrganizationDO record, @Param("example") OrganizationDOExample example);

    int updateByPrimaryKeySelective(OrganizationDO record);

    int updateByPrimaryKey(OrganizationDO record);

    int updateBatch(List<OrganizationDO> list);

    int batchInsert(@Param("list") List<OrganizationDO> list);

    List<NodeDTO> listTree(OrganizationReqDTO organizationReqDTO);


    List<OrganizationDO> selectByOrgPid(@Param("orgPid") Integer orgPid);


    Integer countByOrgPid(@Param("orgPid") Integer orgPid);


    Integer countByOrgPidAndDeleteFlag(@Param("orgPid") Integer orgPid, @Param("deleteFlag") String deleteFlag);


}
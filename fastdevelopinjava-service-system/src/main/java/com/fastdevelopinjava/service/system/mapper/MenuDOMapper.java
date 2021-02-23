package com.fastdevelopinjava.service.system.mapper;

import com.fastdevelopinjava.service.system.model.MenuDO;
import com.fastdevelopinjava.service.system.model.MenuDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDOMapper {
    long countByExample(MenuDOExample example);

    int deleteByExample(MenuDOExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuDO record);

    int insertOrUpdate(MenuDO record);

    int insertOrUpdateSelective(MenuDO record);

    int insertSelective(MenuDO record);

    List<MenuDO> selectByExample(MenuDOExample example);

    MenuDO selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") MenuDO record, @Param("example") MenuDOExample example);

    int updateByExample(@Param("record") MenuDO record, @Param("example") MenuDOExample example);

    int updateByPrimaryKeySelective(MenuDO record);

    int updateByPrimaryKey(MenuDO record);

    int updateBatch(List<MenuDO> list);

    int batchInsert(@Param("list") List<MenuDO> list);
}
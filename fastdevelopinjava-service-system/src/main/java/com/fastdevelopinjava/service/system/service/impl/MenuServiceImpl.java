package com.fastdevelopinjava.service.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.system.convert.MenuConvert;
import com.fastdevelopinjava.service.system.mapper.MenuDOMapper;
import com.fastdevelopinjava.service.system.model.MenuDO;
import com.fastdevelopinjava.service.system.model.MenuDOExample;
import com.fastdevelopinjava.service.system.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDOMapper menuDOMapper;
    @Resource
    private MenuConvert menuConvert;

    private MenuDOExample build(JSONObject jsonObject) {
        MenuDOExample menuDOExample = new MenuDOExample();
        MenuDOExample.Criteria criteria = menuDOExample.createCriteria();
        Integer menuId = jsonObject.getInteger("menuId");
        if (ObjectUtil.isNotEmpty(menuId)) {
            criteria.andMenuIdEqualTo(menuId);
        }
        return menuDOExample;
    }

    @Override
    public Boolean insert(MenuInsertDTO menuInsertDTO) {
        return menuDOMapper.insertSelective(menuConvert.menuInsertDTO2MenuDO(menuInsertDTO)) > 0;
    }

    @Override
    public MenuDTO getOne(MenuReqDTO menuReqDTO) {
        return menuConvert.menuDO2MenuDTO(menuDOMapper.selectByExample(build(new JSONObject().fluentPut("menuId", menuReqDTO.getMenuId()))).stream().findFirst().orElse(null));
    }

    @Override
    public PageDTO<MenuDTO> getList(MenuReqDTO menuReqDTO) {
        PageHelper.startPage(menuReqDTO.getPageNum(), menuReqDTO.getPageable() ? menuReqDTO.getPageSize() : 0, true, true, !menuReqDTO.getPageable());
        PageInfo<MenuDO> pageInfo = new PageInfo<>(menuDOMapper.selectByExample(build(new JSONObject())));
        List<MenuDTO> menuDTOList = pageInfo.getList().stream().map(menuDO -> menuConvert.menuDO2MenuDTO(menuDO)).collect(Collectors.toList());
        return new PageDTO<>(pageInfo.getTotal(), menuDTOList);
    }
}

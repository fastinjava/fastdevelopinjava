package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.service.system.convert.MenuConvert;
import com.fastdevelopinjava.service.system.mapper.MenuDOMapper;
import com.fastdevelopinjava.service.system.model.MenuDO;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class MenuConvertImpl implements MenuConvert {

    @Resource
    private MenuDOMapper menuDOMapper;

    @Resource
    private OauthClientService oauthClientService;

    @Override
    public MenuDO menuInsertDTO2MenuDO(MenuInsertDTO menuInsertDTO) {
        if (null == menuInsertDTO) return null;
        MenuDO menuDO = new MenuDO();
        BeanUtil.copyProperties(menuInsertDTO, menuDO);
        return menuDO;
    }

    @Override
    public MenuDTO menuDO2MenuDTO(MenuDO menuDO) {
        if (null == menuDO) return null;
        MenuDTO menuDTO = new MenuDTO();
        BeanUtil.copyProperties(menuDO, menuDTO);

        String menuPid = menuDO.getMenuPid();
        String menuType = menuDO.getMenuType();

        if (ObjectUtil.isNotEmpty(menuPid) && StrUtil.isNotBlank(menuType)) {
            //菜单类型为-1时，代表父菜单id为客户端id
            if ("-1".equalsIgnoreCase(menuType)) {
                //根据menuPid获取父菜单名称
                OauthDetailReqDTO oauthDetailReqDTO = new OauthDetailReqDTO();
                oauthDetailReqDTO.setClientId(String.valueOf(menuPid));
                OauthDetailsDTO oauthDetailsDTO = oauthClientService.getOne(oauthDetailReqDTO);
                menuDTO.setMenuPname(oauthDetailsDTO.getClientname());
            } else {
                //菜单类型不为-1，说明父菜单跟客户端没有关系
                menuDTO.setMenuPname(Optional.ofNullable(menuDOMapper.selectByPrimaryKey(Integer.parseInt(menuPid))).map(MenuDO::getMenuName).orElse(null));
            }
        }
        return menuDTO;
    }
}

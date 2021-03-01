package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.service.system.convert.MenuConvert;
import com.fastdevelopinjava.service.system.mapper.MenuDOMapper;
import com.fastdevelopinjava.service.system.mapper.OauthDetailsDOMapper;
import com.fastdevelopinjava.service.system.model.MenuDO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDOExample;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

        Integer menuPid = menuDO.getMenuPid();
        String menuType = menuDO.getMenuType();
        /**
         * 这里至少两个问题，
         * 1、oauthClient 需要多加一个列，clientName
         * 2、menuPid 应该为string类型
         */
//        if (ObjectUtil.isNotEmpty(menuPid) && StrUtil.isNotBlank(menuType))
//        {
//            //菜单类型为-1时，代表父菜单id为客户端id
//            if ("-1".equalsIgnoreCase(menuType))
//            {
//                OauthDetailReqDTO oauthDetailReqDTO = new OauthDetailReqDTO();
//                oauthDetailReqDTO.setClientId(String.valueOf(menuPid));
//                OauthDetailsDTO oauthDetailsDTO = oauthClientService.getOne(oauthDetailReqDTO);
//                menuDTO.setMenuPname(oauthDetailsDTO);
//            }
//        }
        MenuDO pMenu = menuDOMapper.selectByPrimaryKey(menuPid);

        if (ObjectUtil.isNotEmpty(pMenu)){
            String pMenuName = pMenu.getMenuName();
            menuDTO.setMenuPname(pMenuName);
        }

        return menuDTO;
    }
}

package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.service.system.convert.MenuConvert;
import com.fastdevelopinjava.service.system.model.MenuDO;
import org.springframework.stereotype.Component;

@Component
public class MenuConvertImpl implements MenuConvert {

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
        MenuDTO menuDTO = MenuDTO.builder().build();
        BeanUtil.copyProperties(menuDO, menuDTO);
        return menuDTO;
    }
}

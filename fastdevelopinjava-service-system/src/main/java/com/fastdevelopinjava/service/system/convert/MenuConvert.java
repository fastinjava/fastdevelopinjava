package com.fastdevelopinjava.service.system.convert;

import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.service.system.model.MenuDO;

public interface MenuConvert {
    MenuDTO menuDO2MenuDTO(MenuDO menuDO);

    MenuDO menuInsertDTO2MenuDO(MenuInsertDTO menuInsertDTO);
}

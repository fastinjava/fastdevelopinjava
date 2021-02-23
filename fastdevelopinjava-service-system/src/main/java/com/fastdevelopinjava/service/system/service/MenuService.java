package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface MenuService {
    PageDTO<MenuDTO> getList(MenuReqDTO menuReqDTO);

    MenuDTO getOne(MenuReqDTO menuReqDTO);

    Boolean insert(MenuInsertDTO menuInsertDTO);
}

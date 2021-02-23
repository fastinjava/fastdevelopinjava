package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface MenuClient {

    ResultDTO<PageDTO<MenuDTO>> getList(MenuReqDTO menuReqDTO);

    ResultDTO<Boolean> insert(MenuInsertDTO menuInsertDTO);

    ResultDTO<MenuDTO> getOne(MenuReqDTO menuReqDTO);
}

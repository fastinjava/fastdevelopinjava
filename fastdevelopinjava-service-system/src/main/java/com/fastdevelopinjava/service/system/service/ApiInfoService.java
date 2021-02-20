package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface ApiInfoService {
    PageDTO<ApiInfoDTO> getList(ApiInfoReqDTO apiInfoReqDTO);

    ApiInfoDTO getOne(ApiInfoReqDTO apiInfoReqDTO);

    Boolean delete(ApiInfoDeleteDTO apiInfoDeleteDTO);

    Boolean insert(ApiInfoInsertDTO apiInfoInsertDTO);
}
